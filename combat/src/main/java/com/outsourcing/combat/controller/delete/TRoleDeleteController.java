package com.outsourcing.combat.controller.delete;

import com.outsourcing.combat.Service.TroleService;
import com.outsourcing.combat.pojo.MenuRole;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TRoleDelete")
public class TRoleDeleteController extends MsgUntil {

    @Autowired
    TroleService troleService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ById")
    @ResponseBody
    JsonResult ById(Integer id) {
        try {
            if (Judge(id) || troleService.getSelectById(id) == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            troleService.getDeleteById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    /*@RequestMapping("/ByRoleName")
    @ResponseBody
    JsonResult ByRoleName(String role_name){
        try {
            if (role_name == null){
                return jsonResult.build(FLAG_FAILED,MSG_Enter_Air);
            }
            int i = troleService.getDeleteTRoleByRoleName(role_name);
            return i != 0? jsonResult.build(FLAG_SUCCESS,MSG_Delete_Success)
                    :jsonResult.build(FLAG_FAILED,MSG_FAILED_TO_DELETE);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED,e.getMessage(),MSG_Abnormal);
        }
    }
*/

    @RequestMapping("/ClearById")
    JsonResult ClearById(Integer id) {
        try {
            if (Judge(id) || troleService.getSelectDeleteById(id) == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            troleService.getClearById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/Clear")
    JsonResult Clear() {
        try {
            troleService.getClear();
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ReplyById")
    JsonResult ReplyById(Integer id) {
        try {
            if (Judge(id) || troleService.getSelectDeleteById(id) == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            troleService.getReplyById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Restore_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}