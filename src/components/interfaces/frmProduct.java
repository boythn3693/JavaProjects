/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.entity.Product;
import components.dao.displayvalueModel;
import components.services.ProductService;
import components.utils.StringHelpers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author MitsuyoRai
 */
public class frmProduct extends javax.swing.JPanel {
    private int _productId = -1;
    int pageSize = 5;
    long count;
    int totalPage, page = 1;
    DefaultTableModel tableModel;
    ProductService productService;
    /**
     * Creates new form frmProduct
     */
    public frmProduct() {
        initComponents();
        productService = new ProductService();
        onLoad();
    }  
    
    private void onLoad(){
        count = productService.countTable();
        totalPage = (int)(Math.ceil(count/pageSize));
    }
    
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
    private void getHeaderTable()
    {
        Object[] obj = new Object[]{"ID", "STT", "Mã Sản Phẩm", "Tên sản phẩm", "Mô tả", "Số lượng", "Status", "Trạng thái", "ProductType", "Loại sản phẩm"};
        tableModel = new DefaultTableModel(obj, 0);
        jTableSanPham.setModel(tableModel);
    }
    private void getDataProduct(int status) {
        ArrayList _status = new ArrayList();
        _status.add(0, "None");
        _status.add(1, "Hiện");
        _status.add(2, "Ẩn");
        
        ArrayList _productType = new ArrayList();
        _productType.add(0, "None");
        _productType.add(1, "Văn phòng phẩm");
        _productType.add(2, "Đồ gia dụng");
        _productType.add(3, "Đồ điện");
        int c = 0;
        try {
            List<Product> listProduct = productService.getDataProduct(status, page, pageSize);
            Iterator iter = listProduct.iterator();
            while ( iter.hasNext() ) {
                Product product = (Product) iter.next();
                Object[] item = new Object[10];
                item[0] = product.getProductId();
                item[1] = ++c;
                item[2] = product.getCode();
                item[3] = product.getProductName();
                item[4] = product.getDescription();
                item[5] = product.getQuantity();
                item[6] = product.getStatus();
                item[7] = _status.get(product.getStatus());
                item[8] = product.getProductType();
                item[9] = _productType.get(product.getProductType());
                tableModel.addRow(item);          
            } 
            //Ẩn ID
            jTableSanPham.getColumnModel().getColumn(0).setMinWidth(0);
            jTableSanPham.getColumnModel().getColumn(0).setMaxWidth(0);
            //Ẩn Status
            jTableSanPham.getColumnModel().getColumn(6).setMinWidth(0);
            jTableSanPham.getColumnModel().getColumn(6).setMaxWidth(0);
            //Ẩn ProductType
            jTableSanPham.getColumnModel().getColumn(8).setMinWidth(0);
            jTableSanPham.getColumnModel().getColumn(8).setMaxWidth(0);
        } catch (Exception ex) {
            System.out.println("123");
            System.out.println(ex.toString());
        }
        lblSoTrang.setText(page+ "/"+totalPage);
        lblPage.setText(""+page);
    }
    
    private void resetInputProduct(){
        txtCode.setText("");
        txtProductName.setText("");
        txtDescription.setText("");
        txtQuantity.setValue(0);
    }
    
