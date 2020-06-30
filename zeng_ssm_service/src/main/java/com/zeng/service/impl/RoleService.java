package com.zeng.service.impl;

import com.zeng.dao.IRoleDao;
import com.zeng.domain.Role;
import com.zeng.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService implements IRoleService {
    @Autowired
    IRoleDao roleDao;

    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
