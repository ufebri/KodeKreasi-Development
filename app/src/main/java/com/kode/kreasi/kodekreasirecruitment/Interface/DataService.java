package com.kode.kreasi.kodekreasirecruitment.Interface;

import com.kode.kreasi.kodekreasirecruitment.Model.DataAlamat;
import com.kode.kreasi.kodekreasirecruitment.Model.NoticeList;
import com.kode.kreasi.kodekreasirecruitment.Model.RajaOngkir.RajongResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET("/apitesandroid/public/alamat")
    Call<DataAlamat> getAlamat();

    @GET("/bins/1bsqcn/")
    Call<NoticeList> getNoticeData();

    @GET("/starter/province")
    Call<RajongResponse> getProvince();

//    @GET("/starter/province")
//    Call<Noti>

    @POST("/apitesandroid/public/alamat")
    @FormUrlEncoded
    Call<DataAlamat> postAlamat(@Body DataAlamat dataAlamat);
//    Call<DataAlamat> postAlamat(@Field("id") String id,
//                                @Field("nama") String nama,
//                                @Field("alamat") String alamat,
//                                @Field("provinsi") String provinsi,
//                                @Field("kota") String kota,
//                                @Field("tanggal_lahir") String tanggal_lahir,
//                                @Field("no_hp") String no_hp,
//                                @Field("created_at") String created_at);
}
