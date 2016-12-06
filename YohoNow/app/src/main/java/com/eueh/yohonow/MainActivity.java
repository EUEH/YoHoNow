package com.eueh.yohonow;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.column.ColumnFragment;
import com.eueh.yohonow.community.CommunityFragment;
import com.eueh.yohonow.magazine.MagazineFragment;
import com.eueh.yohonow.recommend.RecommendFragment;
import com.eueh.yohonow.video.VideoFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton rbtnRecommend, rbtnColumn, rbtnCommunity, rbtnVideo, rbtnMagazine;
    private DrawerLayout drawerLayout;
    private ImageView ivLogin,ivSet;


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
}
