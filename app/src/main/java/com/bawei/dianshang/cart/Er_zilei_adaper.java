package com.bawei.dianshang.cart;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dianshang.R;
import com.bawei.dianshang.cart.F2_zi_modl.Bean_zi;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9.
 */

public class Er_zilei_adaper extends BaseAdapter{
    Context context;

    public Er_zilei_adaper(Context context, List<Bean_zi.DataBean.ListBean> list_list) {
        this.context = context;
        this.list_list = list_list;
    }

    List<Bean_zi.DataBean.ListBean> list_list;
    @Override
    public int getCount() {
        return list_list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = View.inflate(context, R.layout.gr_list,null);
        TextView tv = (TextView) view1.findViewById(R.id.tv_rl);
        ImageView im = (ImageView) view1.findViewById(R.id.im_rl);
        tv.setText(list_list.get(i).getName());
        Log.i("1234",i+"");
        Picasso.with(context).load(list_list.get(i).getIcon()).into(im);

        return view1;
    }
}
