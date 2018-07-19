package com.kode.kreasi.kodekreasirecruitment.Network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://163.53.192.162";
    private static final String BASE_URL2 = "https://api.myjson.com";
    private static final String BASE_URL1 = "https://api.rajaongkir.com";
    private static final String KEY_RAJAONGKIR = "824a55a358f9102e218880420dc994a2";

    public static Retrofit getRetrofitClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getRetrofitClient2(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(
                    new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request().newBuilder()
                                    .addHeader("key", KEY_RAJAONGKIR).build();
                            return chain.proceed(request);
                        }
                    }
            ).build();

    public static Retrofit getRetrofitClient1(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL1)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
