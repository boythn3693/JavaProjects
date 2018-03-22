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
public class ReceiptService {

    ReceiptDAO _dao;
    CommonDAO _commonDao;

    public ReceiptService() {
        _dao = new ReceiptDAO();
        _commonDao = new CommonDAO();
    }

    public Receipt getById(long id) {
        return _dao.getById(id);
    }

    public Receipt getNew() {
        return _dao.getNew();
    }

    public Boolean saveForm(Receipt model) {
        Receipt receipt = _dao.getById(model.getReceiptId());

        if (receipt != null) {
            receipt.setDatetime(model.getDatetime());
            receipt.setPartner(model.getPartner());
            receipt.setStatus(1);
            return _dao.update(receipt);
        } else {
            return false;
        }
    }

    public Boolean delete(long id) {
        List<ReceiptDetail> details = getDetailsById(id);
        if (details != null && details.size() > 0) {
            for (int i = 0; i < details.size(); i++) {
                if (details.get(i).getProduct() != null) {
                    deleteDetailByProductId(id, details.get(i).getProduct().getProductId());
                }
            }
        }
        return _dao.delete(id);
    }

    public List<Receipt> getAll() {
        return _dao.getAll();
    }

    public List<ReceiptDetail> getDetailsById(long id) {
        return _dao.getDetailsById(id);
    }

    public ReceiptDetail getDetailByProductId(long receiptId, long productId) {
        return _dao.getDetailByProductId(receiptId, productId);
    }

    public boolean deleteDetailByProductId(long receiptId, long productId) {
        Receipt receipt = getById(receiptId);
        if (receipt.getStatus() != 2) {
            return cancelDetail(receiptId, productId) && _dao.deleteDetailByProductId(receiptId, productId);
        }
        return _dao.deleteDetailByProductId(receiptId, productId);
    }

    public boolean updateDetail(ReceiptDetail model) {
        Receipt receipt = getById(model.getReceipt().getReceiptId());
        ReceiptDetail detail = getDetailByProductId(model.getReceipt().getReceiptId(), model.getProduct().getProductId());
        Product product = null;
        detail.setQuantity(model.getQuantity());
        if (receipt.getStatus() != 2) {
            cancelDetail(receipt.getReceiptId(), model.getProduct().getProductId());
            product = _commonDao.getProductById(model.getProduct().getProductId());
            int nStock = product.getQuantity();
            product.setQuantity(nStock + model.getQuantity());
        }
        return _dao.updateDetail(detail) && _commonDao.updateObject(product);
    }

    public boolean insertDetail(ReceiptDetail model) {
        Receipt receipt = getById(model.getReceipt().getReceiptId());
        Product product = null;

        model.setQuantity(model.getQuantity());
        if (receipt.getStatus() != 2) {
            product = _commonDao.getProductById(model.getProduct().getProductId());
            int nStock = product.getQuantity();
            product.setQuantity(nStock + model.getQuantity());
        }
        return _dao.insertDetail(model) && _commonDao.updateObject(product);
    }

    public boolean cancelForm(long id) {
        Receipt receipt = getById(id);
        if (receipt.getStatus() != 2) {
            List<ReceiptDetail> details = getDetailsById(id);
            if (details != null && details.size() > 0) {
                for (int i = 0; i < details.size(); i++) {
                    if (details.get(i).getProduct() != null) {
                        cancelDetail(id, details.get(i).getProduct().getProductId());
                    }
                }
            }

            receipt.setStatus(2);
            _dao.update(receipt);
        }
        return true;
    }

    private boolean cancelDetail(long receiptId, long productId) {
        ReceiptDetail detail = getDetailByProductId(receiptId, productId);
        Product product = _commonDao.getProductById(productId);
        int nStock = product.getQuantity();
        nStock = nStock - detail.getQuantity();
        if (nStock < 0) {
            nStock = 0;
        }
        product.setQuantity(nStock);
        return _commonDao.updateObject(product);
    }
}
