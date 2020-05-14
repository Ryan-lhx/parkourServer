package com.outsourcing.combat.Service;


import com.outsourcing.combat.pojo.GameRule;

import java.util.List;

public interface GameRuleService {
    //添加规则
    int getInsetGameRule(GameRule gameRule);

    //根据id假删除
    int getDeleteGameRuleById(Integer id);

    //真删除
    int getDeleteClearById(Integer id);

    //更新
    int getUpdateById(GameRule gameRule);

    //查询所有
    List<GameRule> getSelect();

    //回收站
    List<GameRule> getRuleDelete();

    //id查询
    List<GameRule> getSelectOneById(Integer id);

    //根据标题模糊查询
    List<GameRule> getSelectAllByRuleTitle(String rule_title);

    //根据内容模糊查询
    List<GameRule> getSelectAllByRuleDescription(String rule_description);
}
