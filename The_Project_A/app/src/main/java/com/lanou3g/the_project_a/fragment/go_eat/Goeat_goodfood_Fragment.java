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
import com.lanou3g.the_project_a.adapter.GoeatGoodAdapter;
import com.lanou3g.the_project_a.base.BaseFragment;
import com.lanou3g.the_project_a.bean.GoeatGoodBean;
import com.lanou3g.the_project_a.bean.GoeatGoodBean.FeedsBean;
import com.lanou3g.the_project_a.third_party.EndLessOnScrollListener;
import com.lanou3g.the_project_a.url.MyUrl;
import com.lanou3g.the_project_a.volley.NetHelper;
import com.lanou3g.the_project_a.volley.NetListenet.NetListener;

import java.util.List;

//逛吃 - 美食
public class Goeat_goodfood_Fragment extends BaseFragment {
    private RecyclerView recyclerView;
    private GoeatGoodAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int i = 1;

    @Override
    public int initLayout () {
        return R.layout.fragment_goeat_goodfood;
    }

    @Override
    public void initView () {
        recyclerView = (RecyclerView) getView ().findViewById (R.id.goodFood_recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) getView ().findViewById (R.id.swipe_gf);
        adapter = new GoeatGoodAdapter (getContext ());
        LinearLayoutManager manager = new LinearLayoutManager (getContext ());
        recyclerView.setLayoutManager (manager);
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

    }

    @Override
    public void initData () {
        //开启线程 获取网络数据
        requestData ();
    }

    //拼接网址
    private String createUrl (int i) {
        return MyUrl.EATGOODFOODBEFORE + i + MyUrl.EATGOODFOODAFTER;
    }



    private void requestData () {
        StartURL (createUrl (1));


        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener (new OnRefreshListener () {
            @Override
            public void onRefresh () {
                i=1;
                adapter.Clean ();
                StartURL (createUrl (1));
                adapter.notifyDataSetChanged (); //适配器刷新
                swipeRefreshLayout.setRefreshing (false);//下拉后是否不断刷新
            }
        });


    }


    private void StartURL (String url) {

        NetHelper.MyRequest (url, GoeatGoodBean.class, new NetListener<GoeatGoodBean> () {
            @Override
            public void successListener (GoeatGoodBean response) {
                List<FeedsBean> bean = response.getFeeds ();
                adapter.setBean (bean);
            }

            @Override
            public void errorListener (VolleyError error) {

            }
        });
    }


}
