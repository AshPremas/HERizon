package com.example.herizon;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("modules")
    Call<List<Module>> getModules();

    @POST("modules")
    Call<Module> createModule(@Body Module module);
}
