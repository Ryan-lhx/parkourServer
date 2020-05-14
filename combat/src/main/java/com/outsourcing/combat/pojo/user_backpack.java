package com.outsourcing.combat.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class user_backpack {
    private Integer userId;
    private Integer propsId;
    private String userName;
    private String propsName;
    private String propsDescription;
    private String propsSort;
}
