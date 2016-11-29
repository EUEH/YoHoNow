package com.eueh.yohonow.community;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.yohonow.R;
import com.eueh.yohonow.Tolls;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/11/26.
 */

public class ComAdapter extends BaseAdapter {
    private BeanCom data;
    private Context context;

    public ComAdapter(Context context) {
        this.context = context;
    }

    public void setData(BeanCom data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null && data.getData().getList().size() > 0 ? data.getData().getList().size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return data != null ? data.getData().getList().get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_com_body_son, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //需要更改(截取图片的网址)
        //   Picasso.with(context).load(Tolls.cutStrings(data.getData().getList().get(i).getAuthorInfo().getHeadIcon())).into(holder.ivOne);
        Glide.with(context).load(Tolls.cutStrings(data.getData().getList().get(i).getAuthorInfo().getHeadIcon())).bitmapTransform(new CropCircleTransformation(context)).into(holder.ivOne);


        holder.tvTwo.setText(data.getData().getList().get(i).getAuthorInfo().getNickName());
        //转化为string类型
        holder.tvThree.setText(Tolls.intoTime(String.valueOf(data.getData().getList().get(i).getCreateTime())));
        holder.tvFour.setText(data.getData().getList().get(i).getPostsTitle());

        if (Tolls.subStrings(data.getData().getList().get(i).getBlocks().get(0).getContentData()) == ""){
            holder.tvFive.setText(data.getData().getList().get(i).getBlocks().get(0).getContentData());
        }

        holder.tvSeven.setText(data.getData().getList().get(i).getForumName());
        holder.tvEight.setText(String.valueOf(data.getData().getList().get(i).getComment()));
        holder.tvNine.setText(String.valueOf(data.getData().getList().get(i).getPraise()));

        //初始化子子布局的适配器
        SonSixAdapter sonSixAdapter = new SonSixAdapter(context);
        //给适配器添加数据(进一步的数据判断在子子布局的适配器中进行)
        sonSixAdapter.setData(data.getData().getList().get(i));
        //设置适配器
        holder.rv.setAdapter(sonSixAdapter);
        holder.rv.setLayoutManager(new GridLayoutManager(context, 3));

        return view;
    }


    class ViewHolder {
        private ImageView ivOne;
        private TextView tvTwo, tvThree, tvFour, tvFive, tvSeven, tvEight, tvNine;
        //给listView的子布局  的子布局  中的RecyclerView  加载RecyclerView 的适配器
        private RecyclerView rv;

        public ViewHolder(View view) {
            ivOne = (ImageView) view.findViewById(R.id.iv_com_one);
            tvTwo = (TextView) view.findViewById(R.id.tv_com_two);
            tvThree = (TextView) view.findViewById(R.id.tv_com_three);
            tvFour = (TextView) view.findViewById(R.id.tv_com_four);
            tvFive = (TextView) view.findViewById(R.id.tv_com_five);
            tvSeven = (TextView) view.findViewById(R.id.tv_com_seven);
            tvEight = (TextView) view.findViewById(R.id.tv_com_eight);
            tvNine = (TextView) view.findViewById(R.id.tv_com_nine);
            //绑定
            rv = (RecyclerView) view.findViewById(R.id.iv_com_six_rec);
        }
    }
}
