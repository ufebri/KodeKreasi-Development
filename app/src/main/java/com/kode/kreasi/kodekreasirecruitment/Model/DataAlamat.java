package com.kode.kreasi.kodekreasirecruitment.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataAlamat {
    @SerializedName("data")
    private ArrayList<Alamat> data;

    public ArrayList<Alamat> getData() {
        return data;
    }

    public void setData(ArrayList<Alamat> data) {
        this.data = data;
    }
}
