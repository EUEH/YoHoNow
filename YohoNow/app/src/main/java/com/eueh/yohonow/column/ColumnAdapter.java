package com.eueh.yohonow.column;

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
 * Created by dllo on 16/11/24.
 */


//栏目的适配器
public class ColumnAdapter extends BaseAdapter {
    private BeanCol data;
    private Context context;

    public ColumnAdapter(Context context) {
        this.context = context;
    }

    public void setData(BeanCol data) {
        this.data = data;
        notifyDataSetChanged();
    }

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_col_body, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Picasso.with(context).load(data.getData().get(i).getCover()).into(holder.ivbody);
        holder.tvbodytop.setText(data.getData().get(i).getSummary());
        holder.tvbodybot.setText("更新至"+data.getData().get(i).getTotal()+"篇");

        return view;
    }

    class ViewHolder {
        private ImageView ivbody;
        private TextView tvbodytop, tvbodybot;

        public ViewHolder(View view) {
            ivbody = (ImageView) view.findViewById(R.id.iv_col_body);
            tvbodytop = (TextView) view.findViewById(R.id.tv_col_body_top);
            tvbodybot = (TextView) view.findViewById(R.id.tv_col_body_bot);
        }
    }
}
