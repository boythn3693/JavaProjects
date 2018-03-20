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

    public ReceiptService() {
        _dao = new ReceiptDAO();
    }

    public Receipt getById(long id) {
        return _dao.getById(id);
    }

    public Receipt getNew() {
        return _dao.getNew();
    }

    public Boolean insert(Object obj) {
        return _dao.insert(obj);
    }

    public Boolean update(Object obj) {
        return _dao.update(obj);
    }

    public Boolean delete(long id) {
        return _dao.delete(id);
    }

    public Long countTable() {
        return _dao.countTable();
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
        return _dao.deleteDetailByProductId(receiptId, productId);
    }

    public boolean updateDetail(ReceiptDetail obj) {
        return _dao.updateDetail(obj);
    }

    public boolean insertDetail(ReceiptDetail obj) {
        return _dao.insertDetail(obj);
    }
}
