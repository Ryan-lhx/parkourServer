package com.outsourcing.combat.controller.query;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.GameTaskService;
import com.outsourcing.combat.pojo.GameTask;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * currentPage：页数（第几页）默认为10
 * PageSize：每页的数量 默认为10
 * <p>
 * 查询所有没有设置分页功能
 */
@RestController
@RequestMapping("/GameTaskQuery")
public class GameTaskQueryController extends MsgUntil {

    @Autowired
    GameTaskService gameTaskService;

    JsonResult jsonResult = new JsonResult();

    //查询所有
    @RequestMapping("/GameTask")
    JsonResult Select() {
        try {
            PageInfo<GameTask> select = gameTaskService.getSelect();
            return select.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, select, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    //查询未删除
    @RequestMapping("/Select")
    JsonResult SelectGameTask(Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameTask> selectGameTask = gameTaskService.getSelectGameTask(currentPage, pageSize);
            return selectGameTask.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectGameTask, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    //查询回收站
    @RequestMapping("/Delete")
    JsonResult SelectDelete(Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameTask> selectDelete = gameTaskService.getSelectDelete(currentPage, pageSize);
            return selectDelete.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectDelete, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    //根据id查询回收站
    @RequestMapping("/DeleteById")
    JsonResult SelectDeleteById(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<GameTask> selectDeleteById = gameTaskService.getSelectDeleteById(id);
            return selectDeleteById.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectDeleteById, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    //g根据id查询未删除
    @RequestMapping("/SelectById")
    JsonResult ById(Integer id, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<GameTask> selectById = gameTaskService.getSelectById(id);
            return selectById.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectById, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    //根据标题查询
    @RequestMapping("/SelectByTitle")
    JsonResult byTitle(String title, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(title)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameTask> selectByTitle = gameTaskService.getSelectByTitle(title, currentPage, pageSize);
            return selectByTitle.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByTitle, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    //根据内容查询
    @RequestMapping("/SelectByDescription")
    JsonResult ByDescription(String description, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(description)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameTask> selectByDescription = gameTaskService.getSelectByDescription(description, currentPage, pageSize);
            return selectByDescription.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByDescription, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    //根据类型查询
    //只能进行指定查询
    @RequestMapping("/SelectByType")
    JsonResult ByType(String type, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(type)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameTask> selectByType = gameTaskService.getSelectByType(type, currentPage, pageSize);
            return selectByType.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByType, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    //根据奖励查询未删除
    @RequestMapping("/SelectByReward")
    JsonResult ByReward(String reward, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(reward)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameTask> selectByReward = gameTaskService.getSelectByReward(reward, currentPage, pageSize);
            return selectByReward.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByReward, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    //根据时间查询
    @RequestMapping("/SelectByTime")
    JsonResult ByTime(String time, Integer currentPage, Integer pageSize) {
        try {
            if (Judge(time)) {
                return jsonResult.build(FLAG_SUCCESS, MSG_Enter_Air);
            }
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<GameTask> selectByTime = gameTaskService.getSelectByTime(time, currentPage, pageSize);
            System.out.println(selectByTime);
            return selectByTime.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByTime, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
