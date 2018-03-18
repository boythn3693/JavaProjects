/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.models;

import java.util.Date;

/**
 *
 * @author vankh
 */
public class FormModel {
    
    private long FormId;
    private long PartnerId;
    private Date DateTime;
    private int Status;

    /**
     * Get the value of Status
     *
     * @return the value of Status
     */
    public int getStatus() {
        return Status;
    }

    /**
     * Set the value of Status
     *
     * @param Status new value of Status
     */
    public void setStatus(int Status) {
        this.Status = Status;
    }


    /**
     * Get the value of DateTime
     *
     * @return the value of DateTime
     */
    public Date getDateTime() {
        return DateTime;
    }

    /**
     * Set the value of DateTime
     *
     * @param DateTime new value of DateTime
     */
    public void setDateTime(Date DateTime) {
        this.DateTime = DateTime;
    }


    /**
     * Get the value of PartnerId
     *
     * @return the value of PartnerId
     */
    public long getPartnerId() {
        return PartnerId;
    }

    /**
     * Set the value of PartnerId
     *
     * @param PartnerId new value of PartnerId
     */
    public void setPartnerId(long PartnerId) {
        this.PartnerId = PartnerId;
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
