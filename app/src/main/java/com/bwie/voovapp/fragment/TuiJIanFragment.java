package com.bwie.voovapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.bwie.voovapp.R;
import com.bwie.voovapp.adapter.ViewPagerAdapter;
import com.bwie.voovapp.base.BaseFragment;
import com.bwie.voovapp.bean.DuanZiInfoBean;
import com.bwie.voovapp.bean.HotInfoBean;
import com.bwie.voovapp.childfragment.LeftFragment;
import com.bwie.voovapp.childfragment.RightFragment;
import com.bwie.voovapp.interlist.InterList;
import com.bwie.voovapp.pre.AppPre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/10/30.
 */

public class TuiJIanFragment extends BaseFragment<InterList.tjView,AppPre> implements InterList.tjView{

    private ViewPager viewpager;
    private TabLayout tabLayout;
    private List<String > slist = new ArrayList<>();
    private List<Fragment> flist = new ArrayList<>();

    @Override
    public int getCreatView() {
        return R.layout.tuijianfragment;
    }
    @Override
    public void init(){
        viewpager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.table);
    }
    @Override
    public AppPre getPre() {
        return new AppPre();
    }
    @Override
    public void getData() {
        ipre.getFindHotDown();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         init();
         addTab();
    }
    //添加tab视图
    public void addTab(){
        slist.add("热门");
        slist.add("关注");
        flist.add(new LeftFragment());
        flist.add(new RightFragment());
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText("热门"));
        tabLayout.addTab(tabLayout.newTab().setText("关注"));
        //获得fragment的管理者
        //进行viewpager的数据适配器
        viewpager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(),flist,slist));
        //进行关联
        tabLayout.setupWithViewPager(viewpager);
        //tabLayout.setTabsFromPagerAdapter(new ViewPagerAdapter(getChildFragmentManager(),flist,slist));
    }
    @Override
    public void getHot(List<HotInfoBean.ResourceBean> resource) {

    }

    @Override
    public void getDataDuan(List<DuanZiInfoBean.CharacterBean> character) {

    }


}
