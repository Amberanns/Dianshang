package com.bawei.dianshang.mine.view;

/**
 * Created by xue on 2017-11-13.
 */

public interface MineIView {

    /**
     * 代码提供规范
     * 登录成功
     */
    void onLoginSuccess(String code);

    /**
     * 登录失败
     *
     * @param error
     */
    void onLoginFailed(String error);

}
