package com.bwie.voovapp.utils;

import android.util.Log;

import com.bwie.voovapp.api.Api;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/5/13 10:32
 */

public class ApiRetrofit implements ApiRetrofitInterface {

    private Retrofit retrofit;
    //单例设计模式
    //懒汉 只声明不创建 私有的静态的成员变量
    private static ApiRetrofit apiRetrofit = null;

    //私有的构造方法
    private ApiRetrofit() {
    }
    //提供一个公共的返回实例的静态方法
    public static ApiRetrofit getInstance() {
        if (apiRetrofit == null) {
            synchronized (ApiRetrofit.class) {
                if (apiRetrofit == null) {
                    apiRetrofit = new ApiRetrofit();
                }
            }
        }
        return apiRetrofit;
    }
    @Override
    public Retrofit getRetrofit(String path) {
        //打印retrofit日志
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(final String message) {
                //打印retrofit日志
                Log.i("RetrofitLog", "retrofitBack = " + message);
            }
        });

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(15, TimeUnit.SECONDS);
        builder.writeTimeout(15, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        builder.addInterceptor(loggingInterceptor);
        OkHttpClient okHttpClient = builder.build();
        //创建Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        return retrofit;
    }



    //封装参数的接口对象
    @Override
    public <T> T getClientApi(Class<T> cla,String path) {
        Retrofit retrofit = getRetrofit(path);
        return retrofit.create(cla);
    }
}
