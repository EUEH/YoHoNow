package com.eueh.yohonow.Search.SpMySearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.eueh.yohonow.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/8.
 */

public class AdapterEuen  extends BaseAdapter{
    private ArrayList<Bean> data;
    private Context context;

    public AdapterEuen(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<Bean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size()>0?data.size():0;
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
            view = LayoutInflater.from(context).inflate(R.layout.item_euen,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv.setText(data.get(i).getText());
        return view;
    }
    class  ViewHolder{
        private TextView tv;

        public ViewHolder(View view) {
            tv = (TextView) view.findViewById(R.id.tv_euen);
        }
    }
}
