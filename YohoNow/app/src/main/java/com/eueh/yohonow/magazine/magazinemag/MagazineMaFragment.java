package com.eueh.yohonow.magazine.magazinemag;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.eueh.yohonow.R;
import com.eueh.yohonow.YohoApi;
import com.eueh.yohonow.base.BaseFragment;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/11/25.
 */

public class MagazineMaFragment  extends BaseFragment{
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




    }

    @Override
    public void initData() {
      readMaOne();
      readMaTwo();
      readMaThree();
    }

    private void readMaThree() {
        String URLMAGMATHREE = YohoApi.URLMAGMATHREE;

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(URLMAGMATHREE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                beanthree = new BeanMagamaThree();
                beanthree = gson.fromJson(response,BeanMagamaThree.class);

                Picasso.with(getContext()).load(beanthree.getData().get(0).getCover()).into(ivThreeFirst);
                Picasso.with(getContext()).load(beanthree.getData().get(1).getCover()).into(ivThreeSecond);
                Picasso.with(getContext()).load(beanthree.getData().get(2).getCover()).into(ivThreeThird);
                tvThreeFirst.setText(beanthree.getData().get(0).getJournal());
                tvThreeSecond.setText(beanthree.getData().get(1).getJournal());
                tvThreeThird.setText(beanthree.getData().get(2).getJournal());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }

    //请求杂志第二排
    private void readMaTwo() {
        String URLMAGMATWO = YohoApi.URLMAGMATWO;

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(URLMAGMATWO, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                beanTwo = new BeanMagmaTwo();
                beanTwo = gson.fromJson(response,BeanMagmaTwo.class);

                Picasso.with(getContext()).load(beanTwo.getData().get(0).getCover()).into(ivTwoFirst);
                Picasso.with(getContext()).load(beanTwo.getData().get(1).getCover()).into(ivTwoSecond);
                Picasso.with(getContext()).load(beanTwo.getData().get(2).getCover()).into(ivTwoThird);
                tvTwoFirst.setText(beanTwo.getData().get(0).getJournal());
                tvTwoSecond.setText(beanTwo.getData().get(1).getJournal());
                tvTwoThird.setText(beanTwo.getData().get(2).getJournal());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);


    }

    //请求杂志第一排
    private void readMaOne() {
        String URLMAGMAONE = YohoApi.URLMAGMAONE;
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(URLMAGMAONE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                beanOne = new BeanMagmaOne();
                beanOne = gson.fromJson(response,BeanMagmaOne.class);

                Picasso.with(getContext()).load(beanOne.getData().get(0).getCover()).into(ivOneFirst);
                Picasso.with(getContext()).load(beanOne.getData().get(1).getCover()).into(ivOneSecond);
                Picasso.with(getContext()).load(beanOne.getData().get(2).getCover()).into(ivOneThird);
                tvOneFirst.setText(beanOne.getData().get(0).getJournal());
                tvOneSecond.setText(beanOne.getData().get(1).getJournal());
                tvOneThird.setText(beanOne.getData().get(2).getJournal());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

}
