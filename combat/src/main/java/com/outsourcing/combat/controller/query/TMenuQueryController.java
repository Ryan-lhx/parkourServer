package com.outsourcing.combat.controller.query;

import com.outsourcing.combat.Service.TMenuService;
import com.outsourcing.combat.pojo.TMenu;
import com.outsourcing.combat.utils.BaseController;
import com.outsourcing.combat.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@Controller
@RequestMapping("/TMenuQuery")
public class TMenuQueryController extends BaseController {

    @Autowired
    TMenuService tMenuService;

    JsonResult jsonResult = new JsonResult();

    /*
     * pageNumber当前页数 默认1
     * pageSize每页数量*/
    @RequestMapping("/All")
    @ResponseBody
    JsonResult All() {
        List<TMenu> All = tMenuService.getSelectAll();
        if (All == null) {
            return jsonResult.build(FLAG_FAILED, "没有数据");
        }
        return jsonResult.build(FLAG_SUCCESS, All);
    }

    @RequestMapping("/ById")
    @ResponseBody
    JsonResult ById(Integer id) {
        TMenu selectTMenuById = tMenuService.getSelectTMenuById(id);
        if (selectTMenuById == null) {
            return jsonResult.build(FLAG_FAILED, "数据为空");
        }
        return jsonResult.build(FLAG_SUCCESS, selectTMenuById);
    }

    @RequestMapping("/ByMenuName")
    @ResponseBody
    JsonResult ByMenuName(String menu_name) {
        List<TMenu> selectTMenuByMenuName = tMenuService.getSelectTMenuByMenuName(menu_name);
        if (selectTMenuByMenuName == null) {
            return jsonResult.build(FLAG_FAILED, "数据为空");
        }
        return jsonResult.build(FLAG_SUCCESS, selectTMenuByMenuName);
    }
}
