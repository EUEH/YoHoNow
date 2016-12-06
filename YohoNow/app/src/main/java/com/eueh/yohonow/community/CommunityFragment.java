package com.eueh.yohonow.community;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dalong.francyconverflow.FancyCoverFlow;
import com.eueh.yohonow.R;
import com.eueh.yohonow.Tolls;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseFragment;
import com.eueh.yohonow.community.fancycover.Beancover;
import com.eueh.yohonow.community.fancycover.MyFancyCoverFlowAdapter;
import com.eueh.yohonow.recommend.MyImage;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class CommunityFragment extends BaseFragment {
    private BeanCom bean;
    private ListView listView;
    private Beancover beancover;
    private FancyCoverFlow mfancyCoverFlow;
    private MyFancyCoverFlowAdapter mMyFancyCoverFlowAdapter;
    private View viewTwo;
    private ArrayList<Integer> dataNew;
    private Banner banner;

    @Override
    protected int setLayout() {
        return R.layout.fragment_community;
    }

    @Override
    public void initView(View view) {
        listView = (ListView) view.findViewById(R.id.lv_community);
        View viewOne = LayoutInflater.from(getContext()).inflate(R.layout.item_com_head_top,null);
        banner = (Banner) viewOne.findViewById(R.id.banner_com_head_top);


        viewTwo = LayoutInflater.from(getContext()).inflate(R.layout.item_com_head_bot,null);
        listView.addHeaderView(viewOne);
        listView.addHeaderView(viewTwo);
        dataNew = new ArrayList<>();


    }

    @Override
    public void initData() {
        readFriend();
        readFancyCover();
        runTop();
    }

    //一张图的轮播图
    private void runTop() {
        dataNew.add(R.mipmap.yohocomtop);
        dataNew.add(R.mipmap.yohocomtop);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new MyImage());
        banner.setImages(dataNew);
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.start();

    }

    //采用封装的解析(FancyCover)
    private void readFancyCover() {

        String URLCOVER = YohoApi.URLCOVER;
        NetHelper.MyRequest(URLCOVER, Beancover.class, new NetListener<Beancover>() {
            @Override
            public void successListener(Beancover response) {

                mMyFancyCoverFlowAdapter = new MyFancyCoverFlowAdapter(getContext());
                mfancyCoverFlow = (FancyCoverFlow) viewTwo.findViewById(R.id.fancyCoverFlow);
                mMyFancyCoverFlowAdapter.setData(response);
                mfancyCoverFlow.setAdapter(mMyFancyCoverFlowAdapter);
                mMyFancyCoverFlowAdapter.notifyDataSetChanged();
                mfancyCoverFlow.setSelection(1);
                mfancyCoverFlow.setUnselectedAlpha(1);
                mfancyCoverFlow.setUnselectedSaturation(0.5f);
                mfancyCoverFlow.setUnselectedScale(0.3f);
                mfancyCoverFlow.setSpacing(-50);
                mfancyCoverFlow.setMaxRotation(0);
                mfancyCoverFlow.setScaleDownGravity(0.5f);
                mfancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    //解析社区中朋友圈接口
    private void readFriend() {
        String URLPEOPLE = YohoApi.URLPEOPLE;
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(URLPEOPLE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                bean = new BeanCom();
                bean = gson.fromJson(response,BeanCom.class);

                ComAdapter adapter = new ComAdapter(getContext());
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
}
