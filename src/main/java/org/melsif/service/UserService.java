package org.melsif.service;

import org.melsif.dao.UserDao;
import org.melsif.model.User;

import java.util.List;

public class UserService {
    public List<User> getAllUsers() {
        return UserDao.getInstance().findAll();
    }
}