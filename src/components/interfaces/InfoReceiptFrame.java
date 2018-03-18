/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.interfaces.FormTemplate.InfoFrame;
import components.models.FormModel;
import components.models.ItemFormDetailModel;

/**
 *
 * @author vankh
 */
public class InfoReceiptFrame extends InfoFrame {

    @Override
    protected boolean UpdateOrAddProduct(ItemFormDetailModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean DeleteProduct(ItemFormDetailModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean SaveForm(FormModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void DeleteForm(long formid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
