package com.vkhodonovych.sampledagger2.ui;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;


@Subcomponent
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
