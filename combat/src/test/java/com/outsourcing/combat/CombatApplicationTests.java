package com.outsourcing.combat;

import com.outsourcing.combat.Service.GameUserService;
import com.outsourcing.combat.Service.TUserService;
import com.outsourcing.combat.Service.UserTaskService;
import com.outsourcing.combat.ShiroConfig.ShiroRealm;
import com.outsourcing.combat.pojo.GameUser;
import com.outsourcing.combat.pojo.user_task;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CombatApplicationTests {

    @Autowired
    TUserService tUserService;

    @Autowired
    ShiroRealm shiroRealm;

    @Autowired
    GameUserService gameUserService;

    @Autowired
    UserTaskService userTaskService;

    @Test
    void contextLoads() {
        String hashAlgorithmName = "MD5";
        String credentials = "123456";
        Object obj = new SimpleHash(hashAlgorithmName, credentials, null, 1);
        System.out.println(obj);
    }
}
