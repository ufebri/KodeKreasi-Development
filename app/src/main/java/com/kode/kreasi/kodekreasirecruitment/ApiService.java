package com.kode.kreasi.kodekreasirecruitment;

import android.renderscript.Sampler;
import android.widget.Spinner;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService{

    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> daftar (@Field("Nama") String nama,
                        @Field("Alamat") String alamat,
                        @Field("TglLahir") String tgllahir,
                        @Field("Telpon") String telpon);
}