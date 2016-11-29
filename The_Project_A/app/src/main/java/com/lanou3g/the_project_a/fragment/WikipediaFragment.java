package com.lanou3g.the_project_a.fragment;

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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.activity.GiftSaidActivity;
import com.lanou3g.the_project_a.activity.LoginActivity;
import com.lanou3g.the_project_a.activity.WikipediaDetailsActivity;
import com.lanou3g.the_project_a.adapter.HomePageGridBrandAdapter;
import com.lanou3g.the_project_a.adapter.HomePageGridGroupAdapter;
import com.lanou3g.the_project_a.adapter.HomePageGridRestaurantAdapter;
import com.lanou3g.the_project_a.base.BaseFragment;
import com.lanou3g.the_project_a.bean.HomePageGridBean;
import com.lanou3g.the_project_a.url.MyUrl;
import com.lanou3g.the_project_a.volley.NetHelper;
import com.lanou3g.the_project_a.volley.NetListenet.NetListener;

//一级页面
//食物百科 Fragment 页面
public class WikipediaFragment extends BaseFragment implements OnClickListener {
    private LinearLayout linearsearch;//搜索按钮
    private ImageView home_logo;
    private Button foodAnalysis;//饮食分析
    private GridView gridGroup, gridBrand, gridRestaurant;//页面中三个GridView的ID
    private HomePageGridGroupAdapter homePageGridGroupAdapter;//kind值为Group的Adapter
    private HomePageGridBrandAdapter homePageGridBrandAdapter;//kind值为brand的Adapter
    private HomePageGridRestaurantAdapter homePageGridRestaurantAdapter;//kind值为restaurant的Adapter

    @Override
    public int initLayout () {
        return R.layout.fragment_wikipedia;
    }

    @Override
    public void initView () {
        gridGroup = (GridView) getView ().findViewById (R.id.Grid_Group);
        home_logo = (ImageView) getView ().findViewById (R.id.home_logo);
        foodAnalysis = (Button) getView ().findViewById (R.id.Food_analysis);
        gridBrand = (GridView) getView ().findViewById (R.id.Grid_Brand);
        linearsearch = (LinearLayout) getView ().findViewById (R.id.Linear_search);
        gridRestaurant = (GridView) getView ().findViewById (R.id.Grid_Restaurant);
        foodAnalysis.setOnClickListener (this);
        linearsearch.setOnClickListener (this);
        home_logo.setOnClickListener (this);
        homePageGridBrandAdapter = new HomePageGridBrandAdapter (getContext ());
        homePageGridGroupAdapter = new HomePageGridGroupAdapter (getContext ());
        homePageGridRestaurantAdapter = new HomePageGridRestaurantAdapter (getContext ());


    }

    @Override
    public void initData () {
        //开启线程 获取数据
        requestData ();
        gridGroup.setOnItemClickListener (new OnItemClickListener () {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent (getActivity (), WikipediaDetailsActivity.class);
//                intent.putExtra ("key",parent.)
                startActivity (intent);
            }
        });

    }

    private void requestData () {

        NetHelper.MyRequest (MyUrl.WIKIPEDIA, HomePageGridBean.class, new NetListener<HomePageGridBean> () {
            @Override
            public void successListener (HomePageGridBean response) {
                homePageGridGroupAdapter.setBean (response);
                homePageGridBrandAdapter.setBean (response);
                homePageGridRestaurantAdapter.setBean (response);
                gridBrand.setAdapter (homePageGridBrandAdapter);
                gridGroup.setAdapter (homePageGridGroupAdapter);
                gridRestaurant.setAdapter (homePageGridRestaurantAdapter);
            }

            @Override
            public void errorListener (VolleyError error) {

            }
        });

    }

    @Override
    public void onClick (View view) {

        switch (view.getId ()) {
            case R.id.Linear_search:
                Toast.makeText (getActivity (), "测试", Toast.LENGTH_SHORT).show ();
                break;
            case R.id.home_logo:
                Intent intent = new Intent (getActivity (), GiftSaidActivity.class);
                startActivity (intent);
                break;
            case R.id.Food_analysis:
                Intent intent1=new Intent (getActivity (), LoginActivity.class);
                startActivity (intent1);
                break;
        }
    }

}
