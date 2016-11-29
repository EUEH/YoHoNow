package com.eueh.yohonow;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.text.SimpleDateFormat;

/**
 * Created by dllo on 16/11/26.
 */

public class Tolls {
    //转换时间格式
    public static final String intoTime(String time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String timenew = simpleDateFormat.format(Long.valueOf(time));
        return timenew;
    }
    //截取字符串(到jpg之前的)
    public static final String cutStrings(String str){
        String result = str.substring(0,str.indexOf("?"));
        return result;
    }
    //截取字符串(如果有  ?  这个字符串,就进行截取)
    public static final String subStrings(String str){
        if(str.indexOf("?")!=-1){
            String result = str.substring(0,str.indexOf("?"));
            return result;
        }else{
            //返回一个字符串类型
            return "";
        }

    }

}
