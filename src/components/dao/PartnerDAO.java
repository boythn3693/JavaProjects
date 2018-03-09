package components.dao;

import components.dto.Partner;
import components.model.PartnerModel;
import java.util.List;

/**
 *
 * @author LuuDV
 */
public class PartnerDAO {
    PartnerModel model;
    public PartnerDAO() {
        model = new PartnerModel();
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
    
    public List<Partner> getDataPartner()
    {
        List<Partner> rs = model.getListPartner();  
        return rs;
    }
}
