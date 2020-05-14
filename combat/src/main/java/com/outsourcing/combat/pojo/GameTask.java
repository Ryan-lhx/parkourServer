package com.outsourcing.combat.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GameTask {
    private Integer id;
    //任务标题
    private String taskTitle;
    //任务内容
    private String taskDescription;
    //任务标题
    private String taskType;
    //任务奖励
    private String taskReward;
    //任务时间
    private String taskTime;
}
