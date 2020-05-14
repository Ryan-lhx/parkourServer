package com.outsourcing.combat.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.UserBackpackService;
import com.outsourcing.combat.mapper.UserBackpackMapper;
import com.outsourcing.combat.pojo.user_backpack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = "UserBackpack")
public class UserBackpackServiceImpl implements UserBackpackService {

    @Autowired
    UserBackpackMapper userBackpackMapper;

    //向背包中添加物品
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'Select'")
    public PageInfo<user_backpack> getInsert(user_backpack userBackpack) {
        userBackpackMapper.getInsert(userBackpack);
        return new PageInfo<>(userBackpackMapper.getSelect());
    }

    @Override
    @Transactional
    @Cacheable(key = "'Select'")
    public PageInfo<user_backpack> getSelect() {
        return new PageInfo<>(userBackpackMapper.getSelect());
    }

    //查看背包中的道具
    @Override
    @Transactional
    @Cacheable(key = "'UserBackpack='+#gameUserId+#currentPage+'--'+#pageSize")
    public PageInfo<user_backpack> getSelectAll(Integer gameUserId, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<user_backpack> selectAll = userBackpackMapper.getSelectAll(gameUserId);
        return new PageInfo<>(selectAll);
    }

    //根据name（任务名称）查看
    @Override
    @Transactional
    @Cacheable(key = "'UserName='+#name+'--'+#gameUserId+#currentPage+'--'+#pageSize")
    public PageInfo<user_backpack> getSelectByName(String name, Integer gameUserId, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<user_backpack> selectByName = userBackpackMapper.getSelectByName(name, gameUserId);
        return new PageInfo<>(selectByName);
    }

    //根据id查看
    @Override
    @Transactional
    @Cacheable(key = "'Id='+#id+#gameUserId")
    public PageInfo<user_backpack> getSelectById(Integer id, Integer gameUserId) {
        return new PageInfo<>(userBackpackMapper.getSelectById(id, gameUserId));
    }

    //根据id使用道具
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'id'+#id")
    public PageInfo<user_backpack> getDeleteById(Integer id) {
        userBackpackMapper.getDeleteById(id);
        return new PageInfo<>(userBackpackMapper.getSelect());
    }
}
