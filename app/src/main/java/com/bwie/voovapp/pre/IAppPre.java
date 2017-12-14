package com.bwie.voovapp.pre;

import com.bwie.voovapp.view.IUserNameView;

/**
 * Created by 1 on 2017/11/2.
 */

public interface IAppPre {

    void getResgit(String phone, String pass);
    //登录
    void getLogin(String pnone,String pass);
}
