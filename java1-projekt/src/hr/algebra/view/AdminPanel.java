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

public class AdminPanel extends javax.swing.JPanel {
    private static final String ASSETS = "./assets";
    private Repository repository;
    
    public AdminPanel() {
        initComponents();
        initRepository();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnDeleteAllArticles = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        btnUploadArticles = new javax.swing.JButton();

        tfUsername.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Username:");

        btnDeleteAllArticles.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDeleteAllArticles.setForeground(new java.awt.Color(255, 0, 0));
        btnDeleteAllArticles.setText("DELETE ALL ARTICLES");
        btnDeleteAllArticles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllArticlesActionPerformed(evt);
            }
        });

        btnDeleteUser.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnDeleteUser.setForeground(new java.awt.Color(255, 0, 0));
        btnDeleteUser.setText("DELETE USER");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnUploadArticles.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUploadArticles.setForeground(new java.awt.Color(0, 255, 0));
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDeleteAllArticles, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteUser)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnUploadArticles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteUser)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
                .addComponent(btnUploadArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteAllArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initRepository() {
        try {
            repository = RepositoryFactory.getRepository();
        } catch (Exception ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
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

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        if (tfUsername.getText().trim().length() == 0) {
            MessageUtils.showInformationMessage("Username field empty", "Please specify the username.");
            return;
        }
        
        try {
            if (repository.checkIfUserExists(tfUsername.getText().trim()) == 0) {
                MessageUtils.showInformationMessage("No such user", "Specified user does not exist.");
                return;
            }
            
            repository.deleteUser(tfUsername.getText().trim());
            MessageUtils.showInformationMessage("User deleted", "Specified user successfully deleted.");
        } catch (Exception ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

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
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnUploadArticles;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}