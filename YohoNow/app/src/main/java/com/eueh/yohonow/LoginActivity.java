package com.eueh.yohonow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eueh.yohonow.base.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    private ImageView ivDot, ivQq, ivClose, ivCloseTop, ivTopIn;
    private LinearLayout linearLayout;
    private TextView tvone;
    private EditText etTop;

    @Override
    public int setLayou() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        ivDot = (ImageView) findViewById(R.id.iv_check_dot);
        ivQq = (ImageView) findViewById(R.id.iv_check_qq);
        ivClose = (ImageView) findViewById(R.id.iv_check_close);
        tvone = (TextView) findViewById(R.id.tv_check_inter);
        ivTopIn = (ImageView) findViewById(R.id.iv_top_close);

        etTop = (EditText) findViewById(R.id.et_login_top);
        ivCloseTop = (ImageView) findViewById(R.id.iv_image_close_close);
        linearLayout = (LinearLayout) findViewById(R.id.ll_check_f);
        linearLayout.setVisibility(View.GONE);
        ivTopIn.setVisibility(View.GONE);

        ivDot.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        ivCloseTop.setOnClickListener(this);
        ivTopIn.setOnClickListener(this);
        etTop.addTextChangedListener(this);


    }

    @Override
    public void initData() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.out_second_bot, R.anim.in_second_right);
    }

    //各种图片隐藏,出现
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //三个点... 的点击事件
            case R.id.iv_check_dot:
                ivQq.setVisibility(View.VISIBLE);
                tvone.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                break;
            // ^ 上尖括号的
            case R.id.iv_check_close:
                linearLayout.setVisibility(View.GONE);
                ivDot.setVisibility(View.VISIBLE);
                ivQq.setVisibility(View.GONE);
                tvone.setVisibility(View.GONE);
                break;
            //右上角关闭页面
            case R.id.iv_image_close_close:
                finish();
                overridePendingTransition(R.anim.in_second_right, R.anim.out_second_bot);
                break;
            //手机号/邮箱里的关闭号
            case R.id.iv_top_close:
                etTop.setText("");
                ivTopIn.setVisibility(View.GONE);
                break;
            //手机号/邮箱
            case R.id.et_login_top:
                break;
            //
        }
    }

    //第一个 EditText 改变监听
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        ivTopIn.setVisibility(View.VISIBLE);
        if (charSequence.toString().isEmpty()){
            ivTopIn.setVisibility(View.GONE);
        }
    }
    @Override
    public void afterTextChanged(Editable editable) {

    }

}
