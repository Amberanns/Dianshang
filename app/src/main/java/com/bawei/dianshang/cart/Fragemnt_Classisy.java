package com.bawei.dianshang.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bawei.dianshang.R;
import com.bawei.dianshang.cart.model.Bean_f2;
import com.bawei.dianshang.cart.presenter.F2_Shoupresenter_list;
import com.bawei.dianshang.cart.view.F2_Iview_list;

import java.util.List;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class Fragemnt_Classisy extends Fragment implements F2_Iview_list{

    private List<Bean_f2.DataBean> data;
    private ListView lv;
    private RecyclerView.ViewHolder holder;
    private Fragment getinstance;
    private FragmentTransaction transaction;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.fenlei_item,null);
        //控件
        lv = (ListView) view.findViewById(R.id.lv_er);

        getinstance = Fragment2_fr.getinstance(0);
        final FragmentManager childFragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = childFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frla, getinstance);
        fragmentTransaction.commit();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bean_f2.DataBean dataBean = data.get(i);
                //获取id
                int cid = dataBean.getCid();
                //创建事务
                Fragment getinstance = Fragment2_fr.getinstance(cid);
                FragmentTransaction fragmentTransaction = childFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frla, getinstance);
                //进行提交
                fragmentTransaction.commit();
            }
        });

        F2_Shoupresenter_list f2ShoupresenterList = new F2_Shoupresenter_list(this);
        f2ShoupresenterList.getiview_list();



        return view;
    }

    //MVP
    @Override
    public void getiview(Bean_f2 bean_f2) {
        data = bean_f2.getData();
        MyAdaper adaper = new MyAdaper();
        lv.setAdapter(adaper);
    }

    //Listview适配器
    class  MyAdaper extends BaseAdapter {


        private ViewHolder1 holder1;

        @Override
        public int getCount() {
            return data.size();
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
            if (view == null){
                view  = View.inflate(getContext(),R.layout.f2_er_list_item,null);
                holder1 = new ViewHolder1();
                holder1.tv_er = (TextView) view.findViewById(R.id.er_rv_tv);


                view.setTag(holder);
            }else {
                holder = (RecyclerView.ViewHolder) view.getTag();
            }

            holder1.tv_er.setText(data.get(i).getName());

            return view;
        }
    }
    class ViewHolder1{
        TextView tv_er;
    }

}
