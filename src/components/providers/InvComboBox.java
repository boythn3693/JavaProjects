/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.providers;

import components.models.ItemComboBoxModel;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author vankh
 */
public class InvComboBox extends JComboBox<ItemComboBoxModel> {

    DefaultComboBoxModel _model;

    public InvComboBox() {
        super();
        setRenderer(new InvComboBoxRenderer());
        _model = (DefaultComboBoxModel) this.getModel();
    }

    public void setSelectedByValue(long id) {

        for (int i = 0; i < _model.getSize(); i++) {
            ItemComboBoxModel item = (ItemComboBoxModel) _model.getElementAt(i);
            if (item.getValue() == id) {
                _model.setSelectedItem(item);
                break;
            }
        }
    }

    public long getSelectedValue() {
        return ((ItemComboBoxModel) _model.getSelectedItem()).getValue();
    }

    public void addElementList(List<ItemComboBoxModel> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                _model.addElement(list.get(i));
            }
        }
    }

    public void addElement(ItemComboBoxModel item) {
        if (item != null) {
            _model.addElement(item);
        }
    }

    public void removeAll() {
        _model.removeAllElements();
    }
}
