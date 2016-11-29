package com.eueh.yohonow.community.fancycover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dalong.francyconverflow.FancyCoverFlow;
import com.dalong.francyconverflow.FancyCoverFlowAdapter;
import com.eueh.yohonow.R;
import com.eueh.yohonow.Tolls;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/11/28.
 */

public class MyFancyCoverFlowAdapter extends FancyCoverFlowAdapter {
    private Context context;
    private Beancover data;
    private ArrayList<Integer>dataNew;

    public MyFancyCoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setData(Beancover data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setDataNew(ArrayList<Integer> dataNew) {
        this.dataNew = dataNew;
    }

    @Override
    public View getCoverFlowItem(int position, View reusableView, ViewGroup parent) {
        ViewHolder holder;
        if (reusableView ==null){
            reusableView = LayoutInflater.from(context).inflate(R.layout.item_com_head_bot_in,null);
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth()+600;
            reusableView.setLayoutParams(new FancyCoverFlow.LayoutParams(width / 3 ,FancyCoverFlow.LayoutParams.WRAP_CONTENT));
            holder = new ViewHolder();
            holder.linearLayout = (LinearLayout) reusableView.findViewById(R.id.ll_com_bot_in_one);
            holder.ivOne = (ImageView) reusableView.findViewById(R.id.iv_com_bot_in_one);
            holder.ivTwo = (ImageView) reusableView.findViewById(R.id.iv_com_bot_in_two);
            holder.ivBack = (ImageView) reusableView.findViewById(R.id.iv_com_bot_in_bac);
            holder.tvOne = (TextView) reusableView.findViewById(R.id.tv_com_bot_in_one);
            holder.tvTwo = (TextView) reusableView.findViewById(R.id.tv_com_bot_in_two);
            holder.tvThree = (TextView) reusableView.findViewById(R.id.tv_com_bot_in_three);
            holder.tvFour = (TextView) reusableView.findViewById(R.id.tv_com_bot_in_four);
            holder.tvFive = (TextView) reusableView.findViewById(R.id.tv_com_bot_in_five);
            holder.tvSix = (TextView) reusableView.findViewById(R.id.tv_com_bot_in_six);
            holder.tvSeven = (TextView) reusableView.findViewById(R.id.tv_com_bot_in_seven);
            reusableView.setTag(holder);
        }else {
            holder = (ViewHolder) reusableView.getTag();
        }
        //
        if (position == 0){
            holder.linearLayout.setBackgroundResource(R.mipmap.yohocommid1);
        }else if (position == data.getData().getForumInfo().size() + 1){
            holder.linearLayout.setBackgroundResource(R.mipmap.yohocommid1);
        }else {
            Glide.with(context).load(data.getData().getForumInfo().get(position-1).getForumPic()).into(holder.ivBack);
            Glide.with(context).load(Tolls.cutStrings(data.getData().getForumInfo().get(position-1).getHotPost().getUser().getHeadIcon())).bitmapTransform(new CropCircleTransformation(context)).into(holder.ivOne);
            Glide.with(context).load(Tolls.cutStrings(data.getData().getForumInfo().get(position-1).getNewPost().getUser().getHeadIcon())).bitmapTransform(new CropCircleTransformation(context)).into(holder.ivTwo);
            holder.tvOne.setText(data.getData().getForumInfo().get(position-1).getForumName());
            holder.tvTwo.setText("帖子"+String.valueOf(data.getData().getForumInfo().get(position-1).getPostsNum()));
            holder.tvThree.setText("回复"+String.valueOf(data.getData().getForumInfo().get(position-1).getCommentsNum()));
            holder.tvFour.setText("赞"+String.valueOf(data.getData().getForumInfo().get(position-1).getPraiseNum()));
            holder.tvFive.setText(data.getData().getForumInfo().get(position-1).getHotPost().getPostsTitle());
            holder.tvSix.setText(data.getData().getForumInfo().get(position-1).getNewPost().getPostsTitle());
            holder.tvSeven.setText(String.valueOf(data.getData().getForumInfo().get(position-1).getOneDayAddNum()+"条更新> "));

        }


        return reusableView;
    }

    @Override
    public int getCount() {
        return data.getData().getForumInfo().size()+2;
    }

    @Override
    public Object getItem(int i) {
        return data.getData().getForumInfo().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    static  class ViewHolder{
        ImageView ivOne,ivTwo,ivBack;
        TextView tvOne,tvTwo,tvThree,tvFour,tvFive,tvSix,tvSeven;
        LinearLayout linearLayout;
    }
}
