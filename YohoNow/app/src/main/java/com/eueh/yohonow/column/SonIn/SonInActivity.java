package com.eueh.yohonow.column.SonIn;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.eueh.yohonow.R;
import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.xml.transform.Source;

public class SonInActivity extends BaseActivity {
   private WebView webView;
    private WebSettings webSettings;

    @Override
    public int setLayou() {
        return R.layout.activity_son_in;
    }

    @Override
    public void initView() {
        webView = (WebView) findViewById(R.id.wb);
        webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setTextSize(WebSettings.TextSize.LARGEST);

    }

    @Override
    public void initData() {

        String URLCONTENTDETAIL = "http://new.yohoboys.com/yohoboyins/v5/channel/getContentDetail";
        Intent intent = getIntent();
        String idSon = intent.getStringExtra("idSon");
        String cidSon = intent.getStringExtra("cidSon");

        Log.d("mememememememme", idSon);
        Log.d("mememememememme", cidSon);

        HashMap<String,String> map = new HashMap<>();
        map.put("cid",cidSon);
        map.put("id",idSon);
        map.put("app","1");
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

        NetHelper.MyRequest(URLCONTENTDETAIL, SonInBean.class, new NetListener<SonInBean>() {
            @Override
            public void successListener(SonInBean response) {
             //webView
              webView.loadDataWithBaseURL("about:blank",response.getData().getContents().getContent(),"text/html"
              ,"utf-8",null);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        },mapSure);


    }
}
