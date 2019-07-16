package ru.elminn.weater_mvvm.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ru.elminn.weater_mvvm.data.network.ApiFactory;
import ru.elminn.weater_mvvm.data.network.clients.RxWeatherClient;
import ru.elminn.weater_mvvm.data.repository.weather.MvpWeatherRepository;
import ru.elminn.weater_mvvm.data.repository.weather.WeatherRepositoryImpl;

public class RepositoryProvider {

    private static volatile RepositoryProvider sInstance;

    @Nullable
    private MvpWeatherRepository mvpWeatherRepository;

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
    public MvpWeatherRepository provideNewsFeedRepository() {
        if (mvpWeatherRepository == null) {
            mvpWeatherRepository = new WeatherRepositoryImpl(getServiceInstance(RxWeatherClient.class));
        }
        return mvpWeatherRepository;
    }
}