package com.zeng.controller;

import com.zeng.domain.UserInfo;
import com.zeng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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


























    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
//        UserInfo userList = userService.findAll();
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
