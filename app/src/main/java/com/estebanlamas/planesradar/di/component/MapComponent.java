package com.estebanlamas.planesradar.di.component;


import com.estebanlamas.planesradar.presentation.map.MapActivity;
import com.estebanlamas.planesradar.di.module.MapModule;

import dagger.Subcomponent;

@Subcomponent(modules = {MapModule.class})
public interface MapComponent {
        void inject(MapActivity activity);
}
