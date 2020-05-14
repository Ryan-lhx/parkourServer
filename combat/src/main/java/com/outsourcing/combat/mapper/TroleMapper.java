package com.outsourcing.combat.mapper;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.GameTask;
import com.outsourcing.combat.pojo.TRole;
import com.outsourcing.combat.pojo.MenuRole;

import java.util.List;

public interface TroleMapper {
    //添加
    void getInsert(TRole tRole);

    //查询所有
    List<MenuRole> getSelect();

    //查询未删除
    List<MenuRole> getSelectMenuRole();

    //查询回收站
    List<MenuRole> getSelectDelete();

    //根据id查询
    List<MenuRole> getSelectById(Integer id);

    //根据id查询回收站
    List<MenuRole> getSelectDeleteById(Integer id);

    //根据角色名称（role_name）模糊查询
    List<MenuRole> getSelectByRoleName(String roelName);

    //根据描述（depiction）查询
    List<MenuRole> getSelectByDepiction(String depiction);

    //根据roleId查询
    List<MenuRole> getSelectByRoleId(Integer roleId);

    //根据id更新
    void getUpdateById(TRole tRole);

    //根据id假删除
    void getDeleteById(Integer id);

    //根据其他字段假删除
//    void getDeleteByMenuRole();
    //根据id真删除
    void getClearById(Integer id);

    //全部真删除
    void getClear();

    //根据id还原
    void getReplyById(Integer id);
}
