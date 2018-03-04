/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dto;

import java.io.Serializable;

/**
 *
 * @author MitsuyoRai
 */
public class AccountDTO implements Serializable {
    private long accountId;
    private String username;
    private String password;   
    private String firstname;   
    private String lastname;
    private String numphone;  
    private String email;  
    private boolean inactive;   
    private int role;

    public AccountDTO(long accountId, String username, String password, String firstname, String lastname, String numphone, String email, boolean inactive, int role) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.numphone = numphone;
        this.email = email;
        this.inactive = inactive;
        this.role = role;
    }

    public AccountDTO() {
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNumphone(String numphone) {
        this.numphone = numphone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNumphone() {
        return numphone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isInactive() {
        return inactive;
    }

    public int getRole() {
        return role;
    }
}
