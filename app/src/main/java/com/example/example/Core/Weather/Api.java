package com.example.example.Core.Weather;



import com.example.example.Core.Weather.Pojoclasses.object;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String Url="http://api.openweathermap.org/data/2.5/";
    @GET("forecast")
    Call<object> getTasks(@Query("q") String city, @Query("appid")String appid);
}
