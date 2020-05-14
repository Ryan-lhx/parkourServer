package com.outsourcing.combat.controller.update;

import com.outsourcing.combat.Service.SignInService;
import com.outsourcing.combat.pojo.SignIn;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SignInUpdate")
public class SignInUpdateController extends MsgUntil {

    @Autowired
    SignInService signInService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/ByFrequency")
    JsonResult ByFrequency(String title, String content, String reward, Integer frequency) {
        try {
            if (Judge(frequency) || signInService.getSelectByFrequency(frequency) == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            SignIn signIn = new SignIn();
            signIn.setSignReward(reward);
            signIn.setSignContent(content);
            signIn.setSignTitle(title);
            signIn.setSignFrequency(frequency);
            signInService.getUpdateByFrequency(signIn);
            return jsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
