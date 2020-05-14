package com.outsourcing.combat.mapper;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.user_role;
import com.outsourcing.combat.pojo.TUser;

import java.util.List;

public interface TUserMapper {
    //添加一个用户
    void getInsert(TUser tUser);

    //查看所有
    List<user_role> getTUser();

    //查询未删除
    List<user_role> getSelect();

    //回收站
    List<user_role> getSelectDelete();

    //根据Id查看单个
    List<user_role> getSelectById(Integer id);

    //根据id查询回收站
    List<user_role> getSelectDeleteById(Integer id);

    //根据Name范围查找
    List<user_role> getSelectByName(String name);

    //根据用户角色（user_id）范围查询
    List<user_role> getSelectByUserId(Integer userId);


    //根据Id假删除
    void getDeleteById(Integer id);

    //根据id真删除
    void getClearById(Integer id);

    //全部真删除
    void getClear();

    //根据id还原
    void getReplyById(Integer id);

    //根据id更新
    void getUpdateById(TUser tUser);
}
