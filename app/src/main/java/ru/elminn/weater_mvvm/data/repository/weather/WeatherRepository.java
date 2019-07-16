package ru.elminn.weater_mvvm.data.repository.weather;

import androidx.annotation.NonNull;
import io.reactivex.Single;
import ru.elminn.weater_mvvm.data.models.DayForecastResponse;

public interface MvpWeatherRepository {

    Single<DayForecastResponse> getDayForecast(@NonNull String city);

}
