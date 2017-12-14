package com.bwie.voovapp.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bwie.voovapp.R;
import com.bwie.voovapp.adapter.DuanZiFragmentAdapter;
import com.bwie.voovapp.base.BaseFragment;
import com.bwie.voovapp.bean.DuanZiInfoBean;
import com.bwie.voovapp.bean.HotInfoBean;
import com.bwie.voovapp.interlist.InterList;
import com.bwie.voovapp.pre.AppPre;
import com.bwie.voovapp.pre.BasePre;

import java.util.List;

/**
 * Created by 1 on 2017/10/30.
 */

public class DuanZiFragment extends BaseFragment<InterList.tjView,AppPre> implements InterList.tjView {

    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recycle;

    //创建视图
    @Override
    public int getCreatView() {
        return R.layout.duanzifragment;
    }
    //初始化资源id
    @Override
    public void init() {
        recycle = findViewById(R.id.recycle);
        swipeRefresh = findViewById(R.id.swipefresh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
       recycle.setLayoutManager(linearLayoutManager);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        getData();
    }
    //得到p层的对象
    @Override
    public AppPre getPre() {
        return new AppPre();
    }
    @Override
    public void getData() {
            ipre.getFindDuanZi(1);
}

    @Override
    public void getHot(List<HotInfoBean.ResourceBean> resource) {

    }

    //进行展示段子的信息的视图
    @Override
    public void getDataDuan(List<DuanZiInfoBean.CharacterBean> character) {
//
//        Log.i("xxx","我唠叨了只展示数据方法里面");
//        DuanZiFragmentAdapter duanZiFragmentAdapter = new DuanZiFragmentAdapter(getActivity(), character);
//        recycle.setAdapter(duanZiFragmentAdapter);
    }
}
