package com.bwie.voovapp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.bwie.voovapp.R;
import com.bwie.voovapp.fragment.DuanZiFragment;
import com.bwie.voovapp.fragment.ShiPinFragment;
import com.bwie.voovapp.fragment.TuiJIanFragment;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class ZhuJieMianActivity extends FragmentActivity {

    private TextView title;
    private FragmentManager supportFragmentManager;
    private ImageView userimg;
    private BottomTabBar tabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_zhu_jie_mian);
        init();
        supportFragmentManager = getSupportFragmentManager();
        getSideframe();
        tabBar.init(getSupportFragmentManager())
                .setImgSize(60, 60)
                .setFontSize(16)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.parseColor("#1296DB"), Color.parseColor("#C1C1C1"))
                .addTabItem("推荐",R.mipmap.raw_1500085367, R.mipmap.raw_1500083878,  TuiJIanFragment.class)
                .addTabItem("段子",R.mipmap.raw_1500085899, R.mipmap.raw_1500085327,  DuanZiFragment.class)
                .addTabItem("视频", R.mipmap.raw_1500086067,R.mipmap.raw_1500083686, ShiPinFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        switch (position){
                            case 0:
                                title.setText("推荐");
                                break;
                            case 1:
                                title.setText("段子");
                                break;
                            case 2:
                                title.setText("视频");
                                break;
                        }
                    }
                });
    }
    //初始化资源控件
    public void init(){
        userimg = (ImageView)findViewById(R.id.user);
        title = (TextView)findViewById(R.id.textview);
        ImageView  bianji = (ImageView)findViewById(R.id.bianji);
        tabBar = (BottomTabBar)findViewById(R.id.bottomtab);
    }

    //操作侧拉的显示
    public void getSideframe(){
                final SlidingMenu slidingMenu = new SlidingMenu(ZhuJieMianActivity.this);
                slidingMenu.setMode(SlidingMenu.LEFT);
                slidingMenu.setBehindOffset(100);
                slidingMenu.attachToActivity(ZhuJieMianActivity.this, SlidingMenu.SLIDING_CONTENT);
                //加载布局
                slidingMenu.setMenu(R.layout.menu);
        userimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingMenu.toggle();
            }
        });
    }

}
