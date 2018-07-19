package com.kode.kreasi.kodekreasirecruitment.Model;

import com.google.gson.annotations.SerializedName;

public class Notice {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("brief")
    private String brief;
    @SerializedName("filesource")
    private String filesource;

    public Notice(String id, String title, String brief, String filesource) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.filesource = filesource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getFilesource() {
        return filesource;
    }

    public void setFilesource(String filesource) {
        this.filesource = filesource;
    }
}
