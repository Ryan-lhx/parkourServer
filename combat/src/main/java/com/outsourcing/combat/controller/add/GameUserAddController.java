package com.outsourcing.combat.controller.add;

import com.outsourcing.combat.Service.GameUserService;
import com.outsourcing.combat.pojo.GameUser;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GameUserAdd")
public class GameUserAddController extends MsgUntil {

    @Autowired
    GameUserService gameUserService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/Add")
    JsonResult Add(String userName, String password) {
        try {
            if (Judge(userName) || Judge(password)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            GameUser gameUser = new GameUser();
            gameUser.setUserName(userName);
            gameUser.setUserPassword(password);
            gameUserService.getInsertGameUser(gameUser);
            return jsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
