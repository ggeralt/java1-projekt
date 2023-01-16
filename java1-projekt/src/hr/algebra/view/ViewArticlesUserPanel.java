package hr.algebra.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Article;
import hr.algebra.model.ArticleArchive;
import hr.algebra.parser.rss.ArticleParser;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.JAXBUtils;
import hr.algebra.utils.MessageUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;

public class ViewArticlesUserPanel extends javax.swing.JPanel {
    private static final String XML_FILE = "article_archive.xml";
    private List<Article> articlesXML = new ArrayList<>();
    private Article selectedArticle;
    private DefaultListModel<Article> articlesModel;
    private Repository repository;
    
    public ViewArticlesUserPanel() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lsArticles = new javax.swing.JList<>();
        lbRss = new javax.swing.JLabel();
        btnSaveToXML = new javax.swing.JButton();
        btnLoadFromXML = new javax.swing.JButton();
        lbIcon = new javax.swing.JLabel();
        btnLoadFromDatabase = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lsArticles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsArticlesMouseClicked(evt);
            }
        });
        lsArticles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lsArticlesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lsArticles);

        lbRss.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnSaveToXML.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSaveToXML.setText("SAVE TO XML");
        btnSaveToXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveToXMLActionPerformed(evt);
            }
        });

        btnLoadFromXML.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLoadFromXML.setText("LOAD FROM XML");
        btnLoadFromXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadFromXMLActionPerformed(evt);
            }
        });

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N
        lbIcon.setPreferredSize(new java.awt.Dimension(480, 300));

        btnLoadFromDatabase.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLoadFromDatabase.setText("LOAD FROM DATABASE");
        btnLoadFromDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadFromDatabaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRss, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSaveToXML)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoadFromXML)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoadFromDatabase)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(lbRss, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveToXML)
                    .addComponent(btnLoadFromXML)
                    .addComponent(btnLoadFromDatabase))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadFromXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadFromXMLActionPerformed
        loadModelFromXML();
    }//GEN-LAST:event_btnLoadFromXMLActionPerformed

    private void lsArticlesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsArticlesMouseClicked
        showArticle();       
    }//GEN-LAST:event_lsArticlesMouseClicked

    private void lsArticlesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lsArticlesKeyReleased
        showArticle(); 
    }//GEN-LAST:event_lsArticlesKeyReleased

    private void btnSaveToXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveToXMLActionPerformed
        try {
            new FileOutputStream(new File(XML_FILE), false).close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        articlesXML.clear();
        
        for (int i = 0; i < lsArticles.getModel().getSize(); i++) {
            try {
                Optional<Article> optArticle = repository.selectArticle(
                        lsArticles.getModel().getElementAt(i).getId()
                );

                articlesXML.add(new Article(
                        optArticle.get().getId(),
                        optArticle.get().getCategoryId(),
                        optArticle.get().getTitle(), 
                        optArticle.get().getLink(), 
                        optArticle.get().getDescription(), 
                        optArticle.get().getPicturePath(), 
                        optArticle.get().getPublishedDate()
                ));
            } catch (Exception ex) {
                Logger.getLogger(ViewArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            JAXBUtils.save(new ArticleArchive(articlesXML), XML_FILE);
            MessageUtils.showInformationMessage("XML File Saved", "Articles are successfully saved into " + XML_FILE);
        } catch (JAXBException ex) {
            Logger.getLogger(ViewArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("XML File Saving Error", "Unable to save articles to " + XML_FILE);
        }
    }//GEN-LAST:event_btnSaveToXMLActionPerformed

    private void btnLoadFromDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadFromDatabaseActionPerformed
        loadModelFromDatabase();
    }//GEN-LAST:event_btnLoadFromDatabaseActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        loadModelFromDatabase();
    }//GEN-LAST:event_formComponentShown

    public void showArticle() {
        if (lsArticles.getModel().getSize() != 0) {
            selectedArticle = lsArticles.getSelectedValue();
            fillIcon(selectedArticle);
        }
    }
    
    private void fillIcon(Article article) {
        if (article.getPicturePath() != null && Files.exists(Paths.get(article.getPicturePath()))) {
            setIcon(lbIcon, new File(article.getPicturePath()));
        }
    }
    
    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(ViewArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Set Icon Error", "Unable to set icon.");
        }
    }
    
    private void clearForm() {
        lbIcon.setIcon(new ImageIcon(getClass().getResource("/assets/no_image.png")));
        selectedArticle = null;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadFromDatabase;
    private javax.swing.JButton btnLoadFromXML;
    private javax.swing.JButton btnSaveToXML;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbRss;
    private javax.swing.JList<Article> lsArticles;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            repository = RepositoryFactory.getRepository();
            articlesModel = new DefaultListModel<>();
            loadModelFromDatabase();
        } catch (Exception ex) {
            Logger.getLogger(ViewArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Form Init Error", "Cannot initiate the form.");
            System.exit(1);
        }
    }

    private void loadModelFromDatabase() {
        try {
            List<Article> articlesDatabase = repository.selectArticles();
            articlesModel.clear();
            articlesDatabase.forEach(articlesModel::addElement);
            lsArticles.setModel(articlesModel);
            clearForm();
            lbRss.setText("Current RSS feed: " + ArticleParser.getRSS_URL());
        } catch (Exception ex) {
            Logger.getLogger(ViewArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Load From Database Error", "Cannot load articles from database.");
        }
    }
    
    private void loadModelFromXML() {
        try {
            ArticleArchive articleArchive = (ArticleArchive) JAXBUtils.load(ArticleArchive.class, XML_FILE);
            articlesModel.clear();
            articlesXML = articleArchive.getArticles();
            articlesXML.forEach(articlesModel::addElement);
            lsArticles.setModel(articlesModel);
            clearForm();
            lbRss.setText("Current RSS feed: " + XML_FILE);
        }
        catch (UnmarshalException ex) {
            MessageUtils.showErrorMessage("Load From XML Error", XML_FILE + " does not exist.");
        }
        catch (JAXBException ex) {
            Logger.getLogger(ViewArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Load From XML Error", "Cannot load articles from XML.");
        }
    }
}