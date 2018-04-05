/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.Reports.ReportViewer;
import components.entity.*;
import components.interfaces.Template.*;
import components.models.*;
import java.util.*;

/**
 *
 * @author vankh
 */
public class DeliveryBillFrame extends ListFrame {

    public DeliveryBillFrame() {
        super();
    }

    @Override
    protected List<ItemFormDetailModel> getDetailByFormId(long id) {
        try {
            List<ItemFormDetailModel> rs = new ArrayList();

            List<DeliveryBillDetail> lst = _deliveryBillService.getDetailsById(id);
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
            System.out.println("components.interfaces.DeliveryBillFrame.getDetailByFormId()");
            System.out.println(e);
            return new ArrayList();
        }
    }

    @Override
    protected List<FormModel> getForms() {
        try {
            List<DeliveryBill> lst = _deliveryBillService.getAll();
            List<FormModel> rs = new ArrayList();
            for (int i = 0; i < lst.size(); i++) {
                FormModel item = new FormModel();
                item.setDateTime(lst.get(i).getDatetime());
                item.setFormId(lst.get(i).getDeliveryBillId());
                item.setStatus(lst.get(i).getStatus());
                if (lst.get(i).getPartner() != null) {
                    item.setPartner(lst.get(i).getPartner());
                }
                rs.add(item);
            }
            return rs;

        } catch (Exception e) {
            System.out.println("components.interfaces.DeliveryBillFrame.getForms()");
            System.out.println(e.getMessage());
            return new ArrayList();
        }
    }

    @Override
    protected boolean CancelForm(long id) {
        return _deliveryBillService.cancelForm(id);
    }

    @Override
    protected InfoFrame GetInfoForm() {
        InfoDeliveryBillFrame info = new InfoDeliveryBillFrame();
        info.setTitleForm("LẬP PHIẾU XUẤT KHO");
        return info;
    }

    private static DeliveryBillFrame _frame;

    public static DeliveryBillFrame getInstance() {
        if (_frame == null) {
            _frame = new DeliveryBillFrame();
        }
        return _frame;
    }

    @Override
    protected ReportViewer GetReport() {
        return new ReportViewer(null, "RptDeliveryBill.jasper", null);
    }
}
