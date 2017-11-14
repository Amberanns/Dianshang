package com.bawei.dianshang.cart.F2_zi_presenter;

import com.bawei.dianshang.cart.F2_zi_modl.Bean_zi;
import com.bawei.dianshang.cart.F2_zi_modl.Shoumodl;
import com.bawei.dianshang.cart.F2_zi_view.Iview;

/**
 * Created by Administrator on 2017/11/9.
 */

public class Shoupresenter implements Ipresenter{

    Iview iview;
    private final Shoumodl shoumodl;

    public Shoupresenter(Iview iview) {
        this.iview = iview;
        shoumodl = new Shoumodl();
    }

    @Override
    public void getIview(int cid) {
        shoumodl.setImodl(cid,this);
    }

    @Override
    public void setpresenter(Bean_zi bean_zi) {
            iview.getIview(bean_zi);
    }
}
