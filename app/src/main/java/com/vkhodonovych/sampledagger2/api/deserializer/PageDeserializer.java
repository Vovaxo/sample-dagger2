package com.vkhodonovych.sampledagger2.api.deserializer;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.vkhodonovych.sampledagger2.api.model.Page;
import com.vkhodonovych.sampledagger2.api.model.Pages;

import java.lang.reflect.Type;


public class PageDeserializer implements JsonDeserializer<Pages> {
    private static final String TAG = "PageDeserializer";

    @Override
    public Pages deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement value = ((JsonObject) jsonElement).entrySet().iterator().next().getValue();
        Page page = jsonDeserializationContext.deserialize(value, Page.class);
        Log.d(TAG, "deserialize: " + jsonElement.toString());
        return new Pages(page);
    }
}
