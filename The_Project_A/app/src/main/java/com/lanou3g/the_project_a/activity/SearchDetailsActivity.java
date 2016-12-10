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
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.adapter.SearchDetailsAdapter;
import com.lanou3g.the_project_a.base.BaseActivity;
import com.lanou3g.the_project_a.bean.SearchDetailsBean;
import com.lanou3g.the_project_a.volley.NetHelper;
import com.lanou3g.the_project_a.volley.NetListenet.NetListener;

import java.util.ArrayList;
import java.util.List;

//搜索详情
public class SearchDetailsActivity extends BaseActivity implements OnClickListener{

    private ListView listView;
    private List<SearchDetailsBean.ItemsBean> bean;
    private SearchDetailsAdapter adapter;
    private String url;
    private ImageButton SearchDetailsBack;


    @Override
    public int getLayout () {
        return R.layout.activity_searchdetails;
    }

    @Override
    public void initView () {
        listView = (ListView) findViewById (R.id.searchResults_listView);
        SearchDetailsBack = (ImageButton) findViewById (R.id.SearchDetailsBack);
        adapter=new SearchDetailsAdapter (this);
        bean=new ArrayList<> ();
        SearchDetailsBack.setOnClickListener (this);

    }

    @Override
    public void initData () {
        Intent intent=getIntent ();
        url = intent.getStringExtra ("results");
        NetHelper.MyRequest (url, SearchDetailsBean.class, new NetListener<SearchDetailsBean> () {
            @Override
            public void successListener (SearchDetailsBean response) {
                bean=response.getItems ();
                adapter.setBean (bean);
                listView.setAdapter (adapter);
            }

            @Override
            public void errorListener (VolleyError error) {

            }
        });
    }

    @Override
    public void onClick (View v) {
        switch (v.getId ()){
            case R.id.SearchDetailsBack:
                finish ();
                break;
        }
    }
}
