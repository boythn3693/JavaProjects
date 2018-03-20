/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.services;

import components.dao.*;
import components.entity.Product;

/**
 *
 * @author vankh
 */
public class CommonService {

    CommonDAO _dao;

    public CommonService() {
        _dao = new CommonDAO();
    }

    public Product getProductById(long id) {
        return _dao.getProductById(id);
    }
}
