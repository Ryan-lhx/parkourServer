package com.outsourcing.combat.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.SignInService;
import com.outsourcing.combat.mapper.SignInMapper;
import com.outsourcing.combat.pojo.SignIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = "SignIn")
public class SignInServiceImpl implements SignInService {

    @Autowired
    SignInMapper signInMapper;

    //添加
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'SignIn'")
    public PageInfo<SignIn> getInsert(SignIn signIn) {
        signInMapper.getInsert(signIn);
        return new PageInfo<>(signInMapper.getSelect());
    }

    //查看所有
    @Override
    @Transactional
    @Cacheable(key = "'SignIn'+#currentPage+'--'+#pageSize")
    public PageInfo<SignIn> getSelect(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<SignIn> select = signInMapper.getSelect();
        return new PageInfo<>(select);
    }

    //根据frequency查询
    @Override
    @Transactional
    @Cacheable(key = "'frequency='+#frequency")
    public PageInfo<SignIn> getSelectByFrequency(Integer frequency) {
        return new PageInfo<>(signInMapper.getSelectByFrequency(frequency));
    }

    //根据title查询
    @Override
    @Transactional
    @Cacheable(key = "'title='+#title+#currentPage+'--'+#pageSize")
    public PageInfo<SignIn> getSelectByTitle(String title, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<SignIn> selectByTitle = signInMapper.getSelectByTitle(title);
        return new PageInfo<>(selectByTitle);
    }

    //根据content查询
    @Override
    @Transactional
    @Cacheable(key = "'content='+#content+#currentPage+'--'+#pageSize")
    public PageInfo<SignIn> getSelectByContent(String content, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<SignIn> selectByContent = signInMapper.getSelectByContent(content);
        return new PageInfo<>(selectByContent);
    }

    //根据reward查询
    @Override
    @Transactional
    @Cacheable(key = "'reward='+#reward+#currentPage+'--'+#pageSize")
    public PageInfo<SignIn> getSelectByReward(String reward, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<SignIn> selectByReward = signInMapper.getSelectByReward(reward);
        return new PageInfo<>(selectByReward);
    }

    //更新
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @Cacheable(key = "'SignIn'")
    public PageInfo<SignIn> getUpdateByFrequency(SignIn signIn) {
        signInMapper.getUpdateByFrequency(signIn);
        return new PageInfo<>(signInMapper.getSelect());
    }
}