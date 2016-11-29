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
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.lanou3g.the_project_a.activity.LoginActivity;
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.adapter.GoeatAdapter;
import com.lanou3g.the_project_a.base.BaseFragment;
import com.lanou3g.the_project_a.fragment.go_eat.Goeat_goodfood_Fragment;
import com.lanou3g.the_project_a.fragment.go_eat.Goeat_homepage_Fragment;
import com.lanou3g.the_project_a.fragment.go_eat.Goeat_knowledge_Fragment;
import com.lanou3g.the_project_a.fragment.go_eat.Goeat_review_Fragment;

import java.util.ArrayList;

//一级页面
//逛吃 Fragmen 页面
public class Goeat_Fragment extends BaseFragment implements OnClickListener{
    private TabLayout tabLayout;
    private ImageButton eat_camera;
    private ViewPager viewPager;
    private ArrayList<Fragment> data;
    private GoeatAdapter adapter;
    @Override
    public int initLayout () {
        return R.layout.fragment_go_eat;
    }

    @Override
    public void initView () {
        tabLayout = (TabLayout) getView ().findViewById (R.id.Eat_tab_layout);
        viewPager = (ViewPager) getView ().findViewById (R.id.Eat_ViewPager);
        eat_camera = (ImageButton) getView ().findViewById (R.id.eat_camera);
        eat_camera.setOnClickListener (this);
        data=new ArrayList<> ();
        adapter=new GoeatAdapter (getChildFragmentManager ());

    }

    @Override
    public void initData () {
        //给data添加数据
        DataAdd ();
        adapter.setData (data);
        //绑定适配器
        viewPager.setAdapter (adapter);
        //解决TabLayout居中问题
        tabLayout.setTabGravity (TabLayout.GRAVITY_FILL);
        //Tablayout未选中字体 与选中字体颜色
        tabLayout.setTabTextColors( Color.BLACK,Color.RED);
        //Tablayout下划线颜色
        tabLayout.setSelectedTabIndicatorColor (Color.WHITE);
        //绑定Viewpager
        tabLayout.setupWithViewPager (viewPager);

    }


    private void DataAdd () {
        data.add (new Goeat_homepage_Fragment ());
        data.add (new Goeat_review_Fragment ());
        data.add (new Goeat_knowledge_Fragment ());
        data.add (new Goeat_goodfood_Fragment ());
    }

    @Override
    public void onClick (View view) {
        switch (view.getId ()){
            case R.id.eat_camera:
                Intent intent=new Intent (getActivity (), LoginActivity.class);
                startActivity (intent);
                break;
        }
    }
}
