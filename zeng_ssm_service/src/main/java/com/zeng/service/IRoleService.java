package com.zeng.service;

import com.zeng.domain.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll();

    void save(Role role) throws Exception;
}
