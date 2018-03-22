/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.services;

import components.dao.*;
import components.entity.*;
import java.util.*;

/**
 *
 * @author vankh
 */
public class DeliveryBillService {

    DeliveryBillDAO _dao;
    CommonDAO _commonDao;

    public DeliveryBillService() {
        _dao = new DeliveryBillDAO();
        _commonDao = new CommonDAO();
    }

    public DeliveryBill getById(long id) {
        return _dao.getById(id);
    }

    public DeliveryBill getNew() {
        return _dao.getNew();
    }

    public Boolean saveForm(DeliveryBill model) {
        DeliveryBill deliveryBill = _dao.getById(model.getDeliveryBillId());

        if (deliveryBill != null) {
            deliveryBill.setDatetime(model.getDatetime());
            deliveryBill.setPartner(model.getPartner());
            deliveryBill.setStatus(1);
            return _dao.update(deliveryBill);
        } else {
            return false;
        }
    }

    public Boolean delete(long id) {
        List<DeliveryBillDetail> details = getDetailsById(id);
        if (details != null && details.size() > 0) {
            for (int i = 0; i < details.size(); i++) {
                if (details.get(i).getProduct() != null) {
                    deleteDetailByProductId(id, details.get(i).getProduct().getProductId());
                }
            }
        }
        return _dao.delete(id);
    }

    public List<DeliveryBill> getAll() {
        return _dao.getAll();
    }

    public List<DeliveryBillDetail> getDetailsById(long id) {
        return _dao.getDetailsById(id);
    }

    public DeliveryBillDetail getDetailByProductId(long deliveryBillId, long productId) {
        return _dao.getDetailByProductId(deliveryBillId, productId);
    }

    public boolean deleteDetailByProductId(long deliveryBillId, long productId) {
        DeliveryBill deliveryBill = getById(deliveryBillId);
        if (deliveryBill.getStatus() != 2) {
            return cancelDetail(deliveryBillId, productId) && _dao.deleteDetailByProductId(deliveryBillId, productId);
        }
        return _dao.deleteDetailByProductId(deliveryBillId, productId);
    }

    public boolean updateDetail(DeliveryBillDetail model) {
        DeliveryBill deliveryBill = getById(model.getDeliveryBill().getDeliveryBillId());
        DeliveryBillDetail detail = getDetailByProductId(model.getDeliveryBill().getDeliveryBillId(), model.getProduct().getProductId());
        Product product = null;
        detail.setQuantity(model.getQuantity());
        if (deliveryBill.getStatus() != 2) {
            cancelDetail(deliveryBill.getDeliveryBillId(), model.getProduct().getProductId());
            product = _commonDao.getProductById(model.getProduct().getProductId());
            int nStock = product.getQuantity() - model.getQuantity();
            if (nStock < 0) {
                nStock = 0;
            }
            product.setQuantity(nStock);
        }
        return _dao.updateDetail(detail) && _commonDao.updateObject(product);
    }

    public boolean insertDetail(DeliveryBillDetail model) {
        DeliveryBill deliveryBill = getById(model.getDeliveryBill().getDeliveryBillId());
        Product product = null;

        model.setQuantity(model.getQuantity());
        if (deliveryBill.getStatus() != 2) {
            product = _commonDao.getProductById(model.getProduct().getProductId());
            int nStock = product.getQuantity() - model.getQuantity();
            if (nStock < 0) {
                nStock = 0;
            }
            product.setQuantity(nStock);
        }
        return _dao.insertDetail(model) && _commonDao.updateObject(product);
    }

    public boolean cancelForm(long id) {
        DeliveryBill deliveryBill = getById(id);
        if (deliveryBill.getStatus() != 2) {
            List<DeliveryBillDetail> details = getDetailsById(id);
            if (details != null && details.size() > 0) {
                for (int i = 0; i < details.size(); i++) {
                    if (details.get(i).getProduct() != null) {
                        cancelDetail(id, details.get(i).getProduct().getProductId());
                    }
                }
            }

            deliveryBill.setStatus(2);
            _dao.update(deliveryBill);
        }
        return true;
    }

    private boolean cancelDetail(long deliveryBillId, long productId) {
        DeliveryBillDetail detail = getDetailByProductId(deliveryBillId, productId);
        Product product = _commonDao.getProductById(productId);
        int nStock = product.getQuantity();
        nStock = nStock + detail.getQuantity();
        if (nStock < 0) {
            nStock = 0;
        }
        product.setQuantity(nStock);
        return _commonDao.updateObject(product);
    }
}
