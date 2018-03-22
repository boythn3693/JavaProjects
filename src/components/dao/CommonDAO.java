/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.entity.*;
import java.util.List;

/**
 *
 * @author vankh
 */
public class CommonDAO {

    final String QUERY_GET_PRODUCT_BY_ID
            = "FROM Product p "
            + "WHERE p.productId = '%s'";

    public Product getProductById(long id) {
        List<Product> list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_PRODUCT_BY_ID, id));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public boolean updateObject(Object obj) {
        return QueryDB.GetInstance().update(obj);
    }
}
