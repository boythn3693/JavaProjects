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

    public List runQueryReceipt() {
        final String QUERY_PRODUCT = "from Receipt R";
        return QueryDB.GetInstance().runQuery(String.format(QUERY_PRODUCT));
    }

    public Receipt getById(String id) {
        final String QUERY_GET_RECEIPT_BY_ID = "FROM Receipt R WHERE R.receiptId = '%s'";
        List<Receipt> list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_RECEIPT_BY_ID, id));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return new Receipt();
    }

    public Receipt getNew() {
        Receipt receipt = new Receipt();
        receipt.setReceiptId(-1);
        receipt.setDatetime(new Date());
        insert(receipt);
        final String QUERY_GET_NEW_RECEIPT = "from Receipt r WHERE r.status = 0";
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

    public Boolean delete(Object obj) {
        return QueryDB.GetInstance().delete(obj);
    }

    public Long countTable() {
        return QueryDB.GetInstance().countTable("Receipt");
    }

    public List<Receipt> getAll() {
        final String QUERY_GET_ALL_RECEIPT = "from Receipt r WHERE r.status > 0";

        List<Receipt> rs = QueryDB.GetInstance().executeHQLQuery(QUERY_GET_ALL_RECEIPT);
        return rs;
    }

    public Receipt getById(long id) {
        final String QUERY_GET_ALL_RECEIPT = "from Receipt r WHERE r.status > 0 AND r.receiptId = ";

        List<Receipt> rs = QueryDB.GetInstance().executeHQLQuery(QUERY_GET_ALL_RECEIPT + id);
        if (rs != null && rs.size() > 0) {
            return rs.get(0);
        }
        return new Receipt();
    }
}
