/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.services;

import components.entity.Partner;
import components.dao.PartnerModel;
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
    
    public Long countTable(){
        return model.countTable();
    }
    
    public Long countTableFilter(String filter, boolean isName, boolean isDescription, boolean isAddress, boolean isPhone,  boolean isNDD){
        return model.countTableFilter(filter, isName, isDescription, isAddress, isPhone, isNDD);
    }
    
    public Long countTableFilter2(String maDoiTac, String tenDoiTac, String nguoiDaiDien, String diaChi, String soDienThoai){
        return model.countTableFilter2(maDoiTac, tenDoiTac, nguoiDaiDien, diaChi, soDienThoai);
    }
    
    public List<Partner> getListByPagination(List<Partner> list, int start, int end){
        return model.getListByPagination(list, start, end);
    }
    
    public List<Partner> getDataPartnerFilter(String filter, boolean isName, boolean isDescription, boolean isAddress, boolean isPhone,  boolean isNDD){
        List<Partner> rs = model.getListPartnerFilter( filter, isName, isDescription, isAddress, isPhone, isNDD);
        return rs;
    }
      public Partner getById(long id) {
      return model.getById(id);
  }
}
