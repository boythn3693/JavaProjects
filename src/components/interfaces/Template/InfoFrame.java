/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces.Template;

import components.entity.*;
import components.models.*;
import components.services.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author vankh
 */
public abstract class InfoFrame extends javax.swing.JFrame {

    /**
     * Creates new form ReceiptInfo
     */
    public InfoFrame() {
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        initDataComponents();
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
        jLabel2 = new javax.swing.JLabel();
        txtFormId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbbPartners = new components.providers.InvComboBox();
        jLabel4 = new javax.swing.JLabel();
        dtpDateTime = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        cbbStatus = new components.providers.InvComboBox();
        lblTitle = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbbProducts = new components.providers.InvComboBox();
        numQty = new javax.swing.JSpinner();
        btnUpdatePro = new javax.swing.JButton();
        btnDelPro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetails = new org.jdesktop.swingx.JXTable();
        jXCollapsiblePane1 = new org.jdesktop.swingx.JXCollapsiblePane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Mã phiếu:");

        txtFormId.setEditable(false);
        txtFormId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFormId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFormId.setText("10012");
        txtFormId.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Đối tác:");

        cbbPartners.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ngày lập phiếu:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Status:");

        cbbStatus.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dtpDateTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbPartners, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(txtFormId)
                    .addComponent(cbbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFormId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbPartners, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dtpDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("LẬP PHIẾU NHẬP KHO");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Sản phẩm:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Số lượng:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(numQty)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(numQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdatePro.setText("Cập nhật");
        btnUpdatePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProActionPerformed(evt);
            }
        });

