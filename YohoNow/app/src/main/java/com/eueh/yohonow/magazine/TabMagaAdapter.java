package com.eueh.yohonow.magazine;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/25.
 */

public class TabMagaAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>data;
    private String title[] ={"杂志","壁纸"};
    public TabMagaAdapter(FragmentManager fm) {
        super(fm);
    }

    public TabMagaAdapter(FragmentManager fm, ArrayList<Fragment> data) {
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
