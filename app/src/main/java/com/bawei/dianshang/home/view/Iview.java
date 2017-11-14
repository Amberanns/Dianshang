package com.bawei.dianshang.home.view;

import com.bawei.dianshang.home.bean.Bean;

import java.util.List;

/**
 * @author 郭丽君
 *         类的作用：
 */

public interface Iview {
    void showSuccess(List<Bean.DataBean> list);
    void showError(String r);



}
