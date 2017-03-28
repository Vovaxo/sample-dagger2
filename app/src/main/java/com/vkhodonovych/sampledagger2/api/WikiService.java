package com.vkhodonovych.sampledagger2.api;


import com.vkhodonovych.sampledagger2.api.model.WikiResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

public interface WikiService {

    @GET("w/api.php?format=json&action=query&prop=extracts&explaintext=&titles=Dagger")
    Observable<Response<WikiResponse>> getWiki();
}
