package com.kode.kreasi.kodekreasirecruitment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.kode.kreasi.kodekreasirecruitment.Adapter.AlamatAdapter;
import com.kode.kreasi.kodekreasirecruitment.Interface.DataService;
import com.kode.kreasi.kodekreasirecruitment.Model.Alamat;
import com.kode.kreasi.kodekreasirecruitment.Model.DataAlamat;
import com.kode.kreasi.kodekreasirecruitment.Network.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowDataActivity extends AppCompatActivity {

    private AlamatAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        DataService service = RetrofitClient.getRetrofitClient().create(DataService.class);
        Call<DataAlamat> call = service.getAlamat();
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<DataAlamat>() {
            @Override
            public void onResponse(Call<DataAlamat> call, Response<DataAlamat> response) {
                generateDataAlamat(response.body().getData());
            }

            @Override
            public void onFailure(Call<DataAlamat> call, Throwable t) {
                Toast.makeText(ShowDataActivity.this, "Terjadi kesalahan" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataAlamat(ArrayList<Alamat> alamatArrayList){
        recyclerView = findViewById(R.id.rv_data_alamat);
        adapter = new AlamatAdapter(alamatArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShowDataActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
