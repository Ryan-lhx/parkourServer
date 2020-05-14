package com.outsourcing.combat.controller.query;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.SignInService;
import com.outsourcing.combat.pojo.SignIn;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SignInQuery")
public class SignInQueryCotroller extends MsgUntil {

    @Autowired
    SignInService signInService;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/Select")
    JsonResult Select(Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            PageInfo<SignIn> select = signInService.getSelect(currentPage, pageSize);
            return select.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, select, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByFrequency")
    JsonResult ByFrequency(Integer frequency) {
        try {
            if (Judge(frequency)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<SignIn> selectByFrequency = signInService.getSelectByFrequency(frequency);
            return selectByFrequency.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByFrequency, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByTitle")
    JsonResult ByTitle(String title, Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            if (Judge(title)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<SignIn> selectByTitle = signInService.getSelectByTitle(title, currentPage, pageSize);
            return selectByTitle.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByTitle, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByContent")
    JsonResult ByContent(String content, Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            if (Judge(content)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<SignIn> selectByContent = signInService.getSelectByContent(content, currentPage, pageSize);
            return selectByContent.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByContent, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/ByReward")
    JsonResult ByReward(String reward, Integer currentPage, Integer pageSize) {
        try {
            currentPage = currentPage == null ? 1 : currentPage;
            pageSize = pageSize == null ? 10 : pageSize;
            if (Judge(reward)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageInfo<SignIn> selectByReward = signInService.getSelectByReward(reward, currentPage, pageSize);
            return selectByReward.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, selectByReward, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
}
