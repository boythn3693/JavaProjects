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
public class ItemModel {

    private final long id;
    private final String value;

    public ItemModel(long id, String description) {
        this.id = id;
        this.value = description;
    }

    public long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
