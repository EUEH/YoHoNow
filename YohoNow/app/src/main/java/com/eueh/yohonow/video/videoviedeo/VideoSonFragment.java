package com.eueh.yohonow.video.videoviedeo;

import android.support.v4.app.Fragment;
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

public class VideoSonFragment  extends BaseFragment{
    private BeanVid bean;
    private ListView listView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_videovideo;
    }

    @Override
    public void initView(View view) {
        listView = (ListView) view.findViewById(R.id.lv_video_video);


    }

    @Override
    public void initData() {
        redVideo();

    }

    private void redVideo() {
        String URLVIDEO = YohoApi.URLVIDEO;
        RequestQueue request = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(URLVIDEO, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                bean = new BeanVid();
                bean = gson.fromJson(response,BeanVid.class);

                VideoSonAdapter adapter = new VideoSonAdapter(getContext());
                adapter.setData(bean);
                listView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.add(stringRequest);

    }
}
