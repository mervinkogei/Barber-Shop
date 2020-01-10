package com.example.barbershop.Interface;

import com.example.barbershop.Models.BarberStylistResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BarberApi {
    @GET("https://pixabay.com/api/?key=14866926-2e090587c0327878db3243927&q=men+haircut&image_type=photo&pretty=true")
    Call<BarberStylistResponse> getBarberStylist(
//            @Query("q") String image
//            @Query("tag") String tag
    );
}
