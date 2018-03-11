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
        frmCategory1 = new components.interfaces.frmCategory();
        jTabbedPaneProduct = new javax.swing.JTabbedPane();
        frmProduct = new components.interfaces.frmProduct();
        jTabbedPaneImport = new javax.swing.JTabbedPane();
        frmImport = new components.interfaces.frmImport();
        jTabbedPaneExport = new javax.swing.JTabbedPane();
        frmExport = new components.interfaces.frmExport();
        jTabbedPaneReport = new javax.swing.JTabbedPane();
        frmReport1 = new components.interfaces.frmReport();
        jTabbedPanePartner = new javax.swing.JTabbedPane();
        frmPartner = new components.interfaces.frmPartner();
        jTabbedAccount = new javax.swing.JTabbedPane();
        frmAccount1 = new components.interfaces.frmAccount();
        jTabbedPaneExit = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm Quản lý Kho");

        jPanel1.setRequestFocusEnabled(false);

        jtabPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jtabPanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtabPanel.setInheritsPopupMenu(true);

        jTabbedPaneCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout frmCategory1Layout = new javax.swing.GroupLayout(frmCategory1);
        frmCategory1.setLayout(frmCategory1Layout);
        frmCategory1Layout.setHorizontalGroup(
            frmCategory1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        frmCategory1Layout.setVerticalGroup(
            frmCategory1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        jTabbedPaneCategory.addTab("Quản lý Danh mục", frmCategory1);

        jtabPanel.addTab("Danh mục", new javax.swing.ImageIcon(getClass().getResource("/public/images/attribute_category_label.png")), jTabbedPaneCategory); // NOI18N

        jTabbedPaneProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneProduct.addTab("Danh sách sản phẩm", frmProduct);

        jtabPanel.addTab("Sản phẩm", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_Product_Hunt_1298713.png")), jTabbedPaneProduct); // NOI18N

        jTabbedPaneImport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneImport.addTab("Quản lý Nhập kho", frmImport);

        jtabPanel.addTab("Nhập kho", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_document-import_23211.png")), jTabbedPaneImport); // NOI18N
        jTabbedPaneImport.getAccessibleContext().setAccessibleName("Nhập Kho");

        jTabbedPaneExport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneExport.addTab("Quản lý Xuất kho", frmExport);

        jtabPanel.addTab("Xuất kho", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_document-export_23210.png")), jTabbedPaneExport); // NOI18N

        jTabbedPaneReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout frmReport1Layout = new javax.swing.GroupLayout(frmReport1);
        frmReport1.setLayout(frmReport1Layout);
        frmReport1Layout.setHorizontalGroup(
            frmReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        frmReport1Layout.setVerticalGroup(
            frmReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        jTabbedPaneReport.addTab("Báo cáo", frmReport1);

        jtabPanel.addTab("Báo cáo", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_product-sales-report_49607.png")), jTabbedPaneReport); // NOI18N

        jTabbedPanePartner.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPanePartner.addTab("Đối tác", frmPartner);

        jtabPanel.addTab("Đối tác", new javax.swing.ImageIcon(getClass().getResource("/public/images/if_partner_search_86337.png")), jTabbedPanePartner); // NOI18N

        jTabbedAccount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout frmAccount1Layout = new javax.swing.GroupLayout(frmAccount1);
        frmAccount1.setLayout(frmAccount1Layout);
        frmAccount1Layout.setHorizontalGroup(
            frmAccount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        frmAccount1Layout.setVerticalGroup(
            frmAccount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        jTabbedAccount.addTab("Quản lý Tài khoản", frmAccount1);

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
    private components.interfaces.frmAccount frmAccount1;
    private components.interfaces.frmCategory frmCategory1;
    private components.interfaces.frmExport frmExport;
    private components.interfaces.frmImport frmImport;
    private components.interfaces.frmPartner frmPartner;
    private components.interfaces.frmProduct frmProduct;
    private components.interfaces.frmReport frmReport1;
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
