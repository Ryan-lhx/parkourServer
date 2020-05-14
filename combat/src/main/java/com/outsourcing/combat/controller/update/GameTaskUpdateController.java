package com.outsourcing.combat.controller.update;

import com.outsourcing.combat.Service.GameTaskService;
import com.outsourcing.combat.pojo.GameTask;
import com.outsourcing.combat.pojo.PlayRules;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GameTaskUpdate")
public class GameTaskUpdateController extends MsgUntil {

    @Autowired
    GameTaskService gameTaskService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ById")
    JsonResult ById(String title, String description, String type, String reward, String time, Integer id) {
        try {
            GameTask gameTask = new GameTask();
            if (Judge(id) || gameTaskService.getSelectById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            gameTask.setId(id);
            gameTask.setTaskTitle(title);
            gameTask.setTaskDescription(description);
            gameTask.setTaskType(type);
            gameTask.setTaskReward(reward);
            gameTask.setTaskTime(time);
            gameTaskService.getUpdateById(gameTask);
            return jsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
