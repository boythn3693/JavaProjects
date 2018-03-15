/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.services;

import components.dao.*;
import components.entity.Receipt;

/**
 *
 * @author vankh
 */
public class ReceiptService {
    ReceiptDAO _dao;
    public ReceiptService() 
    {
        _dao = new ReceiptDAO();
    }
    
    public Receipt getNew()
    {
        return _dao.getNew();
    }
}
