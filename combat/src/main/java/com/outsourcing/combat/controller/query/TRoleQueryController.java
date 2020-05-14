package com.outsourcing.combat.controller.query;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.TroleService;
import com.outsourcing.combat.pojo.MenuRole;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TRoleQuery")
public class TRoleQueryController extends MsgUntil {

    @Autowired
    TroleService troleService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/All")
    JsonResult All() {
        try {
            PageInfo<MenuRole> selectTRoleAll = troleService.getSelect();
            return selectTRoleAll.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectTRoleAll, MSG_Inquire_Success)
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
            PageInfo<MenuRole> selectMenuRole = troleService.getSelectMenuRole(currentPage, pageSize);
            return selectMenuRole.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectMenuRole, MSG_Inquire_Success)
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
            PageInfo<MenuRole> selectDelete = troleService.getSelectDelete(currentPage, pageSize);
            return selectDelete.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectDelete, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ById")
    JsonResult ById(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<MenuRole> selectById = troleService.getSelectById(id);
            return selectById.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectById, MSG_Inquire_Success)
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
            PageInfo<MenuRole> selectDeleteById = troleService.getSelectDeleteById(id);
            return selectDeleteById.getTotal() != 0 ? jsonResult.build(FLAG_FAILED, selectDeleteById, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByRoleName")
    JsonResult ByRoleName(String name, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(name)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<MenuRole> selectTRoleAllByRoleName = troleService.getSelectByRoleName(name, currentPage, pageSize);
            return selectTRoleAllByRoleName.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectTRoleAllByRoleName, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByRoleId")
    JsonResult ByRoleId(Integer roleId, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(roleId)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<MenuRole> selectTRoleByRoleId = troleService.getSelectByRoleId(roleId, currentPage, pageSize);
            return selectTRoleByRoleId.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectTRoleByRoleId, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByDepiction")
    JsonResult ByDepiction(String depiction, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(depiction)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<MenuRole> selectByDepiction = troleService.getSelectByDepiction(depiction, currentPage, pageSize);
            return selectByDepiction.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByDepiction, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
