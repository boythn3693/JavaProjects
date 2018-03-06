/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.dto.ProductDTO;
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
    
    public List<ProductDTO> getDataProduct(int status)
    {
        List<ProductDTO> rs = model.getListProduct(status);  
        if( rs == null )
        {
            return null;
        }
        return rs;
    }
}
