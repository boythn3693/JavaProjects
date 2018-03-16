/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.models;

/**
 *
 * @author MitsuyoRai
 */
public class displayvalueModel {
    private Object displayMember;
    private Object displayvalue;

    public Object getDisplayMember() {
        return displayMember;
    }

    public Object getDisplayvalue() {
        return displayvalue;
    }

    public void setDisplayMember(Object displayMember) {
        this.displayMember = displayMember;
    }

    public void setDisplayvalue(Object displayvalue) {
        this.displayvalue = displayvalue;
    }
    
    public displayvalueModel() {}
    
    public displayvalueModel(Object displayMember, Object displayvalue) {
        this.displayMember = displayMember;
        this.displayvalue = displayvalue;
    }
    @Override
    public String toString(){
        return displayMember.toString();
    }
}
