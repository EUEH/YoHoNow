package com.eueh.yohonow.Search.SearchSon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.eueh.yohonow.R;
import com.eueh.yohonow.Tolls;
import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;
import com.google.gson.Gson;

import java.util.HashMap;

public class SearchSonActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv,ivFinish;
    private WebView webView;
    private TextView tvOne,tvTwo,tvThree,tvFour;
    private WebSettings webSettings;



    @Override
    public int setLayou() {
        return R.layout.activity_search_son;
    }

    @Override
    public void initView() {
        iv = (ImageView) findViewById(R.id.iv_mine);
        tvOne = (TextView) findViewById(R.id.tv_mainone);
        tvTwo = (TextView) findViewById(R.id.tv_maintwo);
        tvThree = (TextView) findViewById(R.id.tv_mainthree);
        tvFour = (TextView) findViewById(R.id.tv_mainfour);
        webView = (WebView) findViewById(R.id.web_mine);
        ivFinish = (ImageView) findViewById(R.id.iv_finish);
        ivFinish.setOnClickListener(this);

        webSettings = webView.getSettings();
        //设置webview属性
        webSettings.setLoadWithOverviewMode(true);
        //字体
        webSettings.setMinimumFontSize(16);

    }

    @Override
    public void initData() {

        String URLSEARCHSON = "http://new.yohoboys.com/yohoboyins/v5/channel/getContentDetail";
        //获取值
        Intent intent = getIntent();
        String idSearchSon = intent.getStringExtra("idSearchSon");
        String cidSearchSon = intent.getStringExtra("cidSearchSon");
        //map
        HashMap<String,String> map = new HashMap<>();
        map.put("cid",cidSearchSon);
        map.put("id",idSearchSon);
        map.put("app","1");
        map.put("platform","4");
        map.put("locale","zh-Hans");
        map.put("language","zh-Hans");
        map.put("udid","00000000000000063aa461b71c4cfcf");
        map.put("curVersion","5.0.4");

        HashMap<String,String> mapnew  = new HashMap<>();
        mapnew.put("udid","00000000000000063aa461b71c4cfcf");
        Gson gson = new Gson();
        String a = gson.toJson(mapnew).toString();
        map.put("authInfo",a);

        String value = gson.toJson(map).toString();
        HashMap<String,String> mapSure = new HashMap<>();
        mapSure.put("parameters",value);

        NetHelper.MyRequest(URLSEARCHSON, BeanSearchSon.class, new NetListener<BeanSearchSon>() {
            @Override
            public void successListener(BeanSearchSon response) {

                Glide.with(SearchSonActivity.this).load(response.getData().getContents().getImages().get(0)
                .getUrl()).into(iv);
                tvOne.setText(response.getData().getContents().getTitle());
                tvTwo.setText(response.getData().getContents().getAppEditor());
                tvThree.setText(response.getData().getContents().getTag().get(0).getTag_name());
                tvFour.setText(Tolls.intoTime(response.getData().getContents().getCreate_time()));

                webView.loadDataWithBaseURL("about:blank",response.getData().getContents().getContent(),"text/html"
                        ,"utf-8",null);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        },mapSure);


    }

    //返回分享的点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_finish:
                finish();
                break;
        }
    }
}
