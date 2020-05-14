package com.outsourcing.combat.pojo;

import java.io.Serializable;

public class gameSkin implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer skinId;
    private String skinName;
    private String skinDescription;
    private String modelId;

    public gameSkin(Integer skinId, String skinName, String skinDescription, String modelId) {
        this.skinId = skinId;
        this.skinName = skinName;
        this.skinDescription = skinDescription;
        this.modelId = modelId;
    }

    /**
     * Gets the value of skinId.
     *
     * @return the value of skinId
     */
    public Integer getSkinId() {
        return skinId;
    }

    /**
     * Sets the skinId.
     *
     * <p>You can use getSkinId() to get the value of skinId</p>
     *
     * @param skinId
     */
    public void setSkinId(Integer skinId) {
        this.skinId = skinId;
    }

    /**
     * Gets the value of skinName.
     *
     * @return the value of skinName
     */
    public String getSkinName() {
        return skinName;
    }

    /**
     * Sets the skinName.
     *
     * <p>You can use getSkinName() to get the value of skinName</p>
     *
     * @param skinName
     */
    public void setSkinName(String skinName) {
        this.skinName = skinName == null ? null : skinName.trim();
    }

    /**
     * Gets the value of skinDescription.
     *
     * @return the value of skinDescription
     */
    public String getSkinDescription() {
        return skinDescription;
    }

    /**
     * Sets the skinDescription.
     *
     * <p>You can use getSkinDescription() to get the value of skinDescription</p>
     *
     * @param skinDescription
     */
    public void setSkinDescription(String skinDescription) {
        this.skinDescription = skinDescription == null ? null : skinDescription.trim();
    }

    /**
     * Gets the value of modelId.
     *
     * @return the value of modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * Sets the modelId.
     *
     * <p>You can use getModelId() to get the value of modelId</p>
     *
     * @param modelId
     */
    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }
}
