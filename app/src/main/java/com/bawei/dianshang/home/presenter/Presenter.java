package com.bawei.dianshang.home.presenter;

import com.bawei.dianshang.home.bean.Bean;
import com.bawei.dianshang.home.model.Imodel;
import com.bawei.dianshang.home.model.Onclick;
import com.bawei.dianshang.home.model.model;
import com.bawei.dianshang.home.view.Iview;

import java.util.List;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class Presenter {
    Imodel imodel;
    Iview iview;

    public Presenter( Iview iview) {

        this.iview = iview;
        imodel=new model();
    }
    public  void getok(String url){
        imodel.Request(url, new Onclick() {
            @Override
            public void datasuccess(List<Bean.DataBean> list) {
                iview.showSuccess(list);

            }

            @Override
            public void error(String rr) {
                iview.showError(rr);
            }
        });

    }
}
