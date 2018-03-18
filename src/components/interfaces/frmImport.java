/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.entity.*;
import components.providers.InvComboBoxRenderer;
import components.models.ItemComboBoxModel;
import components.services.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MitsuyoRai
 */
public class frmImport extends javax.swing.JPanel {

    /**
     * Creates new form frmImport
     */
    public frmImport() {
        this.StatusItems = Arrays.asList(new ItemComboBoxModel(0, "Đang lập phiếu"), new ItemComboBoxModel(1, "Đã nhập"), new ItemComboBoxModel(2, "Đã hủy"));
        initComponents();
        initService();
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

        jPanelDanhSachPhieuNhap = new javax.swing.JPanel();
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
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        plReceiptDetail = new javax.swing.JScrollPane();
        tblReceipDetail = new javax.swing.JTable();
        plReceipt = new javax.swing.JScrollPane();
        tblReceipt = new javax.swing.JTable();

        jPanelDanhSachPhieuNhap.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelDanhSachPhieuNhapComponentShown(evt);
            }
        });

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

        cbbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Done", "Hủy" }));
        cbbStatus.setEditor(null);
        cbbStatus.setEnabled(false);

        btnNew.setText("Lưu");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Lập phiếu mới");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Hủy phiếu");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
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
                    .addComponent(cbbStatus, 0, 253, Short.MAX_VALUE)
                    .addComponent(cbbPartner, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        tblReceipDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu", "Sản phẩm", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        plReceiptDetail.setViewportView(tblReceipDetail);

        tblReceipt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu", "Đối tác", "Ngày lập phiếu", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReceipt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReceiptMouseClicked(evt);
            }
        });
        plReceipt.setViewportView(tblReceipt);

        javax.swing.GroupLayout jPanelDanhSachPhieuNhapLayout = new javax.swing.GroupLayout(jPanelDanhSachPhieuNhap);
        jPanelDanhSachPhieuNhap.setLayout(jPanelDanhSachPhieuNhapLayout);
        jPanelDanhSachPhieuNhapLayout.setHorizontalGroup(
            jPanelDanhSachPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhSachPhieuNhapLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plReceiptDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
            .addComponent(plReceipt)
        );
        jPanelDanhSachPhieuNhapLayout.setVerticalGroup(
            jPanelDanhSachPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhSachPhieuNhapLayout.createSequentialGroup()
                .addGroup(jPanelDanhSachPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDanhSachPhieuNhapLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(plReceiptDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelDanhSachPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelDanhSachPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblReceiptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReceiptMouseClicked
        // TODO add your handling code here:
        int index = tblReceipt.getSelectedRow();
        long id = Long.valueOf(tblReceipt.getValueAt(index, 0).toString());
        Receipt receipt = _receiptService.getById(id);
        BindData(receipt);
    }//GEN-LAST:event_tblReceiptMouseClicked

    private void txtReceiptIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReceiptIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReceiptIdActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Receipt receipt = _receiptService.getNew();
        BindData(receipt);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Receipt receipt;
        try {
            receipt = GetReceipt();
            if (receipt.getStatus() == 1) {
                receipt.setStatus(2);
                if (_receiptService.update(receipt) == true) {
                    JOptionPane.showMessageDialog(this, "Hủy thành công");
                    initDataComponents();
                } else {
                    JOptionPane.showMessageDialog(this, "Hủy thất bại");
                }
            } else {
                if (_receiptService.delete(receipt) == true) {
                    JOptionPane.showMessageDialog(this, "Hủy thành công");
                    initDataComponents();
                } else {
                    JOptionPane.showMessageDialog(this, "Hủy thất bại");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(frmImport.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnCancelActionPerformed

    private void jPanelDanhSachPhieuNhapComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelDanhSachPhieuNhapComponentShown
        //        getDataReceipt();
        //        jTableSanPham.getColumnModel().getColumn(0).setMinWidth(0);
        //        jTableSanPham.getColumnModel().getColumn(0).setMaxWidth(0);
    }//GEN-LAST:event_jPanelDanhSachPhieuNhapComponentShown

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            Receipt receipt = GetReceipt();
            if (receipt.getStatus() == 0) {
                receipt.setStatus(1);
            }
            if (_receiptService.update(receipt) == true) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                initDataComponents();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        } catch (ParseException ex) {
            Logger.getLogger(frmImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbPartner;
    private javax.swing.JComboBox<String> cbbStatus;
    private javax.swing.JTextField dtpDatetime;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelDanhSachPhieuNhap;
    private javax.swing.JScrollPane plReceipt;
    private javax.swing.JScrollPane plReceiptDetail;
    private javax.swing.JTable tblReceipDetail;
    private javax.swing.JTable tblReceipt;
    private javax.swing.JTextField txtReceiptId;
    // End of variables declaration//GEN-END:variables

    private void initDataComponents() {

        DefaultComboBoxModel partnerModel = (DefaultComboBoxModel) cbbPartner.getModel();
        partnerModel.removeAllElements();
        List<Partner> partners = _partnerService.getDataPartner();
        partners.forEach((Partner partner) -> {
            partnerModel.addElement(new ItemComboBoxModel(partner.getPartnerId(), (String) partner.getPartnerName()));
        });
        cbbPartner.setModel(partnerModel);
        cbbPartner.setRenderer(new InvComboBoxRenderer());

        DefaultComboBoxModel statusModel = (DefaultComboBoxModel) cbbStatus.getModel();
        statusModel.removeAllElements();
        statusModel.addElement(new ItemComboBoxModel(0, "Đang lập phiếu"));
        statusModel.addElement(new ItemComboBoxModel(1, "Đã nhập"));
        statusModel.addElement(new ItemComboBoxModel(2, "Đã hủy"));

        cbbStatus.setModel(statusModel);
        cbbStatus.setRenderer(new InvComboBoxRenderer());

        Receipt receipt = _receiptService.getNew();
        BindData(receipt);

        _receipts = _receiptService.getAll();
        DefaultTableModel tblModel = (DefaultTableModel) tblReceipt.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }
        _receipts.forEach(new Consumer<Receipt>() {
            @Override
            public void accept(Receipt receipt) {
                String partnerName = "Doi tac 1";
                Partner partner = receipt.getPartner();
                if (partner != null) {
                    //partnerName = partner.getPartnerName();
                }
                Object[] objs = new Object[]{
                    receipt.getReceiptId(),
                    partnerName,//receipt.getPartner().getPartnerName(),
                    df.format(receipt.getDatetime()),
                    StatusItems.get(receipt.getStatus()).getDisplay()
                };
                tblModel.addRow(objs);
                //new Object[]{receipt.getReceiptId(), receipt.getPartner().getPartnerName(), receipt.getDatetime(), receipt.getStatus()});
            }
        });

        tblReceipt.setModel(tblModel);
    }

    private void initService() {
        _partnerService = new PartnerService();
        _receiptService = new ReceiptService();
    }

    private void BindData(Receipt receipt) {
        txtReceiptId.setText(Long.toString(receipt.getReceiptId()));
        
        if (receipt.getDatetime() != null) {
            dtpDatetime.setText(df.format(receipt.getDatetime()));
        }
        cbbStatus.setSelectedIndex(receipt.getStatus());
        
        if (receipt.getPartner() != null) {
            long key = 0;
            String value = "";
            Partner partner = receipt.getPartner();
            if (partner != null) {
                key = partner.getPartnerId();
                value = partner.getPartnerName();
            }
            cbbPartner.setSelectedItem(new ItemComboBoxModel(key, value));
        }
    }

    private Receipt GetReceipt() throws ParseException {
        Receipt receipt = new Receipt();
        receipt.setReceiptId(Long.parseLong(txtReceiptId.getText()));
        receipt.setDatetime(df.parse(dtpDatetime.getText()));
        receipt.setStatus(cbbStatus.getSelectedIndex());

        long partnerId = ((ItemComboBoxModel) cbbPartner.getSelectedItem()).getValue();
        Partner partner = _partnerService.getById(partnerId);
        receipt.setPartner(partner);

        return receipt;
    }

    private DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private List<Receipt> _receipts;
    private List<ItemComboBoxModel> StatusItems;
    private PartnerService _partnerService;
    private ReceiptService _receiptService;
}
