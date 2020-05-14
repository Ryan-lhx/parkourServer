package com.outsourcing.combat.Service.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.GameTaskService;
import com.outsourcing.combat.mapper.GameTaskMapper;
import com.outsourcing.combat.pojo.GameTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = "GameTask")
public class GameTaskServiceImpl implements GameTaskService {

    @Autowired
    GameTaskMapper gameTaskMapper;

    //插入
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameTask'")
    public PageInfo<GameTask> getInsert(GameTask gameTask) {
        gameTaskMapper.getInsert(gameTask);
        return new PageInfo<>(gameTaskMapper.getSelect());
    }

    //查询所有
    @Override
    @Transactional
    @Cacheable(key = "'GameTask'")
    public PageInfo<GameTask> getSelect() {
        return new PageInfo<>(gameTaskMapper.getSelect());
    }

    //查询所有未删除
    @Override
    @Transactional
    @Cacheable(key = "'Select'+#currentPage+'--'+#pageSize")
    public PageInfo<GameTask> getSelectGameTask(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(1, 10);
        List<GameTask> selectGameTask = gameTaskMapper.getSelectGameTask();
        PageInfo<GameTask> pageInfo = new PageInfo<GameTask>(selectGameTask);
        return pageInfo;
    }

    //查询所有被假删除的
    @Override
    @Transactional
    @Cacheable(key = "'Delete'+#currentPage+'--'+#pageSize")
    public PageInfo<GameTask> getSelectDelete(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameTask> selectDelete = gameTaskMapper.getSelectDelete();
        PageInfo pageInfo = new PageInfo<GameTask>(selectDelete, pageSize);
        return pageInfo;
    }

    //根据id查询回收站
    @Override
    @Transactional
    @Cacheable(key = "'Delete-id='+#id")
    public PageInfo<GameTask> getSelectDeleteById(Integer id) {
        return new PageInfo(gameTaskMapper.getSelectDeleteById(id));
    }

    //根据id查询
    @Override
    @Transactional
    @Cacheable(key = "'Select-id='+#id")
    public PageInfo<GameTask> getSelectById(Integer id) {
        return new PageInfo<>(gameTaskMapper.getSelectById(id));
    }

    //根据title查询
    @Override
    @Transactional
    @Cacheable(key = "'title='+#title+#currentPage+'--'+#pageSize")
    public PageInfo<GameTask> getSelectByTitle(String title, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameTask> selectByTitle = gameTaskMapper.getSelectByTitle(title);
        return new PageInfo(selectByTitle);
    }

    //根据description查询
    @Override
    @Transactional
    @Cacheable(key = "'description='+#description+#currentPage+'--'+#pageSize")
    public PageInfo<GameTask> getSelectByDescription(String description, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameTask> selectByDescription = gameTaskMapper.getSelectByDescription(description);
        return new PageInfo<>(selectByDescription);
    }

    //根据type查询
    @Override
    @Transactional
    @Cacheable(key = "'type='+#type+#currentPage+'--'+#pageSize")
    public PageInfo<GameTask> getSelectByType(String type, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameTask> selectByType = gameTaskMapper.getSelectByType(type);
        return new PageInfo<>(selectByType);
    }

    //根据reward查询
    @Override
    @Transactional
    @Cacheable(key = "'reward='+#reward+#currentPage+'--'+#pageSize")
    public PageInfo<GameTask> getSelectByReward(String reward, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameTask> selectByReward = gameTaskMapper.getSelectByReward(reward);
        return new PageInfo<>(selectByReward);
    }

    //根据time查询
    @Override
    @Transactional
    @Cacheable(key = "'time='+#time+#currentPage+'--'+#pageSize")
    public PageInfo<GameTask> getSelectByTime(String time, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameTask> selectByTime = gameTaskMapper.getSelectByTime(time);
        return new PageInfo<>(selectByTime);
    }

    //根据id更新
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameTask'")
    public PageInfo<GameTask> getUpdateById(GameTask gameTask) {
        gameTaskMapper.getUpdateById(gameTask);
        return new PageInfo<>(gameTaskMapper.getSelect());
    }

    //根据id假删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameTask'")
    public PageInfo<GameTask> getDeleteById(Integer id) {
        gameTaskMapper.getDeleteById(id);
        return new PageInfo<>(gameTaskMapper.getSelect());
    }

    //根据其他字段删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameTask'")
    public PageInfo<GameTask> getDeleteByGameTask(GameTask gameTask) {
        gameTaskMapper.getDelete(gameTask);
        return new PageInfo<>(gameTaskMapper.getSelect());
    }

    //根据id真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameTask'")
    public PageInfo<GameTask> getClearById(Integer id) {
        gameTaskMapper.getClearById(id);
        return new PageInfo<>(gameTaskMapper.getSelect());
    }

    //真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameTask'")
    public PageInfo<GameTask> getClear() {
        gameTaskMapper.getClear();
        return new PageInfo<>(gameTaskMapper.getSelect());
    }

    //根据id还原
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameTask'")
    public PageInfo<GameTask> getReplyById(Integer id) {
        gameTaskMapper.getReplyById(id);
        return new PageInfo<>(gameTaskMapper.getSelect());
    }
}
