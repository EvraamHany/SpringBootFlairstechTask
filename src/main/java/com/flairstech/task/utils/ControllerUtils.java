package com.flairstech.task.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class ControllerUtils {
    public Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    protected String failResponse(String code) {

        Gson gson = getGson();
        ResponseUtils response = new ResponseUtils();
        response.fail(code);
        return gson.toJson(response);
    }

}
