package com.lanou3g.the_project_a.activity;

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


import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.adapter.MyCollectionAdapter;
import com.lanou3g.the_project_a.base.BaseActivity;
import com.lanou3g.the_project_a.greendao.CollectionPerson;
import com.lanou3g.the_project_a.greendao.DBTool;

import java.util.ArrayList;
import java.util.List;

//我的收藏
public class MyCollcetActivity extends BaseActivity implements OnClickListener {
    private ImageButton back;
    private ListView listView;
    private List<CollectionPerson> bean;
    private MyCollectionAdapter adapter;

    @Override
    public int getLayout () {
        return R.layout.activity_mycollcet;
    }

    @Override
    public void initView () {
        listView = (ListView) findViewById (R.id.myCollect_listView);
        back = (ImageButton) findViewById (R.id.myCollect_back);
        back.setOnClickListener (this);
        bean=new ArrayList<> ();
        adapter=new MyCollectionAdapter (this);

    }

    @Override
    public void initData () {
        bean= DBTool.getInstance ().queryAll ();//获取数据库内全部内容存入实体类中
        adapter.setBean (bean);
        listView.setAdapter (adapter);
        EnterTheDetails ();//点击进入详情

    }

    private void EnterTheDetails () {
        listView.setOnItemClickListener (new OnItemClickListener () {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent (MyCollcetActivity.this,CollectionDetailsActivity.class);
                intent.putExtra ("ThisKey",bean.get (position).getImage ());
                startActivity (intent);
            }
        });
    }

    @Override
    public void onClick (View v) {
        switch (v.getId ()){
            case R.id.myCollect_back:
                finish ();
                break;
        }
    }
}
