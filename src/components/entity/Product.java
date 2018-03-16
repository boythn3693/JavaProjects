package components.entity;
// Generated Mar 16, 2018 2:40:42 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
public class Product  implements java.io.Serializable {


     private long productId;
     private Category category;
     private String code;
     private String productName;
     private String description;
     private int quantity;
     private int status;
     private int productType;
     private Set receiptDetails = new HashSet(0);
     private Set deliveryBillDetails = new HashSet(0);

    public Product() {
    }

	
    public Product(long productId, String code, String productName, int quantity, int status, int productType) {
        this.productId = productId;
        this.code = code;
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
        this.productType = productType;
    }
    
    public Product(long productId, String code, String productName, String description, int quantity, int status, int productType) {
        this.productId = productId;
        this.code = code;
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.productType = productType;
    }
    
    public Product(long productId, Category category, String code, String productName, String description, int quantity, int status, int productType, Set receiptDetails, Set deliveryBillDetails) {
       this.productId = productId;
       this.category = category;
       this.code = code;
       this.productName = productName;
       this.description = description;
       this.quantity = quantity;
       this.status = status;
       this.productType = productType;
       this.receiptDetails = receiptDetails;
       this.deliveryBillDetails = deliveryBillDetails;
    }
   
    public long getProductId() {
        return this.productId;
    }
    
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public Serializable getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public Serializable getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Serializable getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    public int getProductType() {
        return this.productType;
    }
    
    public void setProductType(int productType) {
        this.productType = productType;
    }
    public Set getReceiptDetails() {
        return this.receiptDetails;
    }
    
    public void setReceiptDetails(Set receiptDetails) {
        this.receiptDetails = receiptDetails;
    }
    public Set getDeliveryBillDetails() {
        return this.deliveryBillDetails;
    }
    
    public void setDeliveryBillDetails(Set deliveryBillDetails) {
        this.deliveryBillDetails = deliveryBillDetails;
    }




}


