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
        ImageIcon icon = new ImageIcon(getClass().getResource("../../images/warehouse.png"));
        this.setIconImage(icon.getImage());
    }

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
        jTabbedPaneListCategory = new javax.swing.JTabbedPane();
        jTabbedPaneAddNewCategory = new javax.swing.JTabbedPane();
        jTabbedPaneProduct = new javax.swing.JTabbedPane();
        jTabbedPaneListProduct = new javax.swing.JTabbedPane();
        jTabbedPaneAddNewProduct = new javax.swing.JTabbedPane();
        jTabbedPaneImport = new javax.swing.JTabbedPane();
        jTabbedPaneExport = new javax.swing.JTabbedPane();
        jTabbedPaneReport = new javax.swing.JTabbedPane();
        jTabbedPanePartner = new javax.swing.JTabbedPane();
        jTabbedAccount = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm Quản lý Kho");
        setPreferredSize(new java.awt.Dimension(1347, 611));

        jPanel1.setRequestFocusEnabled(false);

        jtabPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jtabPanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtabPanel.setInheritsPopupMenu(true);

        jTabbedPaneCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneCategory.addTab("Xem Danh sách Danh mục", new javax.swing.ImageIcon(getClass().getResource("/images/if_list-alt_173045.png")), jTabbedPaneListCategory); // NOI18N
        jTabbedPaneCategory.addTab("Thêm Danh mục", new javax.swing.ImageIcon(getClass().getResource("/images/if_sign-add_299068.png")), jTabbedPaneAddNewCategory); // NOI18N

        jtabPanel.addTab("Danh mục", new javax.swing.ImageIcon(getClass().getResource("/images/attribute_category_label.png")), jTabbedPaneCategory); // NOI18N

        jTabbedPaneProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTabbedPaneListProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneProduct.addTab("Xem Danh sách Sản phẩm", new javax.swing.ImageIcon(getClass().getResource("/images/if_list-alt_173045.png")), jTabbedPaneListProduct); // NOI18N

        jTabbedPaneAddNewProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneProduct.addTab("Thêm Sản phẩm", new javax.swing.ImageIcon(getClass().getResource("/images/if_sign-add_299068.png")), jTabbedPaneAddNewProduct); // NOI18N

        jtabPanel.addTab("Sản phẩm", new javax.swing.ImageIcon(getClass().getResource("/images/if_Product_Hunt_1298713.png")), jTabbedPaneProduct); // NOI18N
        jtabPanel.addTab("Nhập kho", new javax.swing.ImageIcon(getClass().getResource("/images/if_document-import_23211.png")), jTabbedPaneImport); // NOI18N
        jtabPanel.addTab("Xuất kho", new javax.swing.ImageIcon(getClass().getResource("/images/if_document-export_23210.png")), jTabbedPaneExport); // NOI18N
        jtabPanel.addTab("Báo cáo", new javax.swing.ImageIcon(getClass().getResource("/images/if_product-sales-report_49607.png")), jTabbedPaneReport); // NOI18N
        jtabPanel.addTab("Đối tác", new javax.swing.ImageIcon(getClass().getResource("/images/if_partner_search_86337.png")), jTabbedPanePartner); // NOI18N
        jtabPanel.addTab("Tài khoản", new javax.swing.ImageIcon(getClass().getResource("/images/if_windows_users_7394.png")), jTabbedAccount); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1347, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jtabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private javax.swing.JTabbedPane jTabbedPaneAddNewCategory;
    private javax.swing.JTabbedPane jTabbedPaneAddNewProduct;
    private javax.swing.JTabbedPane jTabbedPaneCategory;
    private javax.swing.JTabbedPane jTabbedPaneExport;
    private javax.swing.JTabbedPane jTabbedPaneImport;
    private javax.swing.JTabbedPane jTabbedPaneListCategory;
    private javax.swing.JTabbedPane jTabbedPaneListProduct;
    private javax.swing.JTabbedPane jTabbedPanePartner;
    private javax.swing.JTabbedPane jTabbedPaneProduct;
    private javax.swing.JTabbedPane jTabbedPaneReport;
    private javax.swing.JTabbedPane jtabPanel;
    // End of variables declaration//GEN-END:variables
}
