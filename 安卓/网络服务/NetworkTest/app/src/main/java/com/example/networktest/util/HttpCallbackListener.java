package com.example.networktest.util;

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}