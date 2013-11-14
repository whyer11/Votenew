package com.sbpms.dao;

import com.sbpms.bean.User;

/**
 * Define the interface of User DAO
 * 
 * @author IanLi
 */
public interface UserDao {


    /**
     * Get the information of the user
     * 
     * @param user
     *            the user with information of name and password
     * @return the detail information of the user ligin
     */
    public User selectUser(User user);
    
    /**
     * Update the given user
     * 
     * @param user
     *            the user will be update the database
     * @throws UserDaoException
     *             the exception with message of the name of the method which
     *             throws the exception, and the stack of the exception
     * @return true if success
     */
    public boolean updateUser(User user) throws Exception;
}
