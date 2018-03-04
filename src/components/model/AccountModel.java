/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.model;

import components.dto.AccountDTO;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class AccountModel {
    public String QUERY_CHECK_LOGIN = "from AccountDTO a where Usename='%s' and Password='%s'";
    
    public List<AccountDTO> getAccountByUsernamePassword(String _username, String _password)
    {
        return QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_CHECK_LOGIN, _username, _password));
    }
}
