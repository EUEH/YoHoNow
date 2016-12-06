package com.eueh.yohonow.column.columnson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.eueh.yohonow.R;
import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;
import com.google.gson.Gson;

import java.util.HashMap;

public class ColSonActivity extends BaseActivity {
    private ListView listView;
    private ColSonAdapter adapter;
    private ImageView iv;
    private String url;


    @Override
    public int setLayou() {
        return R.layout.activity_col_son;
    }

    @Override
    public void initView() {
        listView = (ListView) findViewById(R.id.lv_colSon);
        View viewHead = LayoutInflater.from(this).inflate(R.layout.item_col_son_head,null);
        iv = (ImageView) viewHead.findViewById(R.id.iv_col_son_head);

        listView.addHeaderView(viewHead);


        adapter = new ColSonAdapter(this);
        listView.setAdapter(adapter);

    }

    @Override
    public void initData() {

        //获取从上一层传过来的id
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        url = intent.getStringExtra("url");
        Glide.with(this).load(url).into(iv);
        Log.d("ColSonActivity", url);

        String LOOKBOOKBANNER = "http://new.yohoboys.com/yohoboyins/v5/channel/lookbookbanner";
        String LOOKBOOK = "http://new.yohoboys.com/yohoboyins/v5/channel/lookbook";

        //map
        HashMap<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("page","1");
        map.put("limit","20");
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

        //解析数据
        NetHelper.MyRequest(LOOKBOOK, ColSonBean.class, new NetListener<ColSonBean>() {
            @Override
            public void successListener(ColSonBean response) {
                adapter.setData(response);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        },mapSure);

    }
}
