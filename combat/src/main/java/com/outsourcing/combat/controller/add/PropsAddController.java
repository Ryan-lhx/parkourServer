package com.outsourcing.combat.controller.add;

import com.outsourcing.combat.Service.PropsService;
import com.outsourcing.combat.pojo.Props;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PropsAdd")
public class PropsAddController extends MsgUntil {

    @Autowired
    PropsService propsService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/Add")
    JsonResult Add(String name, String description, Integer model, String sort) {
        try {
            if (Judge(name) && Judge(description) && Judge(model) && Judge(sort)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            Props props = new Props();
            props.setPropsName(name);
            props.setPropsDescription(description);
            props.setModelId(model);
            props.setPropsSort(sort);
            propsService.getInsert(props);
            return jsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
