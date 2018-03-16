/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author MitsuyoRai
 */
public class frmMain extends javax.swing.JFrame {
    int tam = 0;
    ImageIcon icon;
    String imageLocation = "bg.jpg";
    String imageName;
    Calendar cal = Calendar.getInstance();

    int day = cal.get(Calendar.DAY_OF_MONTH);
    int month = cal.get(Calendar.MONTH) + 1;
    int year = cal.get(Calendar.YEAR);

    Date dt = cal.getTime();
    // Dinh dang lai hien thi thong tin ngay gio ra man hinh
    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
    
    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        setInitForm();
    }
    
    private void setInitForm() {
        ImageIcon icon = new ImageIcon(getClass().getResource("../../public/images/warehouse.png"));
        this.setIconImage(icon.getImage());
    }
    
//    public DefaultComboBoxModel getDataCBB(String table, String name, String id) {
//        String cautruyvan = "select *from " + table;
//        ResultSet rs = HUYPHPK00628_ASM_GD2.connection.ExcuteQueryGetTable(cautruyvan);
//        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
//        try {
//            while (rs.next()) {
//                displayvalueModel valueModel = new displayvalueModel(rs.getString(Ten), rs.getString(Ma));
//                cbbmodel.addElement(valueModel);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//        return cbbmodel;
//    }
    
    //--Code Nhập kho ---------------------------------------------------=-/
