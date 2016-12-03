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

Created by Android_刘德强 on 16/11/30.
*/


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.base.BaseActivity;

//我的 - 设置
public class SetUpActivity extends BaseActivity implements OnClickListener{
    private ImageButton set_return;
    @Override
    public int getLayout () {
        return R.layout.activity_setup;

    }

    @Override
    public void initView () {
        set_return = (ImageButton) findViewById (R.id.set_return);
        set_return.setOnClickListener (this);
    }

    @Override
    public void initData () {

    }

    @Override
    public void onClick (View v) {
        switch (v.getId ()){
            case R.id.set_return:
                finish ();
                break;
        }
    }
}
