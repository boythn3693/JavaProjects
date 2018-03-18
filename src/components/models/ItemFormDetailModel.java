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
public class ItemFormDetailModel {

    private long FormId;

    private long ProductId;
    
    private String ProductName;

    private int Quantity;

    /**
     * Get the value of ProductName
     *
     * @return the value of ProductName
     */
    public String getProductName() {
        return ProductName;
    }

    /**
     * Set the value of ProductName
     *
     * @param ProductName new value of ProductName
     */
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
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
     * Get the value of ProductId
     *
     * @return the value of ProductId
     */
    public long getProductId() {
        return ProductId;
    }

    /**
     * Set the value of ProductId
     *
     * @param ProductId new value of ProductId
     */
    public void setProductId(long ProductId) {
        this.ProductId = ProductId;
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
