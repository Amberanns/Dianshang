package com.bawei.dianshang.cart.presenter;


import com.bawei.dianshang.cart.model.Bean_f2;
import com.bawei.dianshang.cart.model.F2_Shoumodl_list;
import com.bawei.dianshang.cart.view.F2_Iview_list;

/**
 * Created by Administrator on 2017/11/8.
 */

public class F2_Shoupresenter_list implements F2_presenter_list{
    F2_Iview_list f2IviewList;
    private final F2_Shoumodl_list f2ShoumodlList;

    public F2_Shoupresenter_list(F2_Iview_list f2IviewList) {
        this.f2IviewList = f2IviewList;
        f2ShoumodlList = new F2_Shoumodl_list();
    }

    @Override
    public void getiview_list() {
        f2ShoumodlList.setmodl_list(this);
    }

    @Override
    public void setmodl_list(Bean_f2 bean_f2) {
        f2IviewList.getiview(bean_f2);
    }
}

