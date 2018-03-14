/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.entity.Partner;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class PartnerModel {
    private static final String QUERY_PARTNER = "from Partner p";
    public static final String QUERY_GET_ALL_PARTNER = "from Partner p";
    
    public List runQueryPartner() {
        return QueryDB.GetInstance().runQuery(String.format(QUERY_PARTNER));
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
    
    public List<Partner> getListPartner()
    {
        return QueryDB.GetInstance().executeHQLQuery(QUERY_GET_ALL_PARTNER);
    }
}
