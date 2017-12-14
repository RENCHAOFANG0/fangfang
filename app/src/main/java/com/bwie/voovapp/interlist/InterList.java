package com.bwie.voovapp.interlist;

import com.bwie.voovapp.bean.DuanZiInfoBean;
import com.bwie.voovapp.bean.HotInfoBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;

/**
 * Created by 1 on 2017/11/8.
 */

public interface InterList {
    //推荐接口
    public interface tjView{
        //热门展示
        void getHot( List<HotInfoBean.ResourceBean> resource);
        //段子的接口
        void getDataDuan(List<DuanZiInfoBean.CharacterBean> character);
    }
    public interface tjModle{
            Flowable getModelHotDown();
            Flowable getDuanZi(int page);
    }
    public interface tjPre{
            void getFindHotDown();
            void getFindDuanZi(int page);
    }

}
