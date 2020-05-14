package com.outsourcing.combat.controller.query;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.PlayRuleService;
import com.outsourcing.combat.pojo.PlayRules;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PlayRuleQuery")
public class PlayRuleQueryController extends MsgUntil {

    @Autowired
    PlayRuleService gameRuleService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/Select")
    JsonResult Select() {
        try {
            PageInfo<PlayRules> select = gameRuleService.getSelect();
            return select.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, select, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/PlayRule")
    JsonResult SelectPlayRule(Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<PlayRules> selectPlayRules = gameRuleService.getSelectPlayRules(currentPage, pageSize);
            return selectPlayRules.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectPlayRules, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/Delete")
    JsonResult SelectDelete(Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<PlayRules> ruleDelete = gameRuleService.getSelectDelete(currentPage, pageSize);
            return ruleDelete.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, ruleDelete, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/DeleteById")
    JsonResult SelectDeleteById(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<PlayRules> ruleDelete = gameRuleService.getSelectDeleteById(id);
            return ruleDelete.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, ruleDelete, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ById")
    JsonResult ById(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<PlayRules> selectOneById = gameRuleService.getSelectById(id);
            return selectOneById.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectOneById, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByTitle")
    JsonResult ByTitle(String title, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(title)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<PlayRules> selectAllByRuleTitle = gameRuleService.getSelectByTitle(title, currentPage, pageSize);
            return selectAllByRuleTitle.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectAllByRuleTitle, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByDescription")
    JsonResult ByRuleDescription(String description, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(description)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<PlayRules> selectAllByRuleDescription = gameRuleService.getSelectByDescription(description, currentPage, pageSize);
            return selectAllByRuleDescription.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectAllByRuleDescription, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
