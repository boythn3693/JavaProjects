/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.providers;

import components.models.ItemComboBoxModel;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author vankh
 */
public class InvComboBoxRenderer extends BasicComboBoxRenderer {

    @Override
    @SuppressWarnings("null")
    public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        if (value != null) {
            ItemComboBoxModel item = (ItemComboBoxModel) value;
            setText(item.getDisplay());
        } else {
            setText("");
        }

        //if (index == -1) {
        //    ItemComboBoxModel item = (ItemComboBoxModel) value;
        //    setText("" + item.getId());
        //}
        return this;
    }
}
