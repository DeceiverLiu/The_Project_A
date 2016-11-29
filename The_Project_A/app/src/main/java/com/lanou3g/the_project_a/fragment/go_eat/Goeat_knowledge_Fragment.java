package com.lanou3g.the_project_a.fragment.go_eat;

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

Created by Android_刘德强 on 16/11/23.
*/


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.adapter.GoearKnowledgeAdapter;
import com.lanou3g.the_project_a.base.BaseFragment;
import com.lanou3g.the_project_a.bean.GoeatKnowBean;
import com.lanou3g.the_project_a.bean.GoeatKnowBean.FeedsBean;
import com.lanou3g.the_project_a.third_party.EndLessOnScrollListener;
import com.lanou3g.the_project_a.url.MyUrl;
import com.lanou3g.the_project_a.volley.NetHelper;
import com.lanou3g.the_project_a.volley.NetListenet.NetListener;

import java.util.List;

//逛吃 - 知识
public class Goeat_knowledge_Fragment extends BaseFragment {
    private int i =1;
    private RecyclerView recyclerView;
    private GoearKnowledgeAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<FeedsBean> feeds;

    @Override
    public int initLayout () {
        return R.layout.fragment_goeat_knowledge;
    }

    @Override
    public void initView () {
        recyclerView = (RecyclerView) getView ().findViewById (R.id.konwledge_recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) getView ().findViewById (R.id.swipe_kl);
        LinearLayoutManager manager = new LinearLayoutManager (getContext ());
        recyclerView.setLayoutManager (manager);
        adapter = new GoearKnowledgeAdapter (getContext ());
        recyclerView.setAdapter (adapter);


        //上拉加载
        recyclerView.addOnScrollListener (new EndLessOnScrollListener (manager) {
            @Override
            protected void onLoadMore (int currentPage) {
                if (i<8) {
                    StartURL (createUrl (++i));
                }

            }
        });


        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener (new OnRefreshListener () {
            @Override
            public void onRefresh () {
                i=1;
                adapter.Clean ();
                StartURL (createUrl (1));
                adapter.notifyDataSetChanged ();
                swipeRefreshLayout.setRefreshing (false);//下拉后是否不断刷新
            }
        });

    }


    @Override
    public void initData () {
        // 获取网络数据
        requestData ();
    }

    //拼接网址
    private String createUrl (int i) {
        return MyUrl.EATKNOWLEDGEBEFORE + i + MyUrl.EATKNOWLEDGEAFTER;
    }

    //获取数据
    private void requestData () {
        StartURL (createUrl (1));
    }


    //开始获取数据
    private void StartURL (String url) {

        NetHelper.MyRequest (url, GoeatKnowBean.class, new NetListener<GoeatKnowBean> () {
            @Override
            public void successListener (GoeatKnowBean response) {
                feeds = response.getFeeds ();
                adapter.setBean (feeds);
            }

            @Override
            public void errorListener (VolleyError error) {

            }
        });
    }

}
