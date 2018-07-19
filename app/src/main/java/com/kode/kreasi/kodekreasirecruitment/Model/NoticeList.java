package com.kode.kreasi.kodekreasirecruitment.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NoticeList {
    @SerializedName("notice_list")
    private ArrayList<Notice> noticeList;

    public ArrayList<Notice> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(ArrayList<Notice> noticeList) {
        this.noticeList = noticeList;
    }
}
