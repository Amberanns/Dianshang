package com.bawei.dianshang.mine.presenter;

import android.util.Log;

import com.bawei.dianshang.mine.bean.UserBean;
import com.bawei.dianshang.mine.model.MineModel;
import com.bawei.dianshang.mine.view.MineIView;


public class MinePresenter implements MineModel.OnFinishLisenter{

    public static final String TAG="MinePresenter";

    private final MineIView mineIView;
    private final MineModel mineModel;

    public MinePresenter(MineIView mineIView) {
        this.mineIView = mineIView;
        this.mineModel = new MineModel();
        mineModel.setOnFinishLisenter(this);
    }

    public void setLoginInfo(String mobile, String password) {
        //将数据传给model层
        mineModel.HttpLogin(mobile,password);
    }

    @Override
    public void onLoginFinish(UserBean userBean) {
        Log.d(TAG, "onLoginFinish: =========="+userBean.getCode());
        String code =userBean.getCode();
        if (code.equals("0")){
            //成功
            mineIView.onLoginSuccess(code);
        }else if(code.equals("1")){
            //失败
            mineIView.onLoginFailed(code);
        }

    }
}
