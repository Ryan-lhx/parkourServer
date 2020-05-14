package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.Props;

import java.util.List;

public interface PropsMapper {
    //添加道具
    void getInsert(Props props);

    //查看所有
    List<Props> getProps();

    //查看所有未删除
    List<Props> getSelect();

    //查看回收站
    List<Props> getSelectDelete();

    //根据id查看回收站
    List<Props> getSelectDeleteById(Integer id);

    //根据id查询
    List<Props> getSelectById(Integer id);

    //根据propsName查询
    List<Props> getSelectByName(String name);

    //根据propsDescription查询
    List<Props> getSelectByDescription(String description);

    //根据propsSort查询
    List<Props> getSelectBySort(String Sort);

    //根据id假删除
    void getDeleteById(Integer id);

    //根据id真删除
    void getClearById(Integer id);

    //根据id回复
    void getReplyById(Integer id);

    //全部真删除
    void getClear();

    //根据id更新
    void getUpdateById(Props props);
}
