package com.estebanlamas.planesradar.presentation;

/**
 * Created by esteban on 26/12/17
 */

public class Presenter<T> {
    protected T view;

    public void attachView(T view) {
        this.view = view;
    }
}
