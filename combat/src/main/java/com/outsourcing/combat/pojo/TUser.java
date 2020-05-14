package com.outsourcing.combat.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class TUser {
    private Integer id;
    private String name;
    private String password;
    private String salt;
    private Integer userId;
    private Integer delete1;
    private Set<TRole> tRoles = new HashSet<>();
}
