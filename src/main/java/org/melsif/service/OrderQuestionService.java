/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.service;

import java.util.List;
import org.melsif.dao.OrderQuestionDao;
import org.melsif.model.OrderQuestion;

/**
 *
 * @author air
 */
public class OrderQuestionService {
    public List<OrderQuestion> findAll() {
        return OrderQuestionDao.getInstance().findAll();
    }
}
