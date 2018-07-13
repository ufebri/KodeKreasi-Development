package com.kode.kreasi.kodekreasirecruitment;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.AsyncTask;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;

import com.kode.kreasi.kodekreasirecruitment.Adapter.Adapter;
import com.kode.kreasi.kodekreasirecruitment.Model.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ListView lvLihatData;
    ArrayList<Model> modelList;
    Toolbar toolbarLihatData;
    SearchView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        toolbarLihatData = (Toolbar)findViewById(R.id.toolbarLihatData);
        setSupportActionBar(toolbarLihatData);
        toolbarLihatData.setTitle("");
        getSupportActionBar().setTitle("Lihat Data Penduduk");
        search = (SearchView)findViewById(R.id.sv_lihat_data);
        search.setLayoutParams(new Toolbar.LayoutParams(Gravity.RIGHT));
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Adapter adapter = new Adapter(modelList, ShowDataActivity.this);
                lvLihatData.setAdapter(adapter);

                return false;
            }
        });
        modelList = new ArrayList<>();

        lvLihatData = (ListView)findViewById(R.id.lv_lihat_data);
        new loadData().execute();

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    private ArrayList<Model> searchByName(String name){
        ArrayList<Model> result = new ArrayList<>();
        for (int i=0; i<modelList.size();i++){
            Model model = modelList.get(i);
            if (model.getNama().toLowerCase().contains(name.toLowerCase())){
                result.add(model);
            }

        }
        return result;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        ArrayList<Model> modelSearch = new ArrayList<>();
        if (newText.equals("")){
            modelSearch = modelList;
        } else {
            modelSearch = searchByName(newText);
        }
        Adapter adapter = new Adapter(modelSearch, ShowDataActivity.this);
        lvLihatData.setAdapter(adapter);
        return true;
    }


    public class loadData extends AsyncTask<String,String,String> {
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

                URL url = new URL("http://163.53.192.162/apitesandroid/public/alamat");

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
                JSONArray data = jsonObject.getJSONArray("data");
                Log.d(TAG, String.valueOf(data.length()));
                for (int i =0; i< data.length(); i++){
                    JSONObject item = data.getJSONObject(i);
                    Model model = new Model();
                    model.setId(item.getString("id"));
                    model.setNama(item.getString("nama"));
                    model.setNo_hp(item.getString("no_hp"));
                    model.setAlamat(item.getString("alamat"));
                    model.setKota(item.getString("kota")+", "+item.getString("provinsi"));
                    modelList.add(model);
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
            Adapter adapter = new Adapter(modelList, ShowDataActivity.this);
            lvLihatData.setAdapter(adapter);
        }




    }
}
