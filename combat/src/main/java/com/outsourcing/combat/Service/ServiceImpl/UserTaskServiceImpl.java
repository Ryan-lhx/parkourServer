package com.outsourcing.combat.Service.ServiceImpl;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.GameTaskService;
import com.outsourcing.combat.Service.UserTaskService;
import com.outsourcing.combat.mapper.UserTaskMapper;
import com.outsourcing.combat.pojo.GameTask;
import com.outsourcing.combat.pojo.user_task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTaskServiceImpl implements UserTaskService {

    @Autowired
    UserTaskMapper userTaskMapper;

    @Autowired
    GameTaskService gameTaskService;

    //刷新任务
    @Override
    public PageInfo<user_task> getUpdateByTaskId(Integer taskId, Integer userId, Integer taskId1) {
        userTaskMapper.getUpdateByTaskId(taskId, userId, taskId1);
        return new PageInfo<>(userTaskMapper.getSelectByUserId(userId));
    }

    //根据用户查询任务
    @Override
    public PageInfo<user_task> getSelectByUserId(Integer userId) {
        return new PageInfo<>(userTaskMapper.getSelectByUserId(userId));
    }

    //删除任务
    @Override
    public PageInfo<user_task> getDeleteByCarryOut(Integer taskId, Integer userId) {
        userTaskMapper.getDeleteByCarryOut(taskId, userId);
        return new PageInfo<>(userTaskMapper.getSelectByUserId(userId));
    }
}
