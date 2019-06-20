/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.service;

import java.util.List;
import org.melsif.dao.RecordDao;
import org.melsif.model.Record;

/**
 *
 * @author air
 */
public class RecordService {
    public List<Record> getAllRecords() {
        return RecordDao.getInstance().findAll();
    }
}
