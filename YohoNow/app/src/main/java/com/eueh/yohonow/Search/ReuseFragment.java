package com.eueh.yohonow.Search;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.eueh.yohonow.PostBody;
import com.eueh.yohonow.R;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseFragment;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;

import java.util.HashMap;

/**
 * Created by dllo on 16/11/30.
 */

public class ReuseFragment extends BaseFragment{
    private ListView listView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public void initView(View view) {
        listView = (ListView) view.findViewById(R.id.lv_fragment_search);

    }

    @Override
    public void initData() {

        Bundle bundle = getArguments();
        String msg = bundle.get("key").toString();
        String URLSEARCHCONTENT = YohoApi.URLSEARCHCONTENT;
        HashMap<String,String> map = new HashMap<>();
        PostBody postBody = new PostBody();
        postBody.setChannelId(msg);
        map.put("parameters",postBody.m(postBody));
        NetHelper.MyRequest(URLSEARCHCONTENT, BeanIn.class, new NetListener<BeanIn>() {
            @Override
            public void successListener(BeanIn response) {
                ReuseAdapter adapter = new ReuseAdapter(getContext());
                adapter.setData(response);
                listView.setAdapter(adapter);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        },map);

    }
    public static ReuseFragment newInstance(int pos){
        Bundle args = new Bundle();
        String message = SearchAdapter.getMessage(pos);
        args.putString("key",message);

        ReuseFragment fragment = new ReuseFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
