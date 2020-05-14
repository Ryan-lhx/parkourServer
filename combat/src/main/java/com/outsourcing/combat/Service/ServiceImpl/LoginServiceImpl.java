package com.outsourcing.combat.Service.ServiceImpl;


import com.outsourcing.combat.Service.LoginService;
import com.outsourcing.combat.mapper.LoginMapper;
import com.outsourcing.combat.pojo.user_login;
import com.outsourcing.combat.pojo.user_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public user_role getSelectUserByName(String name) {
        return loginMapper.getSelectUserByName(name);
    }

    @Override
    public List<user_role> getSelectTRoleList(String name) {
        return loginMapper.getSelectTRoleList(name);
    }

    @Override
    public List<user_role> getSelectTMenuList(String name) {
        return loginMapper.getSelectTMenuList(name);
    }
}
