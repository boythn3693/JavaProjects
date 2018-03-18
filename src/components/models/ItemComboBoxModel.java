/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.models;

/**
 *
 * @author vankh
 */
public class ItemComboBoxModel {

    private final long Value;
    private final String Display;

    public ItemComboBoxModel(long value, String display) {
        this.Value = value;
        this.Display = display;
    }

    public long getValue() {
        return Value;
    }

    public String getDisplay() {
        return Display;
    }

    @Override
    public String toString() {
        return Display;
    }
}
