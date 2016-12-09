package com.eueh.yohonow.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eueh.yohonow.R;
import com.eueh.yohonow.Tolls;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/24.
 */

public class RecommendAdapter extends BaseAdapter {
    private BeanRec data;
    private Context context;

    public RecommendAdapter(Context context) {
        this.context = context;
    }

    public void setData(BeanRec data) {
        this.data = data;
        notifyDataSetChanged();
    }

    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;
    private static final int TYPE_THREE = 2;
    private static final int TYPE_FOUR = 3;
    private static final int TYPE_COUNT = 10;

    @Override
    public int getCount() {
        return data != null && data.getData().size() > 0 ? data.getData().size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return data != null ? data.getData().get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        int type = data.getData().get(position).getType();
        if (type == 0) {
            return 0;
        } else if (type == 3) {
            return 2;
        } else if (type == 2) {
            return 1;
        } else {
            return 3;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolderOne holderOne = null;
        ViewHolderTwo holderTwo = null;
        ViewHolderThree holderThree = null;
        ViewHolderFour holderFour = null;

        if (view == null) {
            switch (getItemViewType(i)) {
                case TYPE_ONE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_rec_one, viewGroup, false);
                    holderOne = new ViewHolderOne(view);
                    view.setTag(holderOne);
                    break;
                case TYPE_TWO:
                    view = LayoutInflater.from(context).inflate(R.layout.item_rec_two, viewGroup, false);
                    holderTwo = new ViewHolderTwo(view);
                    view.setTag(holderTwo);
                    break;
                case TYPE_THREE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_rec_three, viewGroup, false);
                    holderThree = new ViewHolderThree(view);
                    view.setTag(holderThree);
                    break;
                case TYPE_FOUR:
                    view = LayoutInflater.from(context).inflate(R.layout.item_rec_four, viewGroup, false);
                    holderFour = new ViewHolderFour(view);
                    view.setTag(holderFour);
                    break;
            }
        } else {
            switch (getItemViewType(i)) {
                case TYPE_ONE:
                    holderOne = (ViewHolderOne) view.getTag();
                    break;
                case TYPE_TWO:
                    holderTwo = (ViewHolderTwo) view.getTag();
                    break;
                case TYPE_THREE:
                    holderThree = (ViewHolderThree) view.getTag();
                    break;
                case TYPE_FOUR:
                    holderFour = (ViewHolderFour) view.getTag();
                    break;
            }
        }
        switch (getItemViewType(i)) {
            case TYPE_ONE:
                if (!data.getData().get(i).getParams().get(0).getImage().isEmpty()){
                    Picasso.with(context).load(data.getData().get(i).getParams().get(0).getImage()).into(holderOne.ivone);
                }
                Picasso.with(context).load(data.getData().get(i).getParams().get(1).getImage()).into(holderOne.ivtwo);
                Picasso.with(context).load(data.getData().get(i).getParams().get(2).getImage()).into(holderOne.ivthree);

                holderOne.tvonefirst.setText(data.getData().get(i).getParams().get(0).getTitle());

                holderOne.tvonethird.setText(Tolls.intoTime(data.getData().get(i).getParams().get(0).getCreate_time()));


                holderOne.tvtwofirst.setText(data.getData().get(i).getParams().get(1).getTitle());

                holderOne.tvtwothird.setText(Tolls.intoTime(data.getData().get(i).getParams().get(1).getCreate_time()));

                holderOne.tvthreefirst.setText(data.getData().get(i).getParams().get(2).getTitle());

                holderOne.tvthreethird.setText(Tolls.intoTime(data.getData().get(i).getParams().get(2).getCreate_time()));


                break;
            case TYPE_TWO:
                Picasso.with(context).load(data.getData().get(i).getParams().get(0).getImage()).into(holderTwo.ivitemttwo);
                holderTwo.tvitemtwotop.setText(data.getData().get(i).getParams().get(0).getTitle());
                holderTwo.tvitemtworight.setText(Tolls.intoTime(data.getData().get(i).getParams().get(0).getCreate_time()));

                break;
            case TYPE_THREE:
                Picasso.with(context).load(data.getData().get(i).getParams().get(0).getCover()).into(holderThree.ivitemthree);
                holderThree.tvitemthreetop.setText(data.getData().get(i).getParams().get(0).getJournal());
                holderThree.tvitemthreebot.setText(data.getData().get(i).getParams().get(0).getSummary());

                break;
            case TYPE_FOUR:

                break;
        }

        return view;
    }
    public void addMore(BeanRec dataMine){
        data.getData().addAll(dataMine.getData());
        notifyDataSetChanged();
    }

    class ViewHolderOne {
        private ImageView ivone, ivtwo, ivthree;
        private TextView tvonefirst, tvonesecond, tvonethird, tvtwofirst, tvtwosecond, tvtwothird, tvthreefirst, tvthreesecond, tvthreethird;

        public ViewHolderOne(View view) {
            ivone = (ImageView) view.findViewById(R.id.rec_one_iv);
            tvonefirst = (TextView) view.findViewById(R.id.rec_one_top);
            tvonesecond = (TextView) view.findViewById(R.id.rec_one_tv_left);
            tvonethird = (TextView) view.findViewById(R.id.rec_one_tv_right);

            ivtwo = (ImageView) view.findViewById(R.id.rec_two_iv);
            tvtwofirst = (TextView) view.findViewById(R.id.rec_two_tv_top);
            tvtwosecond = (TextView) view.findViewById(R.id.rec_two_tv_left);
            tvtwothird = (TextView) view.findViewById(R.id.rec_two_tv_right);

            ivthree = (ImageView) view.findViewById(R.id.rec_three_iv);
            tvthreefirst = (TextView) view.findViewById(R.id.rec_three_tv_top);
            tvthreesecond = (TextView) view.findViewById(R.id.rec_three_tv_left);
            tvthreethird = (TextView) view.findViewById(R.id.rec_three_tv_right);

        }
    }

    class ViewHolderTwo {
        private ImageView ivitemttwo;
        private TextView tvitemtwotop, tvitemtwoleft, tvitemtworight;

        public ViewHolderTwo(View view) {
            ivitemttwo = (ImageView) view.findViewById(R.id.rec_item_two_iv);
            tvitemtwotop = (TextView) view.findViewById(R.id.rec_item_two_tv_top);
            tvitemtwoleft = (TextView) view.findViewById(R.id.rec_item_two_tv_left);
            tvitemtworight = (TextView) view.findViewById(R.id.rec_item_two_tv_right);

        }
    }

    class ViewHolderThree {
        private ImageView ivitemthree;
        private TextView tvitemthreetop, tvitemthreebot;

        public ViewHolderThree(View view) {
            ivitemthree = (ImageView) view.findViewById(R.id.rec_item_three_iv);
            tvitemthreetop = (TextView) view.findViewById(R.id.rec_item_three_tv_top);
            tvitemthreebot = (TextView) view.findViewById(R.id.rec_item_three_tv_bot);
        }
    }


    class ViewHolderFour {

        public ViewHolderFour(View view) {
        }
    }

}

