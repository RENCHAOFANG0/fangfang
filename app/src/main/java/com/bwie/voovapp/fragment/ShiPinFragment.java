package com.bwie.voovapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bwie.voovapp.R;
import com.bwie.voovapp.base.BaseFragment;
import com.bwie.voovapp.bean.DuanZiInfoBean;
import com.bwie.voovapp.bean.HotInfoBean;
import com.bwie.voovapp.pre.AppPre;
import com.bwie.voovapp.pre.BasePre;

import java.util.List;

/**
 * Created by 1 on 2017/10/30.
 */

public class ShiPinFragment extends BaseFragment {
    private View view;
    private TextView viewById;

    @Override
    public int getCreatView() {
        return R.layout.shipinfragment;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         init();
        String s = viewById.getText().toString();
        Log.i("xxx",s);
    }
    @Override
    public void init() {
        viewById = (TextView) findViewById(R.id.tv1);
    }

    @Override
    public BasePre getPre() {
        return new AppPre();
    }

    @Override
    public void getData() {
    }

    @Override
    public void getHot(List<HotInfoBean.ResourceBean> resource) {

    }

    @Override
    public void getDataDuan(List<DuanZiInfoBean.CharacterBean> character) {

    }
}
