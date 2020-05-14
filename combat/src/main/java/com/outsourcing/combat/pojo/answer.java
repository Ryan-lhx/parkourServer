package com.outsourcing.combat.pojo;

import java.io.Serializable;

/**
 * 题库的答案
 */
public class answer implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 关联题库的id
     */
    private Integer questionId;
    private String errorContent;
    private String correctContent;

    @Override
    public String toString() {
        return "answer{" +
                "questionId=" + questionId +
                ", errorContent='" + errorContent + '\'' +
                ", correctContent='" + correctContent + '\'' +
                '}';
    }

    /**
     * Gets the value of questionId.
     *
     * @return the value of questionId
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * Sets the questionId.
     *
     * <p>You can use getQuestionId() to get the value of questionId</p>
     *
     * @param questionId
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * Gets the value of errorContent.
     *
     * @return the value of errorContent
     */
    public String getErrorContent() {
        return errorContent;
    }

    /**
     * Sets the errorContent.
     *
     * <p>You can use getErrorContent() to get the value of errorContent</p>
     *
     * @param errorContent
     */
    public void setErrorContent(String errorContent) {
        this.errorContent = errorContent == null ? null : errorContent.trim();
    }

    /**
     * Gets the value of correctContent.
     *
     * @return the value of correctContent
     */
    public String getCorrectContent() {
        return correctContent;
    }

    /**
     * Sets the correctContent.
     *
     * <p>You can use getCorrectContent() to get the value of correctContent</p>
     *
     * @param correctContent
     */
    public void setCorrectContent(String correctContent) {
        this.correctContent = correctContent == null ? null : correctContent.trim();
    }
}
