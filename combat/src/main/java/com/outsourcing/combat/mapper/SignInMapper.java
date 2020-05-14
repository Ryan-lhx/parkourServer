package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.SignIn;

import java.util.List;

public interface SignInMapper {
    //添加
    void getInsert(SignIn signIn);

    //查看所有
    List<SignIn> getSelect();

    //根据频率（相当与id）找
    List<SignIn> getSelectByFrequency(Integer frequency);

    //根据title查看
    List<SignIn> getSelectByTitle(String title);

    //根据content
    List<SignIn> getSelectByContent(String content);

    //根据reward
    List<SignIn> getSelectByReward(String reward);

    //更新
    void getUpdateByFrequency(SignIn signIn);
}