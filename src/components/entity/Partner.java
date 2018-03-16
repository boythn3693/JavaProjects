package components.entity;
// Generated Mar 16, 2018 2:40:42 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Partner generated by hbm2java
 */
public class Partner  implements java.io.Serializable {


     private long partnerId;
     private Serializable partnerName;
     private Serializable description;
     private Serializable address;
     private Serializable numPhone;
     private Serializable representFullname;
     private Set deliveryBills = new HashSet(0);
     private Set receipts = new HashSet(0);

    public Partner() {
    }

	
    public Partner(long partnerId, Serializable partnerName) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
    }
    public Partner(long partnerId, Serializable partnerName, Serializable description, Serializable address, Serializable numPhone, Serializable representFullname, Set deliveryBills, Set receipts) {
       this.partnerId = partnerId;
       this.partnerName = partnerName;
       this.description = description;
       this.address = address;
       this.numPhone = numPhone;
       this.representFullname = representFullname;
       this.deliveryBills = deliveryBills;
       this.receipts = receipts;
    }
   
    public long getPartnerId() {
        return this.partnerId;
    }
    
    public void setPartnerId(long partnerId) {
        this.partnerId = partnerId;
    }
    public Serializable getPartnerName() {
        return this.partnerName;
    }
    
    public void setPartnerName(Serializable partnerName) {
        this.partnerName = partnerName;
    }
    public Serializable getDescription() {
        return this.description;
    }
    
    public void setDescription(Serializable description) {
        this.description = description;
    }
    public Serializable getAddress() {
        return this.address;
    }
    
    public void setAddress(Serializable address) {
        this.address = address;
    }
    public Serializable getNumPhone() {
        return this.numPhone;
    }
    
    public void setNumPhone(Serializable numPhone) {
        this.numPhone = numPhone;
    }
    public Serializable getRepresentFullname() {
        return this.representFullname;
    }
    
    public void setRepresentFullname(Serializable representFullname) {
        this.representFullname = representFullname;
    }
    public Set getDeliveryBills() {
        return this.deliveryBills;
    }
    
    public void setDeliveryBills(Set deliveryBills) {
        this.deliveryBills = deliveryBills;
    }
    public Set getReceipts() {
        return this.receipts;
    }
    
    public void setReceipts(Set receipts) {
        this.receipts = receipts;
    }




}


