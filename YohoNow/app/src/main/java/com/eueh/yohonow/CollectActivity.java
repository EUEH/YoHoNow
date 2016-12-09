package com.eueh.yohonow;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.eueh.yohonow.base.BaseActivity;
import com.eueh.yohonow.mygreendao.DBTool;
import com.eueh.yohonow.mygreendao.MyCollect;
//杂志的点击存储数据库
public class CollectActivity extends Activity implements View.OnClickListener {
    private ImageView ivBig, ivSmall;
    private TextView tvTop;
    private Button btn;
    private String url;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);

        ivBig = (ImageView) findViewById(R.id.iv_collect_big);
        ivSmall = (ImageView) findViewById(R.id.iv_collect_small);
        tvTop = (TextView) findViewById(R.id.tv_collect_top);
        btn = (Button) findViewById(R.id.tv_collect_bot);
        ivSmall = (ImageView) findViewById(R.id.iv_collect_small);
        ivSmall.setOnClickListener(this);
        btn.setOnClickListener(this);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        text = intent.getStringExtra("text");


        Glide.with(this).load(url).into(ivBig);
        tvTop.setText(text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_collect_small:
                finish();
                break;

            case R.id.tv_collect_bot:
                //查重,再添加
                if (DBTool.getInstance().isSave(url)) {
                    Toast.makeText(this, "泣いたりしたそのあとの空は", Toast.LENGTH_SHORT).show();
                } else {
                    MyCollect myCollect = new MyCollect(null, text, url);
                    DBTool.getInstance().insertMyCollect(myCollect);
                }
                break;
        }
    }
}







