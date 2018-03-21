/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.entity.Receipt;
import components.entity.ReceiptDetail;
import components.interfaces.Template.InfoFrame;
import components.models.FormModel;
import components.models.ItemFormDetailModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vankh
 */
public class InfoReceiptFrame extends InfoFrame {

    public InfoReceiptFrame() {
        super();
    }

    @Override
    protected boolean updateOrAddProduct(ItemFormDetailModel model) {
        try {
            ReceiptDetail rd = _receiptService.getDetailByProductId(model.getFormId(), model.getProduct().getProductId());
            if (rd == null) {
                rd = new ReceiptDetail();
                rd.setProduct(model.getProduct());
                rd.setQuantity(model.getQuantity());
                rd.setReceipt(_receiptService.getById(model.getFormId()));
                return _receiptService.insertDetail(rd);
            } else {
                rd.setProduct(model.getProduct());
                rd.setQuantity(model.getQuantity());
                return _receiptService.updateDetail(rd);
            }
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoReceiptFrame.UpdateOrAddProduct()");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    protected boolean deleteProduct(ItemFormDetailModel model) {
        try {
            return _receiptService.deleteDetailByProductId(model.getFormId(), model.getProduct().getProductId());
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoReceiptFrame.DeleteProduct()");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    protected boolean saveForm(FormModel model) {
        try {
            Receipt receipt = _receiptService.getById(model.getFormId());
            if (receipt != null) {
                receipt.setDatetime(model.getDateTime());
                receipt.setPartner(model.getPartner());
                receipt.setStatus(1);
                return _receiptService.update(receipt);
            }
            return false;
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoReceiptFrame.SaveForm()");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    protected void deleteForm(long formid) {
        _receiptService.delete(formid);
    }

    @Override
    protected FormModel getNewForm() {
        try {
            Receipt receipt = _receiptService.getNew();
            FormModel form = new FormModel();
            form.setDateTime(receipt.getDatetime());
            form.setFormId(receipt.getReceiptId());
            form.setPartner(receipt.getPartner());
            form.setStatus(receipt.getStatus());
            return form;
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoReceiptFrame.getNewForm()");
            System.out.println(e.getMessage());
            return new FormModel();
        }
    }

    @Override
    protected List<ItemFormDetailModel> getDetails(long id) {
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
}
