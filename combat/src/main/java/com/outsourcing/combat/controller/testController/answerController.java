package com.outsourcing.combat.controller.testController;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.mapper.answerMapper;
import com.outsourcing.combat.pojo.answer;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import com.outsourcing.combat.utils.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.sql.SQLException;
import java.util.*;

@RestController
@RequestMapping("/answer")
public class answerController extends MsgUntil {

    @Autowired
    answerMapper aMapper;

    JsonResult jsonResult;

    @RequestMapping("/queryAll")
    public JsonResult getAll(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            PageHelper.startPage(currentPage, pageSize);
            List<answer> all = aMapper.getAll(currentPage, pageSize);
            PageInfo<answer> pageInfo = new PageInfo<answer>(all);
            return JsonResult.build(FLAG_SUCCESS, pageInfo);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/queryById")
    public JsonResult getAnswerSelectById(@RequestParam("id") Integer id, @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageHelper.startPage(currentPage, pageSize);
            List<answer> answerSelectById = aMapper.getAnswerSelectById(id, currentPage, pageSize);
            PageInfo pageInfo = new PageInfo();
            return pageInfo.getTotal() != 0 ? jsonResult.build(FLAG_SUCCESS, pageInfo, MSG_Inquire_Success)
                    : jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }

    }

    @RequestMapping("/updateErrorAnswerByIdAndString")
    public JsonResult updateErrorAnswerByIdAndString(Integer id, String errorContent,
                                                     @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (Judge(id) || Judge(errorContent)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            PageHelper.startPage(currentPage, pageSize);
            Integer integer = aMapper.updateErrorAnswerByIdAndString(id, errorContent, currentPage, pageSize);
            if (integer == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Failure);
            }
            return jsonResult.build(FLAG_SUCCESS, MSG_Modify_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/insertErrorAnswerByIdAndString")
    public JsonResult insertErrorAnswerByIdAndString(Integer id, String ErrorContent, String CorrectContent) {
        try {
            if (Judge(id) || Judge(ErrorContent) || Judge(CorrectContent)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            Integer integer = aMapper.insertErrorAnswerByIdAndString(id, ErrorContent, CorrectContent);
            if (integer == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Failure);
            }
            return jsonResult.build(FLAG_SUCCESS, MSG_Increase_Success);
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

    @RequestMapping("/deleteErrorAnswerById")
    public JsonResult deleteErrorAnswerById(Integer id,
                                            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            Integer integer = aMapper.deleteErrorAnswerById(id, currentPage, pageSize);
            if (integer == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Failure);
            }
            return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/getAnswerCountById")
    public JsonResult getAnswerCountById(Integer id) {
        try {
            if (Judge(id)) {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
            Integer answerCountById = aMapper.getAnswerCountById(id);
            if (answerCountById == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Failure);
            }
            return jsonResult.build(FLAG_FAILED, MSG_Inquire_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }

}
