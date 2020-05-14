package com.outsourcing.combat.Service;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.PlayRules;

import java.util.List;

public interface PlayRuleService {
    //添加规则
    PageInfo<PlayRules> getInset(PlayRules playRules);

    //根据id假删除
    PageInfo<PlayRules> getDeleteById(Integer id);

    //真删除
    PageInfo<PlayRules> getClearById(Integer id);

    //根据其他字段假删除
    PageInfo<PlayRules> getDelete(PlayRules playRules);

    //全部真删除
    PageInfo<PlayRules> getClear();

    //根据id还原
    PageInfo<PlayRules> getReplyById(Integer id);

    //更新
    PageInfo<PlayRules> getUpdateById(PlayRules playRules);

    //查询所有
    PageInfo<PlayRules> getSelect();

    //查询所有未被删除
    PageInfo<PlayRules> getSelectPlayRules(Integer currentPage, Integer pageSize);

    //回收站
    PageInfo<PlayRules> getSelectDelete(Integer currentPage, Integer pageSize);

    //根据id查询回收站
    PageInfo<PlayRules> getSelectDeleteById(Integer id);

    //根据其他字段查询回收站
//    PageInfo<PlayRules> getSelectDeleteBy(PlayRules playRules);
    //id查询
    PageInfo<PlayRules> getSelectById(Integer id);

    //根据标题模糊查询
    PageInfo<PlayRules> getSelectByTitle(String title, Integer currentPage, Integer pageSize);

    //根据内容模糊查询
    PageInfo<PlayRules> getSelectByDescription(String description, Integer currentPage, Integer pageSize);
}
