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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.base.BaseActivity;
import com.lanou3g.the_project_a.greendao.CollectionPerson;
import com.lanou3g.the_project_a.greendao.DBTool;


//逛吃 首页 详情
//webView 型
public class HomePageActivity extends BaseActivity implements OnClickListener{
    private WebView webView;
    private ImageView back_dark_img;
    private CheckBox checkBox;
    private String rtitle;
    private String rsourec;
    private String rtail;
    private String rbackground;
    private String url;

    @Override
    public int getLayout () {
        return R.layout.activity_homepage;
    }

    @Override
    public void initView () {
        webView = (WebView) findViewById (R.id.web_home);
        back_dark_img = (ImageView) findViewById (R.id.back_dark_img);
        back_dark_img.setOnClickListener (this);
        checkBox = (CheckBox) findViewById (R.id.byCollection);

    }

    @Override
    public void initData () {
        String url = GetStringExtra ();//获取字段
        if (DBTool.getInstance ().isSave (rtitle)){
            checkBox.setChecked (true);
        }else {
            checkBox.setChecked (false);
        }
        webView.getSettings ().setJavaScriptEnabled (true);
        webView.getSettings ().setBlockNetworkImage (false);
        webView.loadUrl (url);
        ByCollection ();//点击收藏或者取消收藏

    }

    private String GetStringExtra () {
        Intent intent=getIntent ();
        url = intent.getStringExtra ("network");
        rsourec = intent.getStringExtra ("Rsourec");
        rtitle = intent.getStringExtra ("Rtitle");
        rtail = intent.getStringExtra ("Rtail");
        rbackground = intent.getStringExtra ("Rbackground");
        return url;
    }

    private void ByCollection () {
        checkBox.setOnCheckedChangeListener (new OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    CollectionPerson person=new CollectionPerson (null,rtitle,rsourec,rtail,rbackground,url);
                     DBTool.getInstance ().insertPerson (person);
                    Toast.makeText (HomePageActivity.this, "已收藏", Toast.LENGTH_SHORT).show ();
                }else {
                    DBTool.getInstance ().deleteByTitle (rtitle);
                }

            }
        });
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
