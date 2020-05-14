package com.outsourcing.combat.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.GameTask;
import com.outsourcing.combat.pojo.TRole;
import com.outsourcing.combat.pojo.MenuRole;

import java.util.List;

public interface TroleService {
    //添加
    PageInfo<MenuRole> getInsert(TRole tRole);

    //查询所有
    PageInfo<MenuRole> getSelect();

    //查询未删除
    PageInfo<MenuRole> getSelectMenuRole(Integer currentPage, Integer pageSize);

    //查询回收站
    PageInfo<MenuRole> getSelectDelete(Integer currentPage, Integer pageSize);

    //根据id查询
    PageInfo<MenuRole> getSelectById(Integer id);

    //根据id查询回收站
    PageInfo<MenuRole> getSelectDeleteById(Integer id);

    //根据roleId查询
    PageInfo<MenuRole> getSelectByRoleId(Integer roleId, Integer currentPage, Integer pageSize);

    //根据角色名称（role_name）模糊查询
    PageInfo<MenuRole> getSelectByRoleName(String roelName, Integer currentPage, Integer pageSize);

    //根据描述（depiction）查询
    PageInfo<MenuRole> getSelectByDepiction(String depiction, Integer currentPage, Integer pageSize);

    //根据id更新
    PageInfo<MenuRole> getUpdateById(TRole tRole);

    //根据id假删除
    PageInfo<MenuRole> getDeleteById(Integer id);

    //根据其他字段假删除
//    PageInfo<MenuRole> getDeleteByMenuRole();
    //根据id真删除
    PageInfo<MenuRole> getClearById(Integer id);

    //全部真删除
    PageInfo<MenuRole> getClear();

    //根据id还原
    PageInfo<MenuRole> getReplyById(Integer id);
}
