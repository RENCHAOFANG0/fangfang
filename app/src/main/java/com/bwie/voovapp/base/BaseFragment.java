package com.bwie.voovapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.voovapp.interlist.InterList;
import com.bwie.voovapp.pre.BasePre;

/**
 * Created by 1 on 2017/11/8.
 */

public abstract class BaseFragment<V,T extends BasePre<V>> extends Fragment {

    public  T ipre;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater iInflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null){view = iInflater.inflate(getCreatView(),container,false);}
        ViewGroup parent = (ViewGroup) view.getParent();
        if(parent!=null){parent.removeView(view);}
                //调取方法进行关联P层
                ipre = getPre();
                ipre.attachView((V) getActivity());
        return view;
    }
    public abstract int getCreatView();
    //进行初始化资源id
    public abstract void init();
    public abstract T getPre();
    //进行获取数据
    public abstract void getData();

    @SuppressWarnings("unchecked")
    protected <T extends View> T findViewById(int id)
    {if (view == null) {return null;}
        return (T) view.findViewById(id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ipre.dattchView();
    }
}
