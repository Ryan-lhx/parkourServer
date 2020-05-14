package com.outsourcing.combat.controller.update;

import com.outsourcing.combat.Service.TroleService;
import com.outsourcing.combat.pojo.TRole;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TRoleUpdate")
public class TRoleUpdateController extends MsgUntil {
    @Autowired
    TroleService troleService;

    JsonResult jsonResult = new JsonResult();


    @RequestMapping("/ById")
    JsonResult AlterById(String name, Integer id, String depiction) {
        try {
            TRole tRole = new TRole();
            if (Judge(id) || troleService.getSelectById(id) == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            tRole.setId(id);
            tRole.setDepiction(depiction);
            tRole.setRoleName(name);
            troleService.getUpdateById(tRole);
            return jsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
