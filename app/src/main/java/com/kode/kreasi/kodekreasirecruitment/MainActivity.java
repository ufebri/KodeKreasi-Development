package com.kode.kreasi.kodekreasirecruitment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnLihat, btnRegistrasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLihat = (Button)findViewById(R.id.btn_lihat_data);
        btnRegistrasi = (Button)findViewById(R.id.btn_registrasi);

        btnLihat.setOnClickListener(this);
        btnRegistrasi.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.btn_lihat_data){
            intent = new Intent(MainActivity.this, ShowDataActivity.class);
        } else if (v.getId() == R.id.btn_registrasi){
            intent = new Intent(MainActivity.this, RegisterActivity.class);
        }
        startActivity(intent);
    }
}
