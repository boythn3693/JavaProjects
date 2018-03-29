/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.entity.*;
import components.interfaces.Template.*;
import components.models.*;
import java.util.*;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author vankh
 */
public class ReceiptFrame extends ListFrame {

    public ReceiptFrame() {
        super();
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport("D:\\Project\\git\\JavaProjects\\src\\components\\Reports\\RptReceipt.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jasperPrint, "d:\\sample.pdf");
        } catch (JRException e) {
            System.out.println("components.interfaces.ReceiptFrame.<init>()");
        }

    }

    @Override
    protected List<ItemFormDetailModel> getDetailByFormId(long id) {
        try {
            List<ItemFormDetailModel> rs = new ArrayList();

            List<ReceiptDetail> lst = _receiptService.getDetailsById(id);
            if (lst == null || lst.size() <= 0) {
                return rs;
            }

            for (int i = 0; i < lst.size(); i++) {
                ItemFormDetailModel item = new ItemFormDetailModel();
                item.setFormId(id);
                item.setQuantity(lst.get(i).getQuantity());
                if (lst.get(i).getProduct() != null) {
                    item.setProduct(lst.get(i).getProduct());
                }
                rs.add(item);
            }
            return rs;
        } catch (Exception e) {
            System.out.println("components.interfaces.ReceiptFrame.getDetailByFormId()");
            System.out.println(e);
            return new ArrayList();
        }
    }

    @Override
    protected List<FormModel> getForms() {
        try {
            List<Receipt> lst = _receiptService.getAll();
            List<FormModel> rs = new ArrayList();
            for (int i = 0; i < lst.size(); i++) {
                FormModel item = new FormModel();
                item.setDateTime(lst.get(i).getDatetime());
                item.setFormId(lst.get(i).getReceiptId());
                item.setStatus(lst.get(i).getStatus());
                if (lst.get(i).getPartner() != null) {
                    item.setPartner(lst.get(i).getPartner());
                }
                rs.add(item);
            }
            return rs;

        } catch (Exception e) {
            System.out.println("components.interfaces.ReceiptFrame.getForms()");
            System.out.println(e.getMessage());
            return new ArrayList();
        }
    }

    @Override
    protected boolean CancelForm(long id) {
        return _receiptService.cancelForm(id);
    }

    @Override
    protected InfoFrame GetInfoForm() {
        InfoReceiptFrame info = new InfoReceiptFrame();
        info.setTitleForm("LẬP PHIẾU NHẬP KHO");
        return info;
    }

    private static ReceiptFrame _frame;

    public static ReceiptFrame getInstance() {
        if (_frame == null) {
            _frame = new ReceiptFrame();
        }
        return _frame;
    }
}
