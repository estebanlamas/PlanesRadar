package com.estebanlamas.planesradar.data.common;

import com.estebanlamas.planesradar.data.remote.AdsbExchangeApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestNetworkModule {

    private MockWebServer mockWebServer;
    private Retrofit retrofit;

    public TestNetworkModule() {
        this.mockWebServer = new MockWebServer();
        this.retrofit = getRetrofitTest();
    }

    private String getEndPoint() {
        return "/";
    }

    public MockWebServer getMockWebServer(){
        return this.mockWebServer;
    }

    public AdsbExchangeApi getApiService() {
        return getRetrofitTest().create(AdsbExchangeApi.class);
    }

    public OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(1, TimeUnit.SECONDS);
        builder.connectTimeout(1, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);
        return builder.build();
    }

    private Retrofit getRetrofitTest() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(mockWebServer.url(getEndPoint()))
                .client(getOkHttpClient())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
