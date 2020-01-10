package com.example.barbershop.Models;

import com.example.barbershop.Interface.BarberApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.barbershop.Constants.BARBER_API_KEY;
import static com.example.barbershop.Constants.BARBER_BASE_URL;

public class BarberClient {
    private static Retrofit retrofit = null;

    public static BarberApi getClient() {

//        if (retrofit == null) {
//            OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                            Request newRequest  = chain.request().newBuilder()
//                                    .addHeader("Authorization", BARBER_API_KEY)
//                                    .build();
//                            return chain.proceed(newRequest);
//                        }
//                    })
//                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BARBER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        return retrofit.create(BarberApi.class);
    }
}
