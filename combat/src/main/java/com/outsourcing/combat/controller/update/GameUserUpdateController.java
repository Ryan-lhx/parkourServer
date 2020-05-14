package com.outsourcing.combat.controller.update;

import com.outsourcing.combat.Service.GameUserService;
import com.outsourcing.combat.pojo.GameUser;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GameUserUpdate")
public class GameUserUpdateController extends MsgUntil {

    @Autowired
    GameUserService gameUserService;

    JsonResult jsonResult = new JsonResult();

    //一个错误密码无法改变
    @RequestMapping("/ById")
    JsonResult ById(Integer id, String userName, String userPassword, Integer userVIP, String userDistance, String userIntegral,
                    String userNickname, Integer signFrequency, Integer strokeId, Integer termType, String termToken) {
        try {
            GameUser gameUser = new GameUser();
            if (Judge(id) || gameUserService.getSelectById(id).getTotal() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            gameUser.setId(id);
            gameUser.setUserName(userName);
            gameUser.setUserIntegral(userIntegral);
            gameUser.setUserPassword(userPassword);
            gameUser.setUserVIP(userVIP);
            gameUser.setUserDistance(userDistance);
            gameUser.setUserNickname(userNickname);
            gameUser.setSignFrequency(signFrequency);
            gameUser.setStrokeId(strokeId);
            gameUser.setTermToken(termToken);
            gameUser.setTermType(termType);
            gameUserService.getUpdateById(gameUser);
            return jsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
