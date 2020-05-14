package com.outsourcing.combat.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class TMenu implements Serializable {
    private Integer id;
    private String menuName;
    private String url;
    private Integer delete1;
}
