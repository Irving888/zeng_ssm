package com.zeng.service;

import com.zeng.domain.Role;
import com.zeng.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserInfo> findAll() throws Exception;

    void addUser(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId)throws Exception;

    void addRoleToUser(String userId,String[] roleIds);
}
