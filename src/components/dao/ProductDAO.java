/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.dto.Product;
import components.model.ProductModel;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class ProductDAO {
    ProductModel model;
    public ProductDAO() {
        model = new ProductModel();
    }
    
    public Boolean insert(Object obj){
        return model.insert(obj);
    }
    
    public Boolean update(Object obj){
        return model.update(obj);
    }
    
    public Boolean delete(Object obj){
        return model.delete(obj);
    }
    
    public List<Product> getDataProduct(int status)
    {
        List<Product> rs = model.getListProduct(status);  
        if( rs == null )
        {
            return null;
        }
        return rs;
    }
}
