package com.bwie.voovapp.modle;

import android.util.Log;

import com.bwie.voovapp.api.Api;
import com.bwie.voovapp.bean.DuanZiInfoBean;
import com.bwie.voovapp.bean.HotInfoBean;
import com.bwie.voovapp.bean.UserBean;
import com.bwie.voovapp.bean.UserInfoBean;
import com.bwie.voovapp.inter.NetRetrofitServer;
import com.bwie.voovapp.interlist.InterList;
import com.bwie.voovapp.utils.ApiRetrofit;
import com.bwie.voovapp.view.IUserLogin;
import com.bwie.voovapp.view.IUserNameView;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 1 on 2017/11/2.
 */

public class ModleApp implements IModle,InterList.tjModle {
    //实现操作用户账册账号的方法
    @Override
    public void getModleResgit(String phone, String pass, final IUserNameView iUserNameView) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.RESGITUSER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NetRetrofitServer retrofitServer = retrofit.create(NetRetrofitServer.class);
        Call<UserBean> data = retrofitServer.getData(pass,phone);
        data.enqueue(new Callback<UserBean>() {
            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                UserBean body = response.body();
                String code = body.getCode();
                  if("200".equals(code)){
                      iUserNameView.ResgitSuccess();
                  }else{
                      iUserNameView.ResgitError();
                  }
            }

            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {

            }
        });
    }
    //实现操作用户登录账号的方法
    @Override
    public void getModleLogin(String phone, String pass, final IUserLogin iUserLogin) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Api.LOGIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NetRetrofitServer retrofitServer = build.create(NetRetrofitServer.class);
        Call<UserInfoBean> login = retrofitServer.getLogin(pass, phone);
        login.enqueue(new Callback<UserInfoBean>() {
            @Override
            public void onResponse(Call<UserInfoBean> call, Response<UserInfoBean> response) {
                UserInfoBean body = response.body();
                String code = body.getCode();
                Log.i("xxx",code);
                if(code.equals("200")){
                        iUserLogin.LoginSuccess();
                }else{
                        iUserLogin.LogintError();
                }
            }
            @Override
            public void onFailure(Call<UserInfoBean> call, Throwable t) {

            }
        });
    }

    @Override
    public Flowable getModelHotDown(){
            Flowable<HotInfoBean> hot = ApiRetrofit.getInstance()
                .getClientApi(NetRetrofitServer.class,Api.HOTDOWN)
                .getHot();
        return hot;
    }

    //得到段子的信息
    @Override
    public Flowable<DuanZiInfoBean> getDuanZi(int page) {
        final NetRetrofitServer clientApi = ApiRetrofit
                .getInstance()
                .getClientApi(NetRetrofitServer.class, Api.DUANZI);
        Flowable<DuanZiInfoBean> duanzi = clientApi.getDuanzi(page);
        return duanzi;
    }
}
