package com.outsourcing.combat.controller.update;

import com.outsourcing.combat.Service.TUserService;
import com.outsourcing.combat.pojo.TUser;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TUserUpdate")
public class TUserUpdateController extends MsgUntil {

    @Autowired
    TUserService tUserService;

    JsonResult jsonResult;

    @RequestMapping("/ById")
    JsonResult AlterById(String name, Integer userId, Integer id, String password) {
        try {
            if (Judge(id) || tUserService.getSelectById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            TUser tUser = new TUser();
            tUser.setName(name);
            tUser.setPassword(password);
            tUser.setSalt(name);
            tUser.setUserId(userId);
            tUser.setId(id);
            tUserService.getUpdateById(tUser);
            return jsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
