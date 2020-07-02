package com.zeng.controller;

import com.zeng.domain.Permission;
import com.zeng.domain.Role;
import com.zeng.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllAuthority(@RequestParam(name = "id",required = true)String roleId){
        ModelAndView mv = new ModelAndView();
        Role roleInfo = roleService.findById(roleId);
        List<Permission> permissions = roleService.findOtherPermission(roleId);
        mv.addObject("role",roleInfo);
        mv.addObject("PermissionList",permissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name="roleId",required = true) String roleId,@RequestParam(name = "ids",required = true) String[] permissions) throws Exception {
        roleService.addPermissionToRole(roleId,permissions);
        return "redirect:findAll.do";
    }

    
}
