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

    public DeliveryBillService() {
        _dao = new DeliveryBillDAO();
    }

    public DeliveryBill getById(long id) {
        return _dao.getById(id);
    }

    public DeliveryBill getNew() {
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
        return _dao.deleteDetailByProductId(deliveryBillId, productId);
    }

    public boolean updateDetail(DeliveryBillDetail obj) {
        return _dao.updateDetail(obj);
    }

    public boolean insertDetail(DeliveryBillDetail obj) {
        return _dao.insertDetail(obj);
    }
}
