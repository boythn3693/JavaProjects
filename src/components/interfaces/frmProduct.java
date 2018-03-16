/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.entity.Product;
import components.models.displayvalueModel;
import components.services.ProductService;
import components.utils.StringHelpers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MitsuyoRai
 */
public class frmProduct extends javax.swing.JPanel {

    private int _productId = -1;
    int pageSize = 10;
    long count;
    int totalPage, residual, page = 1;
    int start = 0;
    int end;
    DefaultTableModel tableModel;
    ProductService productService;
    List<Product> listAll;
    /**
     * Creates new form frmProduct
     */
    public frmProduct() {
        initComponents();
        productService = new ProductService();
        onLoad();
    }

    private void onLoad() {
        count = productService.countTable();
        totalPage = (int)(Math.ceil((float)count/pageSize));
        listAll = productService.getDataProduct(1);
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
    private void getHeaderTable() {
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
            start = (page-1)*pageSize;
            end = pageSize*page;
            if(end > listAll.size()){
                end = listAll.size();
            }
            List<Product> listProduct = productService.getListByPagination(listAll, start, end);
            
            Iterator iter = listProduct.iterator();
            while (iter.hasNext()) {
                Product product = (Product) iter.next();
                Object[] item = new Object[10];
                item[0] = product.getProductId();
                item[1] = ++c + start;
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
        lblSoTrang.setText(page + "/" + totalPage);
        lblPage.setText("" + page);
    }

    private void resetInputProduct() {
        txtCode.setText("");
        txtProductName.setText("");
        txtDescription.setText("");
        txtQuantity.setValue(0);
    }

    private void getDataProductType() {
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
        jScrollPaneDanhSachSanPham = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        jPanelItemSanPham = new javax.swing.JPanel();
        jLabelCodeProduct = new javax.swing.JLabel();
        jLabelProductName = new javax.swing.JLabel();
        jLabelDescriptionProduct = new javax.swing.JLabel();
        jLabelQuantityProduct = new javax.swing.JLabel();
        jLabelStatusProduct = new javax.swing.JLabel();
        jLabelProductType = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JSpinner();
        cboStatus = new javax.swing.JComboBox<>();
        cboCategory = new javax.swing.JComboBox<>();
        jPanelButtonProduct = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanelSearchProduct = new javax.swing.JPanel();
        jLabelSearchProduct = new javax.swing.JLabel();
        jLabelKeyProduct = new javax.swing.JLabel();
        txtSearchField = new javax.swing.JTextField();
        jLabelFilterProduct = new javax.swing.JLabel();
        cbCode = new javax.swing.JCheckBox();
        cbProductName = new javax.swing.JCheckBox();
        cbDescription = new javax.swing.JCheckBox();
        cbQuantity = new javax.swing.JCheckBox();
        btnFilter = new javax.swing.JButton();
        jPanelPagingProduct = new javax.swing.JPanel();
        btnPreAll = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnNextAll = new javax.swing.JButton();
        lblSoTrang = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
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
        jScrollPaneDanhSachSanPham.setViewportView(jTableSanPham);

        jLabelCodeProduct.setText("Mã sản phẩm:");

        jLabelProductName.setText("Tên Sản phẩm:");

        jLabelDescriptionProduct.setText("Mô tả:");

        jLabelQuantityProduct.setText("Số lượng:");

        jLabelStatusProduct.setText("Trạng thái:");

        jLabelProductType.setText("Loại sản phẩm:");

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

        javax.swing.GroupLayout jPanelButtonProductLayout = new javax.swing.GroupLayout(jPanelButtonProduct);
        jPanelButtonProduct.setLayout(jPanelButtonProductLayout);
        jPanelButtonProductLayout.setHorizontalGroup(
            jPanelButtonProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelButtonProductLayout.setVerticalGroup(
            jPanelButtonProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonProductLayout.createSequentialGroup()
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelItemSanPhamLayout = new javax.swing.GroupLayout(jPanelItemSanPham);
        jPanelItemSanPham.setLayout(jPanelItemSanPhamLayout);
        jPanelItemSanPhamLayout.setHorizontalGroup(
            jPanelItemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItemSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelItemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProductName)
                    .addComponent(jLabelCodeProduct)
                    .addComponent(jLabelDescriptionProduct)
                    .addComponent(jLabelQuantityProduct)
                    .addComponent(jLabelStatusProduct)
                    .addComponent(jLabelProductType))
                .addGap(18, 18, 18)
                .addGroup(jPanelItemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCategory, 0, 253, Short.MAX_VALUE)
                    .addComponent(txtQuantity)
                    .addComponent(cboStatus, 0, 253, Short.MAX_VALUE)
                    .addComponent(txtCode)
                    .addComponent(txtProductName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelButtonProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelItemSanPhamLayout.setVerticalGroup(
            jPanelItemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItemSanPhamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelItemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodeProduct)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelItemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProductName)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelItemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescriptionProduct)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelItemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQuantityProduct))
                .addGap(25, 25, 25)
                .addGroup(jPanelItemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatusProduct)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelItemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProductType))
                .addContainerGap())
            .addComponent(jPanelButtonProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabelSearchProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSearchProduct.setText("Tìm kiếm");

        jLabelKeyProduct.setText("Từ khóa:");

        jLabelFilterProduct.setText("Lọc theo:");

        cbCode.setText("Mã Sản phẩm");

        cbProductName.setText("Tên Sản phẩm");

        cbDescription.setText("Mô tả");

        cbQuantity.setText("Số lượng");

        btnFilter.setText("Tìm kiếm");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSearchProductLayout = new javax.swing.GroupLayout(jPanelSearchProduct);
        jPanelSearchProduct.setLayout(jPanelSearchProductLayout);
        jPanelSearchProductLayout.setHorizontalGroup(
            jPanelSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchProductLayout.createSequentialGroup()
                .addGroup(jPanelSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSearchProductLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabelSearchProduct)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelSearchProductLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelKeyProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchField))
                    .addGroup(jPanelSearchProductLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelFilterProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCode)
                            .addComponent(cbDescription))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanelSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbQuantity)
                            .addComponent(cbProductName))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchProductLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanelSearchProductLayout.setVerticalGroup(
            jPanelSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSearchProduct)
                .addGap(11, 11, 11)
                .addGroup(jPanelSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKeyProduct)
                    .addComponent(txtSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFilterProduct)
                    .addComponent(cbCode)
                    .addComponent(cbProductName))
                .addGap(18, 18, 18)
                .addGroup(jPanelSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDescription)
                    .addComponent(cbQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        btnPreAll.setText("<<");
        btnPreAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreAllActionPerformed(evt);
            }
        });

        btnPre.setText("<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        lblPage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPage.setText("0");

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnNextAll.setText(">>");
        btnNextAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextAllActionPerformed(evt);
            }
        });

        lblSoTrang.setText("0/1");

        javax.swing.GroupLayout jPanelPagingProductLayout = new javax.swing.GroupLayout(jPanelPagingProduct);
        jPanelPagingProduct.setLayout(jPanelPagingProductLayout);
        jPanelPagingProductLayout.setHorizontalGroup(
            jPanelPagingProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPagingProductLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(btnPreAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPre)
                .addGap(18, 18, 18)
                .addComponent(lblPage)
                .addGap(18, 18, 18)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNextAll)
                .addGap(18, 18, 18)
                .addComponent(lblSoTrang)
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanelPagingProductLayout.setVerticalGroup(
            jPanelPagingProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPagingProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnPreAll, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblPage)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnNextAll, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblSoTrang))
        );

        javax.swing.GroupLayout jPanelDanhSachSanPhamLayout = new javax.swing.GroupLayout(jPanelDanhSachSanPham);
        jPanelDanhSachSanPham.setLayout(jPanelDanhSachSanPhamLayout);
        jPanelDanhSachSanPhamLayout.setHorizontalGroup(
            jPanelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhSachSanPhamLayout.createSequentialGroup()
                .addComponent(jPanelItemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelDanhSachSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPagingProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPaneDanhSachSanPham)
        );
        jPanelDanhSachSanPhamLayout.setVerticalGroup(
            jPanelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDanhSachSanPhamLayout.createSequentialGroup()
                .addGroup(jPanelDanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelItemSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneDanhSachSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelPagingProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDanhSachSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDanhSachSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        setSelectedCombobox(jTableSanPham.getValueAt(index, 7).toString(), cboStatus);
        setSelectedCombobox(jTableSanPham.getValueAt(index, 9).toString(), cboCategory);
    }//GEN-LAST:event_jTableSanPhamMouseClicked

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String Code, productName, Description;
        int Quantity, Status, productType;

        if (txtCode.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Mã sản phẩm", "Thông báo", 2);
            txtCode.requestFocus();
            return;
        } else if (!productService.hasCode(txtCode.getText().toString())) {
            StringHelpers.Message("Mã sản phẩm đã tồn tại", "Thông báo", 2);
            txtCode.requestFocus();
            return;
        } else if (txtProductName.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Tên Sản phẩm", "Thông báo", 2);
            txtProductName.requestFocus();
            return;
        } else if (txtDescription.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập mô tả", "Thông báo", 2);
            txtDescription.requestFocus();
            return;
        } else if (!StringHelpers.isInteger(txtQuantity.getValue().toString())) {
            StringHelpers.Message("Số lượng phải là số nguyên", "Thông báo", 2);
            txtQuantity.requestFocus();
            return;
        } else if (Integer.parseInt(txtQuantity.getValue().toString()) <= 0) {
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

        if (productService.insert(dto)) {
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
        if( _productId == -1 )
        {
            StringHelpers.Message("Vui lòng chọn sản phẩm cần sửa", "Thông báo", 2);
            return;
        }
        String Code, productName,Description;
        int Quantity, Status, productType;

        if (txtCode.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Mã sản phẩm", "Thông báo", 2);
            txtCode.requestFocus();
            return;
        } else if (!productService.hasCode(txtCode.getText().toString(), this._productId)) {
            StringHelpers.Message("Mã sản phẩm đã tồn tại", "Thông báo", 2);
            txtCode.requestFocus();
            return;
        } else if (txtProductName.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Tên Sản phẩm", "Thông báo", 2);
            txtProductName.requestFocus();
            return;
        } else if (txtDescription.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập mô tả", "Thông báo", 2);
            txtDescription.requestFocus();
            return;
        } else if (!StringHelpers.isInteger(txtQuantity.getValue().toString())) {
            StringHelpers.Message("Số lượng phải là số nguyên", "Thông báo", 2);
            txtQuantity.requestFocus();
            return;
        } else if (Integer.parseInt(txtQuantity.getValue().toString()) <= 0) {
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

        if (productService.update(dto)) {
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
        if( _productId == -1 ){
            StringHelpers.Message("Vui lòng chọn sản phẩm cần Xóa", "Thông báo", 2);
            return;
        }
        int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn chắc chắn muốn xóa sản phẩm này?", "Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            Product dto = new Product();
            dto.setProductId(this._productId);
            if (productService.delete(dto)) {
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
        onLoad();
        resetInputProduct();
        getHeaderTable();
        getDataProduct(1);
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
        if (page > 1) {
            page--;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_jButtonPreActionPerformed

    private void jButtonPreAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreAllActionPerformed
        // TODO add your handling code here:
        if (page > 1) {
            page = 1;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_jButtonPreAllActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:
        if (page < totalPage) {
            page++;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonNextAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextAllActionPerformed
        // TODO add your handling code here:
        if (page < totalPage) {
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
        if (cbCode.isSelected()) {
            isCode = true;
        }
        if (cbProductName.isSelected()) {
            isName = true;
        }
        if (cbDescription.isSelected()) {
            isDescription = true;
        }
        if (cbQuantity.isSelected()) {
            isQuantity = true;
        }
//        if( cbStatus.isSelected() ){
//            isStatus = true;
//        }
//        if( cbProductType.isSelected() ){
//            isProductType = true;
//        }
        String filter = txtSearchField.getText();

        if (filter.equals("") == true) {
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
        
        count = productService.countTableFilter(filter, isCode, isName, isDescription, isQuantity, isStatus, isProductType);
        totalPage = (int)(Math.ceil((float)count/pageSize));
        getHeaderTable();
        int c = 0;
        try {
            List<Product> lists = productService.getDataProductFilter(filter, isCode, isName, isDescription, isQuantity, isStatus, isProductType);
            start = (page-1)*pageSize;
            end = pageSize*page;
            if(end > lists.size()){
                end = lists.size();
            }
            List<Product> listProduct = productService.getListByPagination(lists, start, end);
            Iterator iter = listProduct.iterator();
            while (iter.hasNext()) {
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
        lblSoTrang.setText(page + "/" + totalPage);
        lblPage.setText("" + page);
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnPreAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreAllActionPerformed
        // TODO add your handling code here:
        if(page > 1){
            page=1;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_btnPreAllActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        // TODO add your handling code here:
        if(page > 1){
            page--;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if(page < totalPage){
            page++;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnNextAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextAllActionPerformed
        // TODO add your handling code here:
        if(page < totalPage){
            page = totalPage;
            getHeaderTable();
            getDataProduct(1);
        }
    }//GEN-LAST:event_btnNextAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNextAll;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnPreAll;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbCode;
    private javax.swing.JCheckBox cbDescription;
    private javax.swing.JCheckBox cbProductName;
    private javax.swing.JCheckBox cbQuantity;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JLabel jLabelCodeProduct;
    private javax.swing.JLabel jLabelDescriptionProduct;
    private javax.swing.JLabel jLabelFilterProduct;
    private javax.swing.JLabel jLabelKeyProduct;
    private javax.swing.JLabel jLabelProductName;
    private javax.swing.JLabel jLabelProductType;
    private javax.swing.JLabel jLabelQuantityProduct;
    private javax.swing.JLabel jLabelSearchProduct;
    private javax.swing.JLabel jLabelStatusProduct;
    private javax.swing.JPanel jPanelButtonProduct;
    private javax.swing.JPanel jPanelDanhSachSanPham;
    private javax.swing.JPanel jPanelItemSanPham;
    private javax.swing.JPanel jPanelPagingProduct;
    private javax.swing.JPanel jPanelSearchProduct;
    private javax.swing.JScrollPane jScrollPaneDanhSachSanPham;
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
