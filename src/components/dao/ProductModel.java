/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class ProductModel {
    public List runQueryProduct() {
        final String QUERY_PRODUCT = "from Product p";
        return QueryDB.GetInstance().runQuery(String.format(QUERY_PRODUCT));
    }
    
    public Boolean hasCode(String code){
        final String QUERY_HASCODE_PRODUCT = "FROM Product P WHERE P.code = '%s'";
        List<Product> list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_HASCODE_PRODUCT, code));
        if( list != null ) {
            return true;
        }
        return false;
    }
    
    public Boolean hasCode(String code, int id){
        final String QUERY_HASCODE_PRODUCT = "FROM Product P WHERE P.code = '%s' AND P.productId <> %d";
        List list = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_HASCODE_PRODUCT, code, id));
        
        if( list != null ) {
            return true;
        }
        
        return false;
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
    
    public List<Product> getAllDataProduct(){
        final String QUERY_GET_ALL_PRODUCT = "from Product p order by p.productId desc";
        
        List<Product> rs = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_ALL_PRODUCT));
        return rs;
    }
    
    public Long countTable(){
        return QueryDB.GetInstance().countTable("select count (*) from Product");
    }
    
    public Long countTableFilter(String filter, boolean isCode, boolean isName, boolean isDescription, boolean isQuantity, boolean isStatus, boolean isProductType){
        String where = "";
        if( isCode ){
            where += (where.equals("") == true) ? "where p.code like '%"+filter+"%' " : "or p.code like '%"+filter+"%' ";
        }
        if( isName ){
            where += (where.equals("") == true) ? "where p.productName like '%"+filter+"%' " : "or p.productName like '%"+filter+"%' ";
        }
        if( isDescription ){
            where += (where.equals("") == true) ? "where p.description like '%"+filter+"%' " : "or p.description like '%"+filter+"%' ";
        }        
        if( isQuantity ){
            where += (where.equals("") == true) ? "where p.quantity = "+filter+" " : "or p.quantity = "+filter+" ";
        }
//        if( isStatus ){
//            where += (where.equals("") == true) ? "where p.status  %"+filter+"%' " : "or p.status like '%"+filter+"%' ";
//        }
//        if( isProductType ){
//            where += (where.equals("") == true) ? "where p.productType like '%"+filter+"%' " : "or p.productType like '%"+filter+"%' ";
//        }
        final String QUERY_COUNT_PRODUCT = "select count (*) from Product p "+where;
        return QueryDB.GetInstance().countTable(QUERY_COUNT_PRODUCT);
    }
    
//    public List<Product> getListProduct(int status, int lastPageNumber, int pageSize)
//    {
//        final String QUERY_GET_ALL_PRODUCT = "from Product where status = %d order by productId desc";
//        
//        List<Product> rs = QueryDB.GetInstance().executeHQLQueryPaging(String.format(QUERY_GET_ALL_PRODUCT, status), lastPageNumber, pageSize);//String.format(QUERY_GET_ALL_PRODUCT, status)
//        return rs;
//    }
    
    public List<Product> getListProduct(int status)
    {
        final String QUERY_GET_ALL_PRODUCT = "from Product where status = %d order by productId desc";
        
        List<Product> rs = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_ALL_PRODUCT, status));//String.format(QUERY_GET_ALL_PRODUCT, status)
        return rs;
    }
    
    public List<Product> getListByPagination(List<Product> list, int start, int end){
        List<Product> result = new ArrayList<Product>();
        for(int i = start; i < end; i++) {
            result.add(list.get(i));
        }
        return result;
    }
    
    public List<Product> getDataProductFilter(String filter, boolean isCode, boolean isName, boolean isDescription, boolean isQuantity, boolean isStatus, boolean isProductType){
        String where = "";
        if( isCode ){
            where += (where.equals("") == true) ? "where p.code like '%"+filter+"%' " : "or p.code like '%"+filter+"%' ";
        }
        if( isName ){
            where += (where.equals("") == true) ? "where p.productName like '%"+filter+"%' " : "or p.productName like '%"+filter+"%' ";
        }
        if( isDescription ){
            where += (where.equals("") == true) ? "where p.description like '%"+filter+"%' " : "or p.description like '%"+filter+"%' ";
        }        
        if( isQuantity ){
            where += (where.equals("") == true) ? "where p.quantity = "+filter+" " : "or p.quantity = "+filter+" ";
        }
//        if( isStatus ){
//            where += (where.equals("") == true) ? "where p.status  %"+filter+"%' " : "or p.status like '%"+filter+"%' ";
//        }
//        if( isProductType ){
//            where += (where.equals("") == true) ? "where p.productType like '%"+filter+"%' " : "or p.productType like '%"+filter+"%' ";
//        }
        final String QUERY_GET_PRODUCT = "from Product p "+where;
        
        List<Product> rs = QueryDB.GetInstance().executeHQLQuery(QUERY_GET_PRODUCT);
        return rs;
    }
    
    public List<Product> getDataProductFilter2(long productType, int status){
        String where = "";
        if( productType == 0 ) {
            where += "";
        } else {
            where += "where categoryId = "+ productType;
        }
        
        if( status != -1  ) {
            where += (where.equals("") == true) ? "where status = "+status : " and status = "+status;
        }
        final String QUERY_GET_PRODUCT = "from Product "+where;
        
        List<Product> rs = QueryDB.GetInstance().executeHQLQuery(QUERY_GET_PRODUCT);
        return rs;
    }
}
