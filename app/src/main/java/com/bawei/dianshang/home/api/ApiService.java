package com.bawei.dianshang.home.api;

import com.bawei.dianshang.home.bean.Bean;

import retrofit2.http.GET;

/**
 * @author 郭丽君
 *         类的作用：
 */

public interface ApiService {
    @GET("AppNews/getNewsList/type/1/p/")
    rx.Observable<Bean> getNoParams();
}
