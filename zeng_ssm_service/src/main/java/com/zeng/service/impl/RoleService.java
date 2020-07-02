package com.zeng.service.impl;

import com.zeng.dao.IRoleDao;
import com.zeng.domain.Permission;
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

    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    public List<Permission> findOtherPermission(String roleId) {
        return roleDao.findOtherPermission(roleId);
    }

    public void addPermissionToRole(String roleId, String[] permissions) throws Exception {
        for (String permission : permissions) {
            roleDao.addPermissionToRole(roleId,permission);
        }
    }
}
