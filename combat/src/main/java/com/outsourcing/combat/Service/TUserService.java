package com.outsourcing.combat.Service;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.user_role;
import com.outsourcing.combat.pojo.TUser;

import java.util.List;

public interface TUserService {
    //添加一个用户
    PageInfo<user_role> getInsert(TUser tUser);

    //查看所有
    PageInfo<user_role> getTUser();

    //查询未删除
    PageInfo<user_role> getSelect(Integer currentPage, Integer pageSize);

    //回收站
    PageInfo<user_role> getSelectDelete(Integer currentPage, Integer pageSize);

    //根据Id查看单个
    PageInfo<user_role> getSelectById(Integer id);

    //根据id查询回收站
    PageInfo<user_role> getSelectDeleteById(Integer id);

    //根据Name查找
    PageInfo<user_role> getSelectByName(String name, Integer currentPage, Integer pageSize);

    //根据用户角色（user_id）范围查询
    PageInfo<user_role> getSelectByUserId(Integer userId, Integer currentPage, Integer pageSize);


    //根据Id假删除
    PageInfo<user_role> getDeleteById(Integer id);

    //根据id真删除
    PageInfo<user_role> getClearById(Integer id);

    //全部真删除
    PageInfo<user_role> getClear();

    //根据id还原
    PageInfo<user_role> getReplyById(Integer id);

    //根据id更新
    PageInfo<user_role> getUpdateById(TUser tUser);
}