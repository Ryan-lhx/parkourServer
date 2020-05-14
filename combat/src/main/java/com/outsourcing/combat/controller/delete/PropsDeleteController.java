package com.outsourcing.combat.controller.delete;

import com.outsourcing.combat.Service.PropsService;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propsDelete")
public class PropsDeleteController extends MsgUntil {

    @Autowired
    PropsService propsService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ById")
    JsonResult ById(Integer id) {
        try {
            if (Judge(id) || propsService.getSelectById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            propsService.getDeleteById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ClearById")
    JsonResult ClearById(Integer id) {
        try {
            if (Judge(id) || propsService.getSelectDeleteById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            propsService.getClearById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_SUCCESS, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/Clear")
    JsonResult Clear() {
        try {
            propsService.getClear();
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ReplyById")
    JsonResult ReplyById(Integer id) {
        try {
            if (Judge(id) || propsService.getSelectDeleteById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            propsService.getReplyById(id);
            return jsonResult.build(FLAG_SUCCESS, MSG_Restore_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
