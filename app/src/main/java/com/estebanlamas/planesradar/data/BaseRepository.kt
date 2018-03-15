package com.estebanlamas.planesradar.data

import com.estebanlamas.planesradar.data.remote.AdsbExchangeApi

import java.io.IOException

import retrofit2.Call
import retrofit2.Response

open class BaseRepository(protected var adsbExchangeApi: AdsbExchangeApi) {

    @Throws(IOException::class)
    protected fun doCall(call: Call<*>): Response<*> {
        val response = call.execute()
        return if (response == null || !response.isSuccessful) {
            throw IOException()
        } else {
            response
        }
    }
}
