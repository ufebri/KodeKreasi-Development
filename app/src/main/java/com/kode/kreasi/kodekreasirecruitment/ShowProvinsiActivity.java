package com.kode.kreasi.kodekreasirecruitment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.kode.kreasi.kodekreasirecruitment.Adapter.ProvinceAdapter;
import com.kode.kreasi.kodekreasirecruitment.Interface.DataService;
import com.kode.kreasi.kodekreasirecruitment.Network.RetrofitClient;


public class ShowProvinsiActivity extends AppCompatActivity {

    private ProvinceAdapter adapter;
    private RecyclerView recyclerView;
    private DataService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_provinsi);
        DataService service = RetrofitClient.getRetrofitClient2().create(DataService.class);
    }
//
//    private void loadData() {
//        Call<RajongResponse> call = service.getProvince();
//        service.getProvince().enqueue(new Callback<ResultsProvince>() {
//            @Override
//            public void onResponse(Call<ResultsProvince> call, Response<ResultsProvince> response) {
//                if (response.isSuccessful()){
//                    adapter.
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResultsProvince> call, Throwable t) {
//
//            }
//        });
//        Log.wtf("URL Called", call.request().url() + "");
//
//        call.enqueue(new Callback<RajongResponse>() {
//            @Override
//            public void onResponse(Call<RajongResponse> call, Response<RajongResponse> response) {
//                generateProvinceList(response.body().getRajaongkir());
//            }
//
//            @Override
//            public void onFailure(Call<RajongResponse> call, Throwable t) {
//                Toast.makeText(ShowProvinsiActivity.this, "Something wtong......" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void generateProvinceList(List<ResultsProvince> provinceArrayList){
//        recyclerView = findViewById(R.id.rv_provinsi);
//        adapter = new ProvinceAdapter(this, new provinceArrayList);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShowProvinsiActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//    }
}