//    private void getDataReceipt() {
//        Object[] obj = new Object[]{"Mã phiếu", "Sản phẩm", "Số lượng"};
//        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
//        tblReceiptDetail.setModel(tableModel);
//        try {
//           
//        } catch (Exception ex) {
//            System.out.println(ex.toString());
//        }
//    }
//    
//    private void resetTableReceipt(){
//        txtCode.setText("");
//        txtProductName.setText("");
//        txtDescription.setText("");
//        txtQuantity.setValue(0);
//    }
    //------------------------------------------------------------------------------=-/
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtabPanel = new javax.swing.JTabbedPane();
        jTabbedPaneCategory = new javax.swing.JTabbedPane();
        jTabbedPaneProduct = new javax.swing.JTabbedPane();
        jTabbedPaneImport = new javax.swing.JTabbedPane();
        jTabbedPaneExport = new javax.swing.JTabbedPane();
        jTabbedPaneReport = new javax.swing.JTabbedPane();
        jTabbedPanePartner = new javax.swing.JTabbedPane();
        jTabbedAccount = new javax.swing.JTabbedPane();
        jTabbedPaneExit = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm Quản lý Kho");
        setMinimumSize(new java.awt.Dimension(905, 700));
        setPreferredSize(new java.awt.Dimension(905, 700));

        jPanel1.setRequestFocusEnabled(false);

        jtabPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jtabPanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtabPanel.setInheritsPopupMenu(true);

        jTabbedPaneCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneCategory.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPaneCategoryComponentShown(evt);
            }
        });
        jtabPanel.addTab("Danh mục", new javax.swing.ImageIcon(getClass().getResource("/public/images/attribute_category_label.png")), jTabbedPaneCategory); // NOI18N

        jTabbedPaneProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneProduct.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPaneProductComponentShown(evt);
            }
        });
        jtabPanel.addTab("Sản phẩm", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_Product_Hunt_1298713.png")), jTabbedPaneProduct); // NOI18N

        jTabbedPaneImport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneImport.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPaneImportComponentShown(evt);
            }
        });
        jtabPanel.addTab("Nhập kho", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_document-import_23211.png")), jTabbedPaneImport); // NOI18N
        jTabbedPaneImport.getAccessibleContext().setAccessibleName("Nhập Kho");

        jTabbedPaneExport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneExport.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPaneExportComponentShown(evt);
            }
        });
        jtabPanel.addTab("Xuất kho", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_document-export_23210.png")), jTabbedPaneExport); // NOI18N

        jTabbedPaneReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneReport.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPaneReportComponentShown(evt);
            }
        });
        jtabPanel.addTab("Báo cáo", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_product-sales-report_49607.png")), jTabbedPaneReport); // NOI18N

        jTabbedPanePartner.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPanePartner.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPanePartnerComponentShown(evt);
            }
        });
        jtabPanel.addTab("Đối tác", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_partner_search_86337.png")), jTabbedPanePartner); // NOI18N

        jTabbedAccount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedAccount.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedAccountComponentShown(evt);
            }
        });
        jtabPanel.addTab("Tài khoản", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_windows_users_7394.png")), jTabbedAccount); // NOI18N

        jTabbedPaneExit.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPaneExitComponentShown(evt);
            }
        });
        jtabPanel.addTab("Thoát", new javax.swing.ImageIcon(getClass().getResource("/public/images/thoat.png")), jTabbedPaneExit); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtabPanel)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtabPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private int _productId=0;
    private void jTabbedPaneCategoryComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPaneCategoryComponentShown
        // TODO add your handling code here:
        if(!jTabbedPaneCategory.hasFocus()) {
            jTabbedPaneCategory.removeAll();
            frmCategory frm = new frmCategory();
            jTabbedPaneCategory.addTab("Quản lý Danh mục", frm);
        }
    }//GEN-LAST:event_jTabbedPaneCategoryComponentShown

    private void jTabbedPaneProductComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPaneProductComponentShown
        // TODO add your handling code here:
        if(!jTabbedPaneProduct.hasFocus()) {
            jTabbedPaneProduct.removeAll();
            frmProduct frm = new frmProduct();
            jTabbedPaneProduct.addTab("Quản lý sản phẩm", frm);
        }
    }//GEN-LAST:event_jTabbedPaneProductComponentShown

    private void jTabbedPaneImportComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPaneImportComponentShown
        // TODO add your handling code here:
        if(!jTabbedPaneImport.hasFocus()) {
            jTabbedPaneImport.removeAll();
            frmImport frm = new frmImport();
            jTabbedPaneImport.addTab("Quản lý Nhập kho", frm);
        }
    }//GEN-LAST:event_jTabbedPaneImportComponentShown

    private void jTabbedPaneExportComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPaneExportComponentShown
        // TODO add your handling code here:
        if(!jTabbedPaneExport.hasFocus()) {
            jTabbedPaneExport.removeAll();
            frmExport frm = new frmExport();
            jTabbedPaneExport.addTab("Quản lý Xuất kho", frm);
        }
    }//GEN-LAST:event_jTabbedPaneExportComponentShown

    private void jTabbedPaneReportComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPaneReportComponentShown
        // TODO add your handling code here:
        if(!jTabbedPaneReport.hasFocus()) {
            jTabbedPaneReport.removeAll();
            frmReport frm = new frmReport();
            jTabbedPaneReport.addTab("Lập báo cáo", frm);
        }
    }//GEN-LAST:event_jTabbedPaneReportComponentShown

    private void jTabbedPanePartnerComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPanePartnerComponentShown
        // TODO add your handling code here:
        if(!jTabbedPanePartner.hasFocus()) {
            jTabbedPanePartner.removeAll();
            frmPartner frm = new frmPartner();
            jTabbedPanePartner.addTab("Quản lý đối tác", frm);
        }
    }//GEN-LAST:event_jTabbedPanePartnerComponentShown

    private void jTabbedAccountComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedAccountComponentShown
        // TODO add your handling code here:
        if(!jTabbedAccount.hasFocus()) {
            jTabbedAccount.removeAll();
            frmAccount frm = new frmAccount();
            jTabbedAccount.addTab("Quản lý Tài khoản", frm);
        }
    }//GEN-LAST:event_jTabbedAccountComponentShown

    private void jTabbedPaneExitComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPaneExitComponentShown
        // TODO add your handling code here:
        frmLogin frmLogin = new frmLogin();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTabbedPaneExitComponentShown

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedAccount;
    private javax.swing.JTabbedPane jTabbedPaneCategory;
    private javax.swing.JTabbedPane jTabbedPaneExit;
    private javax.swing.JTabbedPane jTabbedPaneExport;
    private javax.swing.JTabbedPane jTabbedPaneImport;
    private javax.swing.JTabbedPane jTabbedPanePartner;
    private javax.swing.JTabbedPane jTabbedPaneProduct;
    private javax.swing.JTabbedPane jTabbedPaneReport;
    private javax.swing.JTabbedPane jtabPanel;
    // End of variables declaration//GEN-END:variables
}
