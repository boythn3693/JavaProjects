/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.entity.DeliveryBill;
import components.entity.DeliveryBillDetail;
import components.interfaces.Template.InfoFrame;
import components.models.FormModel;
import components.models.ItemFormDetailModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vankh
 */
public class InfoDeliveryBillFrame extends InfoFrame {

    public InfoDeliveryBillFrame() {
        super();
    }

    @Override
    protected boolean updateOrAddProduct(ItemFormDetailModel model) {
        try {
            DeliveryBillDetail rd = _deliveryBillService.getDetailByProductId(model.getFormId(), model.getProduct().getProductId());
            if (rd == null) {
                rd = new DeliveryBillDetail();
                rd.setProduct(model.getProduct());
                rd.setQuantity(model.getQuantity());
                rd.setDeliveryBill(_deliveryBillService.getById(model.getFormId()));
                return _deliveryBillService.insertDetail(rd);
            } else {
                rd.setProduct(model.getProduct());
                rd.setQuantity(model.getQuantity());
                return _deliveryBillService.updateDetail(rd);
            }
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoDeliveryBillFrame.UpdateOrAddProduct()");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    protected boolean deleteProduct(ItemFormDetailModel model) {
        try {
            return _deliveryBillService.deleteDetailByProductId(model.getFormId(), model.getProduct().getProductId());
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoDeliveryBillFrame.DeleteProduct()");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    protected boolean saveForm(FormModel model) {
        try {
            DeliveryBill deliveryBill = _deliveryBillService.getById(model.getFormId());
            if (deliveryBill != null) {
                deliveryBill.setDatetime(model.getDateTime());
                deliveryBill.setPartner(model.getPartner());
                deliveryBill.setStatus(1);
                return _deliveryBillService.update(deliveryBill);
            }
            return false;
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoDeliveryBillFrame.SaveForm()");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    protected void deleteForm(long formid) {
        _deliveryBillService.delete(formid);
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
            System.out.println(e.getMessage());
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
