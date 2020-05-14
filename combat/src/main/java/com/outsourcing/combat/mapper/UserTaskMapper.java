package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.user_task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTaskMapper {
    //刷新任务
    void getUpdateByTaskId(Integer taskId, Integer userId, Integer taskId1);

    //根据用户查看任务
    List<user_task> getSelectByUserId(Integer userId);

    //完成任务
    void getDeleteByCarryOut(Integer taskId, Integer userId);
}
