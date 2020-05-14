package com.outsourcing.combat.pojo;

import java.io.Serializable;

public class schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String strokeIncomingSite;
    private String strokeBoardingTime;
    private String strokeOutSite;
    private Integer carId;
    private Integer userId;

    public schedule(Integer id, String strokeIncomingSite, String strokeBoardingTime, String strokeOutSite, Integer carId, Integer userId) {
        this.id = id;
        this.strokeIncomingSite = strokeIncomingSite;
        this.strokeBoardingTime = strokeBoardingTime;
        this.strokeOutSite = strokeOutSite;
        this.carId = carId;
        this.userId = userId;
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
     * Gets the value of strokeIncomingSite.
     *
     * @return the value of strokeIncomingSite
     */
    public String getStrokeIncomingSite() {
        return strokeIncomingSite;
    }

    /**
     * Sets the strokeIncomingSite.
     *
     * <p>You can use getStrokeIncomingSite() to get the value of strokeIncomingSite</p>
     *
     * @param strokeIncomingSite
     */
    public void setStrokeIncomingSite(String strokeIncomingSite) {
        this.strokeIncomingSite = strokeIncomingSite == null ? null : strokeIncomingSite.trim();
    }

    /**
     * Gets the value of strokeBoardingTime.
     *
     * @return the value of strokeBoardingTime
     */
    public String getStrokeBoardingTime() {
        return strokeBoardingTime;
    }

    /**
     * Sets the strokeBoardingTime.
     *
     * <p>You can use getStrokeBoardingTime() to get the value of strokeBoardingTime</p>
     *
     * @param strokeBoardingTime
     */
    public void setStrokeBoardingTime(String strokeBoardingTime) {
        this.strokeBoardingTime = strokeBoardingTime == null ? null : strokeBoardingTime.trim();
    }

    /**
     * Gets the value of strokeOutSite.
     *
     * @return the value of strokeOutSite
     */
    public String getStrokeOutSite() {
        return strokeOutSite;
    }

    /**
     * Sets the strokeOutSite.
     *
     * <p>You can use getStrokeOutSite() to get the value of strokeOutSite</p>
     *
     * @param strokeOutSite
     */
    public void setStrokeOutSite(String strokeOutSite) {
        this.strokeOutSite = strokeOutSite == null ? null : strokeOutSite.trim();
    }

    /**
     * Gets the value of carId.
     *
     * @return the value of carId
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * Sets the carId.
     *
     * <p>You can use getCarId() to get the value of carId</p>
     *
     * @param carId
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * Gets the value of userId.
     *
     * @return the value of userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the userId.
     *
     * <p>You can use getUserId() to get the value of userId</p>
     *
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
