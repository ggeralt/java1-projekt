package hr.algebra.view;

import hr.algebra.MainWindow;
import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Category;
import hr.algebra.model.User;
import hr.algebra.utils.MessageUtils;
import hr.algebra.view.model.ArticleTableModel;
import hr.algebra.view.model.UserTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class EditCategoriesUserPanel extends javax.swing.JPanel {

    private Repository repository;
    private ArticleTableModel articlesTableModel;
    private Category tbDeleteSelectedCategory;
    private Category tbUpdateSelectedCategory;
    private final List<JTable> tables = new ArrayList<>();
    
    public EditCategoriesUserPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDeleteCategories = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDeleteCategory = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCreateCategory = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfCreateCategory = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUpdateCategories = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tfUpdateCategory = new javax.swing.JTextField();
        btnUpdateCategory = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tbDeleteCategories.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDeleteCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDeleteCategoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDeleteCategories);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Update category");

        btnDeleteCategory.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDeleteCategory.setForeground(new java.awt.Color(255, 0, 0));
        btnDeleteCategory.setText("DELETE");
        btnDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCategoryActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Delete category");

        btnCreateCategory.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCreateCategory.setForeground(new java.awt.Color(0, 153, 0));
        btnCreateCategory.setText("CREATE");
        btnCreateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCategoryActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Name:");

        tfCreateCategory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Create category");

        tbUpdateCategories.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUpdateCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUpdateCategoriesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbUpdateCategories);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Name:");

        tfUpdateCategory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnUpdateCategory.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdateCategory.setText("UPDATE");
        btnUpdateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnDeleteCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfCreateCategory))
                        .addComponent(btnCreateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfUpdateCategory))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(btnUpdateCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteCategory)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCreateCategory)
                                .addComponent(btnUpdateCategory))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(tfCreateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfUpdateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void btnDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCategoryActionPerformed
        if (tbDeleteSelectedCategory == null) {
            MessageUtils.showInformationMessage("Category deletion not possible", "Please select a category from the table.");
        }
        else if (tbDeleteSelectedCategory != null) {
            try {
                repository.deleteCategory(tbDeleteSelectedCategory.getId());
                MessageUtils.showInformationMessage("Category deletion", "Successfully deleted category: " + tbDeleteSelectedCategory.getName() + " (IDCategory: " + tbDeleteSelectedCategory.getId() + ")");
                tbDeleteSelectedCategory = null;
                articlesTableModel = new ArticleTableModel(repository.selectArticles());
                tables.forEach(tb -> tb.setModel(articlesTableModel));
            } catch (Exception ex) {
                Logger.getLogger(EditCategoriesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteCategoryActionPerformed

    private void btnCreateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCategoryActionPerformed
        try {
            String name = tfCreateCategory.getText().trim();
            Optional<Category> categoryLog = repository.selectCategoryByName(name);
            
            if ("".equals(name)) {
                MessageUtils.showErrorMessage("Empty string", "Cannot create category with empty name.");
                return;
            }
            
            if (categoryLog.isPresent()) {
                MessageUtils.showErrorMessage("Category already exists", "Please try using a different name.");
                return;
            }
            
            repository.createCategory(tbDeleteSelectedCategory);
            articlesTableModel = new ArticleTableModel(repository.selectArticles());
            tables.forEach(tb -> tb.setModel(articlesTableModel));
            MessageUtils.showInformationMessage("Category created", "Category '" + name + "' successfully created!");
        } catch (Exception ex) {
            Logger.getLogger(EditCategoriesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateCategoryActionPerformed

    private void tbDeleteCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDeleteCategoriesMouseClicked
        tbDeleteSelectedCategory = getSelectedCategoryFromTable(tbDeleteCategories);
    }//GEN-LAST:event_tbDeleteCategoriesMouseClicked

    private void tbUpdateCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUpdateCategoriesMouseClicked
        tbUpdateSelectedCategory = getSelectedCategoryFromTable(tbUpdateCategories);
        tfUpdateCategory.setText(tbUpdateSelectedCategory.getName());
    }//GEN-LAST:event_tbUpdateCategoriesMouseClicked

    private void btnUpdateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCategoryActionPerformed
        try {
            String name = tfUpdateCategory.getText().trim();
        
            if (tbUpdateSelectedCategory == null) {
                MessageUtils.showInformationMessage("Category update not possible", "Please select a category from the table.");
                return;
            }
        
            if ("".equals(name)) {
                MessageUtils.showErrorMessage("Empty string", "Cannot update category with empty name.");
                return;
            }
            
            repository.updateCategory(tbUpdateSelectedCategory.getId(), 
                    new Category(
                            tbUpdateSelectedCategory.getId(),
                            tfUpdateCategory.getText().trim()
                    ));
            
            articlesTableModel.setArticles(repository.selectArticles());
            tables.forEach(tb -> tb.setModel(articlesTableModel));
            MessageUtils.showInformationMessage("Category update", "Selected category successfully updated.");
        } catch (Exception ex) {
            Logger.getLogger(EditCategoriesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Category Update Error", "Unable to update category.");
        }
    }//GEN-LAST:event_btnUpdateCategoryActionPerformed

    public Category getSelectedCategoryFromTable(JTable table) {
        int selectedRow = table.getSelectedRow();
        int rowIndex = table.convertRowIndexToModel(selectedRow);
        int selectedCategoryId = (int) articlesTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<Category> optCategory = repository.selectCategoryByID(selectedCategoryId);
            if (optCategory.isPresent()) {
                return optCategory.get();
            }
        } catch (Exception ex) {
            Logger.getLogger(EditCategoriesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to show article!");
        }
        
        return null;
    }
    
    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }
    
    private void initTables() throws Exception {
        tables.add(tbDeleteCategories);
        tables.add(tbUpdateCategories);
        
        tables.forEach(tb -> tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION));
        tables.forEach(tb -> tb.setAutoCreateRowSorter(true));
        tables.forEach(tb -> tb.setRowHeight(25));
        articlesTableModel = new ArticleTableModel(repository.selectArticles());
        tables.forEach(tb -> tb.setModel(articlesTableModel));
    }

    private void init() {
        try {
            initRepository();
            initTables();
        } catch (Exception ex) {
            Logger.getLogger(EditCategoriesUserPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateCategory;
    private javax.swing.JButton btnDeleteCategory;
    private javax.swing.JButton btnUpdateCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDeleteCategories;
    private javax.swing.JTable tbUpdateCategories;
    private javax.swing.JTextField tfCreateCategory;
    private javax.swing.JTextField tfUpdateCategory;
    // End of variables declaration//GEN-END:variables

}
