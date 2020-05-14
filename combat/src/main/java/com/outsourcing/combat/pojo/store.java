package com.outsourcing.combat.pojo;

import java.io.Serializable;

public class store implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id; // 主键
    private String storeName;
    private String storeSort;
    private String storeShelvesTime;
    private String storeTakeTime;
    private Integer modelId; // 外键model的id

    public store(Integer id, String storeName, String storeSort, String storeShelvesTime, String storeTakeTime, Integer modelId) {
        this.id = id;
        this.storeName = storeName;
        this.storeSort = storeSort;
        this.storeShelvesTime = storeShelvesTime;
        this.storeTakeTime = storeTakeTime;
        this.modelId = modelId;
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
     * Gets the value of storeName.
     *
     * @return the value of storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Sets the storeName.
     *
     * <p>You can use getStoreName() to get the value of storeName</p>
     *
     * @param storeName
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    /**
     * Gets the value of storeSort.
     *
     * @return the value of storeSort
     */
    public String getStoreSort() {
        return storeSort;
    }

    /**
     * Sets the storeSort.
     *
     * <p>You can use getStoreSort() to get the value of storeSort</p>
     *
     * @param storeSort
     */
    public void setStoreSort(String storeSort) {
        this.storeSort = storeSort == null ? null : storeSort.trim();
    }

    /**
     * Gets the value of storeShelvesTime.
     *
     * @return the value of storeShelvesTime
     */
    public String getStoreShelvesTime() {
        return storeShelvesTime;
    }

    /**
     * Sets the storeShelvesTime.
     *
     * <p>You can use getStoreShelvesTime() to get the value of storeShelvesTime</p>
     *
     * @param storeShelvesTime
     */
    public void setStoreShelvesTime(String storeShelvesTime) {
        this.storeShelvesTime = storeShelvesTime == null ? null : storeShelvesTime.trim();
    }

    /**
     * Gets the value of storeTakeTime.
     *
     * @return the value of storeTakeTime
     */
    public String getStoreTakeTime() {
        return storeTakeTime;
    }

    /**
     * Sets the storeTakeTime.
     *
     * <p>You can use getStoreTakeTime() to get the value of storeTakeTime</p>
     *
     * @param storeTakeTime
     */
    public void setStoreTakeTime(String storeTakeTime) {
        this.storeTakeTime = storeTakeTime == null ? null : storeTakeTime.trim();
    }

    /**
     * Gets the value of modelId.
     *
     * @return the value of modelId
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * Sets the modelId.
     *
     * <p>You can use getModelId() to get the value of modelId</p>
     *
     * @param modelId
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
}
