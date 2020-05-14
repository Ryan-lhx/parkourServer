package com.outsourcing.combat.controller.query;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.PropsService;
import com.outsourcing.combat.pojo.Props;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PropsQuery")
public class PropsQueryController extends MsgUntil {

    @Autowired
    PropsService propsService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/Props")
    JsonResult Props() {
        try {
            PageInfo<Props> props = propsService.getProps();
            return props.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, props, MSG_Inquire_Success)
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
            PageInfo<Props> select = propsService.getSelect(currentPage, pageSize);
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
            PageInfo<Props> selectDelete = propsService.getSelectDelete(currentPage, pageSize);
            return selectDelete.getTotal() != 0 ? jsonResult.build(FLAG_FAILED, selectDelete, MSG_Inquire_Success)
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
            PageInfo<Props> selectDeleteById = propsService.getSelectDeleteById(id);
            return selectDeleteById.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectDeleteById, MSG_Inquire_Success)
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
            PageInfo<Props> selectById = propsService.getSelectById(id);
            return selectById.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectById, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByName")
    JsonResult ByName(String name, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(name)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<Props> selectByPropsName = propsService.getSelectByName(name, currentPage, pageSize);
            return selectByPropsName.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByPropsName, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByDescription")
    JsonResult ByDescription(String description, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(description)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<Props> selectByDescription = propsService.getSelectByDescription(description, currentPage, pageSize);
            return selectByDescription.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByDescription, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/BySort")
    JsonResult BySort(String sort, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(sort)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<Props> selectBySort = propsService.getSelectBySort(sort, currentPage, pageSize);
            return selectBySort.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectBySort, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
