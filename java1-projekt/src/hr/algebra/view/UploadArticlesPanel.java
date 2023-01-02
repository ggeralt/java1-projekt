package hr.algebra.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Article;
import hr.algebra.parser.rss.ArticleParser;
import hr.algebra.utils.MessageUtils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class UploadArticlesPanel extends javax.swing.JPanel {
    private DefaultListModel<Article> articlesModel;
    private Repository repository;
    
    public UploadArticlesPanel() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUploadArticles = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsArticles = new javax.swing.JList<>();
        lbRss = new javax.swing.JLabel();

        btnUploadArticles.setText("Upload Articles");
        btnUploadArticles.setActionCommand("Upload articles");
        btnUploadArticles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadArticlesActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lsArticles);

        lbRss.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                    .addComponent(lbRss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUploadArticles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRss, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUploadArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadArticlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadArticlesActionPerformed
        try {
            List<Article> articles = ArticleParser.parse();
            repository.createArticles(articles);
            loadModel();
            
        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Unrecoverable error", "Unable to upload articles");
            System.exit(1);
        }
    }//GEN-LAST:event_btnUploadArticlesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUploadArticles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbRss;
    private javax.swing.JList<Article> lsArticles;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            repository = RepositoryFactory.getRepository();
            articlesModel = new DefaultListModel<>();
            loadModel();
            lbRss.setText("Current RSS feed: " + ArticleParser.getRSS_URL());
        } catch (Exception ex) {
            Logger.getLogger(UploadArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
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
}