package ru.elminn.weater_mvvm.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ru.elminn.weater_mvvm.data.network.ApiFactory;
import ru.elminn.weater_mvvm.data.network.clients.RxWeatherClient;
import ru.elminn.weater_mvvm.data.repository.weather.MvpWeatherRepository;
import ru.elminn.weater_mvvm.data.repository.weather.MvpWeatherRepositoryImpl;

public class MvpRepositoryProvider {

    private static volatile MvpRepositoryProvider sInstance;

    @Nullable
    private MvpWeatherRepository mvpWeatherRepository;

    private MvpRepositoryProvider() {
    }

    public static MvpRepositoryProvider get() {
        if (sInstance == null) {
            synchronized (MvpRepositoryProvider.class) {
                if (sInstance == null) {
                    sInstance = new MvpRepositoryProvider();
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
            mvpWeatherRepository = new MvpWeatherRepositoryImpl(getServiceInstance(RxWeatherClient.class));
        }
        return mvpWeatherRepository;
    }
}