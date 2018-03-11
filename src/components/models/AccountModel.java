/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.models;

import components.entity.Account;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class AccountModel {
    public final String QUERY_CHECK_LOGIN = "from Account a where Username='%s' and Password='%s'";
    
    public List<Account> getAccountByUsernamePassword(String _username, String _password)
    {
        return QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_CHECK_LOGIN, _username, _password));
    }
}
