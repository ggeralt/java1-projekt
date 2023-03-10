package hr.algebra.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Article;
import hr.algebra.model.Category;
import hr.algebra.view.model.ArticleTableModel;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

public class EditArticlesUserPanel extends javax.swing.JPanel {
    private static final String DIR = "assets";
    private Article selectedArticle;
    private Repository repository;
    private ArticleTableModel articlesTableModel;
    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;
    
    public EditArticlesUserPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbArticles = new javax.swing.JTable();
        lbIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        tfLink = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfPublishedDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        btnChoosePicture = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lbTitleError = new javax.swing.JLabel();
        lbLinkError = new javax.swing.JLabel();
        lbDescError = new javax.swing.JLabel();
        lbPubDateError = new javax.swing.JLabel();
        lbIconError = new javax.swing.JLabel();
        tfPicturePath = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbCategories = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tbArticles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbArticles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbArticlesMouseClicked(evt);
            }
        });
        tbArticles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbArticlesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbArticles);

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N
        lbIcon.setPreferredSize(new java.awt.Dimension(480, 300));

        jLabel2.setText("Title");

        jLabel3.setText("Link");

        jLabel4.setText("Description");

        tfPublishedDate.setName("Date"); // NOI18N

        jLabel5.setText("Published date (yyyy-MM-ddThh:mm:ss)");

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane2.setViewportView(taDescription);

        btnChoosePicture.setText("Choose image");
        btnChoosePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoosePictureActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(java.awt.Color.red);
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lbTitleError.setForeground(java.awt.Color.red);

        lbLinkError.setForeground(java.awt.Color.red);

        lbDescError.setForeground(java.awt.Color.red);
        lbDescError.setToolTipText("");

        lbPubDateError.setForeground(java.awt.Color.red);

        lbIconError.setForeground(java.awt.Color.red);

        tfPicturePath.setEditable(false);
        tfPicturePath.setBackground(new java.awt.Color(204, 204, 204));
        tfPicturePath.setName(""); // NOI18N

        jLabel6.setText("Category");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(0, 590, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTitle)
                                    .addComponent(tfLink)
                                    .addComponent(jScrollPane2))
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfPublishedDate, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addComponent(lbPubDateError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCategories, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLinkError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbIconError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfPicturePath, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnChoosePicture)))
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIconError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChoosePicture)
                            .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLinkError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPublishedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPubDateError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (formValid()) {
            try {
                String localPicturePath = uploadPicture();
                Article article = new Article(
                        cbCategories.getItemAt(cbCategories.getSelectedIndex()).getId(),
                        tfTitle.getText().trim(),
                        tfLink.getText().trim(),
                        taDescription.getText().trim(),
                        localPicturePath,
                        LocalDateTime.parse(tfPublishedDate.getText().trim(), Article.DATE_FORMATTER)
                );
                repository.createArticle(article);
                articlesTableModel.setArticles(repository.selectArticles());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Article Creation Error", "Unable to create article.");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private String uploadPicture() throws IOException {
        String picturePath = tfPicturePath.getText().trim();
        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedArticle == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose article to update");
            return;
        }
        
        if (formValid()) {
            try {
                if (!tfPicturePath.getText().trim().equals(selectedArticle.getPicturePath())) {
                    if (selectedArticle.getPicturePath() != null) {
                        Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
                    }
                    String localPicturePath = uploadPicture();
                    selectedArticle.setPicturePath(localPicturePath);
                }

                selectedArticle.setTitle(tfTitle.getText().trim());
                selectedArticle.setLink(tfLink.getText().trim());
                selectedArticle.setDescription(taDescription.getText().trim());
                selectedArticle.setPublishedDate(LocalDateTime.parse(tfPublishedDate.getText().trim(), Article.DATE_FORMATTER));
                selectedArticle.setCategoryId(cbCategories.getItemAt(cbCategories.getSelectedIndex()));

                repository.updateArticle(selectedArticle.getId(), selectedArticle);
                articlesTableModel.setArticles(repository.selectArticles());

                fillForm(selectedArticle);
                
                MessageUtils.showInformationMessage("Article update", "Article successfully updated.");
            } catch (Exception ex) {
                Logger.getLogger(EditArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Article Update Error", "Unable to update article.");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedArticle == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose article to delete");
            return;
        }
        
        if (MessageUtils.showConfirmDialog(
                "Delete article",
                "Do you really want to delete article?") == JOptionPane.YES_OPTION) {
            try {
                if (selectedArticle.getPicturePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
                }
                repository.deleteArticleByID(selectedArticle.getId());
                articlesTableModel.setArticles(repository.selectArticles());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Article Deletion Error", "Unable to delete article.");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnChoosePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoosePictureActionPerformed
        File file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        
        if (file == null) {
            return;
        }
        
        tfPicturePath.setText(file.getAbsolutePath());
        setIcon(lbIcon, file);
    }//GEN-LAST:event_btnChoosePictureActionPerformed

    private void tbArticlesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbArticlesMouseClicked
        showArticle();
    }//GEN-LAST:event_tbArticlesMouseClicked

    public void showArticle() {
        clearForm();
        int selectedRow = tbArticles.getSelectedRow();
        int rowIndex = tbArticles.convertRowIndexToModel(selectedRow);
        int selectedArticleId = (int) articlesTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<Article> optArticle = repository.selectArticle(selectedArticleId);
            if (optArticle.isPresent()) {
                selectedArticle = optArticle.get();
                fillForm(selectedArticle);
            }
        } catch (Exception ex) {
            Logger.getLogger(EditArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Show Article Error", "Unable to show article.");
        }
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void tbArticlesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbArticlesKeyReleased
        showArticle();
    }//GEN-LAST:event_tbArticlesKeyReleased

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            articlesTableModel = new ArticleTableModel(repository.selectArticles());
            tbArticles.setModel(articlesTableModel);
        } catch (Exception ex) {
            Logger.getLogger(EditArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChoosePicture;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Category> cbCategories;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbDescError;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbIconError;
    private javax.swing.JLabel lbLinkError;
    private javax.swing.JLabel lbPubDateError;
    private javax.swing.JLabel lbTitleError;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTable tbArticles;
    private javax.swing.JTextField tfLink;
    private javax.swing.JTextField tfPicturePath;
    private javax.swing.JTextField tfPublishedDate;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            initValidation();
            initRepository();
            initCategories();
            initTable();
        } catch (Exception ex) {
            Logger.getLogger(EditArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Form Init Error", "Cannot initiate the form.");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfTitle, tfLink, taDescription, tfPublishedDate, tfPicturePath);
        errorLabels = Arrays.asList(lbTitleError, lbLinkError, lbDescError, lbPubDateError, lbIconError);
    }

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private void initTable() throws Exception {
        tbArticles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbArticles.setAutoCreateRowSorter(true);
        tbArticles.setRowHeight(25);
        articlesTableModel = new ArticleTableModel(repository.selectArticles());
        tbArticles.setModel(articlesTableModel);
    }

    private void fillForm(Article article) {
        if (article.getPicturePath() != null && Files.exists(Paths.get(article.getPicturePath()))) {
            tfPicturePath.setText(article.getPicturePath());
            setIcon(lbIcon, new File(article.getPicturePath()));
        }
        
        tfTitle.setText(article.getTitle());
        tfLink.setText(article.getLink());
        taDescription.setText(article.getDescription());
        tfPublishedDate.setText(article.getPublishedDate().format(Article.DATE_FORMATTER));
        
        try {
            cbCategories.setSelectedIndex(article.getCategoryId() - 1);
        } catch (Exception ex) {
            Logger.getLogger(EditArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(EditArticlesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Set Icon Error", "Unable to set icon.");
        }
    }

    private void clearForm() {
        validationFields.forEach(e -> e.setText(""));
        errorLabels.forEach(e -> e.setText(""));
        lbIcon.setIcon(new ImageIcon(getClass().getResource("/assets/no_image.png")));
        selectedArticle = null;
    }

    private boolean formValid() {
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");

            if ("Date".equals(validationFields.get(i).getName())) {
                try {
                    LocalDateTime.parse(validationFields.get(i).getText().trim(), Article.DATE_FORMATTER);
                    errorLabels.get(i).setText("");
                } catch (Exception e) {
                    ok = false;
                    errorLabels.get(i).setText("X");
                }
            }
        }

        return ok;
    }
    
    private void initCategories() throws Exception {
        List<Category> categories = repository.selectCategories();
        
        if (cbCategories.getItemCount() != 0) {
            cbCategories.removeAllItems();
        }
        
        categories.forEach((category) -> {
            cbCategories.addItem(new Category(category.getId(), category.getName()));
        });
    }
}