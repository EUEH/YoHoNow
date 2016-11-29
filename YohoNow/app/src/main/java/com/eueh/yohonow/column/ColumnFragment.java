package com.eueh.yohonow.column;

import android.content.pm.LabeledIntent;
import android.util.Log;
import android.view.LayoutInflater;
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

/**
 * Created by dllo on 16/11/23.
 */

public class ColumnFragment extends BaseFragment {
    private BeanCol bean;
    private ListView listView;
    private ColumnAdapter adapter;
    private View viewone;

    @Override
    protected int setLayout() {
        return R.layout.fragment_column;
    }

    @Override
    public void initView(View view) {
        listView = (ListView) view.findViewById(R.id.lv_column);
        viewone = LayoutInflater.from(getActivity()).inflate(R.layout.item_col_head,null);
    }

    @Override
    public void initData() {
        //解析数据
        String urlcolumn = YohoApi.URLCOIUMN;
        adapter = new ColumnAdapter(getContext());
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(urlcolumn, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                bean = gson.fromJson(response, BeanCol.class);

                adapter.setData(bean);
                listView.addHeaderView(viewone);
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
