package com.zeng.dao;

import com.zeng.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {
    @Select("select * from Role where id in(select RoleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class, many = @Many(select = "com.zeng.dao.IPermissionDao.findByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId);

    @Select("select * from role")
    List<Role> findAll();
}
