package com.vkhodonovych.sampledagger2.api.model;

import com.google.gson.annotations.SerializedName;

public class WikiResponse {

    @SerializedName("query") private Query query;

    public Query getQuery() {
        return query;
    }
}