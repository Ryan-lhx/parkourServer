package com.outsourcing.combat.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class user_task {
    private String userName;
    private String taskTitle;
    private String taskDescription;
    private String taskType;
    private String taskReward;
    private String taskTime;
    private Integer userId;
    private Integer taskId;
}
