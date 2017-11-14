package com.bawei.dianshang.mine.api;


import com.bawei.dianshang.home.bean.Bean;
import com.bawei.dianshang.mine.bean.UserBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {

//    @GET("v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0")
//    Observable<HomeBean> getHome();
//    首页
    @GET("yunifang/mobile/home")
    Observable<Bean> getHome();
    //登陆
    @FormUrlEncoded
    @POST("user/login")
    Observable<UserBean> getLogin(@Field("mobile") String mobile, @Field("password") String password);
    //注册
    @FormUrlEncoded
     @POST("user/reg")
    Observable<UserBean> getReg(@Field("mobile") String mobile, @Field("password") String password);


}
