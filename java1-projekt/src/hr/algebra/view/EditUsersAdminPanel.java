package hr.algebra.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.User;
import hr.algebra.utils.MessageUtils;
import hr.algebra.view.model.UserTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class EditUsersAdminPanel extends javax.swing.JPanel {

    private Repository repository;
    private UserTableModel usersTableModel;
    private User tbDeleteSelectedUser;
    private User tbUpdateSelectedUser;
    private final List<JTable> tables = new ArrayList<>();
    
    public EditUsersAdminPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDeleteUsers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDeleteUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCreateUser = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfCreateUsername = new javax.swing.JTextField();
        tfCreatePassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUpdateUsers = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfUpdateUsername = new javax.swing.JTextField();
        tfUpdatePassword = new javax.swing.JPasswordField();
        btnUpdateUser = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tbDeleteUsers.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDeleteUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDeleteUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDeleteUsers);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Update user");

        btnDeleteUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDeleteUser.setForeground(new java.awt.Color(255, 0, 0));
        btnDeleteUser.setText("DELETE");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Delete user");

        btnCreateUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCreateUser.setForeground(new java.awt.Color(0, 153, 0));
        btnCreateUser.setText("CREATE");
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Password:");

        tfCreateUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tfCreatePassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Create user");

        tbUpdateUsers.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUpdateUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUpdateUsersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbUpdateUsers);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Username:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Password:");

        tfUpdateUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tfUpdatePassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnUpdateUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdateUser.setText("UPDATE");
        btnUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfCreatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(23, 23, 23)
                            .addComponent(tfCreateUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addComponent(btnCreateUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(112, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                            .addComponent(btnUpdateUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfUpdatePassword)
                                    .addComponent(tfUpdateUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))))
                        .addGap(33, 33, 33))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addGap(650, 650, 650)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteUser)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCreateUser)
                                .addComponent(btnUpdateUser))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tfCreateUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tfCreatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfUpdateUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfUpdatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2)
                    .addContainerGap(592, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        if (tbDeleteSelectedUser == null) {
            MessageUtils.showInformationMessage("User deletion not possible", "Please select a user from the table.");
        }
        else if (tbDeleteSelectedUser != null && "Administrator".equals(tbDeleteSelectedUser.getRole())) {
            MessageUtils.showInformationMessage("User deletion not allowed", "Deleting user with role 'Administrator' is not allowed by this means.");
            tbDeleteSelectedUser = null;
        }
        else if (tbDeleteSelectedUser != null && !"Administrator".equals(tbDeleteSelectedUser.getRole())) {
            try {
                repository.deleteUserByID(tbDeleteSelectedUser.getId());
                usersTableModel = new UserTableModel(repository.selectUsers());
                tables.forEach(tb -> tb.setModel(usersTableModel));
                tbDeleteSelectedUser = null;
            } catch (Exception ex) {
                Logger.getLogger(EditUsersAdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("User Deletion Error", "Unable to delete user.");
            }
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
        try {
            String username = tfCreateUsername.getText().trim();
            String password = tfCreatePassword.getText();
            Optional<User> userLog = repository.selectUserByUsername(username);
            
            if ("".equals(username) || "".equals(password)) {
                MessageUtils.showErrorMessage("Empty credentials", "Cannot create user with empty credentials.");
                return;
            }
            
            if (userLog.isPresent()) {
                MessageUtils.showErrorMessage("User already exists", "Please try using a different name.");
                return;
            }
            
            repository.createUser(username, password, 2);
            usersTableModel = new UserTableModel(repository.selectUsers());
            tables.forEach(tb -> tb.setModel(usersTableModel));
            tfCreateUsername.setText("");
            tfCreatePassword.setText("");
        } catch (Exception ex) {
            Logger.getLogger(EditUsersAdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("User Creation Error", "Unable to create user.");
        }
    }//GEN-LAST:event_btnCreateUserActionPerformed

    private void tbDeleteUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDeleteUsersMouseClicked
        tbDeleteSelectedUser = getSelectedUserFromTable(tbDeleteUsers);
        
    }//GEN-LAST:event_tbDeleteUsersMouseClicked

    private void tbUpdateUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUpdateUsersMouseClicked
        tbUpdateSelectedUser = getSelectedUserFromTable(tbUpdateUsers);
        tfUpdateUsername.setText(tbUpdateSelectedUser.getUsername());
        tfUpdatePassword.setText(tbUpdateSelectedUser.getPassword());
    }//GEN-LAST:event_tbUpdateUsersMouseClicked

    private void btnUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserActionPerformed
        try {
            String username = tfUpdateUsername.getText().trim();
            String password = tfUpdatePassword.getText();
        
            if (tbUpdateSelectedUser == null) {
                MessageUtils.showInformationMessage("User update not possible", "Please select a user from the table.");
                return;
            }
        
            if ("".equals(username) || "".equals(password)) {
                MessageUtils.showErrorMessage("Empty credentials", "Cannot update user with empty credentials.");
                return;
            }
            
            repository.updateUser(tbUpdateSelectedUser.getId(), 
                    new User(
                            tbUpdateSelectedUser.getId(),
                            tfUpdateUsername.getText().trim(),
                            tfUpdatePassword.getText(),
                            tbUpdateSelectedUser.getRoleID()
                    ));
            
            usersTableModel.setUsers(repository.selectUsers());
            tables.forEach(tb -> tb.setModel(usersTableModel));
            tbUpdateSelectedUser = null;
            tfUpdateUsername.setText("");
            tfUpdatePassword.setText("");
        } catch (Exception ex) {
            Logger.getLogger(EditUsersAdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("User Update Error", "Unable to update user.");
        }
    }//GEN-LAST:event_btnUpdateUserActionPerformed

    public User getSelectedUserFromTable(JTable table) {
        int selectedRow = table.getSelectedRow();
        int rowIndex = table.convertRowIndexToModel(selectedRow);
        int selectedUserId = (int) usersTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<User> optUser = repository.selectUserByID(selectedUserId);
            if (optUser.isPresent()) {
                return optUser.get();
            }
        } catch (Exception ex) {
            Logger.getLogger(EditUsersAdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to show article!");
        }
        
        return null;
    }
    
    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }
    
    private void initTables() throws Exception {
        tables.add(tbDeleteUsers);
        tables.add(tbUpdateUsers);
        
        tables.forEach(tb -> tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION));
        tables.forEach(tb -> tb.setAutoCreateRowSorter(true));
        tables.forEach(tb -> tb.setRowHeight(25));
        usersTableModel = new UserTableModel(repository.selectUsers());
        tables.forEach(tb -> tb.setModel(usersTableModel));
    }

    private void init() {
        try {
            initRepository();
            initTables();
        } catch (Exception ex) {
            Logger.getLogger(EditUsersAdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnUpdateUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDeleteUsers;
    private javax.swing.JTable tbUpdateUsers;
    private javax.swing.JPasswordField tfCreatePassword;
    private javax.swing.JTextField tfCreateUsername;
    private javax.swing.JPasswordField tfUpdatePassword;
    private javax.swing.JTextField tfUpdateUsername;
    // End of variables declaration//GEN-END:variables

}
