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

Created by Android_刘德强 on 16/11/26.
*/


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.adapter.HomePageClassificationFoodAdapter;
import com.lanou3g.the_project_a.adapter.HomePageNutritionAdapter;
import com.lanou3g.the_project_a.base.BaseActivity;
import com.lanou3g.the_project_a.bean.ClassificationOfFoodBean;
import com.lanou3g.the_project_a.bean.ClassificationOfFoodBean.FoodsBean;
import com.lanou3g.the_project_a.bean.WikipediaDetailsBean;
import com.lanou3g.the_project_a.url.MyUrl;
import com.lanou3g.the_project_a.volley.NetHelper;
import com.lanou3g.the_project_a.volley.NetListenet.NetListener;

import java.util.ArrayList;
import java.util.List;

//食物百科
//点击GridView进入详情

public class WikipediaDetailsActivity extends BaseActivity implements OnClickListener {
    private LinearLayout wikipedia_details_linearLayout;
    private RecyclerView recyclerView;
    private ImageButton wikipedia_details_back;
    private PopupWindow popupWindow;
    private HomePageNutritionAdapter adapter;
    private PullToRefreshListView wikipedia_details_listview;
    private String kind;
    private String id;
    private int i= 1;
    private HomePageClassificationFoodAdapter hAdapter;
    private String classificationUrl;
    private List<FoodsBean> bean;

    @Override
    public int getLayout () {
        return R.layout.activity_wikipedia_details;

    }

    @Override
    public void initView () {
        wikipedia_details_linearLayout = (LinearLayout) findViewById (R.id.wikipedia_details_linearLayout);
        wikipedia_details_linearLayout.setOnClickListener (this);
        wikipedia_details_back = (ImageButton) findViewById (R.id.wikipedia_details_back);
        wikipedia_details_back.setOnClickListener (this);
        wikipedia_details_listview = (PullToRefreshListView) findViewById (R.id.wikipedia_details_listview);
        hAdapter = new HomePageClassificationFoodAdapter (this);
        adapter = new HomePageNutritionAdapter (WikipediaDetailsActivity.this);
        wikipedia_details_listview.setMode (Mode.BOTH);
        bean=new ArrayList<> ();

    }

    @Override
    public void initData () {
        initPopup ();
        getCore ();
        //食物百科- 食物分类接口
        ClassificationOfFood (classificationUrl);
        //下拉刷新 上拉加载
        OnRefreshListener ();
    }


    //上拉 下拉加载
    private void OnRefreshListener () {
        wikipedia_details_listview.setOnRefreshListener (new OnRefreshListener2<ListView> () {
            @Override
            public void onPullDownToRefresh (PullToRefreshBase<ListView> pullToRefreshBase) {

            }

            @Override
            public void onPullUpToRefresh (PullToRefreshBase<ListView> pullToRefreshBase) {
                new GetDataTask ().execute ();
            }
        });
    }


    //接值  获得网址拼接中间字段
    private void getCore() {
        Intent intent = getIntent ();
        kind = intent.getStringExtra ("kind");
        id = intent.getStringExtra ("id");
        //食物分类网址拼接
        classificationUrl = MyUrl.ClassificationBefore + kind + MyUrl.ClassificationMiddle + id + MyUrl.ClassificationAfter+i+MyUrl.ClassificationLast;
    }




    @Override
    public void onClick (View v) {
        switch (v.getId ()) {
            //营养排序
            case R.id.wikipedia_details_linearLayout:
                popupWindow.showAsDropDown (wikipedia_details_linearLayout);
                StartURL ();
                break;
            case R.id.wikipedia_details_back:
                finish ();
                break;
        }
    }

    //PopUpWindow显示
    private void initPopup () {
        popupWindow = new PopupWindow (this);
        popupWindow.setHeight (LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth (LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from (this).inflate (R.layout.item_wikepedia_pop, null);
        popupWindow.setContentView (view);
        popupWindow.setOutsideTouchable (true);
        recyclerView = (RecyclerView) view.findViewById (R.id.wikepedia_pop_rl);
        wikipedia_details_listview.setAdapter (hAdapter);

    }

    public String Url_all (int i) {
        return MyUrl.ClassificationBefore + kind + MyUrl.ClassificationMiddle + id + MyUrl.ClassificationAfter+i+MyUrl.ClassificationLast;
    }


    //PopUpWindow数据请求
    public void StartURL () {
        NetHelper.MyRequest (MyUrl.WILIPEDOAPOP, WikipediaDetailsBean.class, new NetListener<WikipediaDetailsBean> () {
            @Override
            public void successListener (WikipediaDetailsBean response) {
                List<WikipediaDetailsBean.TypesBean> bean = response.getTypes ();
                adapter.setBean (bean);
                recyclerView.setAdapter (adapter);
                recyclerView.setLayoutManager (new GridLayoutManager (WikipediaDetailsActivity.this, 3));
            }

            @Override
            public void errorListener (VolleyError error) {
                Toast.makeText (WikipediaDetailsActivity.this, "请求失败", Toast.LENGTH_SHORT).show ();
            }
        });

    }

    //食物百科 - 食物分类
    private void ClassificationOfFood (String url) {
        NetHelper.MyRequest (url, ClassificationOfFoodBean.class, new NetListener<ClassificationOfFoodBean> () {
            @Override
            public void successListener (ClassificationOfFoodBean response) {

                List<ClassificationOfFoodBean.FoodsBean> mid =response.getFoods ();
                if (bean==null){

                    bean = mid;
                }else {
                    for (int i1 = 0; i1 < mid.size (); i1++) {
                        bean.add (mid.get (i1));
                    }
                }
                hAdapter.setBean (bean);
            }

            @Override
            public void errorListener (VolleyError error) {
                Toast.makeText (WikipediaDetailsActivity.this, "网络延迟 请稍后", Toast.LENGTH_SHORT).show ();
            }
        });
    }


    // 上啦加载的异步任务
    private class GetDataTask extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected Integer doInBackground (Integer... params) {
//            try {
//                Thread.sleep (2000);
                i = i + 1;
//            } catch (InterruptedException e) {
//                e.printStackTrace ();
//            }
            return i;
        }

        @Override
        protected void onPostExecute (Integer integer) {
            super.onPostExecute (integer);
            ClassificationOfFood (Url_all (integer));
            adapter.notifyDataSetChanged ();
            wikipedia_details_listview.onRefreshComplete ();
        }

    }

}
