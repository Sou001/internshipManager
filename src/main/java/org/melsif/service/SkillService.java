/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.service;

import java.util.List;
import org.melsif.dao.SkillDao;
import org.melsif.model.Skill;

/**
 *
 * @author air
 */
public class SkillService {
    public List<Skill> getAllSkills() {
        return SkillDao.getInstance().findAll();
    }
}
