package com.bawei.dianshang.home.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dianshang.R;
import com.bawei.dianshang.home.adapter.Adapter;
import com.bawei.dianshang.home.api.Api;
import com.bawei.dianshang.home.bean.Bean;
import com.bawei.dianshang.home.presenter.Presenter;

import java.util.List;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class Fragment_Home extends Fragment implements Iview{

    private RecyclerView re;
    private Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view=View.inflate(getContext(), R.layout.fragment,null);
        re = (RecyclerView) view.findViewById(R.id.re);
        presenter = new Presenter(this);
        presenter.getok(Api.PATH);
        return  view;


    }

    @Override
    public void showSuccess(List<Bean.DataBean> list) {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        re.setLayoutManager(linearLayoutManager);
        Adapter adapter=new Adapter(getActivity(),list);
        re.setAdapter(adapter);
    }

    @Override
    public void showError(String r) {

    }
}
