package com.outsourcing.combat.Service;


import com.outsourcing.combat.pojo.schedule;

import java.util.List;

public interface scheduleService {
    // 查询所有
    List<schedule> selectAll(Integer currentPage, Integer pageSize);

    // 根据id查询
    schedule selectById(Integer id, Integer currentPage, Integer pageSize);

    // 根据cardId查询
    List<schedule> selectByCardId(Integer carId);

    // 根据userId查询
    List<schedule> selectByUserId(Integer userId);

    // 更新schedule
    Integer updateSchedule(schedule s);

    // 插入schedule
    Integer insertSchedule(schedule s);

    // 删除schedule,根据id
    Integer deleteScheduleById(Integer id, Integer currentPage, Integer pageSize);
}
