package ru.elminn.weater_mvvm.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DayForecastInfo {

    @SerializedName("temp")
    private float dayTempInfo;

    @SerializedName("pressure")
    private float pressure;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("weather")
    private List<WeatherInfo> weatherInfo;

    public float getDayTempInfo() {
        return dayTempInfo;
    }

    public float getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public List<WeatherInfo> getWeatherInfo() {
        return weatherInfo;
    }

    @Override
    public String toString() {
        return "DayForecastInfo{" +
                "dayTempInfo=" + dayTempInfo +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", weatherInfo=" + weatherInfo +
                '}';
    }
}
