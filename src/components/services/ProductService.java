/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.services;

import components.entity.Product;
import components.dao.ProductModel;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class ProductService 
{
    ProductModel model;
    public ProductService() 
    {
        model = new ProductModel();
    }
    
    public Boolean hasCode(String code)
    {
        return model.hasCode(code);
    }
    
    public Boolean hasCode(String code, int id){
        return model.hasCode(code, id);
    }
    
    public Boolean insert(Object obj)
    {
        return model.insert(obj);
    }
    
    public Boolean update(Object obj)
    {
        return model.update(obj);
    }
    
    public Boolean delete(Object obj)
    {
        return model.delete(obj);
    }
    
    public Long countTable(){
        return model.countTable();
    }
    
    public List<Product> getDataProduct(int status, int lastPageNumber, int pageSize)
    {
        List<Product> rs = model.getListProduct(status, lastPageNumber, pageSize);
        return rs;
    }
    
    public List<Product> getDataProductFilter(String filter, boolean isCode, boolean isName, boolean isDescription, boolean isQuantity, boolean isStatus, boolean isProductType){
        List<Product> rs = model.getDataProductFilter( filter, isCode, isName, isDescription, isQuantity, isStatus, isProductType);
        return rs;
    }
}
