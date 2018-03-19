/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces.FormTemplate;

import components.models.*;
import java.text.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vankh
 */
public abstract class ListFrame extends javax.swing.JPanel {

    /**
     * Creates new form ListFrame
     */
    public ListFrame() {
        initComponents();
        initDataComponets();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblForm = new org.jdesktop.swingx.JXTable();
        jPanel1 = new javax.swing.JPanel();
        btnCreateForm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFormDetail = new org.jdesktop.swingx.JXTable();

        tblForm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu", "Đối tác", "Ngày lập phiếu", "Status"
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
        tblForm.setColumnSelectionAllowed(true);
        tblForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFormMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblForm);
        tblForm.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jSplitPane1.setLeftComponent(jScrollPane2);

        btnCreateForm.setText("Lập phiếu mới");
        btnCreateForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFormActionPerformed(evt);
            }
        });

        btnCancel.setText("Hủy phiếu");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tblFormDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu", "ProductId", "Sản phẩm", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.Integer.class
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
        tblFormDetail.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblFormDetail);
        tblFormDetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCreateForm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnCreateForm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFormMouseClicked
        int index = tblForm.getSelectedRow();
        long id = Long.valueOf(tblForm.getValueAt(index, 0).toString());
        List<ItemFormDetailModel> details = getDetailByFormId(id);
        boolean rs = setDetail(details);
    }//GEN-LAST:event_tblFormMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        int index = tblForm.getSelectedRow();
        long id = Long.valueOf(tblForm.getValueAt(index, 0).toString());
        if (CancelForm(id) == true) {
            JOptionPane.showMessageDialog(this, "Hủy phiếu thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Hủy phiếu thất bại");
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCreateFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFormActionPerformed
        if (_infoFrame == null) {
            _infoFrame = GetInfoForm();
        }
        _infoFrame.setVisible(true);
    }//GEN-LAST:event_btnCreateFormActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreateForm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private org.jdesktop.swingx.JXTable tblForm;
    private org.jdesktop.swingx.JXTable tblFormDetail;
    // End of variables declaration//GEN-END:variables

    protected InfoFrame _infoFrame;
    private List<ItemComboBoxModel> _statusItems;
    protected DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    protected abstract List<ItemFormDetailModel> getDetailByFormId(long id);

    protected abstract List<FormModel> getForms();

    protected abstract boolean CancelForm(long id);

    protected abstract InfoFrame GetInfoForm();

    private void initDataComponets() {
        _statusItems = Arrays.asList(new ItemComboBoxModel(0, "Đang lập phiếu"),
                new ItemComboBoxModel(1, "Đã nhập"),
                new ItemComboBoxModel(2, "Đã hủy"));
        tblFormDetail.getColumnExt(1).setVisible(false);

        setFormList(getForms());
        _infoFrame = GetInfoForm();
    }

    protected boolean setFormList(List<FormModel> list) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblForm.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }

            for (int i = 0; i < list.size(); i++) {
                Object[] objs = new Object[]{
                    list.get(i).getFormId(),
                    list.get(i).getPartnerName(),
                    df.format(list.get(i).getDateTime()),
                    _statusItems.get(list.get(i).getStatus()).getDisplay()};
                model.addRow(objs);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean setDetail(List<ItemFormDetailModel> list) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblFormDetail.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }

            for (int i = 0; i < list.size(); i++) {
                Object[] objs = new Object[]{
                    list.get(i).getFormId(),
                    list.get(i).getProductId(),
                    list.get(i).getProductName(),
                    list.get(i).getQuantity()};
                model.addRow(objs);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
