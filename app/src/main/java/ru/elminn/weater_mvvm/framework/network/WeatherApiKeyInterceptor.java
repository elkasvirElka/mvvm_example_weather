package ru.elminn.weater_mvvm.framework.network;

import androidx.annotation.NonNull;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ru.elminn.weater_mvvm.BuildConfig;

import java.io.IOException;

public class WeatherApiKeyInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        final Request original = chain.request();
        final HttpUrl originalHttpUrl = original.url();
        final HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("appid", BuildConfig.WEATHER_API_KEY)
                .build();

        return chain.proceed(original.newBuilder().url(url).build());
    }
}