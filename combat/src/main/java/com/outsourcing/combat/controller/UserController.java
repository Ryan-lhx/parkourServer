package com.outsourcing.combat.controller;

import com.outsourcing.combat.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController extends BaseController {

    @RequestMapping({"/", "/index"})
    String toIndex(Integer id) {
        return "index";
    }

    @RequestMapping("/user/add")
    String toAdd() {
        return "User/add";
    }

    @RequestMapping("/user/update")
    String toUpdate() {
        return "user/update";
    }

    @RequestMapping("/unauthorized")
    String unauthorized() {
        return "403";
    }

    /*跳转到登录页面*/
    @RequestMapping("/toLogin")
    String toLogin() {
        return "login";
    }


    @RequestMapping("/toAddUser")
    String toAddUser() {
        return "add1";
    }

//    @RequestMapping("/add1")
//    String Add(String name,String password,String salt){
//        userService.getInsertUser(name,password,salt);
//        return "redirect:index";
//    }
}
