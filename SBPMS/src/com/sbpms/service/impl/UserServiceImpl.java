package com.sbpms.service.impl;

import com.sbpms.bean.User;
import com.sbpms.dao.UserDao;
import com.sbpms.service.UserService;

/**
 *The implement of user service. Accomplish most business logic here
 * 
 * @author IanLi
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private User newUserForService;

    public UserDao getUserDao() {

        return userDao;
    }

    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }

    public User getNewUserForService() {

        return newUserForService;
    }

    public void setNewUserForService(User newUserForService) {

        this.newUserForService = newUserForService;
    }

    /*
     * Get message of user who login
     */
    @Override
    public User login(User user) {

        return userDao.selectUser(user);

    }
    
    /*
     * Update a user
     * 
     * @see
     * com.augmentum.ihds.service.UserService#updateUser(com.augmentum.ihds.
     * bean.User)
     */
    @Override
    public boolean updateUser(User user) {

        try {
            return userDao.updateUser(user);
        } catch (Exception e) {
            // TODO Add log here
            return false;
        }
    }

}
