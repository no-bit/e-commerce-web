package com.ecommerce.burak.service;

import com.ecommerce.burak.dao.RoleDao;
import com.ecommerce.burak.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role){
        return roleDao.save(role);
    }
}
