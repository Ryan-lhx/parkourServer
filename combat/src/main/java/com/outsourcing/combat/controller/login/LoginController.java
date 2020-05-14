package com.outsourcing.combat.controller.login;

import com.outsourcing.combat.utils.BaseController;
import com.outsourcing.combat.utils.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    JsonResult jsonResult = new JsonResult();

    /*
     * 身份调用流程
     * 1。调用Subject.login(token)*/
    /*获取登录信息*/
    @RequestMapping("/ToLogin")
    @ResponseBody
    JsonResult Login(String name, String password, String captcha, boolean rememberMe) {
//        String sessionCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute(CaptchaController.KEY_CAPTCHA);
//        if (captcha == null || !captcha.equalsIgnoreCase(sessionCaptcha)){
//            return jsonResult.build(FLAG_FAILED,"验证码错误");
//        }
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password, rememberMe);
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //执行登录方法
        try {
            subject.login(token);
            return jsonResult.build(FLAG_SUCCESS, "登陆成功");
        } catch (UnknownAccountException e) {
            return jsonResult.build(FLAG_FAILED, "用户名错误");
        } catch (IncorrectCredentialsException e) {
            return jsonResult.build(FLAG_FAILED, "密码错误");
        }
    }
}
