package com.kode.kreasi.kodekreasirecruitment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.kode.kreasi.kodekreasirecruitment.Interface.DataService;
import com.kode.kreasi.kodekreasirecruitment.Network.RetrofitClient;


public class RegisterActivity extends AppCompatActivity {
    private DataService dataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etNama = findViewById(R.id.et_nama);
        final EditText etAlamat = findViewById(R.id.et_alamat);
        final Spinner spinProvinsi = findViewById(R.id.spin_provinsi);
        final Spinner spinKota = findViewById(R.id.spin_kota);
        final EditText etTglLahir = findViewById(R.id.et_tanggal_lahir);
        final EditText etNoHp = findViewById(R.id.et_no_hp);
        Button btnSubmit = findViewById(R.id.btn_submit);

        DataService service = RetrofitClient.getRetrofitClient().create(DataService.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString().trim();
                String alamat = etAlamat.getText().toString().trim();
            }
        });
    }
}
