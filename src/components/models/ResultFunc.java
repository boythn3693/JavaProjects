/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.models;

/**
 *
 * @author vankh
 */
public class ResultFunc {

    private boolean Result;

    private String Message;

    /**
     * Get the value of Message
     *
     * @return the value of Message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * Set the value of Message
     *
     * @param Message new value of Message
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }

    /**
     * Get the value of Result
     *
     * @return the value of Result
     */
    public boolean isResult() {
        return Result;
    }

    /**
     * Set the value of Result
     *
     * @param Result new value of Result
     */
    public void setResult(boolean Result) {
        this.Result = Result;
    }

}
