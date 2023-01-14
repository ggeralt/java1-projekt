package hr.algebra;

import hr.algebra.model.User;
import hr.algebra.utils.MessageUtils;
import hr.algebra.view.MainAdminPanel;
import hr.algebra.view.EditUsersAdminPanel;
import hr.algebra.view.EditArticlesUserPanel;
import hr.algebra.view.EditCategoriesAdminPanel;
import hr.algebra.view.ViewArticlesUserPanel;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainWindow extends javax.swing.JFrame {
    private static final String VIEW_ARTICLES = "View articles";
    private static final String EDIT_ARTICLES = "Edit articles";
    private static final String MAIN_PANEL = "Main panel";
    private static final String USER = "User";
    private static final String CATEGORIES = "Categories";
    private static final String DEFAULT_THEME = "javax.swing.plaf.nimbus.NimbusLookAndFeel";

    public MainWindow(Optional<User> user) {
        initComponents();
        configurePanels(user);
        handleTheme();
    }

    private MainWindow() {}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpContent = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemExit = new javax.swing.JMenuItem();
        menuItemLogout = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();
        menuTheme = new javax.swing.JMenu();
        menuHelp = new javax.swing.JMenu();
        menuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Hello,");

        lbUsername.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(0, 153, 0));

        btnLogout.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setToolTipText("Close aplication and logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        menuFile.setMnemonic('F');
        menuFile.setText("File");
        menuFile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuFile.add(menuItemExit);

        menuItemLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuItemLogout.setText("Logout");
        menuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogoutActionPerformed(evt);
            }
        });
        menuFile.add(menuItemLogout);

        jMenuBar.add(menuFile);

        menuView.setMnemonic('V');
        menuView.setText("View");
        menuView.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuTheme.setMnemonic('T');
        menuTheme.setText("Theme");
        menuView.add(menuTheme);

        jMenuBar.add(menuView);

        menuHelp.setMnemonic('H');
        menuHelp.setText("Help");
        menuHelp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuItemAbout.setText("About");
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAboutActionPerformed(evt);
            }
        });
        menuHelp.add(menuItemAbout);

        jMenuBar.add(menuHelp);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(lbUsername, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.CENTER))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpContent, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        logout();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        exit();
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogoutActionPerformed
        logout();
    }//GEN-LAST:event_menuItemLogoutActionPerformed

    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAboutActionPerformed
        JOptionPane.showMessageDialog(null, "Project name: java1-projekt\nAuthor: Jan Šantek\nProject source: https://github.com/ggeralt/java1-projekt", "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_menuItemAboutActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuItemAbout;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenu menuTheme;
    private javax.swing.JMenu menuView;
    private javax.swing.JTabbedPane tpContent;
    // End of variables declaration//GEN-END:variables

    private void configurePanels(Optional<User> user) {
        lbUsername.setText(user.get().getUsername());

        if (user.get().getRoleID() == 1) {
            tpContent.add(MAIN_PANEL, new MainAdminPanel());
            tpContent.add(USER, new EditUsersAdminPanel());
            tpContent.add(CATEGORIES, new EditCategoriesAdminPanel());
        }
        else {
            tpContent.add(VIEW_ARTICLES, new ViewArticlesUserPanel());
            tpContent.add(EDIT_ARTICLES, new EditArticlesUserPanel());
        }
    }
    
    private void logout() {
        int dialogResult = MessageUtils.showConfirmDialog("Logout", "Are you sure?");
        if (dialogResult == JOptionPane.YES_OPTION) {
            setDefaultTheme();
            this.dispose();
            LogIn logIn = new LogIn();
            logIn.setVisible(true);
        }
    }
    
    private void exit() {
        int dialogResult = MessageUtils.showConfirmDialog("Exit application", "Are you sure?");
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void handleTheme() {
        ButtonGroup bg = new ButtonGroup();
        Arrays.asList(UIManager.getInstalledLookAndFeels()).forEach(info -> {
            JRadioButtonMenuItem mi = new JRadioButtonMenuItem(info.getName());
            menuTheme.add(mi);
            bg.add(mi);
            mi.setSelected("Nimbus".equals(info.getName()));
            mi.addActionListener(e -> {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.updateComponentTreeUI(MainWindow.this);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        });
    }
    
    private void setDefaultTheme() {
        try {
            UIManager.setLookAndFeel(DEFAULT_THEME);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}