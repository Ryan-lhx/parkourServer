package com.outsourcing.combat.pojo;

import java.io.Serializable;

public class questionAndAnswer implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String questionTitle;
    private String questionContent;
    private String questionSort;
    private String questionDifficult;
    private Integer delete1;
    private String errorContent;
    private String correctContent;

    @Override
    public String toString() {
        return "questionAndAnswer{" +
                "id=" + id +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", questionSort='" + questionSort + '\'' +
                ", questionDifficult='" + questionDifficult + '\'' +
                ", delete1=" + delete1 +
                ", errorContent='" + errorContent + '\'' +
                ", correctContent='" + correctContent + '\'' +
                '}';
    }

    /**
     * Gets the value of id.
     *
     * @return the value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * <p>You can use getId() to get the value of id</p>
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the value of questionTitle.
     *
     * @return the value of questionTitle
     */
    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     * Sets the questionTitle.
     *
     * <p>You can use getQuestionTitle() to get the value of questionTitle</p>
     *
     * @param questionTitle
     */
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle == null ? null : questionTitle.trim();
    }

    /**
     * Gets the value of questionContent.
     *
     * @return the value of questionContent
     */
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     * Sets the questionContent.
     *
     * <p>You can use getQuestionContent() to get the value of questionContent</p>
     *
     * @param questionContent
     */
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    /**
     * Gets the value of questionSort.
     *
     * @return the value of questionSort
     */
    public String getQuestionSort() {
        return questionSort;
    }

    /**
     * Sets the questionSort.
     *
     * <p>You can use getQuestionSort() to get the value of questionSort</p>
     *
     * @param questionSort
     */
    public void setQuestionSort(String questionSort) {
        this.questionSort = questionSort == null ? null : questionSort.trim();
    }

    /**
     * Gets the value of questionDifficult.
     *
     * @return the value of questionDifficult
     */
    public String getQuestionDifficult() {
        return questionDifficult;
    }

    /**
     * Sets the questionDifficult.
     *
     * <p>You can use getQuestionDifficult() to get the value of questionDifficult</p>
     *
     * @param questionDifficult
     */
    public void setQuestionDifficult(String questionDifficult) {
        this.questionDifficult = questionDifficult == null ? null : questionDifficult.trim();
    }

    /**
     * Gets the value of delete1.
     *
     * @return the value of delete1
     */
    public Integer getDelete1() {
        return delete1;
    }

    /**
     * Sets the delete1.
     *
     * <p>You can use getDelete1() to get the value of delete1</p>
     *
     * @param delete1
     */
    public void setDelete1(Integer delete1) {
        this.delete1 = delete1;
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
