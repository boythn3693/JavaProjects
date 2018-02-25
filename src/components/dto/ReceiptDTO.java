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
public class ReceiptDTO {
    private int receiptId;
    private int partnerId;
    private Date datetime;
    private int accountId;
    
    public ReceiptDTO()
    {
        this.receiptId = 0;
        this.partnerId = 0;
        this.datetime = new Date();
        this.accountId = 0;
    }
    
    public ReceiptDTO(int _id, int _partnerId, Date _datetime, int _accountId)
    {
        this.receiptId = _id;
        this.partnerId = _partnerId;
        this.datetime = _datetime;
        this.accountId = _accountId;
    }
    
    /**
     * @return the receiptId
     */
    public int getReceiptID()
    {
        return this.receiptId;
    }
    
    /**
     * @param _id the receiptId to set
     */
    public void setReceiptID(int _id)
    {
        this.receiptId = _id;
    }
    
    /**
     * @return the partnerId
     */
    public int getPartnerId()
    {
        return this.partnerId;
    }
    
    /**
     * @param _partnerId the partnerId to set
     */
    public void setPartnerId(int _partnerId)
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
