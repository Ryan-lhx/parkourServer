package com.outsourcing.combat.controller.update;

import com.outsourcing.combat.Service.PropsService;
import com.outsourcing.combat.pojo.Props;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PropsUpdate")
public class PropsUpdateController extends MsgUntil {

    @Autowired
    PropsService propsService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ById")
    JsonResult ById(String name, String description, Integer model, String sort, Integer id) {
        try {
            if (Judge(id) || propsService.getSelectById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            Props props = new Props();
            props.setPropsSort(sort);
            props.setModelId(model);
            props.setPropsDescription(description);
            props.setPropsName(name);
            props.setId(id);
            propsService.getUpdateById(props);
            return jsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
