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

Created by Android_刘德强 on 16/11/25.
*/

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.VolleyError;
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.adapter.SearchAdapter;
import com.lanou3g.the_project_a.base.BaseActivity;
import com.lanou3g.the_project_a.bean.SearchBean;
import com.lanou3g.the_project_a.divider.DividerItemDecoration;
import com.lanou3g.the_project_a.url.MyUrl;
import com.lanou3g.the_project_a.volley.NetHelper;
import com.lanou3g.the_project_a.volley.NetListenet.NetListener;

//一级界面 食物百科点击搜索按钮
//进入搜索界面
public class SearchActivity extends BaseActivity implements OnClickListener{

    private RecyclerView recyclerView;
    private SearchBean bean;
    private SearchAdapter adapter;
    private EditText  food_name;
    private ImageButton food_search;

    @Override
    public int getLayout () {
        return R.layout.activity_search;
    }

    @Override
    public void initView () {
        recyclerView = (RecyclerView) findViewById (R.id.search_rv);
        food_name = (EditText) findViewById (R.id.food_name);
        food_search = (ImageButton) findViewById (R.id.food_search);
        food_search.setOnClickListener (this);
        adapter=new SearchAdapter (this);
        bean=new SearchBean ();

    }

    @Override
    public void initData () {

        //开启网络数据 获取推荐信息
        recommended ();

    }

    private void recommended () {
        NetHelper.MyRequest (MyUrl.SearchRecommended, SearchBean.class, new NetListener<SearchBean> () {
            @Override
            public void successListener (SearchBean response) {
                bean=response;
                adapter.setBean (bean);
                recyclerView.setAdapter (adapter);
                recyclerView.setLayoutManager (new GridLayoutManager (SearchActivity.this,2));
                recyclerView.addItemDecoration (new DividerItemDecoration (SearchActivity.this,1));


            }

            @Override
            public void errorListener (VolleyError error) {

            }
        });
    }

    @Override
    public void onClick (View v) {
        switch (v.getId ()){
            case R.id.food_search:
                String field=food_name.getText ().toString ();
                String results =MyUrl.SearchField+field;
                Intent intent=new Intent (this, SearchDetailsActivity.class);
                intent.putExtra ("results",results);
                startActivity (intent);
                finish ();
                break;
        }

    }
}