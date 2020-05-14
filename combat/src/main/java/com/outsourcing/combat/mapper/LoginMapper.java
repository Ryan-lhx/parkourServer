package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.user_login;
import com.outsourcing.combat.pojo.user_role;

import java.util.List;

public interface LoginMapper {
    //根据name查找账户
    user_role getSelectUserByName(String name);

    List<user_role> getSelectTRoleList(String name);

    List<user_role> getSelectTMenuList(String name);
}
