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

/**
 *
 * @author vankh
 */
public class InfoDeliveryBillFrame extends InfoFrame {

    public InfoDeliveryBillFrame() {
        super();
    }

    @Override
    protected ResultFunc updateOrAddProduct(ItemFormDetailModel model) {
        try {
            DeliveryBillDetail rd = _deliveryBillService.getDetailByProductId(model.getFormId(), model.getProduct().getProductId());
            ResultFunc rs = new ResultFunc();
            int nStock = 0;
            if (model.getProduct() != null) {
                nStock = model.getProduct().getQuantity();
            }

            if (rd == null) {
                if (nStock - model.getQuantity() < 0) {
                    rs.setResult(false);
                    rs.setMessage("Vượt quá số lượng sản phẩm trong kho");
                    return rs;
                }

                rd = new DeliveryBillDetail();
                rd.setProduct(model.getProduct());
                rd.setQuantity(model.getQuantity());
                rd.setDeliveryBill(_deliveryBillService.getById(model.getFormId()));
                rs.setResult(_deliveryBillService.insertDetail(rd));
            } else {
                if (nStock - rd.getQuantity() + model.getQuantity() < 0) {
                    rs.setResult(false);
                    rs.setMessage("Vượt quá số lượng sản phẩm trong kho");
                    return rs;
                }

                rd.setProduct(model.getProduct());
                rd.setQuantity(model.getQuantity());
                rs.setResult(_deliveryBillService.updateDetail(rd));
            }
            return rs;
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoDeliveryBillFrame.UpdateOrAddProduct()");
            System.out.println(e);
            ResultFunc rs = new ResultFunc();
            rs.setResult(false);
            rs.setMessage(e.getMessage());
            return rs;
        }
    }

    @Override
    protected ResultFunc deleteDetail(ItemFormDetailModel model) {
        try {
            ResultFunc rs = new ResultFunc();

            rs.setResult(_deliveryBillService.deleteDetailByProductId(model.getFormId(), model.getProduct().getProductId()));

            return rs;
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoDeliveryBillFrame.DeleteProduct()");
            System.out.println(e);
            ResultFunc rs = new ResultFunc();
            rs.setResult(false);
            rs.setMessage(e.getMessage());
            return rs;
        }
    }

    @Override
    protected ResultFunc saveForm(FormModel model) {
        try {
            ResultFunc rs = new ResultFunc();
            DeliveryBill deliveryBill = new DeliveryBill();
            
            deliveryBill.setDeliveryBillId(model.getFormId());
            deliveryBill.setDatetime(model.getDateTime());
            deliveryBill.setPartner(model.getPartner());
            rs.setResult(_deliveryBillService.saveForm(deliveryBill));
        return rs;
    }
    catch (Exception e

    
        ) {
            System.out.println("components.interfaces.InfoDeliveryBillFrame.SaveForm()");
        System.out.println(e);
        ResultFunc rs = new ResultFunc();
        rs.setResult(false);
        rs.setMessage(e.getMessage());
        return rs;
    }
}

@Override
        protected ResultFunc deleteForm(long formid) {
        ResultFunc rs = new ResultFunc();
        rs.setResult(_deliveryBillService.delete(formid));
        return rs;
    }

    @Override
        protected FormModel getNewForm() {
        try {
            DeliveryBill deliveryBill = _deliveryBillService.getNew();
            FormModel form = new FormModel();
            form.setDateTime(deliveryBill.getDatetime());
            form.setFormId(deliveryBill.getDeliveryBillId());
            form.setPartner(deliveryBill.getPartner());
            form.setStatus(deliveryBill.getStatus());
            return form;
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoDeliveryBillFrame.getNewForm()");
            System.out.println(e);
            return new FormModel();
        }
    }

    @Override
        protected List<ItemFormDetailModel> getDetails(long id) {
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
}
