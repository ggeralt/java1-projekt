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
import javax.swing.DefaultListModel;

public class EditArticlesAdminPanel extends javax.swing.JPanel {
    private static final String ASSETS = "./assets";
    private DefaultListModel<Article> articlesModel;
    private Repository repository;
    
    public EditArticlesAdminPanel() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDeleteAllArticles = new javax.swing.JButton();
        btnUploadArticles = new javax.swing.JButton();
        lbRss = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsArticles = new javax.swing.JList<>();

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

        lbRss.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jScrollPane2.setViewportView(lsArticles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(lbRss, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUploadArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 521, Short.MAX_VALUE)
                        .addComponent(btnDeleteAllArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbRss, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteAllArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUploadArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnDeleteAllArticlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllArticlesActionPerformed
        try {
            repository.deleteAllArticles();
            loadModel();
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
            loadModel();
            MessageUtils.showInformationMessage("Article upload", "Articles successfully uploaded.");
        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Unrecoverable error", "Unable to upload articles");
            System.exit(1);
        }
    }//GEN-LAST:event_btnUploadArticlesActionPerformed
    
    private void init() {
        try {
            repository = RepositoryFactory.getRepository();
            articlesModel = new DefaultListModel<>();
            loadModel();
            lbRss.setText("Current RSS feed: " + ArticleParser.getRSS_URL());
        } catch (Exception ex) {
            Logger.getLogger(ViewArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void loadModel() throws Exception {
        List<Article> articles = repository.selectArticles();
        articlesModel.clear();
        articles.forEach(articlesModel::addElement);
        lsArticles.setModel(articlesModel);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteAllArticles;
    private javax.swing.JButton btnUploadArticles;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbRss;
    private javax.swing.JList<Article> lsArticles;
    // End of variables declaration//GEN-END:variables
}