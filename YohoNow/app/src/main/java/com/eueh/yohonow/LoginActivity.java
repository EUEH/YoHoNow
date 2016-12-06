package com.eueh.yohonow;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eueh.yohonow.base.BaseActivity;
import com.wevey.selector.dialog.NormalAlertDialog;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LoginActivity extends BaseActivity implements View.OnClickListener, TextWatcher, CompoundButton.OnCheckedChangeListener {
    private ImageView ivDot, ivQq, ivClose, ivCloseTop, ivTopIn, ivBot, ivRegist, ivRin;
    private LinearLayout linearLayout;
    private TextView tvone, tvMid, tvJump;
    private EditText etTop, etBot, etNum;
    private Button btnLogin, btnRnext;
    private CheckBox check;
    private LinearLayout llRegist;

    private View viewLogin, viewRegist;
    private ArrayList<View> data;
    private ViewPager vpLogin;
    private LoginAdapter adapter;
    private NormalAlertDialog alertDialog;


    @Override
    public int setLayou() {
        return R.layout.activity_login_main;
    }

    @Override
    public void initView() {
        rigging();

    }

    //绑定各种东西+设置监听
    private void rigging() {
        viewLogin = getLayoutInflater().inflate(R.layout.activity_login, null);
        viewRegist = getLayoutInflater().inflate(R.layout.activity_longin_regist, null);
        vpLogin = (ViewPager) findViewById(R.id.vp_login_main);

        ivRegist = (ImageView) viewRegist.findViewById(R.id.iv_regist);
        ivRin = (ImageView) viewRegist.findViewById(R.id.iv_regist_in);
        etNum = (EditText) viewRegist.findViewById(R.id.et_number);
        llRegist = (LinearLayout) viewRegist.findViewById(R.id.ll_regist);
        btnRnext = (Button) viewRegist.findViewById(R.id.btn_regist_next);
        tvJump = (TextView) viewLogin.findViewById(R.id.tv_jump);
        ivDot = (ImageView) viewLogin.findViewById(R.id.iv_check_dot);
        ivQq = (ImageView) viewLogin.findViewById(R.id.iv_check_qq);
        ivClose = (ImageView) viewLogin.findViewById(R.id.iv_check_close);
        tvone = (TextView) viewLogin.findViewById(R.id.tv_check_inter);
        ivTopIn = (ImageView) viewLogin.findViewById(R.id.iv_top_close);
        ivBot = (ImageView) viewLogin.findViewById(R.id.iv_bot_close);
        etBot = (EditText) viewLogin.findViewById(R.id.et_login_bot);
        btnLogin = (Button) viewLogin.findViewById(R.id.btn_login);
        check = (CheckBox) viewLogin.findViewById(R.id.check_login);
        tvMid = (TextView) viewLogin.findViewById(R.id.tv_mid);
        etTop = (EditText) viewLogin.findViewById(R.id.et_login_top);
        ivCloseTop = (ImageView) viewLogin.findViewById(R.id.iv_image_close_close);
        linearLayout = (LinearLayout) viewLogin.findViewById(R.id.ll_check_f);
        linearLayout.setVisibility(View.GONE);
        ivTopIn.setVisibility(View.GONE);
        ivBot.setVisibility(View.GONE);
        ivDot.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        ivCloseTop.setOnClickListener(this);
        ivTopIn.setOnClickListener(this);
        tvMid.setOnClickListener(this);
        tvJump.setOnClickListener(this);
        ivBot.setOnClickListener(this);
        //给 EditText  设置的监听
        etTop.addTextChangedListener(this);
        etBot.addTextChangedListener(this);
        //checkBox 的监听
        check.setOnCheckedChangeListener(this);
        ivRegist.setOnClickListener(this);
        ivRin.setOnClickListener(this);
        //注册界面 EditText 的 变化监听
        etNum.addTextChangedListener(this);

    }

    @Override
    public void initData() {

        adapter = new LoginAdapter();
        data = new ArrayList<>();
        data.add(viewLogin);
        data.add(viewRegist);
        adapter.setData(data);
        vpLogin.setAdapter(adapter);


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
                // overridePendingTransition(R.anim.in_second_right, R.anim.empty);
                break;
            //手机号/邮箱里的关闭号
            case R.id.iv_top_close:
                etTop.setText("");
                ivTopIn.setVisibility(View.GONE);
                break;
            //    登录第二个 EditText 中 小 X 的点击事件
            case R.id.iv_bot_close:
                etBot.setText("");
                ivBot.setVisibility(View.GONE);
                break;
            //Yoho!Family账号可登陆Yoho!Now 的点击事件
            case R.id.tv_mid:
                dialogMe();
                break;
            //注册界面右上角关闭
            case R.id.iv_regist:
                finish();
                break;
            //EditText 里面的图片的点击事件
            case R.id.iv_regist_in:
                etNum.setText("");
                ivRin.setVisibility(View.GONE);
                break;
            //登陆界面最下面的点击可跳转到登陆界面的
            case R.id.tv_jump:
                vpLogin.setCurrentItem(1);
                break;
        }
    }

    private void dialogMe() {
//        final NormalAlertDialog dialog = new NormalAlertDialog.Builder(LoginActivity.this).setHeight(0.27f)
//                .setWidth(0.87f).setTitleVisible(true).setTitleText("YoHo!Family")
//                .setTitleTextColor(R.color.black)
//                .setContentText("YoHo!Family账号可登陆YoHoBuy!有货YoHo!Now及SHOW")
//                .setContentTextColor(R.color.black).setSingleMode(true)
//                .setSingleButtonText("确定").setSingleButtonTextColor(R.color.black)
//                .setCanceledOnTouchOutside(true)
//                .setSingleListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                }).build();
//        dialog.show();


        final NormalAlertDialog.Builder builder = new NormalAlertDialog.Builder(this);
        builder.setHeight(0.3f);
        builder.setWidth(0.9f).setTitleVisible(true).setTitleText("YoHo!Family")
                .setTitleTextColor(R.color.black)
                .setContentText("YoHo!Family账号可登陆YoHoBuy!有货、YoHo!Now及SHOW")
                .setContentTextColor(R.color.black).setSingleMode(true)
                .setSingleButtonText("确定").setSingleButtonTextColor(R.color.black)
                .setCanceledOnTouchOutside(true);
        builder.setSingleListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  alertDialog.dismiss();
            }
        });
        alertDialog = new NormalAlertDialog(builder);
        alertDialog.show();
    }


    // EditText 改变监听
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        //根据 boolean 型来判断
        boolean strTop = etTop.getText().toString().isEmpty();
        boolean strBot = etBot.getText().toString().isEmpty();
        boolean strRegist = etNum.getText().toString().isEmpty();
        //第一个EditText
        if (!strTop) {
            ivTopIn.setVisibility(View.VISIBLE);
        } else {
            ivTopIn.setVisibility(View.GONE);
        }
        //第二个EditText
        if (!strBot) {
            ivBot.setVisibility(View.VISIBLE);
        } else {
            ivBot.setVisibility(View.GONE);
        }

        //改变按钮颜色
        if (!strTop && !strBot) {
            btnLogin.setBackgroundColor(Color.GREEN);
        } else {
            btnLogin.setBackgroundColor(Color.rgb(162, 162, 162));
        }

        //注册界面的EditText
        if (!strRegist) {
            ivRin.setVisibility(View.VISIBLE);
            btnRnext.setBackgroundColor(Color.GREEN);
        } else {
            ivRin.setVisibility(View.GONE);
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    //checkBox 的点击事件
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if (b) {
            etBot.setInputType(0x90);
        } else {
            etBot.setInputType(0x81);
            // InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
    }
}
