package components.dto;

import java.io.Serializable;

/**
 *
 * @author LuuDV
 */
public class Partner implements Serializable {
    private long partnerId;
    private String partnerName;
    private String description;
    private String address;
    private String numPhone;
    private String representFullname;

    public Partner() {
    }

    public Partner(long partnerId, String partnerName, String description, String address, String numPhone, String representFullname) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.description = description;
        this.address = address;
        this.numPhone = numPhone;
        this.representFullname = representFullname;
    }

    public void setPartnerId(long partnerId) {
        this.partnerId = partnerId;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public void setRepresentFullname(String representFullname) {
        this.representFullname = representFullname;
    }

    public long getPartnerId() {
        return partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public String getRepresentFullname() {
        return representFullname;
    }
}
