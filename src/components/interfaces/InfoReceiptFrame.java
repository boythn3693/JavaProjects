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
public class InfoReceiptFrame extends InfoFrame {

    public InfoReceiptFrame() {
        super();
    }

    @Override
    protected ResultFunc updateOrAddProduct(ItemFormDetailModel model) {
        try {
            ReceiptDetail rd = _receiptService.getDetailByProductId(model.getFormId(), model.getProduct().getProductId());
            ResultFunc rs = new ResultFunc();

            if (rd == null) {
                rd = new ReceiptDetail();
                rd.setProduct(model.getProduct());
                rd.setQuantity(model.getQuantity());
                rd.setReceipt(_receiptService.getById(model.getFormId()));
                rs.setResult(_receiptService.insertDetail(rd));
            } else {
                rd.setProduct(model.getProduct());
                rd.setQuantity(model.getQuantity());
                rs.setResult(_receiptService.updateDetail(rd));
            }
            return rs;
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoReceiptFrame.UpdateOrAddProduct()");
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

            rs.setResult(_receiptService.deleteDetailByProductId(model.getFormId(), model.getProduct().getProductId()));

            return rs;
        } catch (Exception e) {
            System.out.println("components.interfaces.InfoReceiptFrame.DeleteProduct()");
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
            Receipt receipt = new Receipt();
            
            receipt.setReceiptId(model.getFormId());
            receipt.setDatetime(model.getDateTime());
            receipt.setPartner(model.getPartner());
            rs.setResult(_receiptService.saveForm(receipt));
        return rs;
    }
    catch (Exception e

    
        ) {
            System.out.println("components.interfaces.InfoReceiptFrame.SaveForm()");
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
        rs.setResult(_receiptService.delete(formid));
        return rs;
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
            System.out.println(e);
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
