package com.bawei.dianshang.home.model;

import com.bawei.dianshang.home.api.Api;
import com.bawei.dianshang.home.api.ApiService;
import com.bawei.dianshang.home.bean.Bean;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class model implements Imodel{
    private Retrofit retrofit;
    private ApiService apiService;
    private Observable<Bean> noParams;

    @Override
    public void Request(String url, final Onclick onclick) {
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        //通过动态代理得到网络接口对象
        apiService = retrofit.create(ApiService.class);
        noParams = apiService.getNoParams();

        noParams.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onclick.error(e.getMessage().toString());
                    }

                    @Override
                    public void onNext(Bean bean) {
                        List<Bean.DataBean>data=bean.getData();
                        onclick.datasuccess(data);
                    }
                });

    }
}
