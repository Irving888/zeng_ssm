package com.zeng.dao;

import com.zeng.domain.Role;
import com.zeng.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class, many = @Many(select = "com.zeng.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void addUser(UserInfo userInfo);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class, many = @Many(select = "com.zeng.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);

    @Select("select * from Role where id not in(select roleid from users_role where userid = #{id})")
    List<Role> findOtherRoles(String id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId")String userId, @Param("roleId")String roleId);
}
