package com.eueh.yohonow.welcome;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.eueh.yohonow.MainActivity;
import com.eueh.yohonow.R;
import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;
import com.google.gson.Gson;

import java.util.HashMap;

public class WelcomeActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv;
    private Button btn;
    private TimeCount time;

    @Override
    public int setLayou() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
        iv = (ImageView) findViewById(R.id.iv_welcome);
        btn = (Button) findViewById(R.id.btn_welcome);
        btn.setOnClickListener(this);
        time = new TimeCount(6000,1000);
        time.start();
    }

    @Override
    public void initData() {

        String URLWELCOME = "http://new.yohoboys.com/yohoboyins/v5/common/getSplashScreen";
        HashMap<String,String> map = new HashMap<>();
        map.put("platform","4");
        map.put("locale","zh-Hans");
        map.put("language","zh-Hans");
        map.put("udid","00000000000000063aa461b71c4cfcf");
        map.put("curVersion","5.0.4");
        HashMap<String,String> mm = new HashMap<>();
        mm.put("udid","00000000000000063aa461b71c4cfcf");
        Gson gson = new Gson();
        String a = gson.toJson(mm).toString();
        map.put("authInfo",a);

        String value = gson.toJson(map).toString();
        HashMap<String,String> mapSure = new HashMap<>();
        mapSure.put("parameters",value);

        NetHelper.MyRequest(URLWELCOME, BeanWelcome.class, new NetListener<BeanWelcome>() {
            @Override
            public void successListener(BeanWelcome response) {
                Glide.with(WelcomeActivity.this).load(response.getData().getPic()).into(iv);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        },mapSure);

    }

    //倒计时的点击监听
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
        time.cancel();
        startActivity(intent);
        finish();
    }

    class TimeCount extends CountDownTimer{

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            btn.setText("跳过"+l/1000+"S");
        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
