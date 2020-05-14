package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.GameTask;
import com.outsourcing.combat.pojo.PlayRules;

import java.util.List;

public interface PlayRuleMapper {
    //添加规则
    void getInset(PlayRules playRules);

    //根据id假删除
    void getDeleteById(Integer id);

    //根据id真删除
    void getClearById(Integer id);

    //根据其他字段假删除
    void getDelete(PlayRules playRules);

    //全部真删除
    void getClear();

    //根据id还原
    void getReplyById(Integer id);

    //根据id更新
    void getUpdateById(PlayRules playRules);

    //查询所有
    List<PlayRules> getSelect();

    //查询所有未被删除
    List<PlayRules> getSelectPlayRules();

    //回收站
    List<PlayRules> getSelectDelete();

    //根据id查询回收站
    List<PlayRules> getSelectDeleteById(Integer id);

    //根据其他字段查询回收站
    List<PlayRules> getSelectDeleteBy(PlayRules playRules);

    //根据id查询
    List<PlayRules> getSelectById(Integer id);

    //根据标题模糊查询
    List<PlayRules> getSelectByTitle(String title);

    //根据内容模糊查询
    List<PlayRules> getSelectByDescription(String description);
}
