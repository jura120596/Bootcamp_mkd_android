package com.example.mkd.retrofit.requestbody;

public class PredictorRequest {
    String q;
    String lang = "ru";
    String key;
    int limit = 1;

    public PredictorRequest() {
        key = "";
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
