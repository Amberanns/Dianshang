package com.bawei.dianshang.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.dianshang.R;
import com.bawei.dianshang.home.bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private Context context;
    private List<Bean.DataBean> list;
    private View view;

    public Adapter(Context context, List<Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.shou_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tv.setText(list.get(position).getNews_title());
            holder.img.setImageURI(list.get(position).getPic_url());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView img;
        private final TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            img = (SimpleDraweeView) itemView.findViewById(R.id.item_img);
        }
    }
}
