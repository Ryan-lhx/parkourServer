package com.outsourcing.combat.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class TRole {
    private Integer id;
    private String roleName;
    private Integer roleId;
    private String depiction;
    private Integer delete1;
    private Set<TMenu> tMenus = new HashSet<>();
}
