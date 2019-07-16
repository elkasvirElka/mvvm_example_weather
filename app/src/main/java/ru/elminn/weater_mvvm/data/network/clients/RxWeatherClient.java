package ru.elminn.weater_mvvm.data.network.clients;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.elminn.weater_mvvm.data.models.DayForecastResponse;

public interface RxWeatherClient {

    @GET("/data/2.5/weather")
    Single<DayForecastResponse> getDailyForecastByCity(@Query("q") String cityName);

}