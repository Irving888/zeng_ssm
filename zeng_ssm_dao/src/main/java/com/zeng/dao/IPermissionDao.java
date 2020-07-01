package com.zeng.dao;

import com.zeng.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findByRoleId(String id);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission (permissionName,url)values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
