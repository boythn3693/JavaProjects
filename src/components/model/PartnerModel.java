package components.model;

import components.dto.Partner;
import java.util.List;

/**
 *
 * @author LuuDV
 */
public class PartnerModel {
    private static final String QUERY_PARTNER = "from Partner p";
    public static final String QUERY_GET_ALL_PARTNER = "from Partner p where Status = %s";
    
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
    
    public List<Partner> getListPartner(int status)
    {
        return QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_GET_ALL_PARTNER, status));
    }
}
