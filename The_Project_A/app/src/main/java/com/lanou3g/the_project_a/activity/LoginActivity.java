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

Created by Android_刘德强 on 16/11/25.
*/


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.base.BaseActivity;

//登录界面
public class LoginActivity extends BaseActivity implements OnClickListener{
    private ImageButton my_login_return;
    @Override
    public int getLayout () {
        return R.layout.activity_login;
    }

    @Override
    public void initView () {
        my_login_return = (ImageButton) findViewById (R.id.my_login_return);
        my_login_return.setOnClickListener (this);

    }

    @Override
    public void initData () {

    }

    @Override
    public void onClick (View view) {
        switch (view.getId ()){
            case R.id.my_login_return:
                finish ();
                break;

        }
    }
}
