package com.zeng.controller;

import com.zeng.domain.Role;
import com.zeng.domain.UserInfo;
import com.zeng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        UserInfo users = userService.findById(id);
        ModelAndView mv =new ModelAndView();
        mv.addObject("user",users);
        mv.setViewName("user-show1");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String userid)throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(userid);
        List<Role> otherRoles = userService.findOtherRoles(userid);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId, @RequestParam(name = "ids",required = true)String[] roleIds)throws Exception{
        userService.addRoleToUser(userId,roleIds);
        System.out.println(userId);
        for (String roleId : roleIds) {
            System.out.println(roleId);
        }
        return "redirect:findAll.do";
    }


    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/addUser.do")
    public String addUser(UserInfo userInfo) throws Exception{
        userService.addUser(userInfo);
        return "redirect:findAll.do";
    }
}
