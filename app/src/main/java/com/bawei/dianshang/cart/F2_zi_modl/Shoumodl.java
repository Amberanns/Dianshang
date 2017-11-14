package com.bawei.dianshang.cart.F2_zi_modl;

import com.bawei.dianshang.cart.F2_zi_presenter.Ipresenter;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2017/11/9.
 */

public class Shoumodl implements Imodl{

    String url ="http://120.27.23.105/product/getProductCatagory";

    @Override
    public void setImodl(int cid,final Ipresenter ipresenter) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                Bean_zi bean_zi = gson.fromJson(responseString, Bean_zi.class);

                ipresenter.setpresenter(bean_zi);


            }
        });
    }
}
