package ru.elminn.weater_mvvm.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DayForecastInfo {
    public static final String TABLE_NAME = "DayForecastInfo";

    public DayForecastInfo(float dayTempInfo, float pressure, int humidity) {
        this.dayTempInfo = dayTempInfo;
        this.pressure = pressure;
        this.humidity = humidity;
    }

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
        return DayForecastInfo.TABLE_NAME + "{" +
                "dayTempInfo=" + dayTempInfo +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", weatherInfo=" + weatherInfo +
                '}';
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE DayForecastInfo (" +
                    " ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " dayTempInfo Float (4,3)," +
                    " pressure Float (4,3)," +
                    " humidity INTEGER)";
}
