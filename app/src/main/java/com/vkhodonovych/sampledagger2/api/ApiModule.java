package com.vkhodonovych.sampledagger2.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vkhodonovych.sampledagger2.api.deserializer.PageDeserializer;
import com.vkhodonovych.sampledagger2.api.model.Pages;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    private static final HttpUrl API_URL = HttpUrl.parse("https://en.wikipedia.org/");

    @Provides
    @Singleton
    HttpUrl provideBaseUrl() {
        return API_URL;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapter(Pages.class, new PageDeserializer())
                .create();

    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(HttpUrl baseUrl, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    WikiService provideWikiService(Retrofit retrofit) {
        return retrofit.create(WikiService.class);
    }
}
