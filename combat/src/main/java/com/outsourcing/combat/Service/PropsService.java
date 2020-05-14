package com.outsourcing.combat.Service;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.Props;

import java.util.List;

public interface PropsService {
    //添加道具
    PageInfo<Props> getInsert(Props props);

    //查看所有
    PageInfo<Props> getProps();

    //查看所有未删除
    PageInfo<Props> getSelect(Integer currentPage, Integer pageSize);

    //查看回收站
    PageInfo<Props> getSelectDelete(Integer currentPage, Integer pageSize);

    //根据id查看回收站
    PageInfo<Props> getSelectDeleteById(Integer id);

    //根据id查询
    PageInfo<Props> getSelectById(Integer id);

    //根据propsName查询
    PageInfo<Props> getSelectByName(String name, Integer currentPage, Integer pageSize);

    //根据propsDescription查询
    PageInfo<Props> getSelectByDescription(String description, Integer currentPage, Integer pageSize);

    //根据propsSort查询
    PageInfo<Props> getSelectBySort(String Sort, Integer currentPage, Integer pageSize);

    //根据id假删除
    PageInfo<Props> getDeleteById(Integer id);

    //根据id真删除
    PageInfo<Props> getClearById(Integer id);

    //根据id回复
    PageInfo<Props> getReplyById(Integer id);

    //全部真删除
    PageInfo<Props> getClear();

    //根据id更新
    PageInfo<Props> getUpdateById(Props props);
}
