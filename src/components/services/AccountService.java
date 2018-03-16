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
        System.out.print(rs.get(0).getFirstName());
        if( rs != null ) {
            list.add(rs.get(0).getAccountId());
            list.add(rs.get(0).getUsername());
            list.add(rs.get(0).getFirstName());
            list.add(rs.get(0).getLastName());
            list.add(rs.get(0).getRole());            
        }        
        return list;
    }
}
