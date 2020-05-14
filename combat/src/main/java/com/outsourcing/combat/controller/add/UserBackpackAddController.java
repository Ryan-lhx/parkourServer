package com.outsourcing.combat.controller.add;

import com.outsourcing.combat.Service.UserBackpackService;
import com.outsourcing.combat.pojo.user_backpack;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserBackpackAdd")
public class UserBackpackAddController extends MsgUntil {

    @Autowired
    UserBackpackService userBackpackService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/Add")
    JsonResult Add(Integer userId, Integer propsId) {
        try {
            if (Judge(userId) || Judge(propsId)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            user_backpack userBackpack = new user_backpack();
            userBackpack.setPropsId(propsId);
            userBackpack.setUserId(userId);
            userBackpackService.getInsert(userBackpack);
            return jsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
