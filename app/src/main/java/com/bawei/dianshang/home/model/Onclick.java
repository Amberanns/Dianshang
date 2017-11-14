package com.bawei.dianshang.home.model;

import com.bawei.dianshang.home.bean.Bean;

import java.util.List;

/**
 * @author 郭丽君
 *         类的作用：
 */

public interface Onclick {
    void  datasuccess(List<Bean.DataBean> list);
    void  error(String rr);
}
