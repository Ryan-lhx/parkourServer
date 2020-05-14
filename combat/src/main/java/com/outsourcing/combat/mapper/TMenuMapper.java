package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.TMenu;

import java.util.List;

public interface TMenuMapper {
    //查询所有
    List<TMenu> getSelectAll();

    //根据id查询
    TMenu getSelectTMenuById(Integer id);

    //根据menu_name查询
    List<TMenu> getSelectTMenuByMenuName(String menu_name);

    //根据id更新url
    int getUpdateTMenuAlterById(TMenu tMenu);

    //删除
    int getDeleteById(Integer id);
}
