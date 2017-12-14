package com.bwie.voovapp.utils;

import retrofit2.Retrofit;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/5/13 10:34
 */

public interface ApiRetrofitInterface {
    //返回Retrofit
    Retrofit getRetrofit(String path);
    //返回ApiService
    <T> T getClientApi(Class<T> cla,String path);

}
