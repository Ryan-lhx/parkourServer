package com.outsourcing.combat.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GameRule {
    private Integer id;
    private String ruleTitle;
    private String ruleDescription;
    private Integer RuleDelete;
}
