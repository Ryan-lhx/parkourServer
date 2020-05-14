package com.outsourcing.combat.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class GameUser {
    private Integer id;
    //游戏用户账号
    private String userName;
    //游戏用户密码
    private String userPassword;
    //游戏积分
    private String userIntegral;
    //是否是VIP
    private Integer userVIP;
    //游戏的距离
    private String userDistance;
    //用户昵称
    private String userNickname;

    //用户是否被假删除
    private String userDelete;
    //我不知道这个是什么
    private Integer signFrequency;
    //行程的具体路线
    private Integer strokeId;
    //我不知道了
    private Integer termType;
    //我还是不知道
    private String termToken;
}
