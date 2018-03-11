/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.models;

import components.entity.Product;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class ProductModel {
    private static final String QUERY_PRODUCT = "from Product p";
    public static final String QUERY_GET_ALL_PRODUCT = "from Product p where Status = %s";
    
    public List runQueryProduct() {
        return QueryDB.GetInstance().runQuery(String.format(QUERY_PRODUCT));
    }
    
    public Boolean insert(Object obj){
        return QueryDB.GetInstance().save(obj);
    }
    
    public Boolean update(Object obj){
        return QueryDB.GetInstance().update(obj);
    }
    
    public Boolean delete(Object obj){
        return QueryDB.GetInstance().delete(obj);
    }
    
    public List<Product> getListProduct(int status)
    {
        return QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_ALL_PRODUCT, status));
    }
}
