package com.eueh.yohonow.magazine.magazinemag;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.eueh.yohonow.CollectActivity;
import com.eueh.yohonow.R;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseFragment;
import com.eueh.yohonow.volley.NetHelper;
import com.eueh.yohonow.volley.NetListener;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/11/25.
 */

public class MagazineMaFragment  extends BaseFragment implements View.OnClickListener {
    private BeanMagmaOne beanOne ;
    private BeanMagmaTwo beanTwo;
    private BeanMagamaThree beanthree;

    private ImageView ivOneFirst,ivOneSecond,ivOneThird,ivTwoFirst,ivTwoSecond,ivTwoThird,ivThreeFirst,ivThreeSecond,ivThreeThird;
    private TextView tvOneFirst,tvOneSecond,tvOneThird,tvTwoFirst,tvTwoSecond,tvTwoThird,tvThreeFirst,tvThreeSecond,tvThreeThird;
    @Override
    protected int setLayout() {
        return R.layout.item_magazine_maga;
    }

    @Override
    public void initView(View view) {
        ivOneFirst = (ImageView) view.findViewById(R.id.iv_mag_one_first);
        ivOneSecond = (ImageView) view.findViewById(R.id.iv_mag_one_second);
        ivOneThird = (ImageView) view.findViewById(R.id.iv_mag_one_third);
        tvOneFirst = (TextView) view.findViewById(R.id.tv_mag_one_first);
        tvOneSecond = (TextView) view.findViewById(R.id.tv_mag_one_second);
        tvOneThird = (TextView) view.findViewById(R.id.tv_mag_one_third);

        ivTwoFirst = (ImageView) view.findViewById(R.id.iv_mag_two_first);
        ivTwoSecond = (ImageView) view.findViewById(R.id.iv_mag_two_second);
        ivTwoThird = (ImageView) view.findViewById(R.id.iv_mag_two_third);
        tvTwoFirst = (TextView) view.findViewById(R.id.tv_mag_two_first);
        tvTwoSecond = (TextView) view.findViewById(R.id.tv_mag_two_second);
        tvTwoThird = (TextView) view.findViewById(R.id.tv_mag_two_third);

        ivThreeFirst = (ImageView) view.findViewById(R.id.iv_mag_three_first);
        ivThreeSecond = (ImageView) view.findViewById(R.id.iv_mag_three_second);
        ivThreeThird = (ImageView) view.findViewById(R.id.iv_mag_three_third);
        tvThreeFirst = (TextView) view.findViewById(R.id.tv_mag_three_first);
        tvThreeSecond = (TextView) view.findViewById(R.id.tv_mag_three_second);
        tvThreeThird = (TextView) view.findViewById(R.id.tv_mag_three_third);


        ivOneFirst.setOnClickListener(this);
        ivOneSecond.setOnClickListener(this);
        ivOneThird.setOnClickListener(this);

        ivTwoFirst.setOnClickListener(this);
        ivTwoSecond.setOnClickListener(this);
        ivTwoThird.setOnClickListener(this);

        ivThreeFirst.setOnClickListener(this);
        ivThreeSecond.setOnClickListener(this);
        ivThreeThird.setOnClickListener(this);

    }

    @Override
    public void initData() {
      readMaOne();
      readMaTwo();
      readMaThree();
    }

