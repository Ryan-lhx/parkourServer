package com.outsourcing.combat.pojo;


import com.outsourcing.combat.utils.ToolUtil;

import java.io.Serializable;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Getter
//@Setter
//@ToString
public class question_bank implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String QuestionTitle;
    private String QuestionContent;
    private String QuestionSort;
    private String QuestionDifficult;
    private Integer delete1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return QuestionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        QuestionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return QuestionContent;
    }

    public void setQuestionContent(String questionContent) {
        QuestionContent = questionContent;
    }

    public String getQuestionSort() {
        return QuestionSort;
    }

    public void setQuestionSort(String questionSort) {
        QuestionSort = questionSort;
    }

    public String getQuestionDifficult() {
        return QuestionDifficult;
    }

    public void setQuestionDifficult(String questionDifficult) {
        QuestionDifficult = questionDifficult;
    }

    public Integer getDelete1() {
        return delete1;
    }

    public void setDelete1(Integer delete1) {
        if (ToolUtil.equalBool(delete1)) {
            this.delete1 = delete1;
        } else {
            this.delete1 = 1;
        }

    }

    @Override
    public String toString() {
        return "question_bank{" +
                "id=" + id +
                ", QuestionTitle='" + QuestionTitle + '\'' +
                ", QuestionContent='" + QuestionContent + '\'' +
                ", QuestionSort='" + QuestionSort + '\'' +
                ", QuestionDifficult='" + QuestionDifficult + '\'' +
                ", delete1=" + delete1 +
                '}';
    }
}
