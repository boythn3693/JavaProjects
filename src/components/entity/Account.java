package components.entity;
// Generated Mar 16, 2018 2:40:42 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Account generated by hbm2java
 */
public class Account  implements java.io.Serializable {


     private long accountId;
     private String username;
     private String password;
     private String firstName;
     private String lastName;
     private String numPhone;
     private String email;
     private boolean inActive;
     private int role;
     private Set deliveryBills = new HashSet(0);
     private Set receipts = new HashSet(0);
     private Set deliveryBills_1 = new HashSet(0);

    public Account() {
    }

	
    public Account(long accountId, String username, String password, boolean inActive, int role) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.inActive = inActive;
        this.role = role;
    }
    public Account(long accountId, String username, String password, String firstName, String lastName, String numPhone, String email, boolean inActive, int role, Set deliveryBills, Set receipts, Set deliveryBills_1) {
       this.accountId = accountId;
       this.username = username;
       this.password = password;
       this.firstName = firstName;
       this.lastName = lastName;
       this.numPhone = numPhone;
       this.email = email;
       this.inActive = inActive;
       this.role = role;
       this.deliveryBills = deliveryBills;
       this.receipts = receipts;
       this.deliveryBills_1 = deliveryBills_1;
    }
   
    public long getAccountId() {
        return this.accountId;
    }
    
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Serializable getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Serializable getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getNumPhone() {
        return this.numPhone;
    }
    
    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isInActive() {
        return this.inActive;
    }
    
    public void setInActive(boolean inActive) {
        this.inActive = inActive;
    }
    public int getRole() {
        return this.role;
    }
    
    public void setRole(int role) {
        this.role = role;
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
    public Set getDeliveryBills_1() {
        return this.deliveryBills_1;
    }
    
    public void setDeliveryBills_1(Set deliveryBills_1) {
        this.deliveryBills_1 = deliveryBills_1;
    }




}


