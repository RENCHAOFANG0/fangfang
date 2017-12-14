package com.bwie.voovapp.childfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.voovapp.R;
import com.bwie.voovapp.adapter.DuanZiFragmentAdapter;
import com.bwie.voovapp.base.BaseFragment;
import com.bwie.voovapp.bean.DuanZiInfoBean;
import com.bwie.voovapp.bean.HotInfoBean;
import com.bwie.voovapp.interlist.InterList;
import com.bwie.voovapp.pre.AppPre;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.List;

/**
 * Created by 1 on 2017/10/30.
 */

public class LeftFragment extends BaseFragment<InterList.tjView,AppPre> implements InterList.tjView{
    private RollPagerView mRollViewPager;
    private RecyclerView recycle;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public int getCreatView() {
        return R.layout.leftfragment;
    }

    @Override
    public void init() {
        mRollViewPager = findViewById(R.id.roll_view_pager);
        recycle = findViewById(R.id.hot_recycle);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recycle.setLayoutManager(linearLayoutManager);
        //设置播放时间间隔
        mRollViewPager.setPlayDelay(2000);
        //设置透明度
        //  mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
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
        //获取得到数据
        getData();
    }
    @Override
    public void getHot(List<HotInfoBean.ResourceBean> resource) {
        DuanZiFragmentAdapter duanZiFragmentAdapter = new DuanZiFragmentAdapter(getContext(), resource);
        recycle.setAdapter(duanZiFragmentAdapter);
    }



    @Override
    public void getDataDuan(List<DuanZiInfoBean.CharacterBean> character) {

    }
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.mipmap.raw_1500258881,
                R.mipmap.raw_1500258901,
                R.mipmap.raw_1500259026,
        };
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }
        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
