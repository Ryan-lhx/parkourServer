package com.outsourcing.combat.controller.delete;

import com.outsourcing.combat.Service.PlayRuleService;
import com.outsourcing.combat.pojo.PlayRules;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PlayRuleDelete")
public class PlayRuleDeleteController extends MsgUntil {
    @Autowired
    PlayRuleService playRuleService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ById")
    JsonResult ById(Integer id) {
        try {
            if (Judge(id) || playRuleService.getSelectById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            playRuleService.getDeleteById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ClearById")
    JsonResult ClearById(Integer id) {
        try {
            if (Judge(id) || playRuleService.getSelectDeleteById(id) == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            playRuleService.getClearById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    /*@RequestMapping("/Delete")
    @ResponseBody
    JsonResult Delete(String title,String description){
        try {
            PlayRules playRules = new PlayRules();
            if (title != null && title != "" && playRuleService.getSelectByTitle(title).size() != 0){
                playRules.setRuleTitle(title);
            }else if (description != null && description != "" && playRuleService.getSelectByDescription(description).size() != 0){
                playRules.setRuleDescription(description);
            }else {
                return jsonResult.build(FLAG_FAILED,MSG_Enter_Air);
            }
            playRuleService.getDelete(playRules);
            return jsonResult.build(FLAG_SUCCESS,MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED,e.getMessage(),MSG_Abnormal);
        }
    }*/

    @RequestMapping("/Clear")
    JsonResult Clear() {
        try {
            playRuleService.getClear();
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ReplyById")
    JsonResult ReplyById(Integer id) {
        try {
            if (Judge(id) || playRuleService.getSelectDeleteById(id) == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            playRuleService.getReplyById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Restore_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}