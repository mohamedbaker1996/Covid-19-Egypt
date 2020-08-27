package com.mohamed.covid_19_egypt.data.api;

import com.mohamed.covid_19_egypt.data.model.CountryStatsEgypt;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    /*

    @GET("donation-requests")
    Call<Donations> donationRequsests (@Query("api_token")String apiToken,
                             @Query("page") int page ); */

    @GET("egypt")
    Call <CountryStatsEgypt> countryState (@Query("egypt") String egypt);

    @GET("world")
    Call <CountryStatsEgypt> worldState (@Query("world") String world);
}
