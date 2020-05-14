package com.outsourcing.combat.controller.query;

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
@RequestMapping("/UserBackpackQuery")
public class UserBackpackQueryController extends MsgUntil {

    @Autowired
    UserBackpackService userBackpackService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ById")
    JsonResult ById(Integer id, Integer gameUserId) {
        try {
            if (Judge(id) || Judge(gameUserId)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<user_backpack> selectById = userBackpackService.getSelectById(id, gameUserId);
            return jsonResult.build(FLAG_SUCCESS, selectById, MSG_Inquire_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/All")
    JsonResult All(Integer gameUserId, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(gameUserId)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<user_backpack> selectAll = userBackpackService.getSelectAll(gameUserId, currentPage, pageSize);
            return jsonResult.build(FLAG_SUCCESS, selectAll, MSG_Inquire_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByName")
    JsonResult ByName(String name, Integer currentPage, Integer pageSize, Integer gameUserId) {
        try {
            if (Judge(name)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<user_backpack> selectByName = userBackpackService.getSelectByName(name, currentPage, pageSize, gameUserId);
            return jsonResult.build(FLAG_SUCCESS, selectByName, MSG_Inquire_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
