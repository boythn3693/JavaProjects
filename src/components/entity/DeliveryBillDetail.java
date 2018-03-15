package components.entity;
// Generated Mar 16, 2018 1:48:13 AM by Hibernate Tools 4.3.1



/**
 * DeliveryBillDetail generated by hbm2java
 */
public class DeliveryBillDetail  implements java.io.Serializable {


     private long deliveryBillDetailId;
     private DeliveryBill deliveryBill;
     private Product product;
     private int quantity;

    public DeliveryBillDetail() {
    }

	
    public DeliveryBillDetail(long deliveryBillDetailId, int quantity) {
        this.deliveryBillDetailId = deliveryBillDetailId;
        this.quantity = quantity;
    }
    public DeliveryBillDetail(long deliveryBillDetailId, DeliveryBill deliveryBill, Product product, int quantity) {
       this.deliveryBillDetailId = deliveryBillDetailId;
       this.deliveryBill = deliveryBill;
       this.product = product;
       this.quantity = quantity;
    }
   
    public long getDeliveryBillDetailId() {
        return this.deliveryBillDetailId;
    }
    
    public void setDeliveryBillDetailId(long deliveryBillDetailId) {
        this.deliveryBillDetailId = deliveryBillDetailId;
    }
    public DeliveryBill getDeliveryBill() {
        return this.deliveryBill;
    }
    
    public void setDeliveryBill(DeliveryBill deliveryBill) {
        this.deliveryBill = deliveryBill;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}


