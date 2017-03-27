package com.vkhodonovych.sampledagger2.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vkhodonovych.sampledagger2.R;

import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingActivityInjector;

public class MainActivity extends AppCompatActivity implements HasDispatchingActivityInjector {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return null;
    }
}
