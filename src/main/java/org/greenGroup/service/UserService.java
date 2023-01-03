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

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void deleteUserById(Long id) {
        if (userDao.deleteUserById(id) == 0) {
            throw new UserNotFoundException(id);
        }
    }

    public void updateUserById(User user, Long id) {
        if (userDao.updateUserById(user, id) == 0) {
            throw new UserNotFoundException(id);
        }
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
