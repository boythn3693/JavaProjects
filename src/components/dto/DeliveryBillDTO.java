/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dto;

import java.util.Date;

/**
 *
 * @author MitsuyoRai
 */
public class DeliveryBillDTO {
    private int deliveryBillId;
    private int partnerId;
    private Date datetime;
    private int accountId;
    
    public DeliveryBillDTO()
    {
        this.deliveryBillId = 0;
        this.partnerId = 0;
        this.datetime = new Date();
        this.accountId = 0;
    }
    
    public DeliveryBillDTO(int _id, int _partnerId, Date _datetime, int _accountId)
    {
        this.deliveryBillId = _id;
        this.partnerId = _partnerId;
        this.datetime = _datetime;
        this.accountId = _accountId;
    }
    
    /**
     * @return the deliveryBillId
     */
    public int getDeliveryBillID()
    {
        return this.deliveryBillId;
    }
    
    /**
     * @param _id the deliveryBillId to set
     */
    public void setDeliveryBillID(int _id)
    {
        this.deliveryBillId = _id;
    }
    
    /**
     * @return the partnerId
     */
    public int getPartnerID()
    {
        return this.partnerId;
    }
    
    /**
     * @param _partnerId the partnerId to set
     */
    public void setPartnerID(int _partnerId)
    {
        this.partnerId = _partnerId;
    }
    
    /**
     * @return the datetime
     */
    public Date getDatetime()
    {
        return this.datetime;
    }
    
    /**
     * @param _datetime the datetime to set
     */
    public void setDatetime(Date _datetime)
    {
        this.datetime = _datetime;
    }
    
    /**
     * @return the accountId
     */
    public int getAccountID()
    {
        return this.accountId;
    }
    
    /**
     * @param _accountId the accountId to set
     */
    public void setAccountID(int _accountId)
    {
        this.accountId = _accountId;
    }
}
