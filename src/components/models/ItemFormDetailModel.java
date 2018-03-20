/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.models;

import components.entity.Product;

/**
 *
 * @author vankh
 */
public class ItemFormDetailModel {

    private long FormId;

    private int Quantity;

    private Product Product;

    /**
     * Get the value of Product
     *
     * @return the value of Product
     */
    public Product getProduct() {
        return Product;
    }

    /**
     * Set the value of Product
     *
     * @param Product new value of Product
     */
    public void setProduct(Product Product) {
        this.Product = Product;
    }

    /**
     * Get the value of Quantity
     *
     * @return the value of Quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * Set the value of Quantity
     *
     * @param Quantity new value of Quantity
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * Get the value of FormId
     *
     * @return the value of FormId
     */
    public long getFormId() {
        return FormId;
    }

    /**
     * Set the value of FormId
     *
     * @param FormId new value of FormId
     */
    public void setFormId(long FormId) {
        this.FormId = FormId;
    }

}
