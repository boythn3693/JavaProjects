/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.applications;

import components.interfaces.*;

/**
 *
 * @author MitsuyoRai
 */
public class application {
    public static frmMain frmMain;
    public static int accountId = 0;
    public static int role = 0;
    public static String user;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frmLogin frmLogin = new frmLogin();
        //frmLogin.show();
        frmLogin.setVisible(true);
        //frmMain.setVisible(true);
        
        //e10adc3949ba59abbe56e057f20f883e
    }
}
