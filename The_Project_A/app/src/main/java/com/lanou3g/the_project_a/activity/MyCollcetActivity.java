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

Created by Android_刘德强 on 16/12/9.
*/


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.base.BaseActivity;

//我的收藏
public class MyCollcetActivity extends BaseActivity implements OnClickListener {
    private ImageButton back;
    private ListView listView;

    @Override
    public int getLayout () {
        return R.layout.activity_mycollcet;
    }

    @Override
    public void initView () {
        listView = (ListView) findViewById (R.id.myCollect_listView);
        back = (ImageButton) findViewById (R.id.myCollect_back);
        back.setOnClickListener (this);

    }

    @Override
    public void initData () {

    }

    @Override
    public void onClick (View v) {
        switch (v.getId ()){
            case R.id.myCollect_back:
                finish ();
                break;
        }
    }
}
