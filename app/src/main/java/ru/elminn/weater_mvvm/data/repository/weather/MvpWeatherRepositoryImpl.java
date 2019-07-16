package ru.elminn.weater_mvvm.data.repository.weather;

import androidx.annotation.NonNull;
import io.reactivex.Single;
import ru.elminn.weater_mvvm.data.models.DayForecastResponse;
import ru.elminn.weater_mvvm.data.network.clients.RxWeatherClient;

public class MvpWeatherRepositoryImpl implements MvpWeatherRepository {

    @NonNull
    private final RxWeatherClient client;

    public MvpWeatherRepositoryImpl(@NonNull RxWeatherClient client) {
        this.client = client;
    }

    @Override
    public Single<DayForecastResponse> getDayForecast(@NonNull String city) {
        return client.getDailyForecastByCity(city);
    }
}
