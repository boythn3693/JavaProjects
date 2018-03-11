/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.services;

import components.entity.Partner;
import components.models.PartnerModel;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class PartnerService {
    PartnerModel model;
    public PartnerService() {
        model = new PartnerModel();
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
    
    public List<Partner> getDataPartner()
    {
        List<Partner> rs = model.getListPartner();  
        return rs;
    }
}
