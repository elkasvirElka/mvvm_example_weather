package ru.elminn.weater_mvvm.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ru.elminn.weater_mvvm.framework.network.ApiFactory;
import ru.elminn.weater_mvvm.framework.network.clients.RxWeatherClient;
import ru.elminn.weater_mvvm.data.repository.weather.WeatherRepository;
import ru.elminn.weater_mvvm.data.repository.weather.WeatherRepositoryImpl;

public class RepositoryProvider {

    private static volatile RepositoryProvider sInstance;

    @Nullable
    private WeatherRepository weatherRepository;

    private RepositoryProvider() {
    }

    public static RepositoryProvider get() {
        if (sInstance == null) {
            synchronized (RepositoryProvider.class) {
                if (sInstance == null) {
                    sInstance = new RepositoryProvider();
                }
            }
        }
        return sInstance;
    }

    @NonNull
    private static <T> T getServiceInstance(Class<T> clazz) {
        return ApiFactory.getRetrofitInstance().create(clazz);
    }

    @NonNull
    public WeatherRepository provideNewsFeedRepository() {
        if (weatherRepository == null) {
            weatherRepository = new WeatherRepositoryImpl(getServiceInstance(RxWeatherClient.class));
        }
        return weatherRepository;
    }
}