package com.outsourcing.combat.controller.query;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.TUserService;
import com.outsourcing.combat.pojo.user_role;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TUserQuery")
public class TUserQueryController extends MsgUntil {
    @Autowired
    TUserService tUserService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/TUser")
    JsonResult TUserQueryAll() {
        try {
            PageInfo<user_role> TUserAll = tUserService.getTUser();
            return TUserAll.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, TUserAll, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/Select")
    JsonResult Select(Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<user_role> select = tUserService.getSelect(currentPage, pageSize);
            return select.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, select, MSG_Inquire_Success)
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
            PageInfo<user_role> selectDelete = tUserService.getSelectDelete(currentPage, pageSize);
            return selectDelete.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectDelete, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ById")
    JsonResult TUserQueryOne(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<user_role> selectTUserOneById = tUserService.getSelectById(id);
            return selectTUserOneById.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectTUserOneById, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/DeleteById")
    JsonResult DeleteByID(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_SUCCESS, MSG_Enter_Air);
            }
            PageInfo<user_role> selectDeleteById = tUserService.getSelectDeleteById(id);
            return selectDeleteById.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectDeleteById, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByName")
    JsonResult TUserQueryAllByName(String name, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(name)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<user_role> selectByName = tUserService.getSelectByName(name, currentPage, pageSize);
            return selectByName.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByName, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByUserId")
    JsonResult TUserQueryAllByUserId(Integer userId, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(userId)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<user_role> tUserList = tUserService.getSelectByUserId(userId, currentPage, pageSize);
            return tUserList.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, tUserList, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

}
