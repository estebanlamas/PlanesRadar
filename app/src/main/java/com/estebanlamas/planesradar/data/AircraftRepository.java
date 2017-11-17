package com.estebanlamas.planesradar.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.estebanlamas.planesradar.data.remote.AdsbExchangeApi;
import com.estebanlamas.planesradar.data.remote.model.AircraftListResponse;
import com.estebanlamas.planesradar.data.remote.model.AircraftResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by esteban on 24/9/17
 */

public class AircraftRepository extends BaseRepository{

    public AircraftRepository(AdsbExchangeApi adsbExchangeApi) {
        super(adsbExchangeApi);
    }

    public LiveData<List<AircraftResponse>> getAircraftList() {
        final MutableLiveData<List<AircraftResponse>> data = new MutableLiveData<>();
        adsbExchangeApi.getAircraftList().enqueue(new Callback<AircraftListResponse>() {
            @Override
            public void onResponse(Call<AircraftListResponse> call, Response<AircraftListResponse> response) {
                data.setValue(response.body().getAcList());
            }

            @Override
            public void onFailure(Call<AircraftListResponse> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return data;
    }
}
