package com.outsourcing.combat.controller.delete;

import com.outsourcing.combat.Service.GameUserService;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GameUserDelete")
public class GameUserDeleteController extends MsgUntil {

    @Autowired
    GameUserService gameUserService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ById")
    JsonResult ById(Integer id) {
        try {
            if (Judge(id) || gameUserService.getSelectById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            gameUserService.getDeleteById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ClearById")
    JsonResult ClearById(Integer id) {
        try {
            if (Judge(id) || gameUserService.getSelectDeleteById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            gameUserService.getClearById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/Clear")
    JsonResult Clear() {
        try {
            gameUserService.getClear();
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ReplyById")
    JsonResult ReplyById(Integer id) {
        try {
            if (Judge(id) || gameUserService.getSelectDeleteById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            gameUserService.getReplyById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Restore_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
