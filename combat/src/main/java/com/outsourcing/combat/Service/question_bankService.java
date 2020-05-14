package com.outsourcing.combat.Service;

import com.outsourcing.combat.pojo.question_bank;

import java.util.List;


public interface question_bankService {

    // 查询全部
    List<question_bank> getByAll(Integer currentPage,  Integer pageSize);

    // 根据id查找
    question_bank getSelectById(Integer id);

    // 根据题目查找(精确查找)
    question_bank getSelectByTitle(String title);

    // 根据题目查找(模糊查找)
    List<question_bank> getSelectByTitleVague(String vagueTitle);

    // 查找排名第几的题目(精确查找)
    question_bank getSelectBySort(Integer sortData);

    // 根据难度查询题目
    List<question_bank> getSelectByDifficult(String difficult,Integer currentPage,  Integer pageSize);

    // 查询所有
    List<question_bank> getSelectAllQuestion(Integer currentPage,  Integer pageSize);

    // 添加一个题目
    Integer setInsertQuestion(question_bank qBank);

    // 根据id把题目放进回收站
    Integer clearQuestionById(Integer id);

    // 修改题目
    Integer setUpdateQuestion(question_bank qBank);

    // 根据id删除题目
    Integer deleteQuestionById(Integer id, String KeyList);

    // 根据id从回收站中取出
    Integer regainQuestionById(Integer id);

    // 查出总共有多少道题目
    Integer selectCounts();

}