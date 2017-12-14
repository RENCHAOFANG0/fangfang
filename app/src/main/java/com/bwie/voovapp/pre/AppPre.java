package com.bwie.voovapp.pre;

import android.util.Log;

import com.bwie.voovapp.bean.DuanZiInfoBean;
import com.bwie.voovapp.bean.HotInfoBean;
import com.bwie.voovapp.interlist.InterList;
import com.bwie.voovapp.modle.IModle;
import com.bwie.voovapp.modle.ModleApp;
import com.bwie.voovapp.view.IUserLogin;
import com.bwie.voovapp.view.IUserNameView;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by 1 on 2017/11/2.
 */

public class AppPre extends BasePre<InterList.tjView> implements IAppPre,InterList.tjPre {
    private List<DuanZiInfoBean.CharacterBean> character;
    private IUserLogin iUserLogin;
    private IUserNameView iUserNameView;
    private  IModle modleApp;

        //关联m层
    ModleApp modleApp1 = new ModleApp();

    public  AppPre(){
    }
    public AppPre(IUserNameView iUserNameView) {
        this.iUserNameView=iUserNameView;
        modleApp = new ModleApp();
    }
    public AppPre(IUserLogin iUserLogin) {
        this.iUserLogin=iUserLogin;
        modleApp = new ModleApp();
    }



    //用户进行注册账号的方法
    @Override
    public void getResgit(String phone, String pass) {
        modleApp.getModleResgit(phone,pass,iUserNameView);
    }
    //用户进行登录账号的方法
    @Override
    public void getLogin(String pnone, String pass) {
        modleApp.getModleLogin(pnone,pass,iUserLogin);
    }



    //进行加载热门的数据
    @Override
    public void getFindHotDown() {
        Flowable<HotInfoBean> modelHotDown = modleApp1.getModelHotDown();
        modelHotDown.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<HotInfoBean>() {
                    @Override
                    public void onNext(HotInfoBean hotInfoBean) {
                        List<HotInfoBean.ResourceBean> resource = hotInfoBean.getResource();
                        getView().getHot(resource);
                        Log.i("xxx",hotInfoBean.getCode());}
                    @Override
                    public void onError(Throwable t) {}
                    @Override
                    public void onComplete() {}
                });
    }

    //进行获取段子的数据
    @Override
    public void getFindDuanZi(int page) {
        Log.i("xxx","我唠叨了只展示数据方法里面");
        Flowable<DuanZiInfoBean> duanZi = modleApp1.getDuanZi(page);
        duanZi.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DuanZiInfoBean>() {
                    @Override
                    public void onNext(DuanZiInfoBean duanZiInfoBean) {
                        Log.i("xxx",duanZiInfoBean.toString());
                        Log.i("xxx",duanZiInfoBean.getCharacter().size()+"");
                        getView().getDataDuan(duanZiInfoBean.getCharacter());
                    }
                    @Override
                    public void onError(Throwable t) {

                    }
                    @Override
                    public void onComplete() {

                    }
                });


    }
}
