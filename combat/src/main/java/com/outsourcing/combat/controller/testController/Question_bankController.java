package com.outsourcing.combat.controller.testController;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.question_bankService;
import com.outsourcing.combat.pojo.question_bank;
import com.outsourcing.combat.utils.JsonResult;
import com.outsourcing.combat.utils.MsgUntil;
import com.outsourcing.combat.utils.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question_bank")
public class Question_bankController extends MsgUntil {

    @Autowired
    question_bankService qbankSerice;

    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/byAll")
    JsonResult getByAll(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            PageHelper.startPage(currentPage, pageSize);
            List<question_bank> All = qbankSerice.getByAll(currentPage, pageSize);
            PageInfo<question_bank> pageInfo = new PageInfo<question_bank>(All);
        /*Map<String,Object> data = new LinkedHashMap<>();
        data.put("total_page",pageInfo.getTotal());
        data.put("total_size",pageInfo.getPages());
        data.put("current_page",currentPage);
        data.put("total_list",pageInfo.getList());*/
            return JsonResult.build(FLAG_SUCCESS, pageInfo, MSG_Inquire_Success);
        } catch (Exception e) {
            return jsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/byIdIs")
    JsonResult selectById(@RequestParam("id") Integer id) {
        try {
            question_bank q = qbankSerice.getSelectById(id);
//        System.out.println(q.toString());
            if (q == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            } else {
                return jsonResult.build(FLAG_SUCCESS, q, MSG_Inquire_Success);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/byTitle")
    JsonResult selectByTitle(@RequestParam("title") String title) {
        try {
            System.out.println(title);
            question_bank questionBank = qbankSerice.getSelectByTitle(title);
        System.out.println(title);
            if (questionBank == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            } else {
                return jsonResult.build(FLAG_SUCCESS, questionBank, MSG_Inquire_Success);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/byVagueTitle")
    JsonResult selectByVagueTitle(@RequestParam("vagueTitle") String vagueTitle, @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        try {
            List<question_bank> list = qbankSerice.getSelectByTitleVague(vagueTitle);
            if (list.size() == 0) {
                return jsonResult.build(FLAG_FAILED, "没有相关的题目,所有题目中均没有该组词语" + vagueTitle);
            } else {
                PageInfo<question_bank> pageInfo = new PageInfo<question_bank>(list);
                /*Map<String,Object> data = new LinkedHashMap<String, Object>();
                data.put("total_page",pageInfo.getTotal());
                data.put("total_size",pageInfo.getPages());
                data.put("current_page",currentPage);
                data.put("total_list",pageInfo.getList());*/
                return jsonResult.build(FLAG_SUCCESS, pageInfo, MSG_Inquire_Success);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/bySort")
    JsonResult selectBySort(@RequestParam("sortData") Integer sortData) {
        try {
            question_bank questionBank = qbankSerice.getSelectBySort(sortData);
            if (questionBank == null) {
                return jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            } else {
                return jsonResult.build(FLAG_SUCCESS, questionBank, MSG_Inquire_Success);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/byDifficult")
    JsonResult selectByQuestion_Difficult(@RequestParam("difficult") String difficult,@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {

            PageHelper.startPage(currentPage, pageSize);

            List<question_bank> list = qbankSerice.getSelectByDifficult(difficult,currentPage, pageSize);
            PageInfo<question_bank> pageInfo = new PageInfo<question_bank>(list);
            if (list.size() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            } else {
                return jsonResult.build(FLAG_SUCCESS, pageInfo, MSG_Inquire_Success);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/allQuestion")
    JsonResult getSelectAllQuestion(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            PageHelper.startPage(currentPage, pageSize);

            List<question_bank> list = qbankSerice.getSelectAllQuestion(currentPage, pageSize);
            PageInfo<question_bank> pageInfo = new PageInfo<question_bank>(list);
            if (list.size() == 0) {
                return jsonResult.build(FLAG_FAILED, MSG_Output_AIR);
            } else {
                return jsonResult.build(FLAG_SUCCESS, pageInfo, MSG_Inquire_Success);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/insertQuestion")
    JsonResult setInsertQuestion(HttpServletRequest request) {
        try {
            String QuestionTitle = ToolUtil.str("QuestionTitle", request);
            String QuestionContent = ToolUtil.str("QuestionContent", request);
            String QuestionSort = ToolUtil.str("QuestionSort", request);
            String QuestionDifficult = ToolUtil.str("QuestionDifficult", request);
            Integer delete1 = ToolUtil.integer("delete1", request);
            if (ToolUtil.equalBool(QuestionTitle) && ToolUtil.equalBool(QuestionContent) && ToolUtil.equalBool(QuestionSort) && ToolUtil.equalBool(QuestionDifficult)) {
                question_bank qb = new question_bank();
                qb.setQuestionTitle(QuestionTitle);
                qb.setQuestionContent(QuestionContent);
                qb.setQuestionSort(QuestionSort);
                qb.setQuestionDifficult(QuestionDifficult);
                qb.setDelete1(delete1);
                Integer n = qbankSerice.setInsertQuestion(qb);
                System.out.println("n=" + n);
                if (ToolUtil.equalBool(n)) {
                    return jsonResult.build(FLAG_SUCCESS, qb, MSG_Increase_Success);
                } else {
                    return jsonResult.build(FLAG_FAILED, MSG_Failure);
                }
            } else {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }

    }


    @RequestMapping("/updateQuestion")
    JsonResult setUpdateQuestion(HttpServletRequest request) {
        try {
            int id = ToolUtil.integer("id", request);
            String QuestionContent = ToolUtil.str("QuestionContent", request);
            String QuestionTitle = ToolUtil.str("QuestionTitle", request);
            String QuestionSort = ToolUtil.str("QuestionSort", request);
            String QuestionDifficult = ToolUtil.str("QuestionDifficult", request);
            Integer delete1 = ToolUtil.integer("delete1", request);
            System.out.println("id=" + id + ",QuestionTitle=" + QuestionTitle + ",QuestionContent=" + QuestionContent + "," +
                    "QuestionSort=" + QuestionSort + ",QuestionDifficult=" + QuestionDifficult + ",delete1=" + delete1);
            if (ToolUtil.equalBool(id) && ToolUtil.equalBool(delete1) && ToolUtil.equalBool(QuestionTitle) && ToolUtil.equalBool(QuestionContent) && ToolUtil.equalBool(QuestionSort) && ToolUtil.equalBool(QuestionDifficult)) {
                question_bank qb = new question_bank();
                qb.setId(id);
                qb.setQuestionTitle(QuestionTitle);
                qb.setQuestionContent(QuestionContent);
                qb.setQuestionSort(QuestionSort);
                qb.setQuestionDifficult(QuestionDifficult);
                qb.setDelete1(delete1);
                Integer n = qbankSerice.setUpdateQuestion(qb);
                System.out.println("n=" + n);
                if (ToolUtil.equalBool(n)) {
                    return jsonResult.build(FLAG_SUCCESS, qb, MSG_Modify_Success);
                } else {
                    return jsonResult.build(FLAG_FAILED, MSG_Failure);
                }
            } else {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/deleteQuestionById")
    JsonResult deleteQuestionById(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer id = ToolUtil.integer("id", request);
//        KeyList=KEYLIST;
//        System.out.println(KEYLIST);
            if (ToolUtil.equalBool(id)) {
                question_bank qb = qbankSerice.getSelectById(id);
                if (qb.getDelete1() == 0) {
                    Integer result = qbankSerice.deleteQuestionById(id, KEYLIST);
                    if (result == 0) {
                        return jsonResult.build(FLAG_FAILED, MSG_Failure);
                    } else {
                        return jsonResult.build(FLAG_SUCCESS, MSG_Delete_Success);
                    }
                } else {
                    Integer result = qbankSerice.clearQuestionById(id);
                    if (result == 0) {
                        return jsonResult.build(FLAG_FAILED, MSG_Failure);
                    } else {
                        return jsonResult.build(FLAG_SUCCESS, "假" + MSG_Delete_Success);
                    }
                }

            } else {
                return jsonResult.build(FLAG_FAILED, "数据丢失");
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/clearQuestionById")
    JsonResult clearQuestionById(HttpServletRequest request) {
        try {
            Integer id = ToolUtil.integer("id", request);
            if (ToolUtil.equalBool(id)) {
                Integer result = qbankSerice.clearQuestionById(id);
                if (result == 0) {
                    return jsonResult.build(FLAG_FAILED, "数据放入回收站失败");
                } else {
                    return jsonResult.build(FLAG_SUCCESS, "数据收入回收站成功");
                }
            } else {
                return jsonResult.build(FLAG_FAILED, "数据丢失");
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }


    @RequestMapping("/regainQuestionById")
    JsonResult regainQuestionById(HttpServletRequest request) {
        try {
            Integer id = ToolUtil.integer("id", request);
            if (ToolUtil.equalBool(id)) {
                question_bank qb = qbankSerice.getSelectById(id);
                if (qb.getDelete1() == 0) {
                    Integer result = qbankSerice.regainQuestionById(id);
                    if (ToolUtil.equalBool(result)) {
                        return jsonResult.build(FLAG_SUCCESS, MSG_Restore_Success);
                    } else {
                        return jsonResult.build(FLAG_FAILED, MSG_Failure);
                    }
                } else {
                    return jsonResult.build(FLAG_FAILED, MSG_Failure);
                }
            } else {
                return jsonResult.build(FLAG_FAILED, MSG_Enter_Air);
            }
        } catch (Exception e) {
            return JsonResult.build(FLAG_FAILED, e.getMessage(), MSG_Abnormal);
        }
    }
    
}
