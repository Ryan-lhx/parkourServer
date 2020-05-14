package com.outsourcing.combat.controller.delete;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.UserBackpackService;
import com.outsourcing.combat.pojo.user_backpack;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/UserBackpackDelete")
public class UserBackpackDeleteController extends MsgUntil {

    @Autowired
    UserBackpackService userBackpackService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ById")
    JsonResult ById(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            userBackpackService.getDeleteById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
