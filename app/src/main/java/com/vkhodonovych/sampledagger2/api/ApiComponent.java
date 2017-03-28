package com.vkhodonovych.sampledagger2.api;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {
    Retrofit retrofit();
}
