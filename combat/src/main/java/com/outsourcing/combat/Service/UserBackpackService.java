package com.outsourcing.combat.Service;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.user_backpack;

import java.util.List;

public interface UserBackpackService {
    //想背包中添加道具
    PageInfo<user_backpack> getInsert(user_backpack userBackpack);

    //查询所有
    PageInfo<user_backpack> getSelect();

    //查看背包中的所有道具
    PageInfo<user_backpack> getSelectAll(Integer gameUserId, Integer currentPage, Integer pageSize);

    //根据名字搜索道具
    PageInfo<user_backpack> getSelectByName(String name, Integer gameUserId, Integer currentPage, Integer pageSize);

    //查看道具
    PageInfo<user_backpack> getSelectById(Integer id, Integer gameUserId);

    //使用道具
    PageInfo<user_backpack> getDeleteById(Integer id);
}
