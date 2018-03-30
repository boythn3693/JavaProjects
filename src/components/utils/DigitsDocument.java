/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.utils;

import javax.swing.text.AttributeSet; 
import javax.swing.text.BadLocationException; 
import javax.swing.text.PlainDocument; 

/**
 *
 * @author MitsuyoRai
 */
public class DigitsDocument extends PlainDocument {
    public void insertString(int offs, String str, AttributeSet a)  throws BadLocationException 
    { 
        boolean dot = false;
        if(str==null) 
        { 
            return; 
        } 
        char[] addedFigures = str.toCharArray(); 
        char c; 
        for(int i=addedFigures.length; i>0; i--) 
        { 
            c=addedFigures[i-1]; 
            if(c=='.') 
            { 
                if(!dot)
                {
                    dot = true;
                    super.insertString(offs, new String(new Character(c).toString()), a); 
                }
            }
            else if(Character.isDigit(c)) 
            { 
                super.insertString(offs, new String(new Character(c).toString()), a); 
            } 
        } 
    } 
}
