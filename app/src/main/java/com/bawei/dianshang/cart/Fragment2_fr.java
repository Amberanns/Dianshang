package com.bawei.dianshang.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.TextView;

import com.bawei.dianshang.R;
import com.bawei.dianshang.cart.F2_zi_modl.Bean_zi;
import com.bawei.dianshang.cart.F2_zi_presenter.Shoupresenter;
import com.bawei.dianshang.cart.F2_zi_view.Iview;

import java.util.List;

/**
 * Created by Administrator on 2017/11/8.
 */

public class Fragment2_fr extends Fragment implements Iview {

    private ExpandableListView ex;
    private List<Bean_zi.DataBean> list;
    List<Bean_zi.DataBean.ListBean> list_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.f2_ex,null);
        ex = (ExpandableListView) view.findViewById(R.id.ex);

        Bundle bundle = getArguments();
        int cid = bundle.getInt("cid");
        Shoupresenter shoupresenter = new Shoupresenter(this);
        shoupresenter.getIview(cid);
        return view;
    }
    public static Fragment getinstance(int cid){
        Fragment2_fr fragment2_fr = new Fragment2_fr();
        Bundle bundle = new Bundle();
        bundle.putInt("cid",cid);
        fragment2_fr.setArguments(bundle);
        return fragment2_fr;
    }

    @Override
    public void getIview(Bean_zi bean_zi) {
        //大分组
        list = bean_zi.getData();
        Exadaper adaper = new Exadaper();
        ex.setAdapter(adaper);

        for (int i = 0; i <list.size() ; i++) {
            ex.expandGroup(i);
        }
    }



    //ExpandableListView适配器
    class Exadaper extends BaseExpandableListAdapter{

        //大分组
        @Override
        public int getGroupCount() {
            return list.size();
        }
        //子分组
        @Override
        public int getChildrenCount(int i) {
            return list.size();
        }

        @Override
        public Object getGroup(int i) {
            return i;
        }

        @Override
        public Object getChild(int i, int i1) {
            return i1;
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        //父分组
        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            View view_fu = View.inflate(getContext(),R.layout.ex_fu,null);
            TextView tv_fu = (TextView) view_fu.findViewById(R.id.tv_fu);
            tv_fu.setText(list.get(i).getName());

            return view_fu;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            View view2 = View.inflate(getContext(),R.layout.ex_zi,null);
            GridView gr = (GridView) view2.findViewById(R.id.gr);
            List<Bean_zi.DataBean.ListBean> list_list = Fragment2_fr.this.list.get(i).getList();
            Er_zilei_adaper er_adaper = new Er_zilei_adaper(getContext(),list_list);
            gr.setAdapter(er_adaper);

            return view2;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }

}
