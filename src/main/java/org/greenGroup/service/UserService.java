package org.greenGroup.service;

import org.greenGroup.dao.UserDao;
import org.greenGroup.entity.User;
import org.greenGroup.exception.UserNotFoundException;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    public int deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

    public int updateUserById(User user, Long id) {
        return userDao.updateUserById(user, id);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
