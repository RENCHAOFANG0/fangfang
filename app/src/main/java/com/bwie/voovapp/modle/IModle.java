package com.bwie.voovapp.modle;

import com.bwie.voovapp.view.IUserLogin;
import com.bwie.voovapp.view.IUserNameView;

/**
 * Created by 1 on 2017/11/2.
 */

public interface IModle {
    void getModleResgit(String phone, String pass, IUserNameView iUserNameView);
    //用户登录
    void getModleLogin(String phone, String pass, IUserLogin iUserLogin);
}
