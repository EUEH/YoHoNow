package com.eueh.yohonow.mygreendao;

import com.eueh.yohonow.volley.MyApp;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by dllo on 16/12/8.
 */
public class DBTool {
    private static DBTool ourInstance = new DBTool();
    private static  MyCollectDao myCollectDao;

    public static DBTool getInstance() {

        if (ourInstance == null){
            synchronized (DBTool.class){
                if (ourInstance == null){
                    ourInstance = new DBTool();
                }
            }
        }
        myCollectDao = MyApp.getDaoSession().getMyCollectDao();

        return ourInstance;
    }

    private DBTool() {
    }
    //增加
    public void insertMyCollect(MyCollect myCollect){
        myCollectDao.insert(myCollect);
    }
    //删除
    public void deleteMyCollect(MyCollect myCollect){
        myCollectDao.delete(myCollect);
    }
    //查询所有
    public List<MyCollect> queryAll(){
        List<MyCollect> list = myCollectDao.loadAll();
        return list;
    }
    //根据title来查询(判断是否重复)
    public boolean isSave(String url){
        QueryBuilder<MyCollect> queryBuilder = myCollectDao.queryBuilder()
                .where(MyCollectDao.Properties.Url.eq(url));
        Long size = queryBuilder.buildCount().count();
        return size > 0 ? true : false;
    }
    //全部删除
    public void deleteAll(){
        myCollectDao.deleteAll();
    }
}
