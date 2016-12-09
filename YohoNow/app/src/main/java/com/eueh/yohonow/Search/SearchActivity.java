package com.eueh.yohonow.Search;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.VolleyError;
import com.eueh.yohonow.R;
import com.eueh.yohonow.Search.SpMySearch.AdapterEuen;
import com.eueh.yohonow.Search.SpMySearch.Bean;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;

import java.util.ArrayList;

public class SearchActivity extends BaseActivity implements View.OnClickListener, TextWatcher, TextView.OnEditorActionListener, AdapterView.OnItemClickListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private EditText etSearch;
    private ImageView ivLeft, ivRight, iv_close_gr;
    private RelativeLayout llSp;
    private int a = 0;
    private GridView gridView;
    private AdapterEuen adapterEuen;
    private ArrayList<Bean> data;
    private Bean beanSp;
    private SharedPreferences.Editor editor;

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
        llSp = (RelativeLayout) findViewById(R.id.ll_sp);
        gridView = (GridView) findViewById(R.id.gv_euen);
        iv_close_gr = (ImageView) findViewById(R.id.iv_close_gr);


        gridView.setOnItemClickListener(this);

        iv_close_gr.setOnClickListener(this);
        ivLeft.setOnClickListener(this);
        etSearch.setOnClickListener(this);
        etSearch.addTextChangedListener(this);
        ivRight.setOnClickListener(this);
        etSearch.setOnEditorActionListener(this);
    }

    @Override
    public void initData() {
        beanSp = new Bean();
        data = new ArrayList<>();
        readSearch();
        editor = getSharedPreferences("find", MODE_PRIVATE).edit();


    }

    //复用中标题的解析(Tab)
    private void readSearch() {
        String URLSEARCHTAB = YohoApi.URLSEARCHTAB;
        NetHelper.MyRequest(URLSEARCHTAB, BeanTab.class, new NetListener<BeanTab>() {
            @Override
            public void successListener(BeanTab response) {
                SearchAdapter adapter = new SearchAdapter(getSupportFragmentManager());
                adapter.setData(response);
                viewPager.setAdapter(adapter);
                tabLayout.setTabTextColors(Color.BLACK, Color.BLACK);
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
        switch (view.getId()) {
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

                //sp取出
                SharedPreferences sp = getSharedPreferences("find", MODE_PRIVATE);

                for (int i = 0; i < a - 1; i++) {
                    Log.d("SearchActivity", "小X内a-1的数值" + (a - 1));
                    String str = sp.getString(String.valueOf(a - 1), "默认数据");
                    Log.d("SearchActivity", "str的内容" + str);
                    beanSp.setText(str);
                    data.add(beanSp);
                }

                //grideview
                adapterEuen = new AdapterEuen(this);
                adapterEuen.setData(data);
                gridView.setAdapter(adapterEuen);


                break;
            //最右边的X的点击事件
            case R.id.iv_search_right:
                if (etSearch.length() > 0) {
                    etSearch.setText("");
                    ivLeft.setVisibility(View.GONE);
                    tabLayout.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.VISIBLE);
                } else {
                    finish();
                }
                break;

            //清空Sp
            case R.id.iv_close_gr:
                //崩啦
                editor.clear();
                editor.commit();
                data.clear();
                adapterEuen.setData(data);
                Toast.makeText(this, "999999999", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    //EditText 的改变监听事件
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (!charSequence.toString().isEmpty()) {
            ivLeft.setVisibility(View.VISIBLE);
        } else {
            ivLeft.setVisibility(View.GONE);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    //EditText 回车的监听
    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if ( (keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
            //sp存数据
            String me = etSearch.getText().toString();

            Log.d("SearchActivity", "me的值" + me);



            editor.putString(String.valueOf(a), me);

            Log.d("SearchActivity", "a加之前:" + a);

            a++;

            Log.d("SearchActivity", "a加了之后" + a);

            editor.commit();

            return true;
        }
        return false;
    }


    //gridView 的点击事件
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        etSearch.setText(data.get(i).getText());
    }
}
