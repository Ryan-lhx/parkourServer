package com.outsourcing.combat.controller.update;

import com.outsourcing.combat.Service.PlayRuleService;
import com.outsourcing.combat.pojo.PlayRules;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/PlayRuleUpdate")
public class PlayRuleUpdateController extends MsgUntil {

    @Autowired
    PlayRuleService playRuleService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ById")
    @ResponseBody
    JsonResult ById(String title, String description, Integer id) {
        try {
            PlayRules playRules = new PlayRules();
            if (Judge(id) || playRuleService.getSelectById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            playRules.setId(id);
            playRules.setRuleTitle(title);
            playRules.setRuleDescription(description);
            playRuleService.getUpdateById(playRules);
            return jsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
