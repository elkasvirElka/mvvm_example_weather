package ru.elminn.weater_mvvm.data.models;

import com.google.gson.annotations.SerializedName;

public class WeatherInfo {

    @SerializedName("id")
    private long id;

    @SerializedName("main")
    private String weatherMainInfo;

    @SerializedName("description")
    private String weatherDescription;

    @SerializedName("icon")
    private String iconUrl;


    public long getId() {
        return id;
    }

    public String getWeatherMainInfo() {
        return weatherMainInfo;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}
