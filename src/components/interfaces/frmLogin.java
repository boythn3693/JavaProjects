/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.applications.application;
import components.services.AccountService;
import components.utils.MD5Library;
import components.utils.StringHelpers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;;

/**
 *
 * @author MitsuyoRai
 */
public class frmLogin extends javax.swing.JFrame {
    AccountService bus;
    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
        setInitForm();
        bus = new AccountService();
    }
    
    private void setInitForm() {
        ImageIcon icon = new ImageIcon(getClass().getResource("../../public/images/login.png"));
        this.setIconImage(icon.getImage());
        this.setLocation(300, 200);
        File file = new File("luumk.txt");
        // if file doesnt exists, then create it
        String  user="",
                pass="";
        FileReader fw;
        try {
            fw = new FileReader(file);
                BufferedReader bw = new BufferedReader(fw);
            try {
                user = bw.readLine();
                pass = bw.readLine();
                bw.close();
            } catch (IOException ex) {
            }

        } catch (FileNotFoundException ex) {
            System.out.println("không tìm thấy file lưu mk");
        }
        
        txtUserName.setText(user);
        txtPassword.setText(pass);
        if(!user.equals("")){
            cbRememberMe.setSelected(rootPaneCheckingEnabled);
            System.out.println("checked lưu mật khẩu");
        } else {
            System.out.println("đã bỏ checkbox lưu mật khẩu\n\n");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRegisterInfo = new javax.swing.JPanel();
        lblRegisterTitle = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cbRememberMe = new javax.swing.JCheckBox();
        btnRegister = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setResizable(false);

        pnlRegisterInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));

        lblRegisterTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRegisterTitle.setForeground(new java.awt.Color(51, 102, 255));
        lblRegisterTitle.setText("QUẢN LÝ KHO HÀNG");

        lblUserName.setText("Tên đăng nhập");

        lblPassword.setText("Mật khẩu");

        cbRememberMe.setForeground(new java.awt.Color(102, 153, 255));
        cbRememberMe.setText("nhớ Mật Khẩu");
        cbRememberMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRememberMeActionPerformed(evt);
            }
        });

        btnRegister.setForeground(new java.awt.Color(255, 153, 51));
        btnRegister.setText("Đăng ký");
        btnRegister.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRegisterMouseMoved(evt);
            }
        });
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisterMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegisterMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRegisterMouseReleased(evt);
            }
        });
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnLogin.setForeground(new java.awt.Color(255, 153, 51));
        btnLogin.setText("Đăng Nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegisterInfoLayout = new javax.swing.GroupLayout(pnlRegisterInfo);
        pnlRegisterInfo.setLayout(pnlRegisterInfoLayout);
        pnlRegisterInfoLayout.setHorizontalGroup(
            pnlRegisterInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterInfoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlRegisterInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(29, 29, 29)
                .addGroup(pnlRegisterInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegisterInfoLayout.createSequentialGroup()
                        .addComponent(lblRegisterTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlRegisterInfoLayout.createSequentialGroup()
                        .addGroup(pnlRegisterInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserName)
                            .addComponent(txtPassword)
                            .addGroup(pnlRegisterInfoLayout.createSequentialGroup()
                                .addComponent(cbRememberMe, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlRegisterInfoLayout.createSequentialGroup()
                                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))))
        );
        pnlRegisterInfoLayout.setVerticalGroup(
            pnlRegisterInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterInfoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblRegisterTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRegisterInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRegisterInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(18, 18, 18)
                .addComponent(cbRememberMe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegisterInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegister)
                    .addComponent(btnLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRegisterInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRegisterInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbRememberMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRememberMeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRememberMeActionPerformed

    private void btnRegisterMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseMoved

    }//GEN-LAST:event_btnRegisterMouseMoved

    private void btnRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseExited

    }//GEN-LAST:event_btnRegisterMouseExited

    private void btnRegisterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMousePressed

    }//GEN-LAST:event_btnRegisterMousePressed

    private void btnRegisterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseReleased

    }//GEN-LAST:event_btnRegisterMouseReleased
    
    public static int role=0;
    public static String name="", user="";
    public static int accountId = 0;
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        frmRegister frmRegister = new frmRegister();
        frmRegister.setVisible(true);
        //frmRegister.show();
        this.dispose();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String strUsername = txtUserName.getText().trim();
        String strPassword = String.valueOf(txtPassword.getPassword()).trim();
        
        String luumk="",luutdn="";
        if(cbRememberMe.isSelected())
        {
            luutdn = strUsername;
            luumk = strPassword;
            System.out.println("lưu mật khẩu");
        } else {
            luutdn ="";
            luumk ="";
            System.out.println("không lưu mật khẩu");
        }
        try {
            File file = new File("luumk.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(luutdn+"\n"+luumk);
            bw.close();
            if( cbRememberMe.isSelected())
            System.out.println("lưu phiên đăng nhập thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            ArrayList rs = bus.getLogin(strUsername, MD5Library.md5(strPassword));
            if( rs != null ) {
                role = Integer.parseInt(rs.get(4).toString()); 
                name = rs.get(3) + " " + rs.get(2);
                user = rs.get(1).toString();

                accountId = Integer.parseInt(rs.get(0).toString());
                application.accountId = accountId;
                application.role = role;
                application.user = user;
                application.frmMain = new frmMain();
                application.frmMain.setVisible(true);
                this.dispose(); 
            } else {
                StringHelpers.Message("Bạn nhập sai tài khoản hoặc mật khẩu", "Lỗi đăng nhập", 2);
            }
        } catch(Exception e) {
            StringHelpers.Message("Bạn nhập sai tài khoản hoặc mật khẩu", "Lỗi đăng nhập", 2);
        }
    }//GEN-LAST:event_btnLoginActionPerformed
    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JCheckBox cbRememberMe;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegisterTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlRegisterInfo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
