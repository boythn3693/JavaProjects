/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.interfaces.FormTemplate.InfoFrame;
import components.interfaces.FormTemplate.ListFrame;
import components.models.FormModel;
import components.models.ItemFormDetailModel;
import java.util.List;

/**
 *
 * @author vankh
 */
public class DeliveryBillFrame extends ListFrame {

    @Override
    protected List<ItemFormDetailModel> getDetailByFormId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<FormModel> getForms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean CancelForm(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected InfoFrame GetInfoForm() {
        return new InfoDeliveryBillFrame();
    }

}
