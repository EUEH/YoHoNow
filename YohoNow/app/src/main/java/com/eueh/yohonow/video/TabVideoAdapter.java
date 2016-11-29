package com.eueh.yohonow.video;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/25.
 */

public class TabVideoAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>data;
    private String title[] = {"VIDEO","直播"};
    public TabVideoAdapter(FragmentManager fm) {
        super(fm);
    }

    public TabVideoAdapter(FragmentManager fm, ArrayList<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
