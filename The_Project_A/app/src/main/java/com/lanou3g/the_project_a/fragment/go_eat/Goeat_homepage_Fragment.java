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


import android.content.Intent;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.android.volley.VolleyError;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.activity.goeat.HomePageActivity;
import com.lanou3g.the_project_a.activity.goeat.HomePageDetailsActivity;
import com.lanou3g.the_project_a.adapter.GoeatHomeAdapter;
import com.lanou3g.the_project_a.base.BaseFragment;
import com.lanou3g.the_project_a.bean.GoeatHomeBean;
import com.lanou3g.the_project_a.bean.GoeatHomeBean.FeedsBean;
import com.lanou3g.the_project_a.onclick.MyOnClick;
import com.lanou3g.the_project_a.url.MyUrl;
import com.lanou3g.the_project_a.volley.NetHelper;
import com.lanou3g.the_project_a.volley.NetListenet.NetListener;

import java.util.List;

//逛吃 - 首页
public class Goeat_homepage_Fragment extends BaseFragment {

    private LRecyclerView recyclerView;
    private GoeatHomeAdapter adapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private int i = 1;
    private List<FeedsBean> data;

    @Override
    public int initLayout () {
        return R.layout.fragment_goeat_homepage;
    }

    @Override
    public void initView () {
        recyclerView = (LRecyclerView) getView ().findViewById (R.id.recycler_homePage);
        adapter = new GoeatHomeAdapter (getContext ());
//        recyclerView.setAdapter (adapter);
        recyclerView.setRefreshProgressStyle (ProgressStyle.BallSpinFadeLoader);
    }


    @Override
    public void initData () {
        //开启线程 获取网络数据
        requestData ();
        adapter.setMyOnClick (new MyOnClick () {
            @Override
            public void myListener (int pos, int i) {
                if (i == 6) {
                    Intent intent = new Intent (getActivity (), HomePageActivity.class);
                    intent.putExtra ("network", adapter.getBean ().get (pos).getLink ());
                    startActivity (intent);
                } else if (i == 5) {
                    Intent intent = new Intent (getActivity (), HomePageDetailsActivity.class);
                    intent.putExtra ("card_image", adapter.getBean ().get (pos).getCard_image ());
                    intent.putExtra ("publisher_avatar", adapter.getBean ().get (pos).getPublisher_avatar ());
                    intent.putExtra ("publisher", adapter.getBean ().get (pos).getPublisher ());
                    intent.putExtra ("like_ct", adapter.getBean ().get (pos).getLike_ct () + "");
                    startActivity (intent);
                }
            }
        });


    }

    //拼接网址
    private String createUrl (int i) {
        return MyUrl.EATHOMEBEFORE + i + MyUrl.EATHOMEAFTER;
    }


    private void requestData () {
        StartURL (createUrl (1));
        lRecyclerViewAdapter=new LRecyclerViewAdapter (adapter);
        recyclerView.setAdapter (lRecyclerViewAdapter);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager (2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager (manager);

        //上拉加载
        recyclerView.setOnLoadMoreListener (new OnLoadMoreListener () {
            @Override
            public void onLoadMore () {
                ++i;
                StartURL (createUrl (i));
            }
        });


        //下拉刷新
        recyclerView.setOnRefreshListener (new OnRefreshListener () {
            @Override
            public void onRefresh () {
                adapter.Clean ();
                StartURL (createUrl (1));
                recyclerView.refreshComplete ();
                lRecyclerViewAdapter.notifyDataSetChanged ();
            }
        });


    }


    //获取数据
    private void StartURL (String url) {

        NetHelper.MyRequest (url, GoeatHomeBean.class, new NetListener<GoeatHomeBean> () {
            @Override
            public void successListener (GoeatHomeBean response) {
                data = response.getFeeds ();
                adapter.setBean (data);
            }

            @Override
            public void errorListener (VolleyError error) {

            }
        });
    }

}
