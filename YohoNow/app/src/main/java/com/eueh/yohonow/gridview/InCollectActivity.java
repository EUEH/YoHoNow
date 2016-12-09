package com.eueh.yohonow.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.eueh.yohonow.R;
import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.mygreendao.DBTool;
import com.eueh.yohonow.mygreendao.MyCollect;

import java.util.ArrayList;

public class InCollectActivity extends BaseActivity implements View.OnClickListener {
    private ArrayList<MyCollect> data;
    private GridView gridView;
    private ImageView iv;

    @Override
    public int setLayou() {
        return R.layout.activity_in_collect;
    }
    @Override
    public void initView() {
        iv = (ImageView) findViewById(R.id.iv_seeYou);
        iv.setOnClickListener(this);
        gridView = (GridView) findViewById(R.id.gv_collect);
        data = new ArrayList<>();
    }

    //取出数据库里面的数据
    @Override
    public void initData() {
        for (int i = 0; i < DBTool.getInstance().queryAll().size(); i++) {
            data.add(DBTool.getInstance().queryAll().get(i));
        }
        AdapterInCollect adapterInCollect = new AdapterInCollect(this);
        adapterInCollect.setData(data);
        gridView.setAdapter(adapterInCollect);

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
