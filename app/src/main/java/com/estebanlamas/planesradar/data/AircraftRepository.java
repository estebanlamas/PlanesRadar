package com.estebanlamas.planesradar.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.estebanlamas.planesradar.data.mapper.AircraftMapper;
import com.estebanlamas.planesradar.data.remote.AdsbExchangeApi;
import com.estebanlamas.planesradar.data.remote.response.AircraftListResponse;
import com.estebanlamas.planesradar.presentation.model.Aircraft;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by esteban on 24/9/17
 */

public class AircraftRepository extends BaseRepository{
    private MutableLiveData<List<Aircraft>> data;

    @Inject
    public AircraftRepository(AdsbExchangeApi adsbExchangeApi) {
        super(adsbExchangeApi);
        data = new MutableLiveData<>();
    }

    public LiveData<List<Aircraft>> getAircraftList() {
        adsbExchangeApi.getAircraftList().enqueue(new Callback<AircraftListResponse>() {
            @Override
            public void onResponse(@NonNull Call<AircraftListResponse> call, @NonNull Response<AircraftListResponse> response) {
                data.setValue(AircraftMapper.mapResponse(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<AircraftListResponse> call, @NonNull Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return data;
    }
}
