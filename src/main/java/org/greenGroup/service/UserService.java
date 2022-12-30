package org.greenGroup.service;

import org.greenGroup.dao.UserDao;
import org.greenGroup.entity.User;
import org.greenGroup.exception.UserNotFoundException;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    public int deleteUserById(long id) {
        return userDao.deleteUserById(id);
    }

    public int updateUserById(User user, long id) {
        return userDao.updateUserById(user, id);
    }

    public User getUserById(long id) {
        return userDao.getUserById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
