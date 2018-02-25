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
public class PartnerDTO {
    private int partnerId;
    private String partnerName;
    private String description;
    private String address;
    private String numphone;
    private String representFullname;
    
    public PartnerDTO(){
        this.partnerId = 0;
        this.partnerName = null;
        this.description = null;
        this.address = null;
        this.numphone = null;
        this.representFullname = null;
    }
    
    public PartnerDTO(int _id, String _name, String _desc, String _addr, String _phone, String _represent){
        this.partnerId = _id;
        this.partnerName = _name;
        this.description = _desc;
        this.address = _addr;
        this.numphone = _phone;
        this.representFullname = _represent;
    }
    
    /**
     * @return the partnerId
     */
    public int getPartnerID()
    {
        return this.partnerId;
    }
    
    /**
     * @param _id the partnerId to set
     */
    public void setPartnerID(int _id)
    {
        this.partnerId = _id;
    }
    
    /**
     * @return the partnerName
     */
    public String getPartnerName()
    {
        return this.partnerName;
    }
    
    /**
     * @param _name the partnerName to set
     */
    public void setPartnerID(String _name)
    {
        this.partnerName = _name;
    }
    
    /**
     * @return the description
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * @param _desc the description to set
     */
    public void setDescription(String _desc)
    {
        this.description = _desc;
    }
    
    /**
     * @return the address
     */
    public String getAddress()
    {
        return this.address;
    }
    
    /**
     * @param _addr the address to set
     */
    public void setAddress(String _addr)
    {
        this.address = _addr;
    }
    
    /**
     * @return the numphone
     */
    public String getNumphone()
    {
        return this.numphone;
    }
    
    /**
     * @param _phone the numphone to set
     */
    public void setNumphone(String _phone)
    {
        this.numphone = _phone;
    }
    
    /**
     * @return the representFullname
     */
    public String getRepresentFullname()
    {
        return this.representFullname;
    }
    
    /**
     * @param _represent the representFullname to set
     */
    public void setRepresentFullname(String _represent)
    {
        this.representFullname = _represent;
    }
}
