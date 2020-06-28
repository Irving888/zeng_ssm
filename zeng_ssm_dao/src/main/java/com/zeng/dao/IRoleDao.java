package com.zeng.dao;

import com.zeng.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {
    @Select("select * from Role where id in(select RoleId from users_role where userId = #{userId})")
    public List<Role> findRoleByUserId(String userId);
}
