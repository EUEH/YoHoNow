package com.eueh.yohonow.video.videoviedeo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eueh.yohonow.R;
import com.eueh.yohonow.Tolls;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/11/25.
 */

public class VideoSonAdapter extends BaseAdapter {
    private BeanVid data;
    private Context context;

    public VideoSonAdapter(Context context) {
        this.context = context;
    }

    public void setData(BeanVid data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null && data.getData().getContent().size() > 0 ? data.getData().getContent().size() : 0;
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
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_vid_video_one, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Picasso.with(context).load(data.getData().getContent().get(i).getImage()).into(holder.iv);
        holder.tv_top.setText(data.getData().getContent().get(i).getTitle());
        holder.tv_left.setText(data.getData().getContent().get(i).getTag().get(0).getTag_name());
        holder.tv_right.setText(Tolls.intoTime(data.getData().getContent().get(i).getCreate_time()));


        return view;
    }

    class ViewHolder {
        private ImageView iv;
        private TextView tv_top, tv_left, tv_right;

        public ViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.iv_vid_video);
            tv_top = (TextView) view.findViewById(R.id.tv_vid_video_top);
            tv_left = (TextView) view.findViewById(R.id.tv_vid_video_left);
            tv_right = (TextView) view.findViewById(R.id.tv_vid_video_right);
        }
    }
}
