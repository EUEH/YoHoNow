package com.eueh.yohonow;

import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.column.ColumnFragment;
import com.eueh.yohonow.community.CommunityFragment;
import com.eueh.yohonow.gridview.InCollectActivity;
import com.eueh.yohonow.magazine.MagazineFragment;
import com.eueh.yohonow.recommend.RecommendFragment;
import com.eueh.yohonow.video.VideoFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton rbtnRecommend, rbtnColumn, rbtnCommunity, rbtnVideo, rbtnMagazine;
    private DrawerLayout drawerLayout;
    private ImageView ivLogin,ivSet;
    private TextView tvCollectIn;

    private long exitTime = 0;


    @Override
    public int setLayou() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        rbtnRecommend = (RadioButton) findViewById(R.id.rbtn_recommend);
        rbtnColumn = (RadioButton) findViewById(R.id.rbtn_column);
        rbtnCommunity = (RadioButton) findViewById(R.id.rbtn_community);
        rbtnVideo = (RadioButton) findViewById(R.id.rbtn_video);
        rbtnMagazine = (RadioButton) findViewById(R.id.rbtn_magazine);
        ivLogin = (ImageView) findViewById(R.id.iv_main_login);
        ivSet = (ImageView) findViewById(R.id.iv_set);
        tvCollectIn = (TextView) findViewById(R.id.tv_collect_in);

        tvCollectIn.setOnClickListener(this);
        ivSet.setOnClickListener(this);
        ivLogin.setOnClickListener(this);
        rbtnRecommend.setOnClickListener(this);
        rbtnColumn.setOnClickListener(this);
        rbtnCommunity.setOnClickListener(this);
        rbtnVideo.setOnClickListener(this);
        rbtnMagazine.setOnClickListener(this);
        replace(new RecommendFragment());

        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);

    }

    @Override
    public void initData() {

    }

    //监听
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rbtn_recommend:
                replace(new RecommendFragment());
                break;
            case R.id.rbtn_column:
                replace(new ColumnFragment());
                //在每个rbtn点击事件中,关闭抽屉
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                break;
            case R.id.rbtn_community:
                replace(new CommunityFragment());
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                break;
            case R.id.rbtn_video:
                replace(new VideoFragment());
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                break;
            case R.id.rbtn_magazine:
                replace(new MagazineFragment());
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                break;

            //抽屉登陆监听
            case R.id.iv_main_login:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right,R.anim.out_to_bot);
                break;
            //抽屉设置监听
            case R.id.iv_set:
                Intent intentSet = new Intent(this,SetActivity.class);
                startActivity(intentSet);
                overridePendingTransition(R.anim.in_from_right,R.anim.out_to_bot);
                break;
            //收藏的点击事件
            case R.id.tv_collect_in:
                Intent intenttwo = new Intent(MainActivity.this,InCollectActivity.class);
                startActivity(intenttwo);
                break;
        }

    }
    public void replace (Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fmly,fragment);
        transaction.commit();
    }

    //抽屉的静态方法
    public static void drawer(DrawerLayout drawerLayout){
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        drawerLayout.openDrawer(Gravity.LEFT);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void  exit(){
        if (System.currentTimeMillis() - exitTime > 2000){
            Toast.makeText(this, "もう少しだけでいい あと少しだけでいい ", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        }else {
            finish();
            System.exit(0);
        }
    }
}
