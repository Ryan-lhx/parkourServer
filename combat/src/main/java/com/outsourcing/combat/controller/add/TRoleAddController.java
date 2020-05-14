package com.outsourcing.combat.controller.add;

import com.outsourcing.combat.Service.TroleService;
import com.outsourcing.combat.pojo.TRole;
import com.outsourcing.combat.pojo.MenuRole;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/TRoleAdd")
public class TRoleAddController extends MsgUntil {

    @Autowired
    TroleService troleService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/Add")
    @ResponseBody
    JsonResult Add(String name, Integer id, String depiction) {
        try {
            TRole tRole = new TRole();
            if (Judge(name) || Judge(id) || Judge(depiction)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            tRole.setRoleName(name);
            tRole.setRoleId(id);
            tRole.setDepiction(depiction);
            troleService.getInsert(tRole);
            return jsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
