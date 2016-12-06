package com.eueh.yohonow.Search;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.VolleyError;
import com.eueh.yohonow.R;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;

public class SearchActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private EditText etSearch;
    private ImageView ivLeft,ivRight;
    private LinearLayout llSp;
    @Override
    public int setLayou() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        viewPager = (ViewPager) findViewById(R.id.vp_search);
        tabLayout = (TabLayout) findViewById(R.id.tab_search);
        etSearch = (EditText) findViewById(R.id.et_search);
        ivLeft = (ImageView) findViewById(R.id.iv_search_left);
        ivRight = (ImageView) findViewById(R.id.iv_search_right);
        llSp = (LinearLayout) findViewById(R.id.ll_sp);

        ivLeft.setOnClickListener(this);
        etSearch.setOnClickListener(this);
        etSearch.addTextChangedListener(this);
        ivRight.setOnClickListener(this);
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

    //点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //EditText 的 点击 监听事件
            case R.id.et_search:
                tabLayout.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
                llSp.setVisibility(View.VISIBLE);
                break;
            //EditTex 里小x的点击事件
            case R.id.iv_search_left:
                etSearch.setText("");
                ivLeft.setVisibility(View.GONE);
                break;
            //最右边的X的点击事件
            case R.id.iv_search_right:
                if (etSearch.length()>0){
                    etSearch.setText("");
                    ivLeft.setVisibility(View.GONE);
                    tabLayout.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.VISIBLE);
                }else {
                    finish();
                }
                break;
        }
    }


    //EditText 的改变监听事件
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (!charSequence.toString().isEmpty()){
            ivLeft.setVisibility(View.VISIBLE);
        }else {
            ivLeft.setVisibility(View.GONE);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
