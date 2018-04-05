/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.services;

import components.entity.Account;
import components.dao.AccountModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class AccountService {
    AccountModel model;
    public AccountService() {
        model = new AccountModel();
    }
    
    public Boolean insert(Object obj){
        return model.insert(obj);
    }
    
    public Boolean update(Object obj){
        return model.update(obj);
    }
    
    public Boolean delete(Object obj){
        return model.delete(obj);
    }
    
    public List<Account> getList(){
        List<Account> rs = model.getListAccount();
        
        return rs;
    }
    
    public boolean checkLogin(String _username, String _password)
    {
        List<Account> rs = model.getAccountByUsernamePassword(_username, _password);
        if( rs != null ) {
            return true;
        }        
        return false;
    }
    
    public ArrayList getLogin(String _username, String _password)
    {
        ArrayList list = new ArrayList();
        List<Account> rs = model.getAccountByUsernamePassword(_username, _password);
        //System.out.print(rs.get(0).getAccountId());
        if( rs != null ) {
            list.add(rs.get(0).getAccountId());
            list.add(rs.get(0).getUsername());
            list.add(rs.get(0).getFirstName());
            list.add(rs.get(0).getLastName());
            list.add(rs.get(0).getRole());  
            list.add(rs.get(0).getNumPhone());
            list.add(rs.get(0).getEmail()); 
        }        
        return list;
    }
    
    public boolean hasUsername(String username){
        return model.hasUsername(username);
    }
    
    public boolean hasUsername2(String newUsername, int id){
        return model.hasUsername2(newUsername, id);
    }
    
    public boolean hasEmail(String email){
        return model.hasEmail(email);
    }
    
    public boolean hasEmail2(String newEmail, int id){
        return model.hasEmail2(newEmail, id);
    }
    
    public boolean hasUsernamePassword(String username, String pass){
        return model.hasUsernamePassword(username, pass);
    }
}
