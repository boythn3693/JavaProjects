/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dto;

/**
 *
 * @author MitsuyoRai
 */
public class DeliveryBillDetailDTO {
    private int deliveryBillDetailId;
    private int deliveryBillId;
    private int productId;
    private int quantity;
    
    public DeliveryBillDetailDTO()
    {
        this.deliveryBillDetailId = 0;
        this.deliveryBillId = 0;
        this.productId = 0;
        this.quantity = 0;
    }
    
    public DeliveryBillDetailDTO(int _deliveryBillDetailId, int _deliveryBillId, int _productId, int _quantity)
    {
        this.deliveryBillDetailId = _deliveryBillDetailId;
        this.deliveryBillId = _deliveryBillId;
        this.productId = _productId;
        this.quantity = _quantity;
    }
    
    /**
     * @return the deliveryBillDetailId
     */
    public int getDeliveryBillDetailID()
    {
        return this.deliveryBillDetailId;
    }
    
    /**
     * @param _deliveryBillDetailId the deliveryBillDetailId to set
     */
    public void setDeliveryBillDetailID(int _deliveryBillDetailId)
    {
        this.deliveryBillDetailId = _deliveryBillDetailId;
    }
    
    /**
     * @return the deliveryBillId
     */
    public int getDeliveryBillID()
    {
        return this.deliveryBillId;
    }
    
    /**
     * @param _deliveryBillId the deliveryBillId to set
     */
    public void setDeliveryBillID(int _deliveryBillId)
    {
        this.deliveryBillId = _deliveryBillId;
    }
    
    /**
     * @return the productId
     */
    public int getProductID()
    {
        return this.productId;
    }
    
    /**
     * @param _productId the productId to set
     */
    public void setProductID(int _productId)
    {
        this.productId = _productId;
    }
    
    /**
     * @return the quantity
     */
    public int getQuantity()
    {
        return this.quantity;
    }
    
    /**
     * @param _quantity the quantity to set
     */
    public void setQuantity(int _quantity)
    {
        this.quantity = _quantity;
    }
}
