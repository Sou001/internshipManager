/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.service;

import java.util.List;
import org.melsif.dao.OrderResponseDao;
import org.melsif.model.OrderResponse;

/**
 *
 * @author air
 */
public class OrderResponseService {
    public List<OrderResponse> getAllOrderResponses() {
        return OrderResponseDao.getInstance().findAll();
    }
    
    public void newOrderResponse(OrderResponse orderResponse) {
        OrderResponseDao.getInstance().persist(orderResponse);
    }
}
