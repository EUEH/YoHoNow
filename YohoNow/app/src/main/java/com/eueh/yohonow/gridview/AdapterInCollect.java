package com.eueh.yohonow.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.yohonow.R;
import com.eueh.yohonow.mygreendao.MyCollect;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/8.
 */

public class AdapterInCollect extends BaseAdapter {
    private ArrayList<MyCollect> data;
    private Context context;

    public AdapterInCollect(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<MyCollect> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null? 0:data.size();
    }

    @Override
    public Object getItem(int i) {
        return data == null?null:data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_gv_collect,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv.setText(data.get(i).getTitle());
        Glide.with(context).load(data.get(i).getUrl()).into(holder.iv);
        return view;
    }
    class ViewHolder{
        private ImageView iv;
        private TextView tv;

        public ViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.iv_eueh);
            tv = (TextView) view.findViewById(R.id.tv_eueh);
        }
    }
}
