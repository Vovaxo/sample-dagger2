package com.vkhodonovych.sampledagger2.api.model;

import com.google.gson.annotations.SerializedName;

public class Query {

    @SerializedName("pages") private Pages pages;

    public Pages getPages() {
        return pages;
    }
}