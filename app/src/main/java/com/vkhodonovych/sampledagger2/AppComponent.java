package com.vkhodonovych.sampledagger2;

import com.vkhodonovych.sampledagger2.ui.MainActivityModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;


@Component(modules = {AndroidInjectionModule.class, AppModule.class, MainActivityModule.class})
public interface AppComponent {

    void inject(MyApp app);
}
