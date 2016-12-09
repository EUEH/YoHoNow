package com.eueh.yohonow.video.videoviedeo;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.eueh.yohonow.R;
import com.eueh.yohonow.video.videoviedeo.videovideoson.VideoVideoSonActivity;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseFragment;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;

/**
 * Created by dllo on 16/11/25.
 */

public class VideoSonFragment  extends BaseFragment implements AdapterView.OnItemClickListener {
    private BeanVid data;
    private ListView listView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_videovideo;
    }

    @Override
    public void initView(View view) {
        listView = (ListView) view.findViewById(R.id.lv_video_video);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        redVideo();

    }

    //解析
    private void redVideo() {
        String URLVIDEO = YohoApi.URLVIDEO;
        NetHelper.MyRequest(URLVIDEO, BeanVid.class, new NetListener<BeanVid>() {
            @Override
            public void successListener(BeanVid response) {
                data = response;
                VideoSonAdapter adapter = new VideoSonAdapter(getContext());
                adapter.setData(response);
                listView.setAdapter(adapter);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    //传递到二级页面(视频点击后)
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String idVideoSon = data.getData().getContent().get(i).getId();
        String cidVideoSon = data.getData().getContent().get(i).getCid();
       // String videoUri = data.getData().getContent().get(i).getVideoUrl();
        Intent intent = new Intent(getContext(), VideoVideoSonActivity.class);

        intent.putExtra("idVideoSon",idVideoSon);
        intent.putExtra("cidVideoSon",cidVideoSon);
       // intent.putExtra("videoUri",videoUri);
        startActivity(intent);
    }
}
