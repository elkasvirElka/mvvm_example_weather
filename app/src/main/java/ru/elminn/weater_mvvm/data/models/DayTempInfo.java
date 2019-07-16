package ru.elminn.weater_mvvm.data.models;

import com.google.gson.annotations.SerializedName;

public class DayTempInfo {

    @SerializedName("day")
    private float dayTemp;

    @SerializedName("min")
    private float minTemp;

    @SerializedName("max")
    private float maxTemp;

    @SerializedName("night")
    private float nightTemp;

    @SerializedName("eve")
    private float eveningTemp;

    @SerializedName("morn")
    private float morningTemp;


    public float getDayTemp() {
        return dayTemp;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public float getNightTemp() {
        return nightTemp;
    }

    public float getEveningTemp() {
        return eveningTemp;
    }

    public float getMorningTemp() {
        return morningTemp;
    }
}
