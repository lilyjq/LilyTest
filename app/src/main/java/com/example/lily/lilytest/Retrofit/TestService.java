package com.example.lily.lilytest.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ljq
 * on 2018/2/10.
 */

public interface TestService {


    @GET("air/airCities")
    Call<AirResponse> getAirResponse(@Query("key")String key);
}
