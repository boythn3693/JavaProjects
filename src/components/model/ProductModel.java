/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.model;

import components.dto.ProductDTO;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class ProductModel {
    private static final String QUERY_PRODUCT = "from ProductDTO p";
    public static final String QUERY_GET_ALL_PRODUCT = "from ProductDTO p where Status = '%s'";
    
    public List runQueryProduct() {
        return QueryDB.GetInstance().runQuery(String.format(QUERY_PRODUCT));
    }
    
    public Boolean insert(Object obj){
        return QueryDB.GetInstance().saveOrUpdate(obj);
    }
    
    public List<ProductDTO> getListProduct(int status)
    {
        return QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_ALL_PRODUCT, status));
    }
}
