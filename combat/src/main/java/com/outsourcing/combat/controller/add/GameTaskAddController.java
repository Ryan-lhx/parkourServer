package com.outsourcing.combat.controller.add;

import com.outsourcing.combat.Service.GameTaskService;
import com.outsourcing.combat.pojo.GameTask;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/GameTaskAdd")
public class GameTaskAddController extends MsgUntil {

    @Autowired
    GameTaskService gameTaskService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/Add")
    @ResponseBody
    JsonResult Add(String title, String description, String type, String reward, String time) {
        try {
            //当其中一个为空则结束
            if (Judge(title) || Judge(description) || Judge(type) || Judge(reward) || Judge(time)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            GameTask gameTask = new GameTask();
            gameTask.setTaskTitle(title);
            gameTask.setTaskDescription(description);
            gameTask.setTaskType(type);
            gameTask.setTaskReward(reward);
            gameTask.setTaskTime(time);
            gameTaskService.getInsert(gameTask);
            return jsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
