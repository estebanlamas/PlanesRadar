package com.estebanlamas.planesradar.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.estebanlamas.planesradar.PlaneRadarApplication
import com.estebanlamas.planesradar.di.component.AppComponent


/**
 * Created by esteban on 13/1/17
 */

abstract class BaseActivity : AppCompatActivity() {

    val applicationComponent: AppComponent
        get() = (application as PlaneRadarApplication).appComponent

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setModule()
        setContentView(getActivityLayout())
    }

    protected abstract fun setModule()

    protected abstract fun getActivityLayout(): Int
}
