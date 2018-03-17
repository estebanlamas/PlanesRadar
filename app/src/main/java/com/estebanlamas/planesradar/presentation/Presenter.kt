package com.estebanlamas.planesradar.presentation

/**
 * Created by esteban on 26/12/17
 */

open class Presenter<T> {
    var view: T? = null

    fun attachView(view: T) {
        this.view = view
    }
}
