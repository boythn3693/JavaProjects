/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.application;

import components.interfaces.*;

/**
 *
 * @author MitsuyoRai
 */
public class apps {
    public static frmMain frmMain = new frmMain();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frmLogin frmLogin = new frmLogin();
        //frmLogin.show();
        frmLogin.setVisible(true);
    }
}
