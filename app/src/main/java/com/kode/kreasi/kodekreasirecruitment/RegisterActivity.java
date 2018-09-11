package com.kode.kreasi.kodekreasirecruitment;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    public static final String URL = "http://fashion-sell.net/RajaOngkir/";
    private ProgressDialog progress;

    @BindView(R.id.spinner) Spinner spinnerKota;
    @BindView(R.id.spinner2) Spinner spinnerProvinsi;
    @BindView(R.id.editText) EditText editTextNama;
    @BindView(R.id.editText2) EditText editTextAlamat;
    @BindView(R.id.editText4) EditText editTextTglLahir;
    @BindView(R.id.editText5) EditText editTextTelpon;

    @OnClick(R.id.button3) void daftar() {
        //membuat progress dialog
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        //mengambil data dari edittext
        String nama = editTextNama.getText().toString();
        String alamat = editTextAlamat.getText().toString();
        String tglLahir = editTextTglLahir.getText().toString();
        String Telepon = editTextTelpon.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<Value> call = api.daftar(nama, alamat, tglLahir, Telepon);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progress.dismiss();
                if (value.equals("1")) {
                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(RegisterActivity.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

    }
}
