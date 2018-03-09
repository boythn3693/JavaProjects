package components.dto;

import java.io.Serializable;

/**
 *
 * @author LuuDV
 */
public class Partner implements Serializable {
    private long productId;
    private String code;
    private String productName;
    private String description;
    private int quantity;
    private int status;
    private int productType;

    public Partner() {
    }

    public Partner(long productId, String code, String productName, String description, int quantity, int status, int productType) {
        this.productId = productId;
        this.code = code;
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.productType = productType;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public long getProductId() {
        return productId;
    }

    public String getCode() {
        return code;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStatus() {
        return status;
    }

    public int getProductType() {
        return productType;
    }
}