/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.service;

import java.util.List;
import org.melsif.dao.ResponseDao;
import org.melsif.model.Response;

/**
 *
 * @author air
 */
public class ResponseService {
    public List<Response> getAllResponses() {
        return ResponseDao.getInstance().findAll();
    }
    
    public void mergeResponse(Response response) {
        ResponseDao.getInstance().merge(response);
    }
    
    public void newResponse(Response response) {
        ResponseDao.getInstance().persist(response);
    }
    
    public Response getResponse(String content){
        return ResponseDao.getInstance().getByContent(content);
    }
}
