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


import android.content.Intent;
import android.os.CountDownTimer;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.base.BaseActivity;

public class WelcomeActivity extends BaseActivity{
    @Override
    public int getLayout () {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView () {

    }

    @Override
    public void initData () {
        timer.start ();
    }

    private CountDownTimer timer=new CountDownTimer (1000,1000) {
        @Override
        public void onTick (long millisUntilFinished) {

        }

        @Override
        public void onFinish () {
            Intent intent=new Intent (WelcomeActivity.this,MainActivity.class);
            startActivity (intent);
            finish ();
        }
    };
}
