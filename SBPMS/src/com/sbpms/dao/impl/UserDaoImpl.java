package com.sbpms.dao.impl;

import java.util.EnumSet;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.sbpms.bean.User;
import com.sbpms.dao.UserDao;
import com.sbpms.util.EnumForRole.Role;

/**
 * The implements for User DAO interface
 * 
 * @author IanLi
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    /*
     * Search the user from database and judge whether it is correct.
     * 
     * @see
     * com.augmentum.ian.ihds.dao.UserDao#searchUser(com.augmentum.ian.ihds.
     * bean.User)
     */
    @SuppressWarnings("unchecked")
    @Override
    public User selectUser(User user) {
        String sqlString = "from User user where user.name=?";
        String name = user.getName();
        List<User> userList = this.getHibernateTemplate().find(sqlString,
                name);
        if (userList.size() != 0) {
            // If the database return more than one user by the name, We only
            // get the first one. In fact this is a wrong database.
            User userR = userList.get(0);
            // Judge the name and the password between the input and which get
            // from database.
          if (userR.getName().equals(user.getName())
                    && userR.getPassword().equals(user.getPassword())) {
                return userR;
            }
            return null;
        }
        return null;
    }
    
    /*
     * Update the user. 
     * 
     * @see
     * com.augmentum.ian.ihds.dao.UserDao#updateUser(com.augmentum.ian.ihds.
     * bean.User)
     */
    @Override
    public boolean updateUser(User user) throws Exception {

        EnumSet<Role> rolesSet = EnumSet.allOf(Role.class);
        for (Role s : rolesSet){
            if(user.getRole().equals(s.toString())){ // Judge the role of the user.
                try {
                    this.getHibernateTemplate().update(user);
                    return true;
                } catch (Exception e) {
                    throw new Exception(e);
                }
            }
        }
        throw new Exception("Wrong role of user");
    }
}
