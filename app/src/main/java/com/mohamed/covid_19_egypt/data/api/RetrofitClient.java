package com.mohamed.covid_19_egypt.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
   // private static String BASE_URL = "https://corona-virus-stats.herokuapp.com/api/v1/cases/";
    private static String BASE_URL = "https://coronavirus-19-api.herokuapp.com/countries/";
    public  static ApiService getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ApiService.class);
    }
}
