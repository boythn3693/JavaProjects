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
public class AccountDTO {
    private int accountId;
    private String username;
    private String password;   
    private String firstname;   
    private String lastname;
    private String numphone;  
    private String email;  
    private boolean inactive;   
    private short role;
    
    public AccountDTO(){
        this.accountId = 0;
        this.username = "admin";
        this.password = "123456";
        this.firstname = "Chí Đại";
        this.lastname = "Lê";
        this.numphone = "0968495645";
        this.email = "mr.dailc@gmail.com";
        this.inactive = true;
        this.role = 1;
    }
    
    public AccountDTO(int _id, String _username, String _pass, String _firstname, String _lastname, String _numphone, String _email, boolean _active, short _role){
        this.accountId = _id;
        this.username = _username;
        this.password = _pass;
        this.firstname = _firstname;
        this.lastname = _lastname;
        this.numphone = _numphone;
        this.email = _email;
        this.inactive = _active;
        this.role = _role;
    }
    
    /**
     * @return the accountId
     */
    public int getAccountID()
    {
        return this.accountId;
    }
    
    /**
     * @param _id the accountId to set
     */
    public void setAccountID(int _id)
    {
        this.accountId = _id;
    }
    
    /**
     * @return the username
     */
    public String getUsername()
    {
        return this.username;
    }
    
    /**
     * @param _username the username to set
     */
    public void setUsername(String _username)
    {
        this.username = _username;
    }
    
    /**
     * @return the password
     */
    public String getPassword()
    {
        return this.password;
    }
    
    /**
     * @param _pass the password to set
     */
    public void setPassword(String _pass)
    {
        this.password = _pass;
    }
    
    /**
     * @return the firstname
     */
    public String getFirstname()
    {
        return this.firstname;
    }
    
    /**
     * @param _firstname the firstname to set
     */
    public void setFirstname(String _firstname)
    {
        this.firstname = _firstname;
    }
    
    /**
     * @return the lastname
     */
    public String getLastname()
    {
        return this.lastname;
    }
    
    /**
     * @param _lastname the lastname to set
     */
    public void setLastname(String _lastname)
    {
        this.lastname = _lastname;
    }
    
    /**
     * @return the numphone
     */
    public String getNumphone()
    {
        return this.numphone;
    }
    
    /**
     * @param _numphone the numphone to set
     */
    public void setNumphone(String _numphone)
    {
        this.numphone = _numphone;
    }
    
    /**
     * @return the email
     */
    public String getEmail()
    {
        return this.email;
    }
    
    /**
     * @param _email the email to set
     */
    public void setEmail(String _email)
    {
        this.email = _email;
    }
    
    /**
     * @return the inactive
     */
    public boolean getActive()
    {
        return this.inactive;
    }
    
    /**
     * @param _active the inactive to set
     */
    public void setActive(boolean _active)
    {
        this.inactive = _active;
    }
    
    /**
     * @return the role
     */
    public short getRole()
    {
        return this.role;
    }
    
    /**
     * @param _role the role to set
     */
    public void setRole(short _role)
    {
        this.role = _role;
    }
}
