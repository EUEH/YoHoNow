package com.eueh.yohonow.magazine.magapage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.eueh.yohonow.R;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/25.
 */

public class MagazinePageFragment extends BaseFragment {
    private BeanPage bean;
    private ListView listView;

    @Override
    protected int setLayout() {
        return R.layout.item_magazine_page;
    }

    @Override
    public void initView(View view) {
        listView = (ListView) view.findViewById(R.id.lv_mag_pag);

    }

    @Override
    public void initData() {

        readPage();
    }

    private void readPage() {
        String URLPAGE = YohoApi.URLPAGE;
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(URLPAGE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                bean = new BeanPage();
                bean = gson.fromJson(response,BeanPage.class);

                MagPagAdapter adapter = new MagPagAdapter(getContext());
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
