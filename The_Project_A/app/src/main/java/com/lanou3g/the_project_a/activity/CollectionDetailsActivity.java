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

Created by Android_刘德强 on 16/12/12.
*/

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.base.BaseActivity;

//点击我的收藏进入详情
public class CollectionDetailsActivity extends BaseActivity implements OnClickListener {

    private WebView webView;
    private ImageButton imageButton;

    @Override
    public int getLayout () {
        return R.layout.collectiondetails;
    }

    @Override
    public void initView () {
        webView = (WebView) findViewById (R.id.collection_webview);
        imageButton = (ImageButton) findViewById (R.id.CollectDetails_back);
        imageButton.setOnClickListener (this);

    }

    @Override
    public void initData () {
        MyDetails ();//获取网址 并读取详情
    }

    private void MyDetails () {
        Intent intent = getIntent ();
        String url = intent.getStringExtra ("ThisKey");
        webView.getSettings ().setJavaScriptEnabled (true);
        webView.getSettings ().setBlockNetworkImage (false);
        webView.loadUrl (url);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId ()){
            case R.id.CollectDetails_back:
                finish ();
                break;
        }
    }
}
