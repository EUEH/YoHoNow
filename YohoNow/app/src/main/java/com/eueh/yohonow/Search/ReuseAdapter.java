package com.eueh.yohonow.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.yohonow.R;
import com.eueh.yohonow.Tolls;

/**
 * Created by dllo on 16/11/30.
 */

public class ReuseAdapter extends BaseAdapter {
    private BeanIn data;
    private Context context;

    public ReuseAdapter(Context context) {
        this.context = context;
    }

    public void setData(BeanIn data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.getData().getContent().size():0;
    }

    @Override
    public Object getItem(int i) {
        return data != null ? data.getData().getContent().get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_search,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(data.getData().getContent().get(i).getImage()).into(holder.iv);
        holder.tvTop.setText(data.getData().getContent().get(i).getTitle());
        holder.tvLeft.setText("#"+data.getData().getContent().get(i).getTag().get(0).getTag_name());
        holder.tvRight.setText(Tolls.intoTime(data.getData().getContent().get(i).getCreate_time()));
        return view;
    }
    class ViewHolder{
        private ImageView iv;
        private TextView tvTop,tvLeft,tvRight;

        public ViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.iv_search_me);
            tvTop = (TextView) view.findViewById(R.id.tv_search_top);
            tvLeft = (TextView) view.findViewById(R.id.tv_search_left);
            tvRight = (TextView) view.findViewById(R.id.tv_search_right);
        }
    }
}
