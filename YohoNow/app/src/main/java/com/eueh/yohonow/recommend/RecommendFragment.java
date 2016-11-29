package com.eueh.yohonow.recommend;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.eueh.yohonow.MainActivity;
import com.eueh.yohonow.R;
import com.eueh.yohonow.SearchActivity;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseFragment;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class RecommendFragment extends BaseFragment implements View.OnClickListener {
    private ListView listView;
    private BeanRec bean;
    private View viewone;
    private Banner banner;
    private ArrayList<String> picsone;
    private BeanRun data_pic;
    private RequestQueue requestQueue;
    private ImageView ivBtn,ivRecRight;
    private DrawerLayout drawerLayout;

    @Override
    protected int setLayout() {
        return R.layout.fragment_recommend;
    }

    //绑定ID
    @Override
    public void initView(View view) {
        //推荐页右上角按钮
        ivRecRight = (ImageView) view.findViewById(R.id.iv_rec_right);
        ivRecRight.setOnClickListener(this);
        //推荐页左上角的点击按钮
        ivBtn = (ImageView) view.findViewById(R.id.iv_btn_drawer);
        //绑定抽屉布局的id
        drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.activity_main);
        ivBtn.setOnClickListener(this);
        listView = (ListView) view.findViewById(R.id.lv_recommend);
        //头布局(轮播图)
        viewone = LayoutInflater.from(getActivity()).inflate(R.layout.item_rec_head, null);
        banner = (Banner) viewone.findViewById(R.id.banner);
        listView.addHeaderView(viewone);
    }

    //代码
    @Override
    public void initData() {
        requestQueue = Volley.newRequestQueue(getContext());
        //推荐页数据请求
        recMy();
        //调用轮播图解析方法
        findUrl();

    }

    private void recMy() {
        //推荐页数据的解析
        String urlCommend = YohoApi.URLRECOMMEND;
        StringRequest stringRequest = new StringRequest(urlCommend, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                bean = new BeanRec();
                bean = gson.fromJson(response, BeanRec.class);

                RecommendAdapter adapter = new RecommendAdapter(getContext());
                adapter.setData(bean);

                listView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }


    //轮播图的解析
    private void findUrl() {
        String urlrun = YohoApi.URLRUN;

        StringRequest stringRequestone = new StringRequest(urlrun, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("RecommendFragment", response);
                Gson gson = new Gson();
                data_pic = new BeanRun();
                data_pic = gson.fromJson(response, BeanRun.class);
                picsone = new ArrayList<>();

                for (int i = 0; i < data_pic.getData().size(); i++) {
                    picsone.add(data_pic.getData().get(i).getImage());
                }
                //调用banner方法
                useUrl(picsone);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Log.d("RecommendFragment", error.getMessage());
            }
        });

        requestQueue.add(stringRequestone);

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
    }

    //推荐页面的左上角的点击事件(点击弹出抽屉)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_btn_drawer:
                //弹出抽屉(MainActivity 提供的方法)
            MainActivity.drawer(drawerLayout);
                break;
            case R.id.iv_rec_right:
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_to_bot);
                break;
        }

    }
}
