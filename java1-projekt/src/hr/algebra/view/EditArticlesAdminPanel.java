package hr.algebra.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Article;
import hr.algebra.parser.rss.ArticleParser;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.MessageUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditArticlesAdminPanel extends javax.swing.JPanel {
    private static final String ASSETS = "./assets";
    private Repository repository;
    
    public EditArticlesAdminPanel() {
        initComponents();
        initRepository();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDeleteAllArticles = new javax.swing.JButton();
        btnUploadArticles = new javax.swing.JButton();

        btnDeleteAllArticles.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDeleteAllArticles.setForeground(new java.awt.Color(255, 0, 0));
        btnDeleteAllArticles.setText("DELETE ALL ARTICLES");
        btnDeleteAllArticles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllArticlesActionPerformed(evt);
            }
        });

        btnUploadArticles.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUploadArticles.setForeground(new java.awt.Color(0, 153, 0));
        btnUploadArticles.setText("Upload Articles");
        btnUploadArticles.setActionCommand("Upload articles");
        btnUploadArticles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadArticlesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(478, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUploadArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteAllArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(403, 403, 403))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(btnUploadArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnDeleteAllArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initRepository() {
        try {
            repository = RepositoryFactory.getRepository();
        } catch (Exception ex) {
            Logger.getLogger(EditArticlesAdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnDeleteAllArticlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllArticlesActionPerformed
        try {
            repository.deleteAllArticles();
            MessageUtils.showInformationMessage("", "All articles have been successfully deleted!");

        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Unrecoverable error", "Unable to delete articles");
            System.exit(1);
        }

        try {
            File directory = new File(ASSETS);
            FileUtils.cleanDirectory(directory);
        } catch (IOException ex) {
            MessageUtils.showErrorMessage("Unrecoverable error", "Unable to delete images");
            System.exit(1);
        }
    }//GEN-LAST:event_btnDeleteAllArticlesActionPerformed

    private void btnUploadArticlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadArticlesActionPerformed
        try {
            List<Article> articles = ArticleParser.parse();
            repository.createArticles(articles);
            MessageUtils.showInformationMessage("Article upload", "Articles successfully uploaded.");

        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Unrecoverable error", "Unable to upload articles");
            System.exit(1);
        }
    }//GEN-LAST:event_btnUploadArticlesActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteAllArticles;
    private javax.swing.JButton btnUploadArticles;
    // End of variables declaration//GEN-END:variables
}