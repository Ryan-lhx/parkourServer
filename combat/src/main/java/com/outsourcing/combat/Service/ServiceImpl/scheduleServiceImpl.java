package com.outsourcing.combat.Service.ServiceImpl;


import com.outsourcing.combat.Service.scheduleService;
import com.outsourcing.combat.mapper.scheduleMapper;
import com.outsourcing.combat.pojo.schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "SCHEDULE")
@Service
public class scheduleServiceImpl implements scheduleService {
    @Autowired
    com.outsourcing.combat.mapper.scheduleMapper scheduleMapper;

    @Cacheable(key = "'ALL'+'--'+#currentPage+'--'+#pageSize")
    @Override
    public List<schedule> selectAll(Integer currentPage, Integer pageSize) {
        return scheduleMapper.selectAll();
    }

    @Cacheable(key = "'ScheduleId='+#id+'--'+#currentPage+'--'+#pageSize")
    @Override
    public schedule selectById(Integer id, Integer currentPage, Integer pageSize) {
        return scheduleMapper.selectById(id);
    }

    @Override
    public List<schedule> selectByCardId(Integer carId) {
        return scheduleMapper.selectByCardId(carId);
    }

    @Override
    public List<schedule> selectByUserId(Integer userId) {
        return scheduleMapper.selectByUserId(userId);
    }

    @Override
    public Integer updateSchedule(schedule s) {
        return scheduleMapper.updateSchedule(s);
    }

    @Override
    public Integer insertSchedule(schedule s) {
        return scheduleMapper.insertSchedule(s);
    }

    @CacheEvict(key = "'ScheduleId='+#id+'--'+#currentPage+'--'+#pageSize")
    @Override
    public Integer deleteScheduleById(Integer id, Integer currentPage, Integer pageSize) {
        return scheduleMapper.deleteScheduleById(id);
    }
}
