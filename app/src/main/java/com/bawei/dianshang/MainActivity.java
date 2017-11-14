package com.bawei.dianshang;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.dianshang.cart.Fragemnt_Classisy;
import com.bawei.dianshang.fragment.Fragemnt_Find;
import com.bawei.dianshang.home.view.Fragment_Home;
import com.bawei.dianshang.mine.view.Fragment_My;
import com.bawei.dianshang.shop.view.Fragment_Shop;

public class MainActivity extends AppCompatActivity {
    private RadioButton main_rb_homepage;
    private RadioButton main_rb_classify;
    private RadioButton main_rb_find;
    private RadioButton main_rb_shoppingcar;
    private RadioButton main_rb_my;
    private RadioGroup main_rg;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private FrameLayout framelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //更改Fragmnet
        setFragment();
        //更改底部图片大小
        changeImageSize();

    }

    private void changeImageSize() {
        //定义底部标签图片大小
        Drawable drawableFirst = getResources().getDrawable(R.drawable.homepage_check);
        drawableFirst.setBounds(0, 0, 120, 120);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        main_rb_homepage.setCompoundDrawables(null, drawableFirst, null, null);//只放上面

        Drawable drawableSearch = getResources().getDrawable(R.drawable.classify_check);
        drawableSearch.setBounds(0, 0, 120, 120);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        main_rb_classify.setCompoundDrawables(null, drawableSearch, null, null);//只放上面

        Drawable drawableMe = getResources().getDrawable(R.drawable.find_check);
        drawableMe.setBounds(0, 0, 120, 120);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        main_rb_find.setCompoundDrawables(null, drawableMe, null, null);//只放上面

        Drawable drawableMe1 = getResources().getDrawable(R.drawable.shoppingcar_check);
        drawableMe1.setBounds(0, 0, 120, 120);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        main_rb_shoppingcar.setCompoundDrawables(null, drawableMe1, null, null);//只放上面

        Drawable drawableMe2 = getResources().getDrawable(R.drawable.my_check);
        drawableMe2.setBounds(0, 0, 120, 120);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        main_rb_my.setCompoundDrawables(null, drawableMe2, null, null);//只放上面
    }

    private void setFragment() {
       manager = getSupportFragmentManager();
       transaction = manager.beginTransaction();


        main_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.main_rb_homepage:
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragmentlayout, new Fragment_Home()).commit();

                        break;
                    case R.id.main_rb_classify:
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragmentlayout, new Fragemnt_Classisy()).commit();

                        break;
                    case R.id.main_rb_find:
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragmentlayout, new Fragemnt_Find()).commit();

                        break;
                    case R.id.main_rb_shoppingcar:
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragmentlayout, new Fragment_Shop()).commit();

                        break;
                    case R.id.main_rb_my:
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragmentlayout, new Fragment_My()).commit();
                        break;
                }
            }
        });
    }
    private void initView() {
       framelayout = (FrameLayout) findViewById(R.id.fragmentlayout);
        main_rb_homepage = (RadioButton) findViewById(R.id.main_rb_homepage);
        main_rb_classify = (RadioButton) findViewById(R.id.main_rb_classify);
        main_rb_find = (RadioButton) findViewById(R.id.main_rb_find);
        main_rb_shoppingcar = (RadioButton) findViewById(R.id.main_rb_shoppingcar);
        main_rb_my = (RadioButton) findViewById(R.id.main_rb_my);
        main_rg = (RadioGroup) findViewById(R.id.mian_group);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            //            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            //            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            //            // 激活状态栏
            //            tintManager.setStatusBarTintEnabled(true);
            //            // 激活导航栏
            //            tintManager.setNavigationBarTintEnabled(true);
            //            //设置系统栏设置颜色
            //            // tintManager.setTintColor(R.color.colorPrimary);
            //            //给状态栏设置颜色
            //            tintManager.setStatusBarTintResource(Color.argb(0, 0, 0, 0));
            //            //Apply the specified drawable or color resource to the system navigation bar.
            //            //给导航栏设置资源
            //            tintManager.setNavigationBarTintResource(Color.argb(0, 0, 0, 0));

        }

    }
}
