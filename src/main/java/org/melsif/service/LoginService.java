package org.melsif.service;

import org.melsif.dao.UserDao;
import org.melsif.model.User;

public class LoginService {

    public boolean authenticateUser(String email, String password) {
        User user = getUserByEmail(email);
        return user != null && user.getEmail().equals(email) && user.getPassword().equals(password);
    }

    public User getUserByEmail(String email) {
        return UserDao.getInstance().getByEmail(email);
    }

}
