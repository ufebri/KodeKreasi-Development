package com.kode.kreasi.kodekreasirecruitment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnShowData, btnRegister, btnShowProv, btnShowKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        onClickListener();
    }

    private void initView() {
        btnShowData = findViewById(R.id.btn_show_data);
        btnRegister = findViewById(R.id.btn_register);
        btnShowProv = findViewById(R.id.btn_show_provinsi);
        btnShowKota = findViewById(R.id.btn_show_kota);
    }

    private void onClickListener(){
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowDataActivity.class));
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        btnShowProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowProvinsiActivity.class));
            }
        });

        btnShowKota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowKotaActivity.class));
            }
        });
    }
}
