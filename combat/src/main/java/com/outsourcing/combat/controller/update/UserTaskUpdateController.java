package com.outsourcing.combat.controller.update;

import com.outsourcing.combat.Service.UserTaskService;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserTaskUpdate")
public class UserTaskUpdateController extends MsgUntil {

    @Autowired
    UserTaskService userTaskService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ByTaskId")
    JsonResult ByTasKId(Integer taskId, Integer userId, Integer taskId1) {
        try {
            if (Judge(taskId) || Judge(userId) || Judge(taskId1)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            userTaskService.getUpdateByTaskId(taskId, userId, taskId1);
            return jsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
