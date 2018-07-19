package com.kode.kreasi.kodekreasirecruitment.Model.RajaOngkir;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RajongResponse {
    @SerializedName("rajaongkir")
    private List<Rajaongkir> rajaongkir;

    public List<Rajaongkir> getRajaongkir() {
        return rajaongkir;
    }

    public void setRajaongkir(List<Rajaongkir> rajaongkir) {
        this.rajaongkir = rajaongkir;
    }
}
