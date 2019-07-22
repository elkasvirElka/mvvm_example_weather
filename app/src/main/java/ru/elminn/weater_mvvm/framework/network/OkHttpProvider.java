package ru.elminn.weater_mvvm.framework.network;

import androidx.annotation.NonNull;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.elminn.weater_mvvm.BuildConfig;

public final class OkHttpProvider {

    private OkHttpProvider() {
    }

    @NonNull
    public static OkHttpClient provideClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new WeatherApiKeyInterceptor());
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        return builder.build();
    }

}