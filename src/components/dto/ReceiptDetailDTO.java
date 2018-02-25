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
public class ReceiptDetailDTO {
    private int receiptDetailId;
    private int receiptId;
    private int productId;
    private int quantity;
    
    public ReceiptDetailDTO()
    {
        this.receiptDetailId = 0;
        this.receiptId = 0;
        this.productId = 0;
        this.quantity = 0;
    }
    
    public ReceiptDetailDTO(int _receiptDetailId, int _receiptId, int _productId, int _quantity)
    {
        this.receiptDetailId = _receiptDetailId;
        this.receiptId = _receiptId;
        this.productId = _productId;
        this.quantity = _quantity;
    }
    
    /**
     * @return the receiptDetailId
     */
    public int getReceiptDetailID()
    {
        return this.receiptDetailId;
    }
    
    /**
     * @param _receiptDetailId the receiptDetailId to set
     */
    public void setReceiptDetailID(int _receiptDetailId)
    {
        this.receiptDetailId = _receiptDetailId;
    }
    
    /**
     * @return the receiptId
     */
    public int getReceiptId()
    {
        return this.receiptId;
    }
    
    /**
     * @param _receiptId the receiptId to set
     */
    public void setReceiptId(int _receiptId)
    {
        this.receiptId = _receiptId;
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
