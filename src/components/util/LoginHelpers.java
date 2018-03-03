/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.util;

import components.application.apps;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MitsuyoRai
 */
public class LoginHelpers {
    public int role = 0;
    public String name = "", user = "";
    
    public boolean checkLogin(String username, String password, LoginHelpers opt) {
        boolean kq = false;

        String sql = "select * from Account where Usename= '" + username + "' and Password= '" + password + "'";
        //System.out.println(sql);
        ResultSet rs = apps.connection.ExcuteQueryGetTable(sql);

        try {
            if (rs.next()) {
                kq = true;
                opt.role = rs.getInt("Role");
                opt.name = rs.getString("FirstName") + " " + rs.getString("LastName");
                opt.user = rs.getString("Usename");
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đăng nhập");
        }

        return kq;
    }
}
