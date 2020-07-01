package com.zeng.service.impl;

import com.zeng.dao.IPermissionDao;
import com.zeng.domain.Permission;
import com.zeng.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    IPermissionDao permissionDao;

    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    public void save(Permission permission) throws Exception{
        permissionDao.save(permission);
    }
}
