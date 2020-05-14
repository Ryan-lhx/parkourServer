package com.outsourcing.combat.controller.testController;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.gameSkinService;
import com.outsourcing.combat.pojo.gameSkin;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import com.outsourcing.combat.utils.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/gameSkin")
public class gameSkinController extends MsgUntil {

    @Autowired
    gameSkinService gSkinService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/all")
    public JsonResult getGameSkinAll(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            System.out.println("我已经进入方法。。。getGameSkinAll");
            List<gameSkin> list = gSkinService.getGameSkinAll(currentPage, pageSize);
            PageHelper.startPage(currentPage, pageSize);
            PageInfo<gameSkin> pageInfo = new PageInfo<gameSkin>(list);
            /*Map<String, Object> data = new LinkedHashMap<String, Object>();
            data.put("total_page", pageInfo.getTotal());//总条数
            data.put("total_size", pageInfo.getPages());//总页数
            data.put("current_page", currentPage);//当前页
            data.put("total_list", pageInfo.getList());//数据
            System.out.println(data);*/
            return JsonResult.build(FLAG_SUCCESS, pageInfo);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/bySkinId")
    public JsonResult getGameSkinById(@RequestParam("id") Integer id, @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//        System.out.println("我已经进入方法。。。getGameSkinById");
        try {
//            System.out.println("id="+id);
            gameSkin outcome = gSkinService.getGameSkinById(id, currentPage, pageSize);
            if (outcome == null) {
                return JsonResult.build(FLAG_SUCCESS, MSG_Output_AIR);
            }
            return JsonResult.build(FLAG_FAILED, outcome);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/bySkinNameVague")
    public JsonResult getGameSkinBySkinNameVague(HttpServletRequest request) {

        try {
            String vagueName = ToolUtil.str("vagueName", request);
            String currentPage = ToolUtil.str("currentPage", request);
            String pageSize = ToolUtil.str("pageSize", request);
            if (ToolUtil.equalBool(vagueName) && ToolUtil.equalBool(currentPage) && ToolUtil.equalBool(pageSize)) {
                PageHelper.startPage(parseInt(currentPage), parseInt(pageSize));
                List<gameSkin> outcomeList = gSkinService.getGameSkinBySkinNameVague(vagueName);
                if (outcomeList == null || outcomeList.size() == 0) {
                    return JsonResult.build(FLAG_SUCCESS, MSG_Output_AIR);
                }
                PageInfo<gameSkin> pageInfo = new PageInfo<gameSkin>(outcomeList);
                Map<String, Object> data = new LinkedHashMap<String, Object>();//装载分页数据
                data.put("total_page", pageInfo.getTotal());//总条数
                data.put("total_size", pageInfo.getPages());//总页数
                data.put("current_page", currentPage);//当前页
                data.put("total_list", pageInfo.getList());//数据
                return JsonResult.build(FLAG_SUCCESS, data);
            }
            return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    // 根据skinName进行模糊查找
    @RequestMapping("/bySkinDescriptionVague")
    public JsonResult getGameSkinBySkinDescriptionVague(HttpServletRequest request) {
        try {
            String description = ToolUtil.str("description", request);
            String currentPage = ToolUtil.str("currentPage", request);
            String pageSize = ToolUtil.str("pageSize", request);
            if (ToolUtil.equalBool(description) && ToolUtil.equalBool(currentPage) && ToolUtil.equalBool(pageSize)) {
                PageHelper.startPage(parseInt(currentPage), parseInt(pageSize));
                List<gameSkin> list = gSkinService.getGameSkinBySkinDescriptionVague(description);
                if (list == null || list.size() == 0) {
                    return JsonResult.build(FLAG_SUCCESS, MSG_Output_AIR);
                }
                PageInfo<gameSkin> pageInfo = new PageInfo<gameSkin>(list);
                Map<String, Object> data = new LinkedHashMap<String, Object>();//装载分页数据
                data.put("total_page", pageInfo.getTotal());//总条数
                data.put("total_size", pageInfo.getPages());//总页数
                data.put("current_page", currentPage);//当前页
                data.put("total_list", pageInfo.getList());//数据
                return JsonResult.build(FLAG_SUCCESS, data);
            }
            return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/byModelId")
    public JsonResult getGameSkinByModelId(HttpServletRequest request) {
        try {
            String modelId = ToolUtil.str("modelId", request);
            if (ToolUtil.equalBool(modelId)) {
                gameSkin outcome = gSkinService.getGameSkinByModelId(parseInt(modelId));
                if (outcome == null) {
                    return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
                }
                return JsonResult.build(FLAG_SUCCESS, outcome, MSG_Inquire_Success);
            }
            return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/insert")
    public JsonResult insertGameSkin(HttpServletRequest request) {//skinId、skinName、skinDescription、modelId
        try {
            String skinId = ToolUtil.str("skinId", request);
            String skinName = ToolUtil.str("skinName", request);
            String skinDescription = ToolUtil.str("skinDescription", request);
            String modelId = ToolUtil.str("modelId", request);
//        System.out.println(skinId+" "+skinName+" "+skinDescription+" "+modelId);
            if (ToolUtil.equalBool(skinId) && ToolUtil.equalBool(skinName) && ToolUtil.equalBool(skinDescription) && ToolUtil.equalBool(modelId)) {
                gameSkin sample = new gameSkin(parseInt(skinId), skinName, skinDescription, modelId);
                Integer outcome = gSkinService.insertGameSkin(sample);
                if (outcome == null || outcome == 0) {
                    return JsonResult.build(FLAG_FAILED, MSG_Failure);
                }
                return JsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
            }
            return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/updateById")
    public JsonResult updateGameSkin(HttpServletRequest request) {
        try {
            String skinId = ToolUtil.str("skinId", request);
            String skinName = ToolUtil.str("skinName", request);
            String skinDescription = ToolUtil.str("skinDescription", request);
            String modelId = ToolUtil.str("modelId", request);
            if (ToolUtil.equalBool(skinId) && ToolUtil.equalBool(skinName) && ToolUtil.equalBool(skinDescription) && ToolUtil.equalBool(modelId)) {
                gameSkin sample = new gameSkin(parseInt(skinId), skinName, skinDescription, modelId);
                Integer outcome = gSkinService.updateGameSkin(sample);
                if (outcome == 0 || outcome == null) {
                    return JsonResult.build(FLAG_FAILED, MSG_Failure);
                }
                return JsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
            }
            return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/deleteById")
    public JsonResult deleteGameSkinById(@RequestParam("id") Integer id, @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (id == null || id == 0) {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            Integer outcome = gSkinService.deleteGameSkinById(id, currentPage, pageSize);
            if (outcome == null || outcome == 0) {
                return JsonResult.build(FLAG_FAILED, "删除失败");
            }
            return JsonResult.build(FLAG_SUCCESS, "删除成功");
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/getCount")
    public JsonResult selectCounts() {
        try {
            Integer counts = gSkinService.selectCounts();
            if (counts == null || counts == 0) {
                return JsonResult.build(FLAG_SUCCESS, "数据为空");
            }
            return JsonResult.build(FLAG_SUCCESS, counts);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
