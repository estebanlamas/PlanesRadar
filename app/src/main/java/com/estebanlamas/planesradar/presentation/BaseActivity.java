package com.estebanlamas.planesradar.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.estebanlamas.planesradar.PlaneRadarApplication;
import com.estebanlamas.planesradar.di.component.AppComponent;


/**
 * Created by esteban on 13/1/17
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setModule();
        setContentView(getActivityLayout());
    }

    public AppComponent getApplicationComponent() {
        return ((PlaneRadarApplication) getApplication()).getAppComponent();
    }

    protected abstract void setModule();

    protected abstract int getActivityLayout();
}
