package com.eueh.yohonow.Search;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.VolleyError;
import com.eueh.yohonow.R;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;

public class SearchActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    public int setLayou() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        viewPager = (ViewPager) findViewById(R.id.vp_search);
        tabLayout = (TabLayout) findViewById(R.id.tab_search);
    }

    @Override
    public void initData() {

        readSearch();
    }

    private void readSearch() {
        String URLSEARCHTAB = YohoApi.URLSEARCHTAB;
        NetHelper.MyRequest(URLSEARCHTAB, BeanTab.class, new NetListener<BeanTab>() {
            @Override
            public void successListener(BeanTab response) {
                SearchAdapter adapter = new SearchAdapter(getSupportFragmentManager());
                adapter.setData(response);
                viewPager.setAdapter(adapter);
                tabLayout.setTabTextColors(Color.BLACK,Color.BLACK);
                tabLayout.setSelectedTabIndicatorColor(Color.BLACK);
                tabLayout.setupWithViewPager(viewPager);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
