package com.eueh.yohonow.video.videoviedeo.videovideoson;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.VolleyError;
import com.eueh.yohonow.R;
import com.eueh.yohonow.Tolls;
import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;
import com.google.gson.Gson;

import java.util.HashMap;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class VideoVideoSonActivity extends BaseActivity implements View.OnClickListener {
    private TextView tvTop, tvLeft, tvRight;
    private VideoView videoView;
    private WebView webView;
    private WebSettings webSettings;
    private ImageView ivFinishMe,ivShare;

    @Override
    public int setLayou() {
        return R.layout.activity_video_video_son;
    }

    @Override
    public void initView() {
        videoView = (VideoView) findViewById(R.id.video_me);
        tvTop = (TextView) findViewById(R.id.tv_top_me);
        tvLeft = (TextView) findViewById(R.id.tv_left_me);
        tvRight = (TextView) findViewById(R.id.tv_right_me);
        ivFinishMe = (ImageView) findViewById(R.id.iv_finish_me);
        ivShare = (ImageView) findViewById(R.id.iv_share);

        ivFinishMe.setOnClickListener(this);
        ivShare.setOnClickListener(this);

        webView = (WebView) findViewById(R.id.tv_vebview);

        webSettings = webView.getSettings();
        //设置webview属性
        webSettings.setLoadWithOverviewMode(true);
        //字体
        webSettings.setMinimumFontSize(16);

    }

    @Override
    public void initData() {

        //分享
        ShareSDK.initSDK(this);

        Intent intent = getIntent();
        String idVideoSon = intent.getStringExtra("idVideoSon");
        String cidVideoSon = intent.getStringExtra("cidVideoSon");
        //  String videoUri = intent.getStringExtra("videoUri");

        String URLVIDEOVIDEOSON = "http://new.yohoboys.com/yohoboyins/v5/channel/getContentDetail";
        //map
        HashMap<String, String> map = new HashMap<>();
        map.put("cid", cidVideoSon);
        map.put("id", idVideoSon);
        map.put("app", "1");
        map.put("platform", "4");
        map.put("locale", "zh-Hans");
        map.put("language", "zh-Hans");
        map.put("udid", "00000000000000063aa461b71c4cfcf");
        map.put("curVersion", "5.0.4");
        HashMap<String, String> mm = new HashMap<>();
        mm.put("udid", "00000000000000063aa461b71c4cfcf");
        Gson gson = new Gson();
        String a = gson.toJson(mm).toString();
        map.put("authInfo", a);
        HashMap<String, String> mapSure = new HashMap<>();
        String value = gson.toJson(map).toString();
        mapSure.put("parameters", value);

        NetHelper.MyRequest(URLVIDEOVIDEOSON, BeanVideoVideoSon.class, new NetListener<BeanVideoVideoSon>() {
                    @Override
                    public void successListener(BeanVideoVideoSon response) {

                        //视频
                        videoView.setMediaController(new MediaController(VideoVideoSonActivity.this));
                        videoView.setVideoURI(Uri.parse(response.getData().getContents().getVideoUrl()));
                        videoView.start();

                        //文字
                        tvTop.setText(response.getData().getContents().getTitle());
                        tvLeft.setText(response.getData().getContents().getTag().get(0).getTag_name());
                        tvRight.setText(Tolls.intoTime(response.getData().getContents().getCreate_time()));

                        webView.loadDataWithBaseURL("about:blank", response.getData().getContents().getContent(), "text/html"
                                , "utf-8", null);
                    }

                    @Override
                    public void errorListener(VolleyError error) {

                    }
                }, mapSure);
    }


    //返回+分享点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_finish_me:
                finish();
                break;
            case R.id.iv_share:
                showShare();
                break;
        }
    }


    private void showShare() {
            ShareSDK.initSDK(this);
            OnekeyShare oks = new OnekeyShare();
//关闭sso授权
            oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
            oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
            oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
            oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
            oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
            oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
            oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
            oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
            oks.show(this);

    }
}

