package com.outsourcing.combat.controller.testController;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.StoreService;
import com.outsourcing.combat.pojo.store;
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

@RestController
@RequestMapping("/store")
public class storeController extends MsgUntil {

    @Autowired
    StoreService storeService;

    @RequestMapping("/all")
    JsonResult getStoreAll(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            PageHelper.startPage(currentPage, pageSize);
            List<store> outcome = storeService.getStoreAll(currentPage, pageSize);
            if (outcome == null || outcome.size() == 0) {
                return JsonResult.build(FLAG_SUCCESS, "数据为空");
            }
            PageInfo<store> pageInfo = new PageInfo<store>(outcome);
            Map<String, Object> data = new LinkedHashMap<String, Object>();
            data.put("total_page", pageInfo.getTotal());
            data.put("total_size", pageInfo.getPages());
            data.put("current_page", currentPage);
            data.put("total_list", pageInfo.getList());
            return JsonResult.build(FLAG_SUCCESS, data, MSG_Inquire_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/byId")
    JsonResult getStoreById(@RequestParam("id") Integer id, @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (id == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            store outcome = storeService.getStoreById(id, currentPage, pageSize);
            if (outcome == null) {
                return JsonResult.build(FLAG_SUCCESS, MSG_Output_AIR);
            }
            return JsonResult.build(FLAG_SUCCESS, outcome, MSG_Inquire_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/byStoreNameVague")
    JsonResult getStoreByVagueName(@RequestParam("name") String name, @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (name == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageHelper.startPage(currentPage, pageSize);
            List<store> outcomes = storeService.getStoreByVagueName(name);
            if (outcomes == null || outcomes.size() == 0) {
                return JsonResult.build(FLAG_SUCCESS, MSG_Output_AIR);
            }
            PageInfo<store> pageInfo = new PageInfo<store>(outcomes);
            Map<String, Object> data = new LinkedHashMap<String, Object>();
            data.put("total_page", pageInfo.getTotal());
            data.put("total_size", pageInfo.getPages());
            data.put("current_page", currentPage);
            data.put("total_list", pageInfo.getList());
            return JsonResult.build(FLAG_SUCCESS, data, MSG_Inquire_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/byStoreSortVague")
    JsonResult getStoreByStoreSort(@RequestParam("storeSort") String storeSort, @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (storeSort == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageHelper.startPage(currentPage, pageSize);
            List<store> outcomes = storeService.getStoreByStoreSort(storeSort);
            if (outcomes == null || outcomes.size() == 0) {
                return JsonResult.build(FLAG_SUCCESS, MSG_Output_AIR);
            }
            PageInfo<store> pageInfo = new PageInfo<store>(outcomes);
            Map<String, Object> data = new LinkedHashMap<String, Object>();
            data.put("total_page", pageInfo.getTotal());
            data.put("total_size", pageInfo.getPages());
            data.put("current_page", currentPage);
            data.put("total_list", pageInfo.getList());
            return JsonResult.build(FLAG_SUCCESS, outcomes, MSG_Inquire_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/byStoreShelvesTimeVague")
    JsonResult getStoreShelvesTime(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestParam("storeShelvesTime") String storeShelvesTime) {
        try {
            if (storeShelvesTime == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageHelper.startPage(currentPage, pageSize);
            List<store> outcomes = storeService.getStoreShelvesTime(storeShelvesTime);
            if (outcomes == null || outcomes.size() == 0) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            PageInfo<store> pageInfo = new PageInfo<store>(outcomes);
            Map<String, Object> data = new LinkedHashMap<String, Object>();
            data.put("total_page", pageInfo.getTotal());
            data.put("total_size", pageInfo.getPages());
            data.put("current_page", currentPage);
            data.put("total_list", pageInfo.getList());
            return JsonResult.build(FLAG_SUCCESS, outcomes, MSG_Inquire_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/byStoreTakeTimeVague")
    JsonResult getStoreTakeTimeVague(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestParam("storeTakeTimeVague") String storeTakeTimeVague) {
        try {
            if (storeTakeTimeVague == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageHelper.startPage(currentPage, pageSize);
            List<store> outcomes = storeService.getStoreTakeTimeVague(storeTakeTimeVague);
            if (outcomes == null || outcomes.size() == 0) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            PageInfo<store> pageInfo = new PageInfo<store>(outcomes);
            Map<String, Object> data = new LinkedHashMap<String, Object>();
            data.put("total_page", pageInfo.getTotal());
            data.put("total_size", pageInfo.getPages());
            data.put("current_page", currentPage);
            data.put("total_list", pageInfo.getList());
            return JsonResult.build(FLAG_SUCCESS, outcomes, MSG_Inquire_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/byModelId")
    JsonResult getAllByModelId(@RequestParam("modelId") Integer modelId) {
        try {
            if (modelId == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            List<store> outcomes = storeService.getAllByModelId(modelId);
            if (outcomes == null || outcomes.size() == 0) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            return JsonResult.build(FLAG_SUCCESS, outcomes, MSG_Inquire_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/insertByStore")
    JsonResult insertStore(HttpServletRequest request) {
        try {
            String id = ToolUtil.str("id", request);
            String storeName = ToolUtil.str("storeName", request);
            String storeSort = ToolUtil.str("storeSort", request);
            String storeShelvesTime = ToolUtil.str("storeShelvesTime", request);
            String storeTakeTime = ToolUtil.str("storeTakeTime", request);
            String modelId = ToolUtil.str("modelId", request);
            if (ToolUtil.equalBool(id) && ToolUtil.equalBool(storeName) && ToolUtil.equalBool(storeSort) && ToolUtil.equalBool(storeShelvesTime) && ToolUtil.equalBool(storeTakeTime) && ToolUtil.equalBool(modelId)) {
                store sample = new store(Integer.parseInt(id), storeName, storeSort, storeShelvesTime, storeTakeTime, Integer.parseInt(modelId));
                Integer outcome = storeService.insertStore(sample);
                if (outcome != 0) {
                    return JsonResult.build(FLAG_SUCCESS, MSG_Failure);
                }
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/updateByStore")
    JsonResult alterStore(HttpServletRequest request) {
        try {
            String id = ToolUtil.str("id", request);
            String storeName = ToolUtil.str("storeName", request);
            String storeSort = ToolUtil.str("storeSort", request);
            String storeShelvesTime = ToolUtil.str("storeShelvesTime", request);
            String storeTakeTime = ToolUtil.str("storeTakeTime", request);
            String modelId = ToolUtil.str("modelId", request);
            if (ToolUtil.equalBool(id) && ToolUtil.equalBool(storeName) && ToolUtil.equalBool(storeSort) && ToolUtil.equalBool(storeShelvesTime) && ToolUtil.equalBool(storeTakeTime) && ToolUtil.equalBool(modelId)) {
                store sample = new store(Integer.parseInt(id), storeName, storeSort, storeShelvesTime, storeTakeTime, Integer.parseInt(modelId));
                Integer outcome = storeService.alterStore(sample);
                if (outcome != 0) {
                    return JsonResult.build(FLAG_SUCCESS, MSG_Failure);
                }
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/deleteById")
    JsonResult deleteStoreById(@RequestParam("id") Integer id, @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (id == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            Integer outcome = storeService.deleteStoreById(id, currentPage, pageSize);
            if (outcome != 0) {
                return JsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
            }
            return JsonResult.build(FLAG_FAILED, MSG_Failure);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
