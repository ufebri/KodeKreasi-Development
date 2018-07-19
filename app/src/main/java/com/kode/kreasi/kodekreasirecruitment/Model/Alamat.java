package com.kode.kreasi.kodekreasirecruitment.Model;

import com.google.gson.annotations.SerializedName;

public class Alamat {
    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("provinsi")
    private String provinsi;
    @SerializedName("kota")
    private String kota;
    @SerializedName("tanggal_lahir")
    private String tanggal_lahir;
    @SerializedName("no_hp")
    private String no_hp;
    @SerializedName("created_at")
    private String created_at;

    public Alamat(String id, String nama, String alamat, String provinsi, String kota, String tanggal_lahir, String no_hp, String created_at) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.provinsi = provinsi;
        this.kota = kota;
        this.tanggal_lahir = tanggal_lahir;
        this.no_hp = no_hp;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
