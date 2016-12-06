package com.eueh.yohonow.recommend;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.eueh.yohonow.MainActivity;
import com.eueh.yohonow.R;
import com.eueh.yohonow.Search.SearchActivity;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseFragment;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dllo on 16/11/23.
 */

public class RecommendFragment extends BaseFragment implements View.OnClickListener, OnRefreshListener, OnLoadMoreListener {
    private ListView listView;
    //   private BeanRec bean;
    private View viewone;
    private Banner banner;
    private ArrayList<String> picsone;
    //  private BeanRun data_pic;
    private RequestQueue requestQueue;
    private ImageView ivBtn, ivRecRight;
    private DrawerLayout drawerLayout;
    private RecommendAdapter adapter;

    private SwipeToLoadLayout swipeToLoadLayout;
    private int num = 0;

    //解析post接口用到的
    private HashMap<String, String> mapnew;
    private HashMap<String, String> map;
    private String value;
    private Gson gson;
    //用来盛放  新的数据+第一次的数据 传递给适配器
    private BeanRec data;
    private String urlCommend;

    @Override
    protected int setLayout() {
        return R.layout.fragment_recommend;
    }

    //绑定ID
    @Override
    public void initView(View view) {

        swipeToLoadLayout = (SwipeToLoadLayout) view.findViewById(R.id.swipe_to_load_layout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

        //推荐页右上角按钮
        ivRecRight = (ImageView) view.findViewById(R.id.iv_rec_right);
        ivRecRight.setOnClickListener(this);
        //推荐页左上角的点击按钮
        ivBtn = (ImageView) view.findViewById(R.id.iv_btn_drawer);
        //绑定抽屉布局的id
        drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.activity_main);
        ivBtn.setOnClickListener(this);
        listView = (ListView) view.findViewById(R.id.swipe_target);
        //头布局(轮播图)
        viewone = LayoutInflater.from(getActivity()).inflate(R.layout.item_rec_head, null);
        banner = (Banner) viewone.findViewById(R.id.banner);
        listView.addHeaderView(viewone);

        urlCommend = YohoApi.URLRECOMMEND;
    }

    //代码
    @Override
    public void initData() {
        requestQueue = Volley.newRequestQueue(getContext());
        //推荐页数据请求
        recMy();
        //调用轮播图解析方法
        findUrl();
        myMap();
    }

    //推荐页面的HashMap
    private void myMap() {
        map = new HashMap<>();
        map.put("newsEndtime", "0");
        map.put("otherEndTime", "0");
        map.put("magazineType", "3");
        map.put("WallpaperType", "3");
        map.put("scale", "2");
        map.put("num", String.valueOf(num));
        map.put("platform", "4");
        map.put("locale", "zh-Hans");
        map.put("language", "zh-Hans");
        map.put("udid", "00000000000000063aa461b71c4cfcf");
        map.put("curVersion", "5.0.4");

        HashMap<String, String> mm = new HashMap<>();
        mm.put("udid", "00000000000000063aa461b71c4cfcf");
        String a = new Gson().toJson(mm).toString();
        map.put("authInfo", a);
        gson = new Gson();
        value = gson.toJson(map).toString();
        mapnew = new HashMap<>();
        mapnew.put("parameters", value);
        Log.d("吱吱吱", map.get("num"));

    }

    private void recMy() {

        NetHelper.MyRequest(urlCommend, BeanRec.class, new NetListener<BeanRec>() {
            @Override
            public void successListener(BeanRec response) {
                adapter = new RecommendAdapter(getContext());
                Log.d("RecommendFragment", "response.getData().size():" + response.getData().size());
                adapter.setData(response);
                listView.setAdapter(adapter);
                data = response;
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        }, mapnew);

        //   myMap();
    }


    //轮播图的解析
    private void findUrl() {
        String urlrun = YohoApi.URLRUN;
        HashMap<String, String> map = new HashMap<>();
        map.put("language", "zh-Hans");
        map.put("platform", "4");
        map.put("locale", "zh-Hans");
        map.put("udid", "00000000000000063aa461b71c4cfcf");
        map.put("curVersion", "5.0.4");

        HashMap<String, String> mm = new HashMap<>();
        mm.put("udid", "00000000000000063aa461b71c4cfcf");
        Gson gson = new Gson();
        String str = gson.toJson(mm).toString();
        map.put("authInfo", str);
        String value = gson.toJson(map).toString();
        HashMap<String, String> mapBanner = new HashMap<>();
        mapBanner.put("parameters", value);

        NetHelper.MyRequest(urlrun, BeanRun.class, new NetListener<BeanRun>() {
            @Override
            public void successListener(BeanRun response) {
                picsone = new ArrayList<>();
                for (int i = 0; i < response.getData().size(); i++) {
                    picsone.add(response.getData().get(i).getImage());
                }
                useUrl(picsone);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });


    }

    //轮播图的banner
    private void useUrl(ArrayList<String> data) {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new MyImage());
        banner.setImages(data);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getContext(), "qunimade", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //推荐页面的左上角的点击事件(点击弹出抽屉)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_btn_drawer:
                //弹出抽屉(MainActivity 提供的方法)
                MainActivity.drawer(drawerLayout);
                break;
            case R.id.iv_rec_right:
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in_from_right, R.anim.out_to_bot);
                break;
        }

    }

    //刷新
    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
                getRefreshData();
            }
        }, 2000);
    }

    public void getRefreshData() {

        NetHelper.MyRequest(urlCommend, BeanRec.class, new NetListener<BeanRec>() {
            @Override
            public void successListener(BeanRec response) {
                Log.d("hahaha", "response.getData():" + response.getData());
                adapter.setData(response);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        }, mapnew);

    }

    //加载
    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                getLoadData();
            }
        }, 3000);
    }

    private void getLoadData() {
        NetHelper.MyRequest(urlCommend, BeanRec.class, new NetListener<BeanRec>() {
            @Override
            public void successListener(BeanRec response) {
                adapter.addMore(response);
                map.put("num", String.valueOf(num));
                num += 16;
                value = gson.toJson(map).toString();
                mapnew.put("parameters", value);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        }, mapnew);
    }
}
