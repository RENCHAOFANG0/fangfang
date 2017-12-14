package com.bwie.voovapp.pre;

import java.lang.ref.WeakReference;

/**
 * Created by 1 on 2017/11/8.
 */

public abstract class BasePre<T> {

    public WeakReference reference;
    //进行关联与传过来的view层进行关联
    public void attachView(T view){
        reference=new WeakReference<T>(view);
    }
    public void dattchView(){
        if(reference!=null){
            reference.clear();
            reference=null;
        }
    }

    //获取view
    public T getView(){
        reference.get();
        return (T) reference.get();
    }
}
