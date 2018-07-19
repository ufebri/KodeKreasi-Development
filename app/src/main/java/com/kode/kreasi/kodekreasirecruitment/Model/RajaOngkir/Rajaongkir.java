package com.kode.kreasi.kodekreasirecruitment.Model.RajaOngkir;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Rajaongkir {
    @SerializedName("query")
    private ArrayList query;
    @SerializedName("status")
    private Status status;
    @SerializedName("results")
    private ArrayList<ResultsProvince> results;

    public ArrayList getQuery() {
        return query;
    }

    public void setQuery(ArrayList query) {
        this.query = query;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<ResultsProvince> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultsProvince> results) {
        this.results = results;
    }
}
