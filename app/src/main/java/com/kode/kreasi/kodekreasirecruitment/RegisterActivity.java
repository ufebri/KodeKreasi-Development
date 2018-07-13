package com.kode.kreasi.kodekreasirecruitment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.kode.kreasi.kodekreasirecruitment.Adapter.Adapter;
import com.kode.kreasi.kodekreasirecruitment.Model.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    Spinner spinnerProv, spinnerCity;
    EditText edtNama,edtAlamat,edtTanggal,edtBulan,edtTahun,edtNomor;
    Button btnRegister;
    String prov,city;
    List<String> arrayProvinsi,arrayProvinsiId,arrayCity,arrayCityId;
    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;
    Model baru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        spinnerProv = (Spinner)findViewById(R.id.spinner_provinsi);
        spinnerCity = (Spinner)findViewById(R.id.spinner_kota);
        edtNama = (EditText)findViewById(R.id.edt_nama);
        edtAlamat = (EditText)findViewById(R.id.edt_alamat);
        edtTanggal = (EditText)findViewById(R.id.edt_tanggal);
        edtBulan = (EditText)findViewById(R.id.edt_bulan);

        edtTahun = (EditText)findViewById(R.id.edt_tahun);

        edtNomor = (EditText)findViewById(R.id.edt_nomor);
        btnRegister = (Button)findViewById(R.id.btn_submit);
        arrayProvinsi = new ArrayList<>();
        arrayProvinsiId = new ArrayList<>();
        arrayCity = new ArrayList<>();
        arrayCityId = new ArrayList<>();
        spinnerProv.setEnabled(false);
        spinnerCity.setEnabled(false);
        spinnerProv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                new loadCity().execute(arrayProvinsiId.get(position));
                prov = arrayProvinsi.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city = arrayCity.get(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baru = new Model();
                baru.setNama(edtNama.getText().toString());
                baru.setTanggal_lahir(edtTanggal.getText().toString()+"-"+edtBulan.getText().toString()+"-"+edtTahun.getText().toString());
                baru.setAlamat(edtAlamat.getText().toString());
                baru.setNo_hp(edtNomor.getText().toString());
                baru.setKota(city);
                baru.setProvinsi(prov);
                new AsyncRegister().execute();
            }
        });
        new loadProvinsi().execute();
    }

    public class loadProvinsi extends AsyncTask<String,String,String> {
        private static final String TAG = "JSON ";

        @Override
        protected void onPreExecute() {


            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;


            // Will contain the raw JSON response as a string.
            String result = null;

            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast

                URL url = new URL("http://api.rajaongkir.com/starter/province?key=0cb08732d0064245f748121c208963ca");

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                result = buffer.toString();
            } catch (IOException e) {
                Log.e(TAG, "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                        Log.d(TAG, "doinbackground"+result);
                    } catch (final IOException e) {
                        Log.e(TAG, "Error closing stream", e);
                    }
                }
            }
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONObject rajaOngkir = jsonObject.getJSONObject("rajaongkir");
                JSONArray data = rajaOngkir.getJSONArray("results");
                Log.d(TAG, String.valueOf(data.length()));
                for (int i =0; i< data.length(); i++){
                    JSONObject provinsi = data.getJSONObject(i);
                    arrayProvinsi.add(provinsi.getString("province"));
                    arrayProvinsiId.add(provinsi.getString("province_id"));
                }


            } catch (JSONException e) {
                e.printStackTrace();
                result = null;
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayAdapter<String> adapterProvinsi = new ArrayAdapter<String>(RegisterActivity.this,android.R.layout.simple_spinner_item,arrayProvinsi);
            spinnerProv.setAdapter(adapterProvinsi);
            spinnerProv.setEnabled(true);
        }




    }
    public class loadCity extends AsyncTask<String,String,String> {
        private static final String TAG = "JSON ";

        @Override
        protected void onPreExecute() {
            arrayCity.clear();
            ArrayAdapter<String> adapterKota = new ArrayAdapter<String>(RegisterActivity.this,android.R.layout.simple_spinner_item,arrayCity);
            spinnerCity.setAdapter(adapterKota);
            spinnerCity.setEnabled(false);

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;


            // Will contain the raw JSON response as a string.
            String result = null;

            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast

                URL url = new URL("http://api.rajaongkir.com/starter/city?key=0cb08732d0064245f748121c208963ca&province="+params[0]);

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                result = buffer.toString();
            } catch (IOException e) {
                Log.e(TAG, "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                        Log.d(TAG, "doinbackground"+result);
                    } catch (final IOException e) {
                        Log.e(TAG, "Error closing stream", e);
                    }
                }
            }
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONObject rajaOngkir = jsonObject.getJSONObject("rajaongkir");
                JSONArray data = rajaOngkir.getJSONArray("results");
                Log.d(TAG, String.valueOf(data.length()));
                for (int i =0; i< data.length(); i++){
                    JSONObject provinsi = data.getJSONObject(i);
                    arrayCity.add(provinsi.getString("city_name"));
                }


            } catch (JSONException e) {
                e.printStackTrace();
                result = null;
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayAdapter<String> adapterKota = new ArrayAdapter<String>(RegisterActivity.this,android.R.layout.simple_spinner_item,arrayCity);
            spinnerCity.setAdapter(adapterKota);
            spinnerCity.setEnabled(true);
        }




    }

    private class AsyncRegister extends AsyncTask<String, String, String>
    {
        private static final String TAG = "Register ";
        boolean status;

        String message=null;
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
            super.onPreExecute();

        }
        @Override
        protected String doInBackground(String... params) {
            String JSON=null;
            String token=null;
            try {

                // Enter URL address where your php file resides
                url = new URL("http://163.53.192.162/apitesandroid/public/alamat");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "exception";
            }
            try {
                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection)url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");

                // setDoInput and setDoOutput method depict handling of both send and receive
                conn.setDoInput(true);
                conn.setDoOutput(true);

                // Append parameters to URL
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("nama", baru.getNama())
                        .appendQueryParameter("alamat", baru.getAlamat())
                        .appendQueryParameter("kota", baru.getKota())
                        .appendQueryParameter("provinsi", baru.getProvinsi())
                        .appendQueryParameter("tanggal_lahir", baru.getTanggal_lahir())
                        .appendQueryParameter("no_hp", baru.getNo_hp());


                String query = builder.build().getEncodedQuery();

                // Open connection for sending data
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();
                Log.d(TAG, "response code : "+String.valueOf(response_code));
                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    Log.d(TAG, "Success");
                    // Pass data to onPostExecute method
                    JSON = result.toString();
                    JSONObject json = new JSONObject(JSON);
                    message = json.getString("message");
                    status = json.getBoolean("status");





                }else{

                   Log.d("GAGAL","Gagal");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "exception";
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                conn.disconnect();
                Log.d(TAG, "doinbackground"+token);
            }
            return token;

        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread

            Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
            if (status){
                edtAlamat.setText("");
                edtNama.setText("");
                edtNomor.setText("");
                edtTanggal.setText("");
                edtBulan.setText("");
                edtTahun.setText("");
            }
            btnRegister.setEnabled(true);
        }

    }
}
