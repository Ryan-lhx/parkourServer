package com.outsourcing.combat.ShiroConfig;

import com.outsourcing.combat.Service.LoginService;
import com.outsourcing.combat.pojo.user_role;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    LoginService loginService;

    /*授权信息*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        user_role user_role = (com.outsourcing.combat.pojo.user_role) subject.getPrincipal();
        //设置当前用户权限
        //查询权限
        Set<String> roles = new HashSet<String>();
        List<user_role> tUserList = loginService.getSelectTRoleList(user_role.getName());
        for (user_role tRole : tUserList) {
            roles.add(tRole.getRoleName());
        }
        List<user_role> tMenuList = loginService.getSelectTMenuList(user_role.getName());
        for (user_role tMenu : tMenuList) {
            info.addStringPermission(tMenu.getUrl());
        }
        return info;
    }

    /*认证信息
     * 验证用户账号
     * shiro API身份验证核心的入口点*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        /*获取用户名*/
        user_role user = loginService.getSelectUserByName(token.getUsername());
        /*判断用户名是否存在*/
        if (user == null) {
            //返回 null之后 shiro底层会抛出UnknownAccountException
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                this.getName()
        );
        return authenticationInfo;
    }
}
