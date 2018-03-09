/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.dao.*;
import components.dto.*;
import components.model.displayvalueModel;
import components.util.StringHelpers;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    
    ProductDAO productDao;
    PartnerDAO partnerDao;
    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        setInitForm();
        productDao = new ProductDAO();
        partnerDao = new PartnerDAO();
    }
    
    private void setInitForm() {
        ImageIcon icon = new ImageIcon(getClass().getResource("../../images/warehouse.png"));
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
    
    private int GetCbbSelected(JComboBox cbb) {
        Object[] obj = cbb.getSelectedObjects();
        displayvalueModel item = (displayvalueModel) obj[0];
        return Integer.parseInt(item.getDisplayvalue().toString());
    }
    
    private void setSelectedCombobox(String cbbselected, JComboBox cbb) {
        for (int i = 0; i < cbb.getItemCount(); i++) {
            Object obj = cbb.getItemAt(i);
            if (obj != null) {
                displayvalueModel m = (displayvalueModel) obj;
                if (cbbselected.trim().equals(m.getDisplayMember())) {
                    cbb.setSelectedItem(m);
                }
            }
        }
    }
    
    //--Code Sản phẩm---------------------------------------------------=-/
    private void getDataProduct(int status) {
        Object[] obj = new Object[]{"ID", "STT", "Mã Sản Phẩm", "Tên sản phẩm", "Mô tả", "Số lượng", "Trạng thái", "Loại sản phẩm"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        jTableSanPham.setModel(tableModel);
        int c = 0;
        try {
            List<Product> listProduct = productDao.getDataProduct(status);
            if( listProduct != null ) {
                for( int i =0; i < listProduct.size(); i++ ){
                    Object[] item = new Object[8];
                    item[0] = ++c;
                    item[1] = listProduct.get(i).getProductId();
                    item[2] = listProduct.get(i).getCode();
                    item[3] = listProduct.get(i).getProductName();
                    item[4] = listProduct.get(i).getDescription();
                    item[5] = listProduct.get(i).getQuantity();
                    item[6] = listProduct.get(i).getStatus();
                    item[7] = listProduct.get(i).getProductType();
                    tableModel.addRow(item);
                }           
            }  
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    private void resetTableProduct(){
        txtCode.setText("");
        txtProductName.setText("");
        txtDescription.setText("");
        txtQuantity.setValue(0);
    }
    //------------------------------------------------------------------------------=-/
    
    //--Code Nhập kho ---------------------------------------------------=-/
    private void getDataReceipt() {
        Object[] obj = new Object[]{"Mã phiếu", "Sản phẩm", "Số lượng"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblReceiptDetail.setModel(tableModel);
        try {
           
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    private void resetTableReceipt(){
        txtCode.setText("");
        txtProductName.setText("");
        txtDescription.setText("");
        txtQuantity.setValue(0);
    }
    //------------------------------------------------------------------------------=-/
    
    //--Code Đồi tác---------------------------------------------------=-/
    private void getDataPartner() {
        Object[] obj = new Object[]{"ID", "STT", "Tên đối tác", "Mô tả", "Địa chỉ", "Số điện thoại", "Tên người đại diện"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        jTablePartner.setModel(tableModel);
        int c = 0;
        try {
            List<Partner> listPartner = partnerDao.getDataPartner();
            if( listPartner != null ) {
                for( int i =0; i < listPartner.size(); i++ ){
                    Object[] item = new Object[7];
                    item[0] = listPartner.get(i).getPartnerId();
                    item[1] = ++c;
                    item[2] = listPartner.get(i).getPartnerName();
                    item[3] = listPartner.get(i).getDescription();
                    item[4] = listPartner.get(i).getAddress();
                    item[5] = listPartner.get(i).getNumPhone();
                    item[6] = listPartner.get(i).getRepresentFullname();
                    tableModel.addRow(item);
                }           
            }  
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    private void resetTablePartner()
    {
        txtTenDoiTac.setText("");
        txtTenNDD.setText("");
        txtSoDienThoai.setText("");
        txtDiaChi.setText("");
        jTextAreaMoTa.setText("");
        
    }
    //---------------------------------------------------------------------

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
        jPanelDanhSachDanhMuc = new javax.swing.JPanel();
        jTabbedPaneProduct = new javax.swing.JTabbedPane();
        jPanelDanhSachSanPham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JSpinner();
        cboStatus = new javax.swing.JComboBox<>();
        cboCategory = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPaneImport = new javax.swing.JTabbedPane();
        jPanelDanhSachPhieuNhap = new javax.swing.JPanel();
        plReceiptDetail = new javax.swing.JScrollPane();
        tblReceiptDetail = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtReceiptId = new javax.swing.JTextField();
        dtpDatetime = new javax.swing.JTextField();
        cbbPartner = new javax.swing.JComboBox<>();
        cbbStatus = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        btnInsert2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        btnReset2 = new javax.swing.JButton();
        jTabbedPaneExport = new javax.swing.JTabbedPane();
        jPanelDanhSachPhieuXuat = new javax.swing.JPanel();
        plReceiptDetail1 = new javax.swing.JScrollPane();
        tblReceiptDetail1 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtReceiptId1 = new javax.swing.JTextField();
        dtpDatetime1 = new javax.swing.JTextField();
        cbbPartner1 = new javax.swing.JComboBox<>();
        cbbStatus1 = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        btnInsert3 = new javax.swing.JButton();
        btnDelete3 = new javax.swing.JButton();
        btnReset3 = new javax.swing.JButton();
        jTabbedPaneReport = new javax.swing.JTabbedPane();
        jTabbedPanePartner = new javax.swing.JTabbedPane();
        jPanelDanhSachDoiTac = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePartner = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTenDoiTac = new javax.swing.JTextField();
        txtTenNDD = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnInsert1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaMoTa = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTabbedAccount = new javax.swing.JTabbedPane();
        jTabbedPaneExit = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm Quản lý Kho");

        jPanel1.setRequestFocusEnabled(false);

        jtabPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jtabPanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtabPanel.setInheritsPopupMenu(true);

        jTabbedPaneCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanelDanhSachDanhMuc.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelDanhSachDanhMucComponentShown(evt);
            }
        });

        javax.swing.GroupLayout jPanelDanhSachDanhMucLayout = new javax.swing.GroupLayout(jPanelDanhSachDanhMuc);
        jPanelDanhSachDanhMuc.setLayout(jPanelDanhSachDanhMucLayout);
        jPanelDanhSachDanhMucLayout.setHorizontalGroup(
            jPanelDanhSachDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
        );
        jPanelDanhSachDanhMucLayout.setVerticalGroup(
            jPanelDanhSachDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        jTabbedPaneCategory.addTab("Danh sách Danh mục", jPanelDanhSachDanhMuc);

        jtabPanel.addTab("Danh mục", new javax.swing.ImageIcon(getClass().getResource("/images/attribute_category_label.png")), jTabbedPaneCategory); // NOI18N

        jTabbedPaneProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPaneProduct.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPaneProductComponentShown(evt);
            }
        });

        jPanelDanhSachSanPham.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelDanhSachSanPhamComponentShown(evt);
            }
        });

        jTableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "STT", "Mã Sản phẩm", "Tên Sản phẩm", "Mô tả", "Số lượng", "Trạng thái", "Loại sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSanPham);

        jLabel1.setText("Mã sản phẩm:");

        jLabel2.setText("Tên Sản phẩm:");

        jLabel3.setText("Mô tả:");

        jLabel4.setText("Số lượng:");

        jLabel5.setText("Trạng thái:");

        jLabel6.setText("Loại sản phẩm:");

        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Chỉnh sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCategory, 0, 253, Short.MAX_VALUE)
                    .addComponent(txtQuantity)
                    .addComponent(cboStatus, 0, 253, Short.MAX_VALUE)
                    .addComponent(txtCode)
                    .addComponent(txtProductName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDanhSachSanPhamLayout = new javax.swing.GroupLayout(jPanelDanhSachSanPham);
        jPanelDanhSachSanPham.setLayout(jPanelDanhSachSanPhamLayout);
        jPanelDanhSachSanPhamLayout.setHorizontalGroup(
            jPanelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhSachSanPhamLayout.createSequentialGroup()
                .addGroup(jPanelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDanhSachSanPhamLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelDanhSachSanPhamLayout.setVerticalGroup(
            jPanelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDanhSachSanPhamLayout.createSequentialGroup()
                .addGroup(jPanelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneProduct.addTab("Danh sách Sản phẩm", jPanelDanhSachSanPham);

        jtabPanel.addTab("Sản phẩm", new javax.swing.ImageIcon(getClass().getResource("/images/if_Product_Hunt_1298713.png")), jTabbedPaneProduct); // NOI18N

        jTabbedPaneImport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanelDanhSachPhieuNhap.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelDanhSachPhieuNhapComponentShown(evt);
            }
        });

        tblReceiptDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "STT", "Mã Sản phẩm", "Tên Sản phẩm", "Mô tả", "Số lượng", "Trạng thái", "Loại sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblReceiptDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReceiptDetailMouseClicked(evt);
            }
        });
        plReceiptDetail.setViewportView(tblReceiptDetail);

        jLabel13.setText("Mã phiếu:");

        jLabel15.setText("Đối tác:");

        jLabel16.setText("Ngày lập phiếu: ");

        jLabel18.setText("Trạng thái:");

        txtReceiptId.setEditable(false);
        txtReceiptId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReceiptIdActionPerformed(evt);
            }
        });

        cbbPartner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cty TNHH MTV Ánh Dương", "Cty CPTMDT TheGioiDiDong" }));

        cbbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Done", "Hủy" }));

        btnInsert2.setText("Lập phiếu nhập");
        btnInsert2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsert2ActionPerformed(evt);
            }
        });

        btnDelete2.setText("Hủy");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        btnReset2.setText("Reset");
        btnReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInsert2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(btnDelete2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReset2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInsert2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbPartner, 0, 253, Short.MAX_VALUE)
                    .addComponent(txtReceiptId)
                    .addComponent(dtpDatetime, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtReceiptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbbPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(dtpDatetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDanhSachPhieuNhapLayout = new javax.swing.GroupLayout(jPanelDanhSachPhieuNhap);
        jPanelDanhSachPhieuNhap.setLayout(jPanelDanhSachPhieuNhapLayout);
        jPanelDanhSachPhieuNhapLayout.setHorizontalGroup(
            jPanelDanhSachPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhSachPhieuNhapLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 280, Short.MAX_VALUE))
            .addComponent(plReceiptDetail)
        );
        jPanelDanhSachPhieuNhapLayout.setVerticalGroup(
            jPanelDanhSachPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDanhSachPhieuNhapLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plReceiptDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneImport.addTab("Nhập kho", jPanelDanhSachPhieuNhap);

        jtabPanel.addTab("Nhập kho", new javax.swing.ImageIcon(getClass().getResource("/images/if_document-import_23211.png")), jTabbedPaneImport); // NOI18N
        jTabbedPaneImport.getAccessibleContext().setAccessibleName("Nhập Kho");

        jTabbedPaneExport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanelDanhSachPhieuXuat.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelDanhSachPhieuXuatComponentShown(evt);
            }
        });

        tblReceiptDetail1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "STT", "Mã Sản phẩm", "Tên Sản phẩm", "Mô tả", "Số lượng", "Trạng thái", "Loại sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblReceiptDetail1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReceiptDetail1MouseClicked(evt);
            }
        });
        plReceiptDetail1.setViewportView(tblReceiptDetail1);

        jLabel17.setText("Mã phiếu:");

        jLabel19.setText("Đối tác:");

        jLabel20.setText("Ngày lập phiếu: ");

        jLabel21.setText("Trạng thái:");

        txtReceiptId1.setEditable(false);
        txtReceiptId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReceiptId1ActionPerformed(evt);
            }
        });

        cbbPartner1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cty TNHH MTV Ánh Dương", "Cty CPTMDT TheGioiDiDong" }));

        cbbStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Done", "Hủy" }));

        btnInsert3.setText("Lập phiếu xuất");
        btnInsert3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsert3ActionPerformed(evt);
            }
        });

        btnDelete3.setText("Hủy");
        btnDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete3ActionPerformed(evt);
            }
        });

        btnReset3.setText("Reset");
        btnReset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInsert3, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(btnDelete3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReset3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInsert3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbStatus1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbPartner1, 0, 253, Short.MAX_VALUE)
                    .addComponent(txtReceiptId1)
                    .addComponent(dtpDatetime1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtReceiptId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbbPartner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(dtpDatetime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbbStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDanhSachPhieuXuatLayout = new javax.swing.GroupLayout(jPanelDanhSachPhieuXuat);
        jPanelDanhSachPhieuXuat.setLayout(jPanelDanhSachPhieuXuatLayout);
        jPanelDanhSachPhieuXuatLayout.setHorizontalGroup(
            jPanelDanhSachPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhSachPhieuXuatLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 280, Short.MAX_VALUE))
            .addComponent(plReceiptDetail1)
        );
        jPanelDanhSachPhieuXuatLayout.setVerticalGroup(
            jPanelDanhSachPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDanhSachPhieuXuatLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plReceiptDetail1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneExport.addTab("Nhập kho", jPanelDanhSachPhieuXuat);

        jtabPanel.addTab("Xuất kho", new javax.swing.ImageIcon(getClass().getResource("/images/if_document-export_23210.png")), jTabbedPaneExport); // NOI18N
        jtabPanel.addTab("Báo cáo", new javax.swing.ImageIcon(getClass().getResource("/images/if_product-sales-report_49607.png")), jTabbedPaneReport); // NOI18N

        jTabbedPanePartner.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPanePartner.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPanePartnerComponentShown(evt);
            }
        });

        jPanelDanhSachDoiTac.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelDanhSachDoiTacComponentShown(evt);
            }
        });

        jTablePartner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "STT", "Tên đối tác", "Mô tả", "Địa chỉ", "Số điện thoại", "Tên người đại diện"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTablePartner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePartnerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePartner);

        jLabel8.setText("Tên đối tác:");

        jLabel9.setText("Tên Người đại diện:");

        jLabel10.setText("Số điện thoại:");

        jLabel11.setText("Địa chỉ:");

        jLabel12.setText("Mô tả:");

        btnInsert1.setText("Thêm");
        btnInsert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsert1ActionPerformed(evt);
            }
        });

        btnUpdate1.setText("Chỉnh sửa");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        btnDelete1.setText("Xóa");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnReset1.setText("Reset");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInsert1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUpdate1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(btnDelete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReset1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnInsert1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTextAreaMoTa.setColumns(20);
        jTextAreaMoTa.setRows(5);
        jScrollPane3.setViewportView(jTextAreaMoTa);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenDoiTac, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(txtTenNDD, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenDoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenNDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel12)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDanhSachDoiTacLayout = new javax.swing.GroupLayout(jPanelDanhSachDoiTac);
        jPanelDanhSachDoiTac.setLayout(jPanelDanhSachDoiTacLayout);
        jPanelDanhSachDoiTacLayout.setHorizontalGroup(
            jPanelDanhSachDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhSachDoiTacLayout.createSequentialGroup()
                .addGroup(jPanelDanhSachDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDanhSachDoiTacLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanelDanhSachDoiTacLayout.setVerticalGroup(
            jPanelDanhSachDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDanhSachDoiTacLayout.createSequentialGroup()
                .addGroup(jPanelDanhSachDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPanePartner.addTab("Danh sách Đối tác", jPanelDanhSachDoiTac);

        jtabPanel.addTab("Đối tác", new javax.swing.ImageIcon(getClass().getResource("/images/if_partner_search_86337.png")), jTabbedPanePartner); // NOI18N
        jtabPanel.addTab("Tài khoản", new javax.swing.ImageIcon(getClass().getResource("/images/if_windows_users_7394.png")), jTabbedAccount); // NOI18N

        jTabbedPaneExit.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPaneExitComponentShown(evt);
            }
        });
        jtabPanel.addTab("Thoát", new javax.swing.ImageIcon(getClass().getResource("/images/thoat.png")), jTabbedPaneExit); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtabPanel)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtabPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
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
    private void jTableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseClicked
        // TODO add your handling code here:
        int index = jTableSanPham.getSelectedRow();
        this._productId = Integer.valueOf(jTableSanPham.getValueAt(index, 0).toString());
        txtCode.setText(jTableSanPham.getValueAt(index, 2).toString());
        txtProductName.setText(jTableSanPham.getValueAt(index, 3).toString());
        txtDescription.setText(jTableSanPham.getValueAt(index, 4).toString());
        txtQuantity.setValue(Integer.valueOf(jTableSanPham.getValueAt(index, 5).toString())); 
        setSelectedCombobox(jTableSanPham.getValueAt(index, 6).toString(), cboStatus);
        setSelectedCombobox(jTableSanPham.getValueAt(index, 7).toString(), cboCategory);
    }//GEN-LAST:event_jTableSanPhamMouseClicked

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String Code, productName,Description;
        int Quantity, Status, productType;
        
        if(txtCode.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Mã sản phẩm", "Thông báo", 2);
            txtCode.requestFocus();
            return;
        } else if(txtProductName.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Tên Sản phẩm", "Thông báo", 2);
            txtProductName.requestFocus();
            return;
        } else if(txtDescription.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập mô tả", "Thông báo", 2);
            txtDescription.requestFocus();
            return;
        } else if(!StringHelpers.isInteger(txtQuantity.getValue().toString())) {
            StringHelpers.Message("Số lượng phải là số nguyên", "Thông báo", 2);
            txtQuantity.requestFocus();
            return;
        } else if( Integer.parseInt(txtQuantity.getValue().toString()) <= 0 ) {
            StringHelpers.Message("Số lượng phải là số nguyên > 0", "Thông báo", 2);
            txtQuantity.requestFocus();
            return;
        }
        
        Code = txtCode.getText();
        productName = txtProductName.getText();
        Description = txtDescription.getText();
        Quantity = Integer.parseInt(txtQuantity.getValue().toString());
        Status = GetCbbSelected(cboStatus);
        productType = GetCbbSelected(cboCategory);
        
        Product dto = new Product(-1, Code, productName, Description, Quantity, Status, productType);

        if( productDao.insert(dto) ) {
            StringHelpers.Message("Sản phẩm đã được thêm vào csdl", "Thành công", 1);
        } else {
            StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
        }
        getDataProduct(1);
        resetTableProduct();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String Code, productName,Description;
        int Quantity, Status, productType;
        
        if(txtCode.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Mã sản phẩm", "Thông báo", 2);
            txtCode.requestFocus();
            return;
        } else if(txtProductName.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Tên Sản phẩm", "Thông báo", 2);
            txtProductName.requestFocus();
            return;
        } else if(txtDescription.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập mô tả", "Thông báo", 2);
            txtDescription.requestFocus();
            return;
        } else if(!StringHelpers.isInteger(txtQuantity.getValue().toString())) {
            StringHelpers.Message("Số lượng phải là số nguyên", "Thông báo", 2);
            txtQuantity.requestFocus();
            return;
        } else if( Integer.parseInt(txtQuantity.getValue().toString()) <= 0 ) {
            StringHelpers.Message("Số lượng phải là số nguyên > 0", "Thông báo", 2);
            txtQuantity.requestFocus();
            return;
        }
        
        Code = txtCode.getText();
        productName = txtProductName.getText();
        Description = txtDescription.getText();
        Quantity = Integer.parseInt(txtQuantity.getValue().toString());
        Status = GetCbbSelected(cboStatus);
        productType = GetCbbSelected(cboCategory);
        
        Product dto = new Product(this._productId, Code, productName, Description, Quantity, Status, productType);

        if( productDao.update(dto) ) {
            StringHelpers.Message("Sản phẩm đã được cập nhật thành công", "Thành công", 1);
        } else {
            StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
        }
        getDataProduct(1);
        resetTableProduct();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn chắc chắn muốn xóa sản phẩm này?", "Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            Product dto = new Product();
            dto.setProductId(this._productId);
            if( productDao.delete(dto) ) {
                StringHelpers.Message("Sản phẩm đã được Xóa thành công", "Thành công", 1);
            } else {
                StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
            }
            getDataProduct(1);
            resetTableProduct();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetTableProduct();
    }//GEN-LAST:event_btnResetActionPerformed

    private void jPanelDanhSachDanhMucComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelDanhSachDanhMucComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelDanhSachDanhMucComponentShown

    private void jPanelDanhSachSanPhamComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelDanhSachSanPhamComponentShown
        // TODO add your handling code here:
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        displayvalueModel valueModel1 = new displayvalueModel("Hiển", 1);
        cbbmodel.addElement(valueModel1);
        displayvalueModel valueModel2 = new displayvalueModel("Ẩn", 2);
        cbbmodel.addElement(valueModel2);
        cboStatus.setModel(cbbmodel);
        
        
        DefaultComboBoxModel cbbmodel2 = new DefaultComboBoxModel();
        displayvalueModel valueModel3 = new displayvalueModel("Văn phòng phẩm", 1);
        cbbmodel2.addElement(valueModel3);
        displayvalueModel valueModel4 = new displayvalueModel("Đồ gia dụng", 2);
        cbbmodel2.addElement(valueModel4);
        displayvalueModel valueModel5 = new displayvalueModel("Đồ điện", 2);
        cbbmodel2.addElement(valueModel5);
        cboCategory.setModel(cbbmodel2);
        
        
    }//GEN-LAST:event_jPanelDanhSachSanPhamComponentShown

    private void jTabbedPaneExitComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPaneExitComponentShown
        // TODO add your handling code here:
        frmLogin frmLogin = new frmLogin();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTabbedPaneExitComponentShown

    private void jTabbedPaneProductComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPaneProductComponentShown
        // TODO add your handling code here:
        getDataProduct(1);
        jTableSanPham.getColumnModel().getColumn(0).setMinWidth(0);
        jTableSanPham.getColumnModel().getColumn(0).setMaxWidth(0);
    }//GEN-LAST:event_jTabbedPaneProductComponentShown

    private void jPanelDanhSachDoiTacComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelDanhSachDoiTacComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelDanhSachDoiTacComponentShown

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        // TODO add your handling code here:
        resetTablePartner();
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn chắc chắn muốn xóa đối tác này?", "Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            Partner dto = new Partner();
            dto.setPartnerId(this._partnerId);
            if( partnerDao.delete(dto) ) {
                StringHelpers.Message("Đối tác đã được Xóa thành công", "Thành công", 1);
            } else {
                StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
            }
            getDataPartner();
            resetTablePartner();
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        // TODO add your handling code here:
        String tenDoiTac, tenNguoiDaiDien, sdt, diachi, mota;
        
        if(txtTenDoiTac.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Tên Đói tác", "Thông báo", 2);
            txtTenDoiTac.requestFocus();
            return;
        } else if(txtTenNDD.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Tên Người đại diện", "Thông báo", 2);
            txtTenNDD.requestFocus();
            return;
        } else if(txtSoDienThoai.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Số điện thoại", "Thông báo", 2);
            txtSoDienThoai.requestFocus();
            return;
        } else if(txtDiaChi.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Địa chỉ", "Thông báo", 2);
            txtDiaChi.requestFocus();
            return;
        } 
        //
        
        tenDoiTac = txtTenDoiTac.getText();
        tenNguoiDaiDien = txtTenNDD.getText();
        sdt = txtSoDienThoai.getText();
        diachi = txtDiaChi.getText();
        mota = jTextAreaMoTa.getText();
        
        Partner dto = new Partner(this._partnerId, tenDoiTac, mota, diachi, sdt, tenNguoiDaiDien );
        if( partnerDao.update(dto) ) {
            StringHelpers.Message("Đối tác đã được cập nhật", "Thành công", 1);
        } else {
            StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
        }
        getDataPartner();
        resetTablePartner();
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnInsert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsert1ActionPerformed
        // TODO add your handling code here:
        //Xử lý thêm
        String tenDoiTac, tenNguoiDaiDien, sdt, diachi, mota;
        
        if(txtTenDoiTac.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Tên Đói tác", "Thông báo", 2);
            txtTenDoiTac.requestFocus();
            return;
        } else if(txtTenNDD.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Tên Người đại diện", "Thông báo", 2);
            txtTenNDD.requestFocus();
            return;
        } else if(txtSoDienThoai.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Số điện thoại", "Thông báo", 2);
            txtSoDienThoai.requestFocus();
            return;
        } else if(txtDiaChi.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Địa chỉ", "Thông báo", 2);
            txtDiaChi.requestFocus();
            return;
        } else if(jTextAreaMoTa.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Địa chỉ", "Thông báo", 2);
            jTextAreaMoTa.requestFocus();
            return;
        }
        
        tenDoiTac = txtTenDoiTac.getText();
        tenNguoiDaiDien = txtTenNDD.getText();
        sdt = txtSoDienThoai.getText();
        diachi = txtDiaChi.getText();
        mota = jTextAreaMoTa.getText();
        
        Partner dto = new Partner(-1, tenDoiTac, mota, diachi, sdt, tenNguoiDaiDien );
        if( partnerDao.insert(dto) ) {
            StringHelpers.Message("Đối tác đã được thêm vào csdl", "Thành công", 1);
        } else {
            StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
        }
        getDataPartner();
        resetTablePartner();
    }//GEN-LAST:event_btnInsert1ActionPerformed

    private int _partnerId;
    private void jTablePartnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePartnerMouseClicked
        // TODO add your handling code here:
        int index = jTablePartner.getSelectedRow();
        this._partnerId = Integer.valueOf(jTablePartner.getValueAt(index, 0).toString());
        txtTenDoiTac.setText(jTablePartner.getValueAt(index, 2).toString());
        txtTenNDD.setText(jTablePartner.getValueAt(index, 6).toString());
        txtSoDienThoai.setText(jTablePartner.getValueAt(index, 5).toString());
        txtDiaChi.setText(jTablePartner.getValueAt(index, 4).toString());
        jTextAreaMoTa.setText(jTablePartner.getValueAt(index, 3).toString());
    }//GEN-LAST:event_jTablePartnerMouseClicked

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void jTabbedPanePartnerComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPanePartnerComponentShown
        // TODO add your handling code here:
        getDataPartner();
        jTablePartner.getColumnModel().getColumn(0).setMinWidth(0);
        jTablePartner.getColumnModel().getColumn(0).setMaxWidth(0);
    }//GEN-LAST:event_jTabbedPanePartnerComponentShown

    private void tblReceiptDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReceiptDetailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblReceiptDetailMouseClicked

    private void txtReceiptIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReceiptIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReceiptIdActionPerformed

    private void btnInsert2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsert2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsert2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset2ActionPerformed

    private void jPanelDanhSachPhieuNhapComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelDanhSachPhieuNhapComponentShown
        getDataReceipt();
        jTableSanPham.getColumnModel().getColumn(0).setMinWidth(0);
        jTableSanPham.getColumnModel().getColumn(0).setMaxWidth(0);
    }//GEN-LAST:event_jPanelDanhSachPhieuNhapComponentShown

    private void tblReceiptDetail1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReceiptDetail1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblReceiptDetail1MouseClicked

    private void txtReceiptId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReceiptId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReceiptId1ActionPerformed

    private void btnInsert3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsert3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsert3ActionPerformed

    private void btnDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete3ActionPerformed

    private void btnReset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset3ActionPerformed

    private void jPanelDanhSachPhieuXuatComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelDanhSachPhieuXuatComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelDanhSachPhieuXuatComponentShown

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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnDelete3;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnInsert1;
    private javax.swing.JButton btnInsert2;
    private javax.swing.JButton btnInsert3;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnReset2;
    private javax.swing.JButton btnReset3;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JComboBox<String> cbbPartner;
    private javax.swing.JComboBox<String> cbbPartner1;
    private javax.swing.JComboBox<String> cbbStatus;
    private javax.swing.JComboBox<String> cbbStatus1;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JTextField dtpDatetime;
    private javax.swing.JTextField dtpDatetime1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelDanhSachDanhMuc;
    private javax.swing.JPanel jPanelDanhSachDoiTac;
    private javax.swing.JPanel jPanelDanhSachPhieuNhap;
    private javax.swing.JPanel jPanelDanhSachPhieuXuat;
    private javax.swing.JPanel jPanelDanhSachSanPham;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedAccount;
    private javax.swing.JTabbedPane jTabbedPaneCategory;
    private javax.swing.JTabbedPane jTabbedPaneExit;
    private javax.swing.JTabbedPane jTabbedPaneExport;
    private javax.swing.JTabbedPane jTabbedPaneImport;
    private javax.swing.JTabbedPane jTabbedPanePartner;
    private javax.swing.JTabbedPane jTabbedPaneProduct;
    private javax.swing.JTabbedPane jTabbedPaneReport;
    private javax.swing.JTable jTablePartner;
    private javax.swing.JTable jTableSanPham;
    private javax.swing.JTextArea jTextAreaMoTa;
    private javax.swing.JTabbedPane jtabPanel;
    private javax.swing.JScrollPane plReceiptDetail;
    private javax.swing.JScrollPane plReceiptDetail1;
    private javax.swing.JTable tblReceiptDetail;
    private javax.swing.JTable tblReceiptDetail1;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JSpinner txtQuantity;
    private javax.swing.JTextField txtReceiptId;
    private javax.swing.JTextField txtReceiptId1;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenDoiTac;
    private javax.swing.JTextField txtTenNDD;
    // End of variables declaration//GEN-END:variables
}