    //第三排
    private void readMaThree() {
        String URLMAGMATHREE = YohoApi.URLMAGMATHREE;
        NetHelper.MyRequest(URLMAGMATHREE, BeanMagamaThree.class, new NetListener<BeanMagamaThree>() {
            @Override
            public void successListener(BeanMagamaThree response) {
                beanthree = response;
                Picasso.with(getContext()).load(response.getData().get(0).getCover()).into(ivThreeFirst);
                Picasso.with(getContext()).load(response.getData().get(1).getCover()).into(ivThreeSecond);
                Picasso.with(getContext()).load(response.getData().get(2).getCover()).into(ivThreeThird);
                tvThreeFirst.setText(response.getData().get(0).getJournal());
                tvThreeSecond.setText(response.getData().get(1).getJournal());
                tvThreeThird.setText(response.getData().get(2).getJournal());
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }
    //请求杂志第二排
    private void readMaTwo() {
        String URLMAGMATWO = YohoApi.URLMAGMATWO;

        NetHelper.MyRequest(URLMAGMATWO, BeanMagmaTwo.class, new NetListener<BeanMagmaTwo>() {
            @Override
            public void successListener(BeanMagmaTwo response) {
                beanTwo = response;
                Picasso.with(getContext()).load(response.getData().get(0).getCover()).into(ivTwoFirst);
                Picasso.with(getContext()).load(response.getData().get(1).getCover()).into(ivTwoSecond);
                Picasso.with(getContext()).load(response.getData().get(2).getCover()).into(ivTwoThird);
                tvTwoFirst.setText(response.getData().get(0).getJournal());
                tvTwoSecond.setText(response.getData().get(1).getJournal());
                tvTwoThird.setText(response.getData().get(2).getJournal());
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }

    //请求杂志第一排
    private void readMaOne() {
        String URLMAGMAONE = YohoApi.URLMAGMAONE;

        NetHelper.MyRequest(URLMAGMAONE, BeanMagmaOne.class, new NetListener<BeanMagmaOne>() {
            @Override
            public void successListener(BeanMagmaOne response) {
                beanOne = response;
                Picasso.with(getContext()).load(response.getData().get(0).getCover()).into(ivOneFirst);
                Picasso.with(getContext()).load(response.getData().get(1).getCover()).into(ivOneSecond);
                Picasso.with(getContext()).load(response.getData().get(2).getCover()).into(ivOneThird);
                tvOneFirst.setText(response.getData().get(0).getJournal());
                tvOneSecond.setText(response.getData().get(1).getJournal());
                tvOneThird.setText(response.getData().get(2).getJournal());

            }
            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    //图片的点击事件
    @Override
    public void onClick(View view) {
        //第一排3个
        switch (view.getId()){
            case R.id.iv_mag_one_first:
                Intent intent = new Intent(getContext(), CollectActivity.class);
                intent.putExtra("url",beanOne.getData().get(0).getCover());
                intent.putExtra("text",beanOne.getData().get(0).getJournal());
                startActivity(intent);

                break;
            case R.id.iv_mag_one_second:

                Intent intenttwo = new Intent(getContext(), CollectActivity.class);
                intenttwo.putExtra("url",beanOne.getData().get(1).getCover());
                intenttwo.putExtra("text",beanOne.getData().get(1).getJournal());
                startActivity(intenttwo);

                break;
            case R.id.iv_mag_one_third:
                Intent intentthree = new Intent(getContext(), CollectActivity.class);
                intentthree.putExtra("url",beanOne.getData().get(2).getCover());
                intentthree.putExtra("text",beanOne.getData().get(2).getJournal());
                startActivity(intentthree);

                break;


            //第2排3个
            case R.id.iv_mag_two_first:

                Intent intentfour = new Intent(getContext(), CollectActivity.class);
                intentfour.putExtra("url",beanTwo.getData().get(0).getCover());
                intentfour.putExtra("text",beanTwo.getData().get(0).getJournal());
                startActivity(intentfour);

                break;
            case R.id.iv_mag_two_second:

                Intent intentfive = new Intent(getContext(), CollectActivity.class);
                intentfive.putExtra("url",beanTwo.getData().get(1).getCover());
                intentfive.putExtra("text",beanTwo.getData().get(1).getJournal());
                startActivity(intentfive);

                break;
            case R.id.iv_mag_two_third:
                Intent intentsix = new Intent(getContext(), CollectActivity.class);
                intentsix.putExtra("url",beanTwo.getData().get(2).getCover());
                intentsix.putExtra("text",beanTwo.getData().get(2).getJournal());
                startActivity(intentsix);
                break;


            //第3排3个
            case R.id.iv_mag_three_first:
                Intent intentseven = new Intent(getContext(), CollectActivity.class);
                intentseven.putExtra("url",beanthree.getData().get(0).getCover());
                intentseven.putExtra("text",beanthree.getData().get(0).getJournal());
                startActivity(intentseven);

                break;
            case R.id.iv_mag_three_second:

                Intent intenteight = new Intent(getContext(), CollectActivity.class);
                intenteight.putExtra("url",beanthree.getData().get(1).getCover());
                intenteight.putExtra("text",beanthree.getData().get(1).getJournal());
                startActivity(intenteight);
                break;
            case R.id.iv_mag_three_third:

                Intent intentnine = new Intent(getContext(), CollectActivity.class);
                intentnine.putExtra("url",beanthree.getData().get(2).getCover());
                intentnine.putExtra("text",beanthree.getData().get(2).getJournal());
                startActivity(intentnine);
                break;


        }
    }
}
