package com.lanou3g.the_project_a.greendao;

 /*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG

Created by Android_刘德强 on 16/11/22.
*/


import android.app.Application;
import android.content.Context;

//全局Context对象
public class MyApp extends Application{
    private static Context context;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    @Override
    public void onCreate () {
        super.onCreate ();
        context=this;
    }

    public static Context getContext(){
        return context;
    }

    //对位提供获取DaoManager对象
    public static DaoMaster getDaoMaster() {
        DaoMaster.DevOpenHelper helper =
                new DaoMaster.DevOpenHelper
                        (getContext (),"Person.db");
        //初始化DaoMaster对象
        daoMaster=new DaoMaster (helper.getWritableDb ());
        return daoMaster;
    }



    //对外提供获取DaoSession对象
    public static DaoSession getDaoSession(){
        if (daoSession ==null){
            if (daoMaster==null){
                daoMaster=getDaoMaster ();
            }
            //初始化DaoSession对象
            daoSession=daoMaster.newSession ();
        }
        return daoSession;
    }
}
