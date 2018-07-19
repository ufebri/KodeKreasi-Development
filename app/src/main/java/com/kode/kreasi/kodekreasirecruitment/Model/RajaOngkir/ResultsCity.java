package com.kode.kreasi.kodekreasirecruitment.Model.RajaOngkir;

import com.google.gson.annotations.SerializedName;

public class ResultsCity {
    @SerializedName("city_id")
    private Integer city_id;
    @SerializedName("province_id")
    private Integer province_id;
    @SerializedName("province")
    private String province;
    @SerializedName("type")
    private String type;
    @SerializedName("city_name")
    private String city_name;
    @SerializedName("postal_code")
    private String postal_code;

    public ResultsCity(Integer city_id, Integer province_id, String province, String type, String city_name, String postal_code) {
        this.city_id = city_id;
        this.province_id = province_id;
        this.province = province;
        this.type = type;
        this.city_name = city_name;
        this.postal_code = postal_code;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
}
