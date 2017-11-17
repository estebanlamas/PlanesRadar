package com.estebanlamas.planesradar.data;

import com.estebanlamas.planesradar.data.remote.AdsbExchangeApi;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class BaseRepository {
    protected AdsbExchangeApi adsbExchangeApi;

    public BaseRepository(AdsbExchangeApi apiService) {
        this.adsbExchangeApi = apiService;
    }

    protected Response doCall(Call call) throws IOException {
        Response response = call.execute();
        if (response == null || !response.isSuccessful()) {
            throw new IOException();
        }else{
            return response;
        }
    }
}
