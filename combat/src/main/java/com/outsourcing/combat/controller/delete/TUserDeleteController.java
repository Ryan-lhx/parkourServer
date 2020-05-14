package com.outsourcing.combat.controller.delete;

import com.outsourcing.combat.Service.TUserService;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TUserDelete")
public class TUserDeleteController extends MsgUntil {
    @Autowired
    TUserService tUserService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ById")
    JsonResult DeleteTUserById(Integer id) {
        try {
            if (Judge(id) || tUserService.getSelectById(id) == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            tUserService.getDeleteById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    /*@RequestMapping("/ByName")
    @ResponseBody
    JsonResult DeleteTUserByName(String name){
        try {
            if(Judge(name) || tUserService.getSelectByName(name) == null){
                return jsonResult.build(FLAG_FAILED,MSG_Enter_Air);
            }
            tUserService.getDeleteTUserByName(name);
            return tUserService.getSelectTUserAllByName(name).size()!= 0? jsonResult.build(FLAG_SUCCESS,MSG_Delete_Success)
                    :jsonResult.build(FLAG_FAILED,MSG_Output_is_empty);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED,e.getMessage(),MSG_Abnormal);
        }
    }

    @RequestMapping("/ByNameSpecify")
    @ResponseBody
    JsonResult DeleteTUserByNameSpecify(String name){
        try {
            if(name == null){
                return jsonResult.build(FLAG_FAILED,MSG_Enter_Air);
            }
            tUserService.getDeleteTUserByNameSpecify(name);
            return  tUserService.getSelectTUserAllByName(name).size()!= 0? jsonResult.build(FLAG_SUCCESS,MSG_Delete_Success)
                    :jsonResult.build(FLAG_FAILED,MSG_Output_is_empty);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED,e.getMessage(),MSG_Abnormal);
        }
    }

    @RequestMapping("/ByUserId")
    @ResponseBody
    JsonResult DeleteTUserByUserID(Integer userId){
        try {
            if(Judge(userId)){
                return jsonResult.build(FLAG_FAILED,MSG_Enter_Air);
            }
            tUserService.getDeleteTUserByUserId(user_id);
            return  tUserService.getSelectTUserAllByUserId(user_id).size()!= 0? jsonResult.build(FLAG_SUCCESS,MSG_Delete_Success)
                    :jsonResult.build(FLAG_FAILED,MSG_Output_is_empty);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED,e.getMessage(),MSG_Abnormal);
        }
    }*/

    @RequestMapping("/ClearById")
    JsonResult ClearById(Integer id) {
        try {
            if (Judge(id) || tUserService.getSelectById(id) == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            tUserService.getClearById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/Clear")
    JsonResult Clear() {
        try {
            tUserService.getClear();
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ReplyById")
    JsonResult ReplyById(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            tUserService.getReplyById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Restore_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}