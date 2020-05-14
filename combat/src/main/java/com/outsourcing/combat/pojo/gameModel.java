package com.outsourcing.combat.pojo;

import java.io.Serializable;

public class gameModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id; // 主键
    private String modelName;
    private String modelSort;
    private String modelUrl;
    private String modelAddTime;
    private String modelChangeTime;
    private Integer delete1;

    @Override
    public String toString() {
        return "gameModel{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", modelSort='" + modelSort + '\'' +
                ", modelUrl='" + modelUrl + '\'' +
                ", modelAddTime='" + modelAddTime + '\'' +
                ", modelChangeTime='" + modelChangeTime + '\'' +
                ", delete1=" + delete1 +
                '}';
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

    public gameModel(Integer id, String modelName, String modelSort, String modelUrl, String modelAddTime, String modelChangeTime) {
        this.id = id;
        this.modelName = modelName;
        this.modelSort = modelSort;
        this.modelUrl = modelUrl;
        this.modelAddTime = modelAddTime;
        this.modelChangeTime = modelChangeTime;
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
     * Gets the value of modelName.
     *
     * @return the value of modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the modelName.
     *
     * <p>You can use getModelName() to get the value of modelName</p>
     *
     * @param modelName
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    /**
     * Gets the value of modelSort.
     *
     * @return the value of modelSort
     */
    public String getModelSort() {
        return modelSort;
    }

    /**
     * Sets the modelSort.
     *
     * <p>You can use getModelSort() to get the value of modelSort</p>
     *
     * @param modelSort
     */
    public void setModelSort(String modelSort) {
        this.modelSort = modelSort == null ? null : modelSort.trim();
    }

    /**
     * Gets the value of modelUrl.
     *
     * @return the value of modelUrl
     */
    public String getModelUrl() {
        return modelUrl;
    }

    /**
     * Sets the modelUrl.
     *
     * <p>You can use getModelUrl() to get the value of modelUrl</p>
     *
     * @param modelUrl
     */
    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl == null ? null : modelUrl.trim();
    }

    /**
     * Gets the value of modelAddTime.
     *
     * @return the value of modelAddTime
     */
    public String getModelAddTime() {
        return modelAddTime;
    }

    /**
     * Sets the modelAddTime.
     *
     * <p>You can use getModelAddTime() to get the value of modelAddTime</p>
     *
     * @param modelAddTime
     */
    public void setModelAddTime(String modelAddTime) {
        this.modelAddTime = modelAddTime == null ? null : modelAddTime.trim();
    }

    /**
     * Gets the value of modelChangeTime.
     *
     * @return the value of modelChangeTime
     */
    public String getModelChangeTime() {
        return modelChangeTime;
    }

    /**
     * Sets the modelChangeTime.
     *
     * <p>You can use getModelChangeTime() to get the value of modelChangeTime</p>
     *
     * @param modelChangeTime
     */
    public void setModelChangeTime(String modelChangeTime) {
        this.modelChangeTime = modelChangeTime == null ? null : modelChangeTime.trim();
    }
}
