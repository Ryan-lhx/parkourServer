package com.outsourcing.combat.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Props {
    private Integer id;
    //道具名称
    private String propsName;
    //道具描述
    private String propsDescription;
    //模型id
    private Integer modelId;
    //道具分类
    private String propsSort;
    //删除
//    private Integer delete1;
}
