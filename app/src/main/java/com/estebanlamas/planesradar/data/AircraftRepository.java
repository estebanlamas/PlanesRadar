package com.estebanlamas.planesradar.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

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
    private MutableLiveData<List<AircraftResponse>> data;

    public AircraftRepository(AdsbExchangeApi adsbExchangeApi) {
        super(adsbExchangeApi);
        data = new MutableLiveData<>();
    }

    public LiveData<List<AircraftResponse>> getAircraftList() {
        adsbExchangeApi.getAircraftList().enqueue(new Callback<AircraftListResponse>() {
            @Override
            public void onResponse(@NonNull Call<AircraftListResponse> call, @NonNull Response<AircraftListResponse> response) {
                data.setValue(response.body().getAcList());
            }

            @Override
            public void onFailure(@NonNull Call<AircraftListResponse> call, @NonNull Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return data;
    }
}
