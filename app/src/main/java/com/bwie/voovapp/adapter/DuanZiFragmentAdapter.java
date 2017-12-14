package com.bwie.voovapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.voovapp.R;
import com.bwie.voovapp.bean.DuanZiInfoBean;
import com.bwie.voovapp.bean.HotInfoBean;
import com.bwie.voovapp.coustom.RoundImageView;

import java.util.List;

/**
 * Created by 1 on 2017/11/14.
 */

public class DuanZiFragmentAdapter extends RecyclerView.Adapter<DuanZiFragmentAdapter.MyViewHolder> {
    private Context context;
    private List<HotInfoBean.ResourceBean> list;

    public DuanZiFragmentAdapter(Context context, List<HotInfoBean.ResourceBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
               context).inflate(R.layout.duanzirecycle, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.username.setText(list.get(position).getUptime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public final RoundImageView rollPagerView;
        public final TextView username;
        public final TextView time;
        public final TextView context;
        public MyViewHolder(View itemView) {
            super(itemView);
            rollPagerView = (RoundImageView)itemView.findViewById(R.id.headIma);
            username = (TextView)itemView.findViewById(R.id.duanzi_name);
            time = (TextView)itemView.findViewById(R.id.duanzi_time);
            context = (TextView)itemView.findViewById(R.id.context_title);
        }
    }
}
