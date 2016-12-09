package com.eueh.yohonow.welcome;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.eueh.yohonow.R;
import com.eueh.yohonow.base.BaseActivity;

public class WelcomeFirstActivity extends BaseActivity {
    private ImageView iv;
    private TimeCount time;


    @Override
    public int setLayou() {
        return R.layout.activity_welcome_first;
    }

    @Override
    public void initView() {
        iv = (ImageView) findViewById(R.id.iv_welcome_first);
        iv.setImageResource(R.mipmap.yohofirstpageme);
    }

    @Override
    public void initData() {
        time = new TimeCount(2000,1000);
        time.start();
    }
    class TimeCount extends CountDownTimer{

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {

        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(WelcomeFirstActivity.this, WelcomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
