package com.outsourcing.combat.controller.testController;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.scheduleService;
import com.outsourcing.combat.pojo.schedule;
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
@RequestMapping("/schedule")
public class scheduleController extends MsgUntil {
    @Autowired
    com.outsourcing.combat.Service.scheduleService scheduleService;

    @RequestMapping("/queryAll")
    JsonResult selectAll(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            PageHelper.startPage(currentPage, pageSize);
            List<schedule> outcome = scheduleService.selectAll(currentPage, pageSize);
            if (outcome == null || outcome.size() == 0) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            PageInfo<schedule> pageInfo = new PageInfo<schedule>(outcome);
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

    @RequestMapping("/queryById")
    JsonResult selectById(@RequestParam("id") Integer id,
                          @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (id == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            schedule outcome = scheduleService.selectById(id, currentPage, pageSize);
            if (outcome == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            return JsonResult.build(FLAG_SUCCESS, outcome, MSG_Inquire_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/queryByCarId")
    JsonResult selectByCarId(@RequestParam("carId") Integer carId) {
        try {
            if (carId == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            List<schedule> outcome = scheduleService.selectByCardId(carId);
            if (outcome == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            return JsonResult.build(FLAG_SUCCESS, outcome, MSG_Inquire_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/queryByUserId")
    JsonResult selectByUserId(@RequestParam("userId") Integer userId) {
        try {
            if (userId == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            List<schedule> outcome = scheduleService.selectByUserId(userId);
            if (outcome == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            return JsonResult.build(FLAG_SUCCESS, outcome, MSG_Inquire_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/updateSchedule")
    JsonResult updateSchedule(HttpServletRequest request) {
        try {
            String id = ToolUtil.str("id", request);
            String strokeIncomingSite = ToolUtil.str("strokeIncomingSite", request);
            String strokeBoardingTime = ToolUtil.str("strokeBoardingTime", request);
            String strokeOutSite = ToolUtil.str("strokeOutSite", request);
            String carId = ToolUtil.str("carId", request);
            String userId = ToolUtil.str("userId", request);
            if (ToolUtil.equalBool(id) && ToolUtil.equalBool(strokeBoardingTime) && ToolUtil.equalBool(strokeIncomingSite)
                    && ToolUtil.equalBool(strokeOutSite) && ToolUtil.equalBool(carId) && ToolUtil.equalBool(userId)) {
                schedule sample = new schedule(Integer.parseInt(id), strokeIncomingSite, strokeBoardingTime, strokeOutSite, Integer.parseInt(carId), Integer.parseInt(userId));
                Integer result = scheduleService.updateSchedule(sample);
                if (result == null || result == 0) {
                    return JsonResult.build(FLAG_FAILED, MSG_Failure);
                }
                return JsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
            } else {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/insertSchedule")
    JsonResult insertSchedule(HttpServletRequest request) {
        try {
            String id = ToolUtil.str("id", request);
            String strokeIncomingSite = ToolUtil.str("strokeIncomingSite", request);
            String strokeBoardingTime = ToolUtil.str("strokeBoardingTime", request);
            String strokeOutSite = ToolUtil.str("strokeOutSite", request);
            String carId = ToolUtil.str("carId", request);
            String userId = ToolUtil.str("userId", request);
            if (ToolUtil.equalBool(id) && ToolUtil.equalBool(strokeBoardingTime) && ToolUtil.equalBool(strokeIncomingSite)
                    && ToolUtil.equalBool(strokeOutSite) && ToolUtil.equalBool(carId) && ToolUtil.equalBool(userId)) {
                schedule sample = new schedule(Integer.parseInt(id), strokeIncomingSite, strokeBoardingTime, strokeOutSite, Integer.parseInt(carId), Integer.parseInt(userId));
                Integer result = scheduleService.insertSchedule(sample);
                if (result == null || result == 0) {
                    return JsonResult.build(FLAG_FAILED, MSG_Failure);
                }
                return JsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
            } else {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/deleteById")
    JsonResult deleteScheduleById(@RequestParam("id") Integer id, @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (id == null) {
                return JsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            }
            Integer result = scheduleService.deleteScheduleById(id, currentPage, pageSize);
            if (result == null || result == 0) {
                return JsonResult.build(FLAG_FAILED, MSG_Failure);
            }
            return JsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
