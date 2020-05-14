package com.outsourcing.combat.controller.delete;

import com.outsourcing.combat.Service.UserTaskService;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/UserTaskDelete")
@RestController
public class UserTaskDeleteController extends MsgUntil {

    @Autowired
    UserTaskService userTaskService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ByCaryOut")
    JsonResult ByCarryOut(Integer taskId, Integer userId) {
        try {
            if (taskId == null || userId == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            userTaskService.getDeleteByCarryOut(taskId, userId);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
