/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.entity.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vankh
 */
public class DeliveryBillDAO {

    final String QUERY_GET_RECEIPT_BY_ID
            = "SELECT r "
            + "FROM DeliveryBill r "
            + "WHERE r.deliveryBillId = '%s'";
    final String QUERY_GET_ALL_RECEIPT
            = "SELECT r "
            + "FROM DeliveryBill r "
            + "JOIN FETCH r.partner p "
            + "WHERE r.status > 0";
    final String QUERY_GET_NEW_RECEIPT
            = "SELECT r "
            + "FROM DeliveryBill r "
            //+ "JOIN FETCH r.partner p "
            + "WHERE r.status = 0";
    final String QUERY_GET_RECEIPT_DETAI_BY_ID
            = "SELECT rd "
            + "FROM DeliveryBillDetail rd "
            + "JOIN FETCH rd.deliveryBill r "
            + "JOIN FETCH rd.product p "
            + "WHERE r.deliveryBillId = '%s'";
    final String QUERY_GET_RECEIPT_DETAI_BY_PRODUCT_ID
            = "SELECT rd "
            + "FROM DeliveryBillDetail rd "
            + "JOIN FETCH rd.deliveryBill r "
            + "JOIN FETCH rd.product p "
            + "WHERE r.deliveryBillId = '%s' AND p.productId = '%s'";

    public DeliveryBill getById(long id) {
        List<DeliveryBill> list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_RECEIPT_BY_ID, id));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public DeliveryBill getNew() {
        DeliveryBill deliveryBill = new DeliveryBill();
        deliveryBill.setDeliveryBillId(-1);
        deliveryBill.setDatetime(new Date());
        insert(deliveryBill);
        List<DeliveryBill> list = QueryDB.GetInstance().executeHQLQuery(QUERY_GET_NEW_RECEIPT);
        if (list != null && list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return new DeliveryBill();
    }

    public Boolean insert(Object obj) {
        return QueryDB.GetInstance().save(obj);
    }

    public Boolean update(Object obj) {
        return QueryDB.GetInstance().update(obj);
    }

    public Boolean delete(long id) {
        DeliveryBill obj = getById(id);
        if (obj != null) {
            return QueryDB.GetInstance().delete(obj);
        } else {
            return false;
        }
    }

    public Long countTable() {
        return QueryDB.GetInstance().countTable("DeliveryBill");
    }

    public List<DeliveryBill> getAll() {

        List<DeliveryBill> rs = QueryDB.GetInstance().executeHQLQuery(QUERY_GET_ALL_RECEIPT);
        //List<DeliveryBill> rs = QueryDB.GetInstance().executeQueryWithType(QUERY_GET_ALL_RECEIPT, DeliveryBill.class);
        return rs;
    }

    public List<DeliveryBillDetail> getDetailsById(long id) {
        return QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_RECEIPT_DETAI_BY_ID, id));
    }

    public DeliveryBillDetail getDetailByProductId(long deliveryBillId, long productId) {
        List<DeliveryBillDetail> list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_RECEIPT_DETAI_BY_ID, deliveryBillId, productId));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public boolean deleteDetailByProductId(long deliveryBillId, long productId) {
        List<DeliveryBillDetail> list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_RECEIPT_DETAI_BY_ID, deliveryBillId, productId));
        if (list != null && list.size() > 0) {
            return QueryDB.GetInstance().delete(list.get(0));
        }
        return false;
    }

    public boolean updateDetail(DeliveryBillDetail obj) {
        return QueryDB.GetInstance().update(obj);
    }

    public boolean insertDetail(DeliveryBillDetail obj) {
        return QueryDB.GetInstance().save(obj);
    }
}
