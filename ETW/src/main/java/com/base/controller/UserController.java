package com.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.base.dao.pojo.User;
import com.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value="/getUserInfo")
    public String getUserInfo(HttpServletRequest request,ModelMap modelMap){
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        System.out.println("用户为=> [ " + currentUser + "]");
        modelMap.addAttribute("currUser", currentUser.getUsername());
        return "/user/info";
    }

}
