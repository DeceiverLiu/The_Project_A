package com.lanou3g.the_project_a.adapter;

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


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

//逛吃 TabLayout适配器
public class GoeatAdapter extends FragmentPagerAdapter{

    private ArrayList<Fragment> data;
    private String [] title={"首页","测评","知识","美食"};

    public void setData (ArrayList<Fragment> data) {
        this.data = data;
        notifyDataSetChanged ();
    }

    public GoeatAdapter (FragmentManager fm) {
        super (fm);
    }

    @Override
    public Fragment getItem (int position) {
        return data.get (position);
    }

    @Override
    public int getCount () {
        return data.size ();
    }

    @Override
    public CharSequence getPageTitle (int position) {
        return title[position];
    }
}
