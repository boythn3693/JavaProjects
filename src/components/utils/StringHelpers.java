/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MitsuyoRai
 */
public class StringHelpers {
    public static boolean isInteger( String input ){
        try {
           Integer.parseInt( input );
           return true;
        } catch( Exception e) {
           return false;
        }
    }
    public static boolean checkContainsLettersNumbers(String str) {
        boolean rs = false;
        Pattern p = Pattern.compile("[a-zA-Z][0-9]");
        Matcher m = p.matcher(str);
        if (!(str == str.toLowerCase())) {
            rs = m.find();
        }
        return rs;
    }

    public static boolean checkEmail(String email) {
        boolean kq = false;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern v = Pattern.compile(EMAIL_PATTERN);
        Matcher m = v.matcher(email);
        kq = m.matches();
        return kq;
    }

    public static void Message(String content, String subject, int icon) {
        JOptionPane.showMessageDialog(new JFrame(), content, subject, icon);
    }
}
