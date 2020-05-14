package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.user_backpack;

import java.util.List;

public interface UserBackpackMapper {
    //想背包中添加道具
    void getInsert(user_backpack userBackpack);

    //查询所有
    List<user_backpack> getSelect();

    //查看当前背包中的所有道具
    List<user_backpack> getSelectAll(Integer gameUserId);

    //根据name查询当前用户道具
    List<user_backpack> getSelectByName(String name, Integer gameUserId);

    //根据id查询当前用户道具
    List<user_backpack> getSelectById(Integer id, Integer gameUserId);

    //使用道具
    void getDeleteById(Integer id);
}
