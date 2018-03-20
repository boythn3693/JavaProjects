/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.services;

import components.dao.DeliveryBillDAO;
import components.entity.Receipt;
import java.util.List;

/**
 *
 * @author vankh
 */
public class DeliveryBillService {

    DeliveryBillDAO _dao;

    public DeliveryBillService() {
        _dao = new DeliveryBillDAO();
    }

    public Receipt getNew() {
        return _dao.getNew();
    }

    public Boolean update(Object obj) {
        return _dao.update(obj);
    }

    public Boolean delete(Object obj) {
        return _dao.delete(obj);
    }

    public List<Receipt> getAll() {
        return _dao.getAll();
    }

    public Receipt getById(long id) {
        return _dao.getById(id);
    }
}
