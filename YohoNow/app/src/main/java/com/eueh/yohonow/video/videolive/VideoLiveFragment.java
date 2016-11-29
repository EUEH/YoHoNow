package com.eueh.yohonow.video.videolive;

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
 * Created by dllo on 16/11/25.
 */

public class VideoLiveFragment extends BaseFragment {
    private BeanLiv bean;
    private ListView listView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_videolive;
    }

    @Override
    public void initView(View view) {
        listView = (ListView) view.findViewById(R.id.lv_video_live);

    }

    @Override
    public void initData() {

        readLive();
    }

    private void readLive() {
        String URLLIVE = YohoApi.URLLIVE;
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(URLLIVE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                bean = new BeanLiv();
                bean = gson.fromJson(response,BeanLiv.class);

                VideoLiveAdapter adapter = new VideoLiveAdapter(getContext());
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
