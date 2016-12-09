package com.eueh.yohonow.volley;

import android.app.Application;
import android.content.Context;

import com.eueh.yohonow.mygreendao.DaoMaster;
import com.eueh.yohonow.mygreendao.DaoSession;

/**
 * Created by leisure on 2016/11/28.
 */
//切记如何使用!!!!!
    //清单文件中加入自己的App
public class MyApp extends Application {
    private static Context mContext;
    private static DaoMaster sDaoMaster;
    private static DaoSession sDaoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }
    //对外提供一个获取Context对象的方法
    public static Context getmContext() {
        return mContext;
    }

    public static DaoMaster getDaoMaster () {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mContext , "MyCollect.db" , null);
        sDaoMaster = new DaoMaster(helper.getWritableDb());
        return sDaoMaster;
    }

    public static DaoSession getDaoSession(){
        if (sDaoSession == null){
            if (sDaoMaster == null){
                sDaoMaster = getDaoMaster();
            }
            sDaoSession = sDaoMaster.newSession();
        }
        return sDaoSession ;
    }
}
