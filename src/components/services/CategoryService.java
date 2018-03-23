/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.services;

import components.dao.CategoryModel;
import components.entity.Category;
import components.entity.Product;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class CategoryService {
    CategoryModel model;
    public CategoryService() 
    {
        model = new CategoryModel();
    }
    public List runQueryCategory() {
        return model.runQueryCategory();
    }
    
    public Boolean insert(Object obj){
        return model.insert(obj);
    }
    
    public Boolean update(Object obj){
        return model.update(obj);
    }
    
    public Boolean delete(Object obj, int CatId){
         List<Product> list = model.getListCategoryByExistProductCat(CatId);
         //System.out.println(list.isEmpty());
            if( list.isEmpty() )
                return model.delete(obj);
            else
                return false;
        
    }
    
    public List<Category> getListCategory()
    {
        List<Category> rs = model.getListCategory();
        return rs;
    }
}
