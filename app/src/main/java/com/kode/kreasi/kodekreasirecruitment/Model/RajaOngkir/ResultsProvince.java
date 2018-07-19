package com.kode.kreasi.kodekreasirecruitment.Model.RajaOngkir;

import com.google.gson.annotations.SerializedName;

public class ResultsProvince {
    @SerializedName("province_id")
    private Integer province_id;
    @SerializedName("province")
    private String province;

    public ResultsProvince(Integer province_id, String province) {
        this.province_id = province_id;
        this.province = province;
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
}