package com.outsourcing.combat.ShiroConfig;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Configuration
public class ShiroConfig {

    /* @Value("${spring.redis.host}")
     private String host;
     @Value("${spring.redis.port}")
     private int port;
     @Value("${spring.redis.password:}")
     private String password;
     @Value("${spring.redis.timeout}")
     private int timeout;
     @Value("${spring.redis.database:0}")
     private int database;
 */
    /*
     * Realm是一个安全数据源 ,一个域
     * shiro会从Realm中获取用户的信息，权限
     * 我们可以对他进行自定义设置
     * 让他获取数据库里面的数据*/
    @Bean("getRealm")
    public ShiroRealm getRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return shiroRealm;
    }

    /*
    加密算法 是把输入的密码进行加密然后传给数据库进行对比  不会对数据库的密码进行加密
    如果不进行这个方法的话不会比较密码
    * shiro 提供 加密密码 和 验证密码 服务的 CredentialsMatcher 接口
    * HashedCredentialsMatcher 是 CredentialsMatcher的实现类*/
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        加密方式
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        加密次数
        hashedCredentialsMatcher.setHashIterations(1);
        /*存储散列后的密码是否为16进制
        设置16进制编码的存储凭证
        （没有看懂）*/
//        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);

//        hashedCredentialsMatcher.doCredentialsMatch(token,info);
        return hashedCredentialsMatcher;
    }

    /*
     * 安全管理器*/
    @Bean
    public SecurityManager securityManager(ShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //配置securityManager，注入shiroRealm
        securityManager.setRealm(shiroRealm);
        //配置 rememberMeCookie
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /*
     * 过滤器*/
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        /*设置安全管理器*/
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /*设置跳转到登录页面*/
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        /*账号正确跳转页面*/
        shiroFilterFactoryBean.setSuccessUrl("/index");
        /*设置未授权页面*/
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        /*shiro内置过滤器
         * 权限相关的拦截
         * 常用过滤器
         *   anon:无需登录（认证）就开源访问
         *   authc:必须认证才可以访问
         *   user: 如果使用remember的功能可以直接访问
         *   perms: 该资源必须得到资源权限才可以访问
         *   role: 该资源必须得到角色权限才可以访问
         *   */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        /*
         * anno是可以直接访问*/
        filterMap.put("index", "anon");
        filterMap.put("add1", "anon");
        /*
         * authc需要登录之后才可以访问*/
        filterMap.put("/GameTaskQuery/**", "authc");
        filterMap.put("/GameUserQuery/**", "authc");
        filterMap.put("/PlayRuleQuery/**", "authc");
        filterMap.put("/PropsQuery/**", "authc");
        filterMap.put("/SignInQuery/**", "authc");

        /*
         * perms[user:1] 判断用户是否存在[USER:1]*/
        filterMap.put("/user/add", "perms[user:1]");
        filterMap.put("/user/update", "perms[user:3]");
        filterMap.put("TRoleQuery", "perms[user:select]");
        filterMap.put("TUserQuery", "perms[user:select]");

        filterMap.put("/GameTaskAdd/**", "perms[admin:add]");
        filterMap.put("/GameUserAdd/**", "perms[admin:add]");
        filterMap.put("/PlayRuleAdd/**", "perms[admin:add");
        filterMap.put("/PropsAdd/**", "perms[admin:add]");
        filterMap.put("/SignInAdd/**", "perms[admin:add]");
        filterMap.put("/TRoleAdd/**", "perms[admin:add]");
        filterMap.put("/TUserAdd/**", "perms[admin:add]");

        filterMap.put("/GameTaskDelete/ById", "perms[user:delete]");
        filterMap.put("/GameUserDelete/ById", "perms[user:delete]");
        filterMap.put("/PlayRuleDelete/ById", "perms[user:delete]");
        filterMap.put("/propsDelete/ById", "perms[user:delete]");
        filterMap.put("/TRoleDelete/ById", "perms[user:delete]");
        filterMap.put("/TUserDelete/ById", "perms[user:delete]");

        filterMap.put("/GameTaskDelete/ClearById", "perms[admin:delete]");
        filterMap.put("/GameUserDelete/ClearById", "perms[admin:delete]");
        filterMap.put("/PlayRuleDelete/ClearById", "perms[admin:delete]");
        filterMap.put("/propsDelete/ClearById", "perms[admin:delete]");
        filterMap.put("/TRoleDelete/ClearById", "perms[admin:delete]");
        filterMap.put("/TUserDelete/ClearById", "perms[admin:delete]");

        filterMap.put("/GameTaskDelete/Clear", "perms[admin:delete]");
        filterMap.put("/GameUserDelete/Clear", "perms[admin:delete]");
        filterMap.put("/PlayRuleDelete/Clear", "perms[admin:delete]");
        filterMap.put("/propsDelete/Clear", "perms[admin:delete]");
        filterMap.put("/TRoleDelete/Clear", "perms[admin:delete]");
        filterMap.put("/TUserDelete/Clear", "perms[admin:delete]");

        filterMap.put("/GameTaskDelete/ReplyById", "perms[admin:delete]");
        filterMap.put("/GameUserDelete/ReplyById", "perms[admin:delete]");
        filterMap.put("/PlayRuleDelete/ReplyById", "perms[admin:delete]");
        filterMap.put("/propsDelete/ReplyById", "perms[admin:delete]");
        filterMap.put("/TRoleDelete/ReplyById", "perms[admin:delete]");
        filterMap.put("/TUserDelete/ReplyById", "perms[admin:delete]");

        filterMap.put("/GameTaskUpdate/**", "perms[admin:delete]");
        filterMap.put("/GameUserUpdate/**", "perms[admin:delete]");
        filterMap.put("/PlayRuleUpdate/**", "perms[admin:delete]");
        filterMap.put("/SignInUpdate/**", "perms[admin:delete]");
        filterMap.put("/PropsUpdate/**", "perms[admin:delete]");
        filterMap.put("/TRoleUpdate/**", "perms[admin:delete]");
        filterMap.put("/TUserUpdate/**", "perms[admin:delete]");

        /*
         * 为过滤器中设置属性*/
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /*
     * cookie是*/
    private SimpleCookie cookie() {
        //设置cookie的名称 对应html页面的name
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        //设置过期时间
        cookie.setMaxAge(10000);
        return cookie;
    }

    private CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        //设置Cookie
        rememberMeManager.setCookie(cookie());
        //rememberMe cookie 加密的密码
        //加密
        String encryptKey = "febs_shiro_key";
        byte[] encryptKeyBytes = encryptKey.getBytes(StandardCharsets.UTF_8);
        String rememberKey = Base64Utils.encodeToString(Arrays.copyOf(encryptKeyBytes, 16));
        rememberMeManager.setCipherKey(Base64.decode(rememberKey));
        return rememberMeManager;
    }

    /*
     * 开启shiro相关注解*/
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /*
     * 开启 THY模板 中shiro标签的使用*/
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    /*@Bean
    public RedisSessionDAO redisSessionDAO(){
        RedisSessionDAO redisSessionDAO =new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }*/

    //设置shiro关于redis的缓存
    /*public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host+" : "+port);
        if (StringUtils.isNotBlank(password)){
            redisManager.setPassword(password);
        }
        redisManager.setTimeout(timeout);
        redisManager.setDatabase(database);
        System.out.println(host+"====="+
                port+"===="+password+"====="
                +timeout+"====="+database);
        return redisManager;
    }*/

/*
    private RedisCacheManager redisCacheManager(){
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }
*/

    /*@Bean
    public DefaultWebSessionManager defaultWebSessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        Collection<SessionListener>listeners = new ArrayList<>();
        //设置超时时间
        sessionManager.setGlobalSessionTimeout(100000000);
        sessionManager.setSessionListeners(listeners);
        sessionManager.setSessionDAO(redisSessionDAO());
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }*/
}
