package com.eueh.yohonow.column;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.eueh.yohonow.column.columnson.ColSonActivity;
import com.eueh.yohonow.R;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseFragment;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by dllo on 16/11/23.
 */

public class ColumnFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener, AdapterView.OnItemClickListener {
    private BeanCol data;
    private ListView listView;
    private ColumnAdapter adapter;
    private View viewone;
    private SwipeToLoadLayout swipeToLoadLayout;
    private String me = "";
    private int q = 1;

    private Gson gson;
    private String values;
    private String num = "0";
    private HashMap<String, String> mapsure;
    private String urlcolumn;
    private HashMap<String, String> map;

    @Override
    protected int setLayout() {
        return R.layout.fragment_column;
    }

    @Override
    public void initView(View view) {

        swipeToLoadLayout = (SwipeToLoadLayout) view.findViewById(R.id.swipe_to_load_layout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

        listView = (ListView) view.findViewById(R.id.swipe_target);
        viewone = LayoutInflater.from(getActivity()).inflate(R.layout.item_col_head, null);
        listView.addHeaderView(viewone);
        adapter = new ColumnAdapter(getContext());

        listView.setOnItemClickListener(this);

    }

    //post  map
    private void columnMap() {
        map = new HashMap<>();
        map.put("limit", "12");

        map.put("lastTime", num);

        map.put("startTime", "0");
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
        values = gson.toJson(map).toString();

        mapsure = new HashMap<>();
        mapsure.put("parameters", values);
    }

    @Override
    public void initData() {



        //解析数据
        urlcolumn = YohoApi.URLCOIUMN;

        columnMap();

        NetHelper.MyRequest(urlcolumn, BeanCol.class, new NetListener<BeanCol>() {


            @Override
            public void successListener(BeanCol response) {
                adapter.setData(response);

                //判断数据
                if (q == 1) {
                    me = response.getData().get(response.getData().size() - 1).getCreate_time();
                }

                //传数据的时候用
                data = response;
                listView.setAdapter(adapter);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        }, mapsure);

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
        NetHelper.MyRequest(urlcolumn, BeanCol.class, new NetListener<BeanCol>() {
            @Override
            public void successListener(BeanCol response) {
                adapter.setData(response);
                data = response;
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        }, mapsure);
    }

    //加载
    @Override
    public void onLoadMore() {

        //让其第一个接口的数据只加载一遍
        if (q == 1) {
            num = me;
            map.put("lastTime", num);
            values = gson.toJson(map).toString();
            mapsure.put("parameters", values);
            q = -1;
        }


        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);

                getLoadData();
            }
        }, 2000);
    }

    private void getLoadData() {

        NetHelper.MyRequest(urlcolumn, BeanCol.class, new NetListener<BeanCol>() {
            @Override
            public void successListener(BeanCol response) {
                adapter.addMore(response);

                data.getData().addAll(response.getData());
                //接口中是空的,让其重复加载
                if (response.getData().isEmpty()) {
                    num = "0";
                } else {
                    num = response.getData().get(response.getData().size() - 1).getCreate_time();
                }

                //更新map
                map.put("lastTime", num);
                values = gson.toJson(map).toString();
                mapsure.put("parameters", values);


            }

            @Override
            public void errorListener(VolleyError error) {

            }
        }, mapsure);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String id = data.getData().get(i).getId();
        String url = data.getData().get(i).getCover();

        Intent intent = new Intent(getContext(), ColSonActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("url",url);
        startActivity(intent);
    }
}
