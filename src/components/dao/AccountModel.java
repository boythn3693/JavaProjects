/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.entity.Account;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class AccountModel {
    public Boolean insert(Object obj){
        return QueryDB.GetInstance().save(obj);
    }
    
    public Boolean update(Object obj){
        return QueryDB.GetInstance().update(obj);
    }
    
    public Boolean delete(Object obj){
        return QueryDB.GetInstance().delete(obj);
    }
    public List<Account> getListAccount()
    {
        String QUERY = "from Account";
        return QueryDB.GetInstance().executeHQLQuery(QUERY);
    }
    
    public List<Account> getAccountByUsernamePassword(String _username, String _password)
    {
        String QUERY_CHECK_LOGIN = "from Account where username='%s' and password='%s'";
        List<Account> rs = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_CHECK_LOGIN, _username, _password));
        return rs;
    }
    
    public boolean hasUsername(String username){
        String QUERY_CHECK= "select count(*) from Account where username='"+username+"'";
        Long rs = QueryDB.GetInstance().countTable(QUERY_CHECK);
        if(rs > 0)
            return true;
        else
            return false;
    }
    
    public boolean hasUsername2(String newUsername, int id){
        String QUERY_CHECK= "select count(*) from Account where username='"+newUsername+"' and accountId != "+id;
        Long rs = QueryDB.GetInstance().countTable(QUERY_CHECK);
        if(rs > 0)
            return true;
        else
            return false;
    }
    
    public boolean hasEmail(String email){
        String QUERY_CHECK= "select count(*) from Account where email='"+email+"'";
        Long rs = QueryDB.GetInstance().countTable(QUERY_CHECK);
        if(rs > 0)
            return true;
        else
            return false;
    }
    
    public boolean hasEmail2(String newEmail, int id){
        String QUERY_CHECK= "select count(*) from Account where email='"+newEmail+"' and accountId != "+id;
        Long rs = QueryDB.GetInstance().countTable(QUERY_CHECK);
        if(rs > 0)
            return true;
        else
            return false;
    }
}
