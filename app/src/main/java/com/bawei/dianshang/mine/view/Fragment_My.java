package com.bawei.dianshang.mine.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dianshang.R;
import com.bawei.dianshang.mine.presenter.MinePresenter;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class Fragment_My extends Fragment implements MineIView,View.OnClickListener{

    private TextView login_back;
    private ImageView login_userImg;
    private EditText login_name;
    private EditText login_pass;
    private TextView login_zhuce;
    private Button login_button;
    private MinePresenter minePresenter;
    private String nameStr;
    private String passStr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.activity_login,null);
        login_back = (TextView) view.findViewById(R.id.login_back);
        login_userImg = (ImageView) view.findViewById(R.id.login_userImg);
        login_name = (EditText) view.findViewById(R.id.login_name);
        login_pass = (EditText) view.findViewById(R.id.login_pass);
        login_zhuce = (TextView) view.findViewById(R.id.login_zhuce);
        login_button = (Button) view.findViewById(R.id.login_button);
        minePresenter = new MinePresenter(this);
        login_back.setOnClickListener(this);
        login_userImg.setOnClickListener(this);
         login_zhuce.setOnClickListener(this);
        login_button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onLoginSuccess(String code) {

    }

    @Override
    public void onLoginFailed(String error) {

    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.login_back://返回
      
        break;
    case R.id.login_userImg:

        break;
    case R.id.login_zhuce://注册
        Toast.makeText(getContext(), "注册", Toast.LENGTH_SHORT).show();
        break;
    case R.id.login_button://登陆

        nameStr = login_name.getText().toString().trim();
        passStr = login_pass.getText().toString().trim();
        if ((nameStr.equals("") || nameStr == null) && (passStr.equals("") || passStr == null)) {
            Toast.makeText(getContext(), "手机号，密码不能为空!", Toast.LENGTH_SHORT).show();
        }else {
            minePresenter.setLoginInfo(nameStr, passStr);
        }
        break;

}
    }




}
