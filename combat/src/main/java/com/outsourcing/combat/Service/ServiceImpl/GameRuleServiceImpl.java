package com.outsourcing.combat.Service.ServiceImpl;


import com.outsourcing.combat.Service.GameRuleService;
import com.outsourcing.combat.mapper.GameRuleMapper;
import com.outsourcing.combat.pojo.GameRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameRuleServiceImpl implements GameRuleService {

    @Autowired
    GameRuleMapper gameRuleMapper;

    @Override
    public int getInsetGameRule(GameRule gameRule) {
        int i = gameRuleMapper.getInsetGameRule(gameRule);
        return i;
    }

    @Override
    public int getDeleteGameRuleById(Integer id) {
        int i = gameRuleMapper.getDeleteGameRuleById(id);
        return i;
    }

    @Override
    public int getDeleteClearById(Integer id) {
        int i = gameRuleMapper.getDeleteClearById(id);
        return i;
    }

    @Override
    public int getUpdateById(GameRule gameRule) {
        int i = gameRuleMapper.getUpdateById(gameRule);
        return i;
    }

    @Override
    public List<GameRule> getSelect() {
        return gameRuleMapper.getSelect();
    }

    @Override
    public List<GameRule> getRuleDelete() {
        return gameRuleMapper.getRuleDelete();
    }

    @Override
    public List<GameRule> getSelectOneById(Integer id) {
        return gameRuleMapper.getSelectOneById(id);
    }

    @Override
    public List<GameRule> getSelectAllByRuleTitle(String rule_title) {
        return gameRuleMapper.getSelectAllByRuleTitle(rule_title);
    }

    @Override
    public List<GameRule> getSelectAllByRuleDescription(String rule_description) {
        return gameRuleMapper.getSelectAllByRuleDescription(rule_description);
    }
}
