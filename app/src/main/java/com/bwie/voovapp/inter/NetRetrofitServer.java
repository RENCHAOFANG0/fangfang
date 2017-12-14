package com.bwie.voovapp.inter;

import com.bwie.voovapp.bean.DuanZiInfoBean;
import com.bwie.voovapp.bean.HotInfoBean;
import com.bwie.voovapp.bean.UserBean;
import com.bwie.voovapp.bean.UserInfoBean;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 1 on 2017/11/2.
 */

public interface NetRetrofitServer {
    //用户注册
    @POST(".")
    @FormUrlEncoded
    Call<UserBean> getData(@Field("userPassword")String pass, @Field("userPhone")String phone);
    //用户登录
    @POST(".")
    @FormUrlEncoded
    Call<UserInfoBean> getLogin(@Field("userPassword")String pass, @Field("userPhone")String phone);
    //查找热门信息
    @GET(".")
    Flowable<HotInfoBean> getHot();
    //查询段子信息
//    @POST(".")
//    @FormUrlEncoded
//    Flowable<DuanZiInfoBean> getDuanzi(@Field("currentpage")int age);

    @GET("getCharacterlist")
    Flowable<DuanZiInfoBean> getDuanzi(@Query("currentpage") int age);
}

