package com.lanou3g.the_project_a.activity.goeat;

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

Created by Android_刘德强 on 16/11/29.
*/

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.base.BaseActivity;


//逛吃 首页 详情
//webView 型
public class HomePageActivity extends BaseActivity implements OnClickListener{
    private WebView webView;
    private ImageView back_dark_img;
    @Override
    public int getLayout () {
        return R.layout.activity_homepage;
    }

    @Override
    public void initView () {
        webView = (WebView) findViewById (R.id.web_home);
        back_dark_img = (ImageView) findViewById (R.id.back_dark_img);
        back_dark_img.setOnClickListener (this);

    }

    @Override
    public void initData () {
        Intent intent=getIntent ();
        String url=intent.getStringExtra ("network");
        webView.getSettings ().setJavaScriptEnabled (true);
        webView.getSettings ().setBlockNetworkImage (false);
        webView.loadUrl (url);

    }

    @Override
    public void onClick (View v) {
        switch (v.getId ()){
            case R.id.back_dark_img:
                finish ();
                break;
        }
    }
}
