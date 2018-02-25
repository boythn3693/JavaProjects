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
public class ProductDTO {
    private int productId;
    private String code;
    private String productName;
    private String description;
    private int quantity;
    private boolean status;
    private short productType;
    
    public ProductDTO()
    {
        this.productId = 0;
        this.code = null;
        this.productName = null;
        this.description = null;
        this.quantity = 1;     
        this.status = true; 
        this.productType = 1;        
    }
    
    public ProductDTO(int _id, String _code, String _name, String _desc, int _quantity, boolean _status, short _type)
    {
        this.productId = _id;
        this.code = _code;
        this.productName = _name;
        this.description = _desc;
        this.quantity = _quantity;     
        this.status = _status; 
        this.productType = _type;        
    }
    
    /**
     * @return the productId
     */
    public int getProductID()
    {
        return this.productId;
    }
    
    /**
     * @param _id the productId to set
     */
    public void setProductID(int _id)
    {
        this.productId = _id;
    }
    
    /**
     * @return the code
     */
    public String getCode()
    {
        return this.code;
    }
    
    /**
     * @param _code the code to set
     */
    public void setProductID(String _code)
    {
        this.code = _code;
    }
    
    /**
     * @return the productName
     */
    public String getProductName()
    {
        return this.productName;
    }
    
    /**
     * @param _name the code to set
     */
    public void setProductName(String _name)
    {
        this.productName = _name;
    }
    
    /**
     * @return the description
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * @param _desc the code to set
     */
    public void setDescription(String _desc)
    {
        this.description = _desc;
    }
    
    /**
     * @return the quantity
     */
    public int getQuantity()
    {
        return this.quantity;
    }
    
    /**
     * @param _quantity the code to set
     */
    public void setQuantity(int _quantity)
    {
        this.quantity = _quantity;
    }
    
    /**
     * @return the status
     */
    public boolean getStatus()
    {
        return this.status;
    }
    
    /**
     * @param _status the code to set
     */
    public void setStatus(boolean _status)
    {
        this.status = _status;
    }
    
    /**
     * @return the productType
     */
    public short getProductType()
    {
        return this.productType;
    }
    
    /**
     * @param _type the code to set
     */
    public void setStatus(short _type)
    {
        this.productType = _type;
    }
}
