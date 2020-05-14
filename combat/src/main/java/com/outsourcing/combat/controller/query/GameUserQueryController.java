package com.outsourcing.combat.controller.query;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.GameUserService;
import com.outsourcing.combat.pojo.GameUser;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/GameUserQuery")
public class GameUserQueryController extends MsgUntil {

    @Autowired
    GameUserService gameUserService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/GameUser")
    JsonResult Select() {
        try {
            PageInfo<GameUser> select = gameUserService.getSelect();
            return select.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, select, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/Select")
    JsonResult GameUser(Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameUser> selectGameUser = gameUserService.getSelectGameUser(currentPage, pageSize);
            return selectGameUser.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectGameUser, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/Delete")
    JsonResult Delete(Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameUser> selectDelete = gameUserService.getSelectDelete(currentPage, pageSize);
            return selectDelete.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectDelete, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/DeleteById")
    JsonResult DeleteById(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<GameUser> selectDeleteById = gameUserService.getSelectDeleteById(id);
            return selectDeleteById.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectDeleteById, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/SelectById")
    JsonResult ById(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_SUCCESS, MSG_Enter_Air);
            }
            PageInfo<GameUser> selectById = gameUserService.getSelectById(id);
            return selectById.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectById, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByUserName")
    JsonResult ByUserName(String userName, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(userName)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameUser> selectByUserName = gameUserService.getSelectByUserName(userName, currentPage, pageSize);
            return selectByUserName.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByUserName, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByUserIntegral")
    JsonResult ByUserIntegral(Integer integral, Integer integral1, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(integral) || Judge(integral1)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameUser> selectByUserIntegral = gameUserService.getSelectByUserIntegral(integral, integral1, currentPage, pageSize);
            return selectByUserIntegral.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByUserIntegral, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByVIP")
    JsonResult ByVIP(Integer VIP, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(VIP)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameUser> selectByUserVIP = gameUserService.getSelectByUserVIP(VIP, currentPage, pageSize);
            return selectByUserVIP.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByUserVIP, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByUserDistance")
    JsonResult ByUserDistance(Integer distance, Integer distance1, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(distance) || Judge(distance1)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameUser> selectByUserDistance = gameUserService.getSelectByUserDistance(distance, distance1, currentPage, pageSize);
            return selectByUserDistance.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByUserDistance, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("ByUserNickname")
    JsonResult ByUserNickename(String nickname, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(nickname)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameUser> selectByUserNickname = gameUserService.getSelectByUserNickname(nickname, currentPage, pageSize);
            return selectByUserNickname.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByUserNickname, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
