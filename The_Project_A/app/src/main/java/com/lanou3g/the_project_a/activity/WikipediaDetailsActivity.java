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
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.adapter.HomePageNutritionAdapter;
import com.lanou3g.the_project_a.base.BaseActivity;
import com.lanou3g.the_project_a.bean.WikipediaDetailsBean;
import com.lanou3g.the_project_a.url.MyUrl;
import com.lanou3g.the_project_a.volley.NetHelper;
import com.lanou3g.the_project_a.volley.NetListenet.NetListener;

import java.util.List;

//食物百科
//点击GridView进入详情

public class WikipediaDetailsActivity extends BaseActivity implements OnClickListener {
    private LinearLayout wikipedia_details_linearLayout;
    private RecyclerView recyclerView;
    private ImageButton wikipedia_details_back;
    private PopupWindow popupWindow;
    private HomePageNutritionAdapter adapter;
    private ListView wikipedia_details_listview;

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
        wikipedia_details_listview = (ListView) findViewById (R.id.wikipedia_details_listview);


    }

    @Override
    public void initData () {
        initPopup ();
        adapter = new HomePageNutritionAdapter (WikipediaDetailsActivity.this);
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

    private void initPopup () {
        popupWindow = new PopupWindow (this);
        popupWindow.setHeight (LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth (LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from (this).inflate (R.layout.item_wikepedia_pop, null);
        popupWindow.setContentView (view);
        popupWindow.setOutsideTouchable (true);
        recyclerView = (RecyclerView) view.findViewById (R.id.wikepedia_pop_rl);

    }


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
}
