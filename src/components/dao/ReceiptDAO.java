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
public class ReceiptDAO {

    final String QUERY_GET_RECEIPT_BY_ID
            = "SELECT r "
            + "FROM Receipt r "
            + "WHERE r.receiptId = '%s'";
    final String QUERY_GET_ALL_RECEIPT
            = "SELECT r "
            + "FROM Receipt r "
            + "JOIN r.partner p "
            + "WHERE r.status > 0";
    final String QUERY_GET_NEW_RECEIPT
            = "SELECT r "
            + "FROM Receipt r "
            //+ "JOIN r.partner p "
            + "WHERE r.status = 0";
    final String QUERY_GET_RECEIPT_DETAI_BY_ID
            = "SELECT rd "
            + "FROM ReceiptDetail rd "
            + "JOIN rd.receipt r "
            + "WHERE r.receiptId = '%s'";
    final String QUERY_GET_RECEIPT_DETAI_BY_PRODUCT_ID
            = "SELECT rd "
            + "FROM ReceiptDetail rd "
            + "JOIN rd.receipt r "
            + "JOIN rd.product p "
            + "WHERE r.receiptId = '%s' AND p.productId = '%s'";

    public Receipt getById(long id) {
        List<Receipt> list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_RECEIPT_BY_ID, id));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public Receipt getNew() {
        Receipt receipt = new Receipt();
        receipt.setReceiptId(-1);
        receipt.setDatetime(new Date());
        insert(receipt);
        List<Receipt> list = QueryDB.GetInstance().executeHQLQuery(QUERY_GET_NEW_RECEIPT);
        if (list != null && list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return new Receipt();
    }

    public Boolean insert(Object obj) {
        return QueryDB.GetInstance().save(obj);
    }

    public Boolean update(Object obj) {
        return QueryDB.GetInstance().update(obj);
    }

    public Boolean delete(long id) {
        Receipt obj = getById(id);
        if (obj != null) {
            return QueryDB.GetInstance().delete(obj);
        } else {
            return false;
        }
    }

    public Long countTable() {
        return QueryDB.GetInstance().countTable("Receipt");
    }

    public List<Receipt> getAll() {

        List<Receipt> rs = QueryDB.GetInstance().executeHQLQuery(QUERY_GET_ALL_RECEIPT);
        return rs;
    }

    public List<ReceiptDetail> getDetailsById(long id) {
        return QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_RECEIPT_DETAI_BY_ID, id));
    }

    public ReceiptDetail getDetailByProductId(long receiptId, long productId) {
        List<ReceiptDetail> list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_RECEIPT_DETAI_BY_ID, receiptId, productId));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public boolean deleteDetailByProductId(long receiptId, long productId) {
        List<ReceiptDetail> list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_RECEIPT_DETAI_BY_ID, receiptId, productId));
        if (list != null && list.size() > 0) {
            return QueryDB.GetInstance().delete(list.get(0));
        }
        return false;
    }

    public boolean updateDetail(ReceiptDetail obj) {
        return QueryDB.GetInstance().update(obj);
    }

    public boolean insertDetail(ReceiptDetail obj) {
        return QueryDB.GetInstance().save(obj);
    }
}
