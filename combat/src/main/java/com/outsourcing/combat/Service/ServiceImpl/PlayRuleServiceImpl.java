package com.outsourcing.combat.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.PlayRuleService;
import com.outsourcing.combat.mapper.PlayRuleMapper;
import com.outsourcing.combat.pojo.PlayRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = "PlayRule")
public class PlayRuleServiceImpl implements PlayRuleService {

    @Autowired
    PlayRuleMapper playRuleMapper;

    //插入
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'PlayRule'")
    public PageInfo<PlayRules> getInset(PlayRules playRules) {
        playRuleMapper.getInset(playRules);
        return new PageInfo<>(playRuleMapper.getSelect());
    }

    //根据id假删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'PlayRule'")
    public PageInfo<PlayRules> getDeleteById(Integer id) {
        playRuleMapper.getDeleteById(id);
        return new PageInfo<>(playRuleMapper.getSelect());
    }

    //根据id真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'PlayRule'")
    public PageInfo<PlayRules> getClearById(Integer id) {
        playRuleMapper.getClearById(id);
        return new PageInfo<>(playRuleMapper.getSelect());
    }

    //根据其他字段删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'PlayRule'")
    public PageInfo<PlayRules> getDelete(PlayRules playRules) {
        playRuleMapper.getDelete(playRules);
        return new PageInfo<>(playRuleMapper.getSelect());
    }

    //全部真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'PlayRule'")
    public PageInfo<PlayRules> getClear() {
        playRuleMapper.getClear();
        return new PageInfo<>(playRuleMapper.getSelect());
    }

    //根据id还原
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'PlayRule'")
    public PageInfo<PlayRules> getReplyById(Integer id) {
        playRuleMapper.getReplyById(id);
        return new PageInfo<>(playRuleMapper.getSelect());
    }

    //根据id更新
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'PlayRule'")
    public PageInfo<PlayRules> getUpdateById(PlayRules playRules) {
        playRuleMapper.getUpdateById(playRules);
        return new PageInfo<>(playRuleMapper.getSelect());
    }

    //查询所有
    @Override
    @Transactional
    @Cacheable(key = "'PlayRule'")
    public PageInfo<PlayRules> getSelect() {
        return new PageInfo<>(playRuleMapper.getSelect());
    }

    //查询所有未删除
    @Override
    @Transactional
    @Cacheable(key = "'Select'+#currentPage+'--'+#pageSize")
    public PageInfo<PlayRules> getSelectPlayRules(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<PlayRules> selectPlayRules = playRuleMapper.getSelectPlayRules();
        return new PageInfo<>(selectPlayRules);
    }

    //查询回收站
    @Override
    @Transactional
    @Cacheable(key = "'Delete'+#currentPage+'--'+#pageSize")
    public PageInfo<PlayRules> getSelectDelete(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<PlayRules> selectDelete = playRuleMapper.getSelectDelete();
        return new PageInfo<>(selectDelete);
    }

    //根据id查询回收站
    @Override
    @Transactional
    @Cacheable(key = "'Delete-id='+#id")
    public PageInfo<PlayRules> getSelectDeleteById(Integer id) {
        return new PageInfo<>(playRuleMapper.getSelectDeleteById(id));
    }

    //根据id查询
    @Override
    @Transactional
    @Cacheable(key = "'Select-id='+#id")
    public PageInfo<PlayRules> getSelectById(Integer id) {
        return new PageInfo<>(playRuleMapper.getSelectById(id));
    }

    //根据title查询
    @Override
    @Transactional
    @Cacheable(key = "'title='+#title+#currentPage+'--'+#pageSize")
    public PageInfo<PlayRules> getSelectByTitle(String title, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<PlayRules> selectByTitle = playRuleMapper.getSelectByTitle(title);
        return new PageInfo<>(selectByTitle);
    }

    //根据description查询
    @Override
    @Transactional
    @Cacheable(key = "'PLAYRULE-description='+#description+#currentPage+'--'+#pageSize")
    public PageInfo<PlayRules> getSelectByDescription(String description, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<PlayRules> selectByDescription = playRuleMapper.getSelectByDescription(description);
        return new PageInfo<>(selectByDescription);
    }
}
