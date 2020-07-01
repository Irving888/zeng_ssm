package com.zeng.service;

import com.zeng.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll();

    void save(Permission permission) throws Exception;
}
