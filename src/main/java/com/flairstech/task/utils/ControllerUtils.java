package com.flairstech.task.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class ControllerUtils {
    public Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
    protected String serializeRESTSuccessResponse(Object data) {

        Gson gson = getGson();
        ResponseUtils response = new ResponseUtils();
        response.success(data);
        return gson.toJson(response);
    }
    protected String serializeRESTFailResponse(Object code) {

        Gson gson = getGson();
        ResponseUtils response = new ResponseUtils();
        response.fail(code);
        return gson.toJson(response);
    }

}
