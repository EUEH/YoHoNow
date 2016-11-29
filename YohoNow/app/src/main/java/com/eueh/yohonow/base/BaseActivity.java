package com.eueh.yohonow.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dllo on 16/11/23.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayou());
        initView();
        initData();
    }
    //设置布局
     public abstract int setLayou();
    //初始化组件
     public abstract void initView();
    //初始化数据
     public abstract void initData();
}
