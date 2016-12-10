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

Created by Android_刘德强 on 16/12/9.
*/


import com.lanou3g.the_project_a.greendao.CollectionPersonDao.Properties;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class DBTool {
    private static DBTool ourInstance = new DBTool ();
    private static CollectionPersonDao personDao;

    //对外提供getInstance方法获取本类的单例对象
    public static DBTool getInstance () {
        if (ourInstance == null) {
            synchronized (DBTool.class) {
                if (ourInstance == null) {
                    ourInstance = new DBTool ();
                }
            }
        }
        //初始化Dao对象
        personDao = MyApp.getDaoSession ().getCollectionPersonDao ();
        return ourInstance;
    }

    private DBTool () {
    }

    //增加单一对象的方法
    public void insertPerson (CollectionPerson person) {
        personDao.insert (person);
    }

    //增加集合的方法
    public void insertList (List<CollectionPerson> list) {
        personDao.insertInTx (list);
    }

    //删除单一对象的方法
    public void deletePerson (CollectionPerson person) {
        personDao.delete (person);
    }

    //删除所有内容
    public void deleteAll () {
        personDao.deleteAll ();
    }

    //根据id进行删除
    public void deleteById (Long id) {
        personDao.deleteByKey (id);
    }

    //根据某一个字段进行删除操作
    public void deleteByTitle (String title) {
        DeleteQuery<CollectionPerson> delayQueue = personDao.
                queryBuilder ().where (
                Properties.Title.eq (title)).buildDelete ();
        delayQueue.executeDeleteWithoutDetachingEntities ();
    }

    //根据标题.作者进行删除
    public void deleteBy (String title, String source) {
        DeleteQuery<CollectionPerson> deleteQuery = personDao.queryBuilder ()
                .where (Properties.Title.eq (title), Properties.Source.eq (source))
                .buildDelete ();
        if (deleteQuery != null) {
            deleteQuery.executeDeleteWithoutDetachingEntities ();
        }
    }

    //查询所有的方法
    public List<CollectionPerson> queryAll () {
        //查询方法1
        List<CollectionPerson> list = personDao.loadAll ();
        //查询方法2
        List<CollectionPerson> personList = personDao.queryBuilder ().list ();
        return list;
    }

    //查重方法
    //根据标题来查询
    public boolean isSave(String title){
        QueryBuilder<CollectionPerson> queryBuilder = personDao.
                queryBuilder().where(Properties.Title.eq(title));
        //获取到我们要查询的内容的size
        Long size = queryBuilder.buildCount().count();
        return size > 0 ? true : false;
    }

    public boolean isSave(CollectionPerson person){
        QueryBuilder<CollectionPerson> queryBuilder =
                personDao.queryBuilder().
                        where(Properties.Title.eq(person.getTitle ())
                                , Properties.Source.eq(person.getSource ()));
        Long size = queryBuilder.buildCount().count();
        return size > 0 ? true : false;
    }
}
































