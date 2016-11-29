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


import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.adapter.GoeatReviewAdapter;
import com.lanou3g.the_project_a.base.BaseFragment;
import com.lanou3g.the_project_a.bean.GoeatReviewBean;
import com.lanou3g.the_project_a.url.MyUrl;
import com.lanou3g.the_project_a.volley.NetHelper;
import com.lanou3g.the_project_a.volley.NetListenet.NetListener;

//逛吃 - 测评
public class Goeat_review_Fragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final int REFRESH_COMPLETE_R = 2110;//刷新请求码
    private ListView listView;
    private GoeatReviewAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public int initLayout () {
        return R.layout.fragment_goeat_review;
    }

    @Override
    public void initView () {
        listView = (ListView) getView ().findViewById (R.id.review_listView);
        swipeRefreshLayout = (SwipeRefreshLayout) getView ().findViewById (R.id.swipe_lv);
        adapter = new GoeatReviewAdapter (getContext ());
        swipeRefreshLayout.setOnRefreshListener (this);
    }

    private Handler handler = new Handler () {
        @Override
        public void handleMessage (Message msg) {
            super.handleMessage (msg);
            switch (msg.what)//获取请求码
            {
                case REFRESH_COMPLETE_R://如果请求码等于某个刷新请求码
                    adapter.notifyDataSetChanged (); //适配器刷新
                    swipeRefreshLayout.setRefreshing (false);//下拉后是否不断刷新
                    break;
            }
        }
    };

    @Override
    public void initData () {
        //开启线程,网络数据请求
        requestData ();
    }


    private void requestData () {

        NetHelper.MyRequest (MyUrl.EATREVIEW, GoeatReviewBean.class, new NetListener<GoeatReviewBean> () {
            @Override
            public void successListener (GoeatReviewBean response) {
                adapter.setBean (response);
                listView.setAdapter (adapter);
            }

            @Override
            public void errorListener (VolleyError error) {

            }
        });


    }

    //下拉刷新switchPreference的监听事件
    @Override
    public void onRefresh () {
        handler.sendEmptyMessageDelayed (REFRESH_COMPLETE_R, 2000);//参1: 请求码  参2:刷新时长
    }
}
