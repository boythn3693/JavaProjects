/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.entity.Category;
import components.entity.Product;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class CategoryModel {
    public List runQueryCategory() {
        final String QUERY_CATEGORY = "from Category c";
        return QueryDB.GetInstance().runQuery(String.format(QUERY_CATEGORY));
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
    
    public List<Category> getListCategory()
    {
        final String QUERY_GET_ALL_CATEGORY = "from Category";
        
        List<Category> rs = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_ALL_CATEGORY));//String.format(QUERY_GET_ALL_PRODUCT, status)
        return rs;
    }
    
    public List<Product> getListCategoryByExistProductCat(int id){
        
        final String QUERY = "from Product where categoryId = "+id;
        
        List<Product> rs = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY));//String.format(QUERY_GET_ALL_PRODUCT, status)
        return rs;
    }
}
