package com.outsourcing.combat.Service;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.SignIn;

import java.util.List;

public interface SignInService {
    //添加
    PageInfo<SignIn> getInsert(SignIn signIn);

    //查看所有
    PageInfo<SignIn> getSelect(Integer currentPage, Integer pageSize);

    //根据频率（相当与id）找
    PageInfo<SignIn> getSelectByFrequency(Integer frequency);

    //根据title查看
    PageInfo<SignIn> getSelectByTitle(String title, Integer currentPage, Integer pageSize);

    //根据content
    PageInfo<SignIn> getSelectByContent(String content, Integer currentPage, Integer pageSize);

    //根据reward
    PageInfo<SignIn> getSelectByReward(String reward, Integer currentPage, Integer pageSize);

    //更新
    PageInfo<SignIn> getUpdateByFrequency(SignIn signIn);
}