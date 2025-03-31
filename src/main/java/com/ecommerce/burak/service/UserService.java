package com.ecommerce.burak.service;

import com.ecommerce.burak.dao.RoleDao;
import com.ecommerce.burak.dao.UserDao;
import com.ecommerce.burak.entity.Role;
import com.ecommerce.burak.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user){
        return userDao.save(user);
    }
    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserFirstName("burak");
        user.setUserLastName("burak");
        user.setUserName("burak123");
        user.setUserPassword("burak@pass");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole((userRoles));
        userDao.save(user);
    }
}
