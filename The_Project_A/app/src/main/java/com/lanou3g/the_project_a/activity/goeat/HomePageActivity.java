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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.base.BaseActivity;
import com.lanou3g.the_project_a.greendao.CollectionPerson;
import com.lanou3g.the_project_a.greendao.DBTool;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;


//逛吃 首页 详情
//webView 型
public class HomePageActivity extends BaseActivity implements OnClickListener {
    private WebView webView;
    private ImageView back_dark_img;
    private CheckBox checkBox;
    private String rtitle;
    private String rsourec;
    private String rtail;
    private String rbackground;
    private String url;
    private RelativeLayout relativeLayout;

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
        relativeLayout = (RelativeLayout) findViewById (R.id.MyShare);
        relativeLayout.setOnClickListener (this);
        ShareSDK.initSDK (this);

    }

    @Override
    public void initData () {
        String url = GetStringExtra ();//获取字段
        if (DBTool.getInstance ().isSave (rtitle)) {
            checkBox.setChecked (true);
        } else {
            checkBox.setChecked (false);
        }
        webView.getSettings ().setJavaScriptEnabled (true);
        webView.getSettings ().setBlockNetworkImage (false);
        webView.loadUrl (url);
        ByCollection ();//点击收藏或者取消收藏

    }

    private String GetStringExtra () {
        Intent intent = getIntent ();
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
                if (isChecked) {
                    CollectionPerson person = new CollectionPerson (null, rtitle, rsourec, rtail, rbackground, url);
                    DBTool.getInstance ().insertPerson (person);
                    Toast.makeText (HomePageActivity.this, "已收藏", Toast.LENGTH_SHORT).show ();
                } else {
                    DBTool.getInstance ().deleteByTitle (rtitle);
                }

            }
        });
    }

    @Override
    public void onClick (View v) {
        switch (v.getId ()) {
            case R.id.back_dark_img:
                finish ();
                break;
            case R.id.MyShare:
                showShare ();
                break;
        }
    }

    //第三方分享功能
    private void showShare () {
        ShareSDK.initSDK (this);
        OnekeyShare oks = new OnekeyShare ();
//关闭sso授权
        oks.disableSSOWhenAuthorize ();
// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle ("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl ("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText ("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl ("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment ("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite (getString (R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl ("http://sharesdk.cn");

// 启动分享GUI
        oks.show (this);
    }
}
