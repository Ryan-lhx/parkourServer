package com.outsourcing.combat.Service;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.user_task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserTaskService {
    //刷新任务
    PageInfo<user_task> getUpdateByTaskId(Integer taskId, Integer userId, Integer taskId1);

    //根据用户查看任务
    PageInfo<user_task> getSelectByUserId(Integer userId);

    //完成任务
    PageInfo<user_task> getDeleteByCarryOut(Integer taskId, Integer userId);

}
