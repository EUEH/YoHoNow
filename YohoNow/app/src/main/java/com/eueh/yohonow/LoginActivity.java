package com.eueh.yohonow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eueh.yohonow.base.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivDot,ivQq,ivClose,ivCloseTop;
    private LinearLayout linearLayout;
    private TextView tvone;

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
        ivCloseTop = (ImageView) findViewById(R.id.iv_image_close_close);
        linearLayout = (LinearLayout) findViewById(R.id.ll_check_f);
        linearLayout.setVisibility(View.GONE);

        ivDot.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        ivCloseTop.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.out_second_bot,R.anim.in_second_right);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_check_dot:
                ivQq.setVisibility(View.VISIBLE);
                tvone.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_check_close:
                linearLayout.setVisibility(View.GONE);
                ivDot.setVisibility(View.VISIBLE);
                ivQq.setVisibility(View.GONE);
                tvone.setVisibility(View.GONE);
                break;
            case R.id.iv_image_close_close:
                finish();
                overridePendingTransition(R.anim.in_second_right,R.anim.out_second_bot);
                break;
        }
    }
}
