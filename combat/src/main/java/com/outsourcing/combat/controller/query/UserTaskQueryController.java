package com.outsourcing.combat.controller.query;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.GameTaskService;
import com.outsourcing.combat.Service.UserTaskService;
import com.outsourcing.combat.pojo.user_task;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/UserTaskQuery")
public class UserTaskQueryController extends MsgUntil {

    @Autowired
    UserTaskService userTaskService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ByUserId")
    JsonResult ByUserId(Integer userId) {
        try {
            if (Judge(userId)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<user_task> selectByUserId = userTaskService.getSelectByUserId(userId);
            return jsonResult.build(FLAG_SUCCESS, selectByUserId, MSG_Inquire_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

}
