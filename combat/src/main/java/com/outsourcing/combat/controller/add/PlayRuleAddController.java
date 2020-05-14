package com.outsourcing.combat.controller.add;

import com.outsourcing.combat.Service.PlayRuleService;
import com.outsourcing.combat.pojo.PlayRules;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/PlayRuleAdd")
public class PlayRuleAddController extends MsgUntil {

    @Autowired
    PlayRuleService gameRuleService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/Add")
    @ResponseBody
    JsonResult Add(String title, String description) {
        try {
            if (Judge(title) || Judge(description)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PlayRules menuRule = new PlayRules();
            menuRule.setRuleTitle(title);
            menuRule.setRuleDescription(description);
            gameRuleService.getInset(menuRule);
            return jsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
