package com.eueh.yohonow.magazine.magapage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eueh.yohonow.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/11/25.
 */

public class MagPagAdapter extends BaseAdapter {
    private BeanPage data;
    private Context context;

    public MagPagAdapter(Context context) {
        this.context = context;
    }

    public void setData(BeanPage data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data!=null&&data.getData().getWallpaperList().size()>0?data.getData().getWallpaperList().size():0;
    }

    @Override
    public Object getItem(int i) {
        return data!=null?data.getData().getWallpaperList().get(i):null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_mag_page_son,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tvTop.setText(data.getData().getWallpaperList().get(i).getJournal());
        holder.tvBot.setText(data.getData().getWallpaperList().get(i).getMonth());
        Picasso.with(context).load(data.getData().getWallpaperList().get(i).getImages().get(0).getThumbImage()).into(holder.ivOne);
        Picasso.with(context).load(data.getData().getWallpaperList().get(i).getImages().get(1).getThumbImage()).into(holder.ivThree);
        Picasso.with(context).load(data.getData().getWallpaperList().get(i).getImages().get(2).getThumbImage()).into(holder.ivTwo);
        Picasso.with(context).load(data.getData().getWallpaperList().get(i).getImages().get(3).getThumbImage()).into(holder.ivFour);


        return view;
    }
    class ViewHolder {
        private TextView tvTop,tvBot;
        private ImageView ivOne,ivTwo,ivThree,ivFour;

        public ViewHolder(View view) {
            tvTop = (TextView) view.findViewById(R.id.tv_page_top);
            tvBot = (TextView) view.findViewById(R.id.tv_page_bot);
            ivOne = (ImageView) view.findViewById(R.id.iv_page_one);
            ivTwo = (ImageView) view.findViewById(R.id.iv_page_two);
            ivThree = (ImageView) view.findViewById(R.id.iv_page_three);
            ivFour = (ImageView) view.findViewById(R.id.iv_page_four);

        }
    }
}
