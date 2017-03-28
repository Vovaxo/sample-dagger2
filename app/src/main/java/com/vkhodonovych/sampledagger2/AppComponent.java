package com.vkhodonovych.sampledagger2;

import com.vkhodonovych.sampledagger2.api.ApiModule;
import com.vkhodonovych.sampledagger2.ui.MainActivityModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class,
        ApiModule.class})
public interface AppComponent {

    void inject(MyApp app);
}
