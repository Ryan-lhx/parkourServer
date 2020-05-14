package com.outsourcing.combat.controller.add;

import com.outsourcing.combat.Service.TUserService;
import com.outsourcing.combat.pojo.TUser;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/TUserAdd")
public class TUserAddController extends MsgUntil {

    @Autowired
    TUserService tUserService;

    JsonResult jsonResult = new JsonResult();

    /*
     * 目前添加密码一般是123456*/
    @RequestMapping("/Add")
    @ResponseBody
    JsonResult TUserAdd(String name, String password) {
        try {
            if (Judge(name) || Judge(password)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            TUser tUser = new TUser();
            tUser.setName(name);
            tUser.setPassword(password);
            tUser.setSalt(name);
            tUserService.getInsert(tUser);
            return jsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

}
