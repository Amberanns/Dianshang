package com.bawei.dianshang.cart.model;

import com.bawei.dianshang.cart.presenter.F2_presenter_list;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2017/11/8.
 */

public class F2_Shoumodl_list implements F2_modl_list{
    String url="http://120.27.23.105/product/getCatagory";
    @Override
    public void setmodl_list(final F2_presenter_list f2_presenter_list) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                Bean_f2 bean_f2 = gson.fromJson(responseString, Bean_f2.class);
                f2_presenter_list.setmodl_list(bean_f2);

            }
        });
    }
}
