package com.kode.kreasi.kodekreasirecruitment.Model.RajaOngkir;

import com.google.gson.annotations.SerializedName;

public class Status {
    @SerializedName("code")
    private String code;
    @SerializedName("description")
    private String description;

    public Status(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
