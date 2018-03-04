/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.dto.AccountDTO;
import components.model.QueryDB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MitsuyoRai
 */
public class AccountDAO {
    private static final String QUERY_CHECK_LOGIN = "from AccountDTO acc where Usename='%s' and Password='%s'";
    
    public boolean checkLogin(String _username, String _password)
    {
        List<AccountDTO> rs = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_CHECK_LOGIN, _username, _password));
        if( rs != null ) {
            return true;
        }        
        return false;
    }
    
    public ArrayList getLogin(String _username, String _password)
    {
        ArrayList list = new ArrayList();
        List<AccountDTO> rs = QueryDB.GetInstance().executeHQLQuery(String.format(QUERY_CHECK_LOGIN, _username, _password));
        if( rs != null ) {
            list.add(rs.get(0).getAccountId());
            list.add(rs.get(0).getUsername());
            list.add(rs.get(0).getFirstname());
            list.add(rs.get(0).getLastname());
            list.add(rs.get(0).getRole());            
        }        
        return list;
    }
}