    private void getDataProductType()
    {
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
        displayvalueModel valueModel5 = new displayvalueModel("Đồ điện", 3);
        cbbmodel2.addElement(valueModel5);
        cboCategory.setModel(cbbmodel2);
    }
    //------------------------------------------------------------------------------=-/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel8 = new javax.swing.JLabel();
        txtSearchField = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbCode = new javax.swing.JCheckBox();
        cbProductName = new javax.swing.JCheckBox();
        cbDescription = new javax.swing.JCheckBox();
        cbQuantity = new javax.swing.JCheckBox();
        cbStatus = new javax.swing.JCheckBox();
        cbProductType = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jButtonPreAll = new javax.swing.JButton();
        jButtonPre = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();
        jButtonNext = new javax.swing.JButton();
        jButtonNextAll = new javax.swing.JButton();
        lblSoTrang = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "STT", "Mã Sản phẩm", "Tên Sản phẩm", "Mô tả", "Số lượng", "Status", "Trạng thái", "ProductType", "Loại sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
                    .addComponent(cboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel8.setText("Từ khóa:");

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        jLabel9.setText("Tìm theo:");

        cbCode.setText("Mã Sản phẩm");

        cbProductName.setSelected(true);
        cbProductName.setText("Tên Sản phẩm");

        cbDescription.setText("Mô tả");

        cbQuantity.setText("Số lượng");

        cbStatus.setText("Trạng thái");

        cbProductType.setText("Loại sản phẩm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFilter)
                .addGap(108, 108, 108))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchField))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCode)
                            .addComponent(cbDescription)
                            .addComponent(cbStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbQuantity)
                            .addComponent(cbProductName)
                            .addComponent(cbProductType))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbCode)
                    .addComponent(cbProductName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDescription)
                    .addComponent(cbQuantity))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatus)
                    .addComponent(cbProductType))
                .addGap(26, 26, 26)
                .addComponent(btnFilter)
                .addContainerGap())
        );

        jButtonPreAll.setText("<<");
        jButtonPreAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreAllActionPerformed(evt);
            }
        });

        jButtonPre.setText("<");
        jButtonPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreActionPerformed(evt);
            }
        });

        lblPage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPage.setText("0");

        jButtonNext.setText(">");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonNextAll.setText(">>");
        jButtonNextAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextAllActionPerformed(evt);
            }
        });

        lblSoTrang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSoTrang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoTrang.setText("1/1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jButtonPreAll, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPre, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNext, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNextAll, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblSoTrang)
                .addGap(261, 261, 261))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonPreAll, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(jButtonPre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSoTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonNextAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelDanhSachSanPhamLayout = new javax.swing.GroupLayout(jPanelDanhSachSanPham);
        jPanelDanhSachSanPham.setLayout(jPanelDanhSachSanPhamLayout);
        jPanelDanhSachSanPhamLayout.setHorizontalGroup(
            jPanelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanelDanhSachSanPhamLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelDanhSachSanPhamLayout.setVerticalGroup(
            jPanelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhSachSanPhamLayout.createSequentialGroup()
                .addGroup(jPanelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelDanhSachSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanelDanhSachSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseClicked
        // TODO add your handling code here:
        int index = jTableSanPham.getSelectedRow();
        this._productId = Integer.valueOf(jTableSanPham.getValueAt(index, 0).toString());
        txtCode.setText(jTableSanPham.getValueAt(index, 2).toString());
        txtProductName.setText(jTableSanPham.getValueAt(index, 3).toString());
        txtDescription.setText(jTableSanPham.getValueAt(index, 4).toString());
        txtQuantity.setValue(Integer.valueOf(jTableSanPham.getValueAt(index, 5).toString()));
        setSelectedCombobox(jTableSanPham.getValueAt(index, 6).toString(), cboStatus);
        setSelectedCombobox(jTableSanPham.getValueAt(index, 8).toString(), cboCategory);
    }//GEN-LAST:event_jTableSanPhamMouseClicked

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String Code, productName,Description;
        int Quantity, Status, productType;

        if(txtCode.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Mã sản phẩm", "Thông báo", 2);
            txtCode.requestFocus();
            return;
        } else if(!productService.hasCode(txtCode.getText().toString())){
            StringHelpers.Message("Mã sản phẩm đã tồn tại", "Thông báo", 2);
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

        if( productService.insert(dto) ) {
            StringHelpers.Message("Sản phẩm đã được thêm vào csdl", "Thành công", 1);
        } else {
            StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
        }
        onLoad();
        
        getHeaderTable();
        getDataProduct(1);
        resetInputProduct();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String Code, productName,Description;
        int Quantity, Status, productType;

        if(txtCode.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Mã sản phẩm", "Thông báo", 2);
            txtCode.requestFocus();
            return;
        } else if(!productService.hasCode(txtCode.getText().toString(), this._productId)){
            StringHelpers.Message("Mã sản phẩm đã tồn tại", "Thông báo", 2);
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

        if( productService.update(dto) ) {
            StringHelpers.Message("Sản phẩm đã được cập nhật thành công", "Thành công", 1);
        } else {
            StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
        }
        onLoad();
        
        getHeaderTable();
        getDataProduct(1);
        resetInputProduct();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn chắc chắn muốn xóa sản phẩm này?", "Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            Product dto = new Product();
            dto.setProductId(this._productId);
            if( productService.delete(dto) ) {
                StringHelpers.Message("Sản phẩm đã được Xóa thành công", "Thành công", 1);
            } else {
                StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
            }
            
            onLoad();
            
            getHeaderTable();
            getDataProduct(1);
            resetInputProduct();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetInputProduct();
    }//GEN-LAST:event_btnResetActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        getDataProductType();
        resetInputProduct();
        getHeaderTable();
        getDataProduct(1);
    }//GEN-LAST:event_formComponentShown

    private void jButtonPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreActionPerformed
        // TODO add your handling code here:
        if(page > 1){
            page--;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_jButtonPreActionPerformed

    private void jButtonPreAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreAllActionPerformed
        // TODO add your handling code here:
        if(page > 1){
            page=1;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_jButtonPreAllActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:
        if(page < totalPage){
            page++;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonNextAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextAllActionPerformed
        // TODO add your handling code here:
        if(page < totalPage){
            page = totalPage;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_jButtonNextAllActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        Boolean isCode = false, 
                isName = false, 
                isDescription = false, 
                isQuantity = false, 
                isStatus = false, 
                isProductType = false;
        if( cbCode.isSelected() ){
            isCode = true;
        }
        if( cbProductName.isSelected() ){
            isName = true;
        }
        if( cbDescription.isSelected() ){
            isDescription = true;
        }        
        if( cbQuantity.isSelected() ){
            isQuantity = true;
        }
        if( cbStatus.isSelected() ){
            isStatus = true;
        }
        if( cbProductType.isSelected() ){
            isProductType = true;
        }
        String filter = txtSearchField.getText();
        
        if( filter.equals("") == true ) {
            StringHelpers.Message("Vui lòng nhập từ khóa", "Thông báo", 2);
            return;
        } 
        ArrayList _status = new ArrayList();
        _status.add(0, "None");
        _status.add(1, "Hiện");
        _status.add(2, "Ẩn");
        
        ArrayList _productType = new ArrayList();
        _productType.add(0, "None");
        _productType.add(1, "Văn phòng phẩm");
        _productType.add(2, "Đồ gia dụng");
        _productType.add(3, "Đồ điện");
        getHeaderTable();
        int c = 0;
        try {
            List<Product> listProduct = productService.getDataProductFilter(filter, isCode, isName, isDescription, isQuantity, isStatus, isProductType);
            Iterator iter = listProduct.iterator();
            while ( iter.hasNext() ) {
                Product product = (Product) iter.next();
                Object[] item = new Object[10];
                item[0] = product.getProductId();
                item[1] = ++c;
                item[2] = product.getCode();
                item[3] = product.getProductName();
                item[4] = product.getDescription();
                item[5] = product.getQuantity();
                item[6] = product.getStatus();
                item[7] = _status.get(product.getStatus());
                item[8] = product.getProductType();
                item[9] = _productType.get(product.getProductType());
                tableModel.addRow(item);          
            } 
            //Ẩn ID
            jTableSanPham.getColumnModel().getColumn(0).setMinWidth(0);
            jTableSanPham.getColumnModel().getColumn(0).setMaxWidth(0);
            //Ẩn Status
            jTableSanPham.getColumnModel().getColumn(6).setMinWidth(0);
            jTableSanPham.getColumnModel().getColumn(6).setMaxWidth(0);
            //Ẩn ProductType
            jTableSanPham.getColumnModel().getColumn(8).setMinWidth(0);
            jTableSanPham.getColumnModel().getColumn(8).setMaxWidth(0);
        } catch (Exception ex) {
            System.out.println("123");
            System.out.println(ex.toString());
        }
        lblSoTrang.setText(page+ "/"+totalPage);
        lblPage.setText(""+page);
    }//GEN-LAST:event_btnFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbCode;
    private javax.swing.JCheckBox cbDescription;
    private javax.swing.JCheckBox cbProductName;
    private javax.swing.JCheckBox cbProductType;
    private javax.swing.JCheckBox cbQuantity;
    private javax.swing.JCheckBox cbStatus;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonNextAll;
    private javax.swing.JButton jButtonPre;
    private javax.swing.JButton jButtonPreAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelDanhSachSanPham;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSanPham;
    private javax.swing.JLabel lblPage;
    private javax.swing.JLabel lblSoTrang;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JSpinner txtQuantity;
    private javax.swing.JTextField txtSearchField;
    // End of variables declaration//GEN-END:variables
}
