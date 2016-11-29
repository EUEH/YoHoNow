package com.eueh.yohonow.video;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.eueh.yohonow.R;
import com.eueh.yohonow.base.BaseFragment;
import com.eueh.yohonow.video.videolive.VideoLiveFragment;
import com.eueh.yohonow.video.videoviedeo.VideoSonFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class VideoFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment>data;
    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tb_video);
        viewPager = (ViewPager) view.findViewById(R.id.vp_video);
        data = new ArrayList<>();

    }

    @Override
    public void initData() {
         addFragment();
    }


    //添加tablayout的方法
    private void addFragment() {
        data.add(new VideoSonFragment());
        data.add(new VideoLiveFragment());

        TabVideoAdapter tabadapter = new TabVideoAdapter(getChildFragmentManager(),data);
        viewPager.setAdapter(tabadapter);
        tabLayout.setupWithViewPager(viewPager);


    }

}
