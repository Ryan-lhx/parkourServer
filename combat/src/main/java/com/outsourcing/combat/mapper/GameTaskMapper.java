package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.GameTask;

import java.util.List;

public interface GameTaskMapper {
    //添加
    void getInsert(GameTask gameTask);

    //查询所有
    List<GameTask> getSelect();

    //查询未删除
    List<GameTask> getSelectGameTask();

    //查询删除（回收站）
    List<GameTask> getSelectDelete();

    //根据id查询回收站
    List<GameTask> getSelectDeleteById(Integer id);

    //根据id查询
    List<GameTask> getSelectById(Integer id);

    //根据 Title（标题查询）
    List<GameTask> getSelectByTitle(String title);

    //根据Description（内容查询）
    List<GameTask> getSelectByDescription(String description);

    //根据Type（类型）查询
    List<GameTask> getSelectByType(String type);

    //根据Reward（奖励）查询
    List<GameTask> getSelectByReward(String reward);

    //根据Time（时间）查询
    List<GameTask> getSelectByTime(String time);

    //根据id更新
    void getUpdateById(GameTask gameTask);
    //根据其他字段批量更新
//    void getUpdate(GameTask gameTask);

    //根据id假删除
    void getDeleteById(Integer id);

    //根据其他字段假删除
    void getDelete(GameTask gameTask);

    //根据id真删除
    void getClearById(Integer id);

    //全部真删除
    void getClear();

    //根据id还原
    void getReplyById(Integer id);

    //分页查询
    List<GameTask> getSelectPage();
}
