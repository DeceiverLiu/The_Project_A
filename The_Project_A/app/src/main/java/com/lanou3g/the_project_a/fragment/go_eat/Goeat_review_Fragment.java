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
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.activity.goeat.HomePageActivity;
import com.lanou3g.the_project_a.adapter.GoeatReviewAdapter;
import com.lanou3g.the_project_a.base.BaseFragment;
import com.lanou3g.the_project_a.bean.GoeatReviewBean;
import com.lanou3g.the_project_a.url.MyUrl;
import com.lanou3g.the_project_a.volley.NetHelper;
import com.lanou3g.the_project_a.volley.NetListenet.NetListener;

import java.util.ArrayList;
import java.util.List;

//逛吃 - 评测
public class Goeat_review_Fragment extends BaseFragment {
    private PullToRefreshListView listView;
    private GoeatReviewAdapter adapter;
    private List<GoeatReviewBean.FeedsBean> bean;
    private int i = 1;

    @Override
    public int initLayout () {
        return R.layout.fragment_goeat_review;
    }

    @Override
    public void initView () {
        listView = (PullToRefreshListView) getView ().findViewById (R.id.review_listView);
        //上拉和下拉的方式
        listView.setMode (Mode.BOTH);
        adapter = new GoeatReviewAdapter (getContext ());
        bean = new ArrayList<> ();


    }




    @Override
    public void initData () {
        //开启线程,网络数据请求
        requestData (Url_all (1));

        listView.setAdapter (adapter);
        listView.setOnItemClickListener (new OnItemClickListener () {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (getActivity (), HomePageActivity.class);
                intent.putExtra ("network", bean.get (position-1).getLink ());
                startActivity (intent);
            }
        });

        //下拉刷新
        listView.setOnRefreshListener (new OnRefreshListener2<ListView> () {
            //下拉刷新
            @Override
            public void onPullDownToRefresh (PullToRefreshBase<ListView> pullToRefreshBase) {
                new PutDataTask().execute ();
            }

            //上拉加载
            @Override
            public void onPullUpToRefresh (PullToRefreshBase<ListView> pullToRefreshBase) {
                new GetDataTask ().execute ();
            }
        });
    }


    // 网址拼接的方法
    public String Url_all (int i) {
        return MyUrl.AVI_ONE + i + MyUrl.AVI_TWO;
    }


    //网址拉取数据
    private void requestData (String url) {
        NetHelper.MyRequest (url, GoeatReviewBean.class, new NetListener<GoeatReviewBean> () {
            @Override
            public void successListener (GoeatReviewBean response) {

                List<GoeatReviewBean.FeedsBean> mid = response.getFeeds ();
                if (bean == null) {
                    bean = mid;
                } else {
                    for (int i = 0; i < mid.size (); i++) {
                        bean.add (mid.get (i));
                    }
                }
                adapter.setBean (bean);
            }
            @Override
            public void errorListener (VolleyError error) {

            }
        });


    }


    // 下拉刷新的异步任务
    private class PutDataTask extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected Integer doInBackground (Integer... params) {
            try {
                Thread.sleep (2000);
                i = 1;
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            return i;
        }

        @Override
        protected void onPostExecute (Integer integer) {
            super.onPostExecute (integer);
            adapter.Clean ();
            requestData (Url_all (integer));
            adapter.notifyDataSetChanged ();
            listView.onRefreshComplete ();
        }

    }

    // 上啦加载的异步任务
    private class GetDataTask extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected Integer doInBackground (Integer... params) {
            try {
                Thread.sleep (2000);
                i = i + 1;
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            return i;
        }

        @Override
        protected void onPostExecute (Integer integer) {
            super.onPostExecute (integer);
            requestData (Url_all (integer));

            adapter.notifyDataSetChanged ();
            listView.onRefreshComplete ();
        }

    }

}
