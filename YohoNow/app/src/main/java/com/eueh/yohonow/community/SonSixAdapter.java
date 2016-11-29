package com.eueh.yohonow.community;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.eueh.yohonow.R;
import com.eueh.yohonow.Tolls;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/26.
 */

//社区布局中加载的子布局 RecyclerView
public class SonSixAdapter extends RecyclerView.Adapter<SonSixAdapter.MyViewHolder> {
    //  我们接口实体类的实例化对象 data
    private BeanCom.DataBean.ListBean data;
    private Context context;
    //用来盛装我们筛选后的数据
    private ArrayList<String> data_url;

    public SonSixAdapter(Context context) {
        this.context = context;
    }

    public void setData(BeanCom.DataBean.ListBean data) {
        this.data = data;
        data_url= new ArrayList<>();

        //做判断(以接口中Blocks的数量循环)
        for (int i = 0; i < data.getBlocks().size(); i++) {
            //利用 subStrings 方法,判断 ContentData 中的数据是否为想要的字符串类型
            //若满足条件 进行截取,再赋值给  sub_a
            String sub_a = Tolls.subStrings(data.getBlocks().get(i).getContentData());
            //判断  在我们自己创建的集合中,如果不是  "" 的话
            if (!sub_a.equals("")) {
                //我们判断后三位是不是jpg
                String test=(sub_a.substring(sub_a.length() - 4, sub_a.length()));
                //如果是jpg
                if (test.equals(".jpg")) {
                    //将其添加进集合中
                    data_url.add(sub_a);
                }
            }

        }
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_com_six_rec_son,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //利用 Picasso 将的到的筛选后的图片网址设置给iv
        Picasso.with(context).load(data_url.get(position)).into(holder.iv);
    }

    @Override
    public int getItemCount() {
      //判断返回的图片数量(我们只想返回三张)
        if ((data_url!=null)&&data_url.size()>0){
            if (data_url.size()>=3){
                return 3;
            }else {
                return  data_url.size();
            }
        }else {
            return 0;
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_com_six_rec_son);
        }
    }



}
