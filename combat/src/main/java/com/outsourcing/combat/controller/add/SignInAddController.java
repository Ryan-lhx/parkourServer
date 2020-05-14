package com.outsourcing.combat.controller.add;

import com.outsourcing.combat.Service.SignInService;
import com.outsourcing.combat.pojo.SignIn;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SignInAdd")
public class SignInAddController extends MsgUntil {

    @Autowired
    SignInService signInService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/Add")
    JsonResult Add(String title, String content, String reward) {
        try {
            if (Judge(title) || Judge(content) || Judge(reward)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            SignIn signIn = new SignIn();
            signIn.setSignTitle(title);
            signIn.setSignContent(content);
            signIn.setSignReward(reward);
            signInService.getInsert(signIn);
            return jsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
