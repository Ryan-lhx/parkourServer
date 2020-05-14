package com.outsourcing.combat.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class user_role {
    private Integer id;
    private String name;
    private String password;
    private String salt;
    private String roleName;
    private String url;
}