        btnDelPro.setText("Xóa");
        btnDelPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelProActionPerformed(evt);
            }
        });

        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu", "ProId", "Sản phẩm", "Số lượng", "Tồn", "_"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetails.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tblDetails);
        tblDetails.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnUpdatePro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelPro, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSave)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jXCollapsiblePane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnUpdatePro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDelPro)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jXCollapsiblePane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int rs = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn hủy phiếu lập", "Warning", JOptionPane.YES_NO_OPTION);
        if (rs == JOptionPane.YES_OPTION) {
            deleteForm(Long.parseLong(txtFormId.getText()));
            _listFrame.refresh();
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDelProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelProActionPerformed
        ItemFormDetailModel model = new ItemFormDetailModel();
        model.setFormId(Long.parseLong(txtFormId.getText()));
        model.setProduct(_commonService.getProductById(cbbProducts.getSelectedValue()));
        model.setQuantity((int) numQty.getValue());
        ResultFunc rs = deleteDetail(model);

        if (rs.isResult()) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            refresh();
        } else {
            if (rs.getMessage() != "") {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            } else {
                JOptionPane.showMessageDialog(this, rs.getMessage());
            }
        }
    }//GEN-LAST:event_btnDelProActionPerformed

    private void btnUpdateProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProActionPerformed
        ItemFormDetailModel model = new ItemFormDetailModel();
        model.setFormId(Long.parseLong(txtFormId.getText()));
        model.setProduct(_commonService.getProductById(cbbProducts.getSelectedValue()));
        model.setQuantity((int) numQty.getValue());
        ResultFunc rs = updateOrAddProduct(model);
        if (rs.isResult()) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            refresh();
        } else {
            if (rs.getMessage() != "") {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại: " + rs.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateProActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        FormModel model = getInfoForm();
        ResultFunc rs = saveForm(model);
        if (rs.isResult()) {
            JOptionPane.showMessageDialog(this, "Lập phiếu thành công");
            _listFrame.refresh();
            this.setVisible(false);
            this.dispose();
        } else {
            if (rs.getMessage() != "") {
                JOptionPane.showMessageDialog(this, "Lập phiếu thất bại");
            } else {
                JOptionPane.showMessageDialog(this, "Lập phiếu thất bại:" + rs.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelPro;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdatePro;
    private components.providers.InvComboBox cbbPartners;
    private components.providers.InvComboBox cbbProducts;
    private components.providers.InvComboBox cbbStatus;
    private org.jdesktop.swingx.JXDatePicker dtpDateTime;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JSpinner numQty;
    private org.jdesktop.swingx.JXTable tblDetails;
    private javax.swing.JTextField txtFormId;
    // End of variables declaration//GEN-END:variables

    private void initDataComponents() {
        _productService = new ProductService();
        _partnerService = new PartnerService();
        _commonService = new CommonService();
        _receiptService = new ReceiptService();
        _deliveryBillService = new DeliveryBillService();

        _statusItems = Arrays.asList(new ItemComboBoxModel(0, "Đang lập phiếu"),
                new ItemComboBoxModel(1, "Đã nhập"),
                new ItemComboBoxModel(2, "Đã hủy"));
        cbbStatus.removeAll();
        cbbStatus.addElementList(_statusItems);

        txtFormId.setText("");
        dtpDateTime.setDate(new Date());
        cbbStatus.setSelectedByValue(0);

        List<Product> pros = _productService.getDataProduct(1);
        cbbProducts.removeAll();
        for (int i = 0; i < pros.size(); i++) {
            cbbProducts.addElement(new ItemComboBoxModel(pros.get(i).getProductId(), (String) pros.get(i).getProductName()));
        }

        List<Partner> partners = _partnerService.getDataPartner();
        cbbPartners.removeAll();
        for (int i = 0; i < partners.size(); i++) {
            cbbPartners.addElement(new ItemComboBoxModel(partners.get(i).getPartnerId(), (String) partners.get(i).getPartnerName()));
        }

        tblDetails.getColumnExt(1).setVisible(false);
        setInfoForm(getNewForm());
    }

    public void setInfoForm(FormModel model) {
        if (model != null) {
            txtFormId.setText(Long.toString(model.getFormId()));
            dtpDateTime.setDate(model.getDateTime());
            if (model.getPartner() != null) {
                cbbPartners.setSelectedByValue(model.getPartner().getPartnerId());
            }
            cbbStatus.setSelectedByValue(model.getStatus());
        }
    }

    public void setListFrame(ListFrame listFrame) {
        _listFrame = listFrame;
    }

    public FormModel getInfoForm() {
        FormModel model = new FormModel();
        try {
            model.setFormId(Long.parseLong(txtFormId.getText()));
            model.setPartner(_partnerService.getById(cbbPartners.getSelectedValue()));
            model.setStatus((int) cbbStatus.getSelectedValue());
            model.setDateTime(dtpDateTime.getDate());
            return model;
        } catch (Exception e) {
            return model;
        }
    }

    public void setTitleForm(String title) {
        lblTitle.setText(title);
        this.setTitle(title);
    }

    public void setFormDetail(List<ItemFormDetailModel> details) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblDetails.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }

            for (int i = 0; i < details.size(); i++) {
                long ProductId = 0;
                String ProductName = "";
                int ProductNStock = 0;
                if (details.get(i).getProduct() != null) {
                    ProductId = details.get(i).getProduct().getProductId();
                    ProductName = (String) details.get(i).getProduct().getProductName();
                    ProductNStock = details.get(i).getProduct().getQuantity();
                }
                Object[] objs = new Object[]{
                    details.get(i).getFormId(),
                    ProductId,
                    ProductName,
                    details.get(i).getQuantity(),
                    ProductNStock};
                model.addRow(objs);
            }
        } catch (Exception e) {
            System.out.println("components.interfaces.Template.InfoFrame.setFormDetail()");
            System.out.println(e);
        }
    }

    public void refresh() {
        setFormDetail(getDetails(getInfoForm().getFormId()));
    }

    protected abstract ResultFunc updateOrAddProduct(ItemFormDetailModel model);

    protected abstract ResultFunc deleteDetail(ItemFormDetailModel model);

    protected abstract ResultFunc saveForm(FormModel model);

    protected abstract ResultFunc deleteForm(long formid);

    protected abstract List<ItemFormDetailModel> getDetails(long formid);

    protected abstract FormModel getNewForm();

    private List<ItemComboBoxModel> _statusItems;
    protected ProductService _productService;
    protected PartnerService _partnerService;
    protected CommonService _commonService;
    protected ReceiptService _receiptService;
    protected DeliveryBillService _deliveryBillService;
    protected ListFrame _listFrame;
}
