package com.outsourcing.combat.Service;


import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.GameTask;


public interface GameTaskService {
    //添加
    PageInfo<GameTask> getInsert(GameTask gameTask);

    //查询所有
    PageInfo<GameTask> getSelect();

    //查询未删除
    PageInfo<GameTask> getSelectGameTask(Integer currentPage, Integer pageSize);

    //查询删除
    PageInfo<GameTask> getSelectDelete(Integer currentPage, Integer pageSize);

    //根据id查询回收站
    PageInfo<GameTask> getSelectDeleteById(Integer id);

    //根据id查询
    PageInfo<GameTask> getSelectById(Integer id);

    //根据 Title（标题查询）
    PageInfo<GameTask> getSelectByTitle(String title, Integer currentPage, Integer pageSize);

    //根据Description（内容查询）
    PageInfo<GameTask> getSelectByDescription(String description, Integer currentPage, Integer pageSize);

    //根据Type（类型）查询
    PageInfo<GameTask> getSelectByType(String type, Integer currentPage, Integer pageSize);

    //根据Reward（奖励）查询
    PageInfo<GameTask> getSelectByReward(String reward, Integer currentPage, Integer pageSize);

    //根据Time（时间）查询
    PageInfo<GameTask> getSelectByTime(String time, Integer currentPage, Integer pageSize);

    //根据id更新
    PageInfo<GameTask> getUpdateById(GameTask gameTask);

    //根据id假删除
    PageInfo<GameTask> getDeleteById(Integer id);

    //根据其他字段假删除
    PageInfo<GameTask> getDeleteByGameTask(GameTask gameTask);

    //根据id真删除
    PageInfo<GameTask> getClearById(Integer id);

    //全部真删除
    PageInfo<GameTask> getClear();

    //根据id还原
    PageInfo<GameTask> getReplyById(Integer id);
}
