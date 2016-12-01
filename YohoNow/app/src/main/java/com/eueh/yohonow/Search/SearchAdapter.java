package com.eueh.yohonow.Search;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by dllo on 16/11/30.
 */

public class SearchAdapter extends FragmentStatePagerAdapter{
    private static BeanTab data;

    public SearchAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(BeanTab data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return ReuseFragment.newInstance(position) ;
    }

    @Override
    public int getCount() {
        return data != null?data.getData().get(0).getSubNav().size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.getData().get(0).getSubNav().get(position).getChannel_name_cn();
    }

    public static String getMessage(int pos){
        return data.getData().get(0).getSubNav().get(pos).getId();
    }
}
