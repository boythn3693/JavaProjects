/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.entity.Category;
import components.entity.Product;
import components.models.displayvalueModel;
import components.services.CategoryService;
import components.services.ProductService;
import components.utils.StringHelpers;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MitsuyoRai
 */
public class frmTabExportExcelProduct extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    CategoryService categoryService;
    ProductService productService;
    List<Category> listCat;
    List<Product> listAll;
    List<Product> listFilter;
    /**
     * Creates new form frmTabExportExcelProduct
     */
    public frmTabExportExcelProduct() {
        initComponents();
        categoryService = new CategoryService();
        productService = new ProductService();
        onLoad();
    }
    
    private void onLoad() {
        listCat = categoryService.getListCategory();
        listAll = productService.getAllDataProduct();
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
    
    private void getCBbox() {
        try {
            DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
            cbbmodel.addElement(new displayvalueModel("Tất cả", 0));
            Iterator iter = listCat.iterator();
            while (iter.hasNext()) {
                Category category = (Category) iter.next();
                displayvalueModel valueModel = new displayvalueModel(category.getName(), category.getCategoryId());
                cbbmodel.addElement(valueModel);
            }
            
            cboCategory.setModel(cbbmodel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void getHeaderTable() {
        Object[] obj = new Object[]{"ID", "STT", "Mã Sản Phẩm", "Tên sản phẩm", "Mô tả", "Số lượng", "Status", "Trạng thái", "ProductType", "Loại sản phẩm"};
        tableModel = new DefaultTableModel(obj, 0);
        jTableGridProduct.setModel(tableModel);
    }

    private void getAllDataProduct() {
        ArrayList _status = new ArrayList();
        _status.add(0, "None");
        _status.add(1, "Hiện");
        _status.add(2, "Ẩn");

        int c = 0;
        try {
            Iterator iter = listAll.iterator();
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
                item[8] = product.getCategory().getCategoryId();//product.getProductType();
                item[9] = product.getCategory().getName();
                tableModel.addRow(item);
            }
            //Ẩn ID
            jTableGridProduct.getColumnModel().getColumn(0).setMinWidth(0);
            jTableGridProduct.getColumnModel().getColumn(0).setMaxWidth(0);
            //Ẩn Status
            jTableGridProduct.getColumnModel().getColumn(6).setMinWidth(0);
            jTableGridProduct.getColumnModel().getColumn(6).setMaxWidth(0);
            //Ẩn ProductType
            jTableGridProduct.getColumnModel().getColumn(8).setMinWidth(0);
            jTableGridProduct.getColumnModel().getColumn(8).setMaxWidth(0);
        } catch (Exception ex) {
            System.out.println(ex.toString());
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

        jPanelControl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox<>();
        jCheckBoxShow = new javax.swing.JCheckBox();
        jCheckBoxHide = new javax.swing.JCheckBox();
        btnFilter = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanelGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGridProduct = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(780, 611));
        setPreferredSize(new java.awt.Dimension(780, 611));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Trạng thái:");

        jLabel2.setText("Loại sản phẩm:");

        cboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBoxShow.setText("Hiện");

        jCheckBoxHide.setText("Ẩn");

        btnFilter.setText("Lọc");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnExcel.setText("Xuất Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlLayout = new javax.swing.GroupLayout(jPanelControl);
        jPanelControl.setLayout(jPanelControlLayout);
        jPanelControlLayout.setHorizontalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelControlLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelControlLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelControlLayout.createSequentialGroup()
                                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcel))
                            .addGroup(jPanelControlLayout.createSequentialGroup()
                                .addComponent(jCheckBoxShow)
                                .addGap(8, 8, 8)
                                .addComponent(jCheckBoxHide)))))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanelControlLayout.setVerticalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxHide)
                    .addComponent(jCheckBoxShow)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter)
                    .addComponent(btnExcel)
                    .addComponent(btnReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableGridProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản phẩm", "Tên sản phẩm", "Mô tả", "Số lượng", "Trạng thái", "Loại Sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableGridProduct);

        javax.swing.GroupLayout jPanelGridLayout = new javax.swing.GroupLayout(jPanelGrid);
        jPanelGrid.setLayout(jPanelGridLayout);
        jPanelGridLayout.setHorizontalGroup(
            jPanelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanelGridLayout.setVerticalGroup(
            jPanelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        long productType = GetCbbSelected(cboCategory); 
        int status = -1;
        if (jCheckBoxShow.isSelected() && jCheckBoxHide.isSelected()) {
            status = -1;
        } else if( jCheckBoxShow.isSelected() && !jCheckBoxHide.isSelected() ) {
            status = 1;
        } else if( !jCheckBoxShow.isSelected() && jCheckBoxHide.isSelected() ) {
            status = 0;
        }
         ArrayList _status = new ArrayList();
        _status.add(0, "None");
        _status.add(1, "Hiện");
        _status.add(2, "Ẩn");
        getHeaderTable();
        int c = 0;
        try {
            listFilter = productService.getDataProductFilter2(productType, status);
            Iterator iter = listFilter.iterator();
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
                item[8] = product.getCategory().getCategoryId();//product.getProductType();
                item[9] = product.getCategory().getName();
                tableModel.addRow(item);
            }
            //Ẩn ID
            jTableGridProduct.getColumnModel().getColumn(0).setMinWidth(0);
            jTableGridProduct.getColumnModel().getColumn(0).setMaxWidth(0);
            //Ẩn Status
            jTableGridProduct.getColumnModel().getColumn(6).setMinWidth(0);
            jTableGridProduct.getColumnModel().getColumn(6).setMaxWidth(0);
            //Ẩn ProductType
            jTableGridProduct.getColumnModel().getColumn(8).setMinWidth(0);
            jTableGridProduct.getColumnModel().getColumn(8).setMaxWidth(0);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        // TODO add your handling code here:
        
//        if (rVal == JFileChooser.CANCEL_OPTION) {
//          filename.setText("You pressed cancel");
//          dir.setText("");
//        }
        try {
            String filename = "", dir ="";
            JFileChooser c = new JFileChooser();
            c.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("excel (.xlsx)", "xlsx");
            c.setFileFilter(filter);
            int rVal = c.showSaveDialog(frmTabExportExcelProduct.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                filename = c.getSelectedFile().getName();
                if (!FilenameUtils.getExtension(filename).equalsIgnoreCase("xlsx")) {
                    filename = filename + ".xlsx";
                }
                dir = c.getCurrentDirectory().toString();
                FileOutputStream file = new FileOutputStream(dir + "/" +filename);
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet workSheet = workbook.createSheet("Sheet1");
                XSSFRow row;
                XSSFCell cellA;
                XSSFCell cellB;
                XSSFCell cellC;
                XSSFCell cellD;
                XSSFCell cellE;
                XSSFCell cellF;
                XSSFCell cellG;
                 ArrayList _status = new ArrayList();
                _status.add(0, "None");
                _status.add(1, "Hiện");
                _status.add(2, "Ẩn");
                Iterator iter;
                if( listFilter != null ) {
                    iter = listFilter.iterator();
                } else {
                    iter = listAll.iterator();
                }

                row = workSheet.createRow((short)0);
                
                CellStyle style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                
                cellA = row.createCell((short)0);
                cellA.setCellValue("STT");
                //cellA.setColumnWidth(1);
                cellA.setCellStyle(style);
                
                cellB = row.createCell((short)1);
                cellB.setCellValue("Mã Sản phẩm");
                cellB.setCellStyle(style);

                cellC = row.createCell((short)2);
                cellC.setCellValue("Tên Sản phẩm");
                cellC.setCellStyle(style);

                cellD = row.createCell((short)3);
                cellD.setCellValue("Mô tả Sản phẩm");
                cellD.setCellStyle(style);

                cellE = row.createCell((short)4);
                cellE.setCellValue("Số lượng");
                cellE.setCellStyle(style);

                cellF = row.createCell((short)5);
                cellF.setCellValue("Trạng thái");
                cellF.setCellStyle(style);

                cellG = row.createCell((short)6);
                cellG.setCellValue("Loại Sản phẩm");
                cellG.setCellStyle(style);
                int i = 1;
                while (iter.hasNext()) {
                    row = workSheet.createRow((short)i);
                    Product product = (Product) iter.next();
                    cellA = row.createCell((short)0);
                    cellA.setCellValue(i);

                    cellB = row.createCell((short)1);
                    cellB.setCellValue(product.getCode().toString());

                    cellC = row.createCell((short)2);
                    cellC.setCellValue(product.getProductName().toString());

                    cellD = row.createCell((short)3);
                    cellD.setCellValue(product.getDescription().toString());

                    cellE = row.createCell((short)4);
                    cellE.setCellValue(product.getQuantity());

                    cellF = row.createCell((short)5);
                    cellF.setCellValue(_status.get(product.getStatus()).toString());

                    cellG = row.createCell((short)6);
                    cellG.setCellValue(product.getCategory().getName());
                    i++;
                }
                workbook.write(file);
                workbook.close();
                file.close();

                StringHelpers.Message("Xuất file thành công!", "Thành công!", 1);
            }
        } catch( IOException ex) {
            StringHelpers.Message(ex.getMessage(), ex.getLocalizedMessage(), 2);
        }
    }//GEN-LAST:event_btnExcelActionPerformed
    
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        getCBbox();
        getHeaderTable();
        getAllDataProduct();
    }//GEN-LAST:event_formComponentShown

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        listFilter = null;
        getCBbox();
        getHeaderTable();
        getAllDataProduct();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JCheckBox jCheckBoxHide;
    private javax.swing.JCheckBox jCheckBoxShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelControl;
    private javax.swing.JPanel jPanelGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGridProduct;
    // End of variables declaration//GEN-END:variables
}
