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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lanou3g.the_project_a.activity.LoginActivity;
import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.base.BaseFragment;


//一级页面
//我的 Fragment 页面
public class My_Fragment extends BaseFragment implements OnClickListener{

    private Button my_login;//点击登录按钮
    private RelativeLayout RelativeLayout_photo,RelativeLayout_collcet, //我的照片,我的收藏,上传食物数据,我的订单
            RelativeLayout_upload,RelativeLayout_order;
    @Override
    public int initLayout () {
        return R.layout.fragment_my;
    }

    @Override
    public void initView () {
        RelativeLayout_order = (RelativeLayout) getView ().findViewById (R.id.RelativeLayout_order);
        RelativeLayout_photo = (RelativeLayout) getView ().findViewById (R.id.RelativeLayout_photo);
        RelativeLayout_collcet = (RelativeLayout) getView ().findViewById (R.id.RelativeLayout_collcet);
        RelativeLayout_upload = (RelativeLayout) getView ().findViewById (R.id.RelativeLayout_upload);
        my_login = (Button) getView ().findViewById (R.id.my_login);
        RelativeLayout_upload.setOnClickListener (this);
        RelativeLayout_order.setOnClickListener (this);
        RelativeLayout_collcet.setOnClickListener (this);
        RelativeLayout_photo.setOnClickListener (this);
        my_login.setOnClickListener (this);

    }

    @Override
    public void initData () {

    }

    @Override
    public void onClick (View view) {
        switch (view.getId ()){
            case R.id.my_login:
                StartAty ();
                break;
            case R.id.RelativeLayout_photo:
                StartAty ();
                break;
            case R.id.RelativeLayout_collcet:
                StartAty ();
                break;
            case R.id.RelativeLayout_upload:
                StartAty ();
                break;
            case R.id.RelativeLayout_order:
                StartAty ();
                break;
        }
    }

    //跳转LoginActivity页面
    private void StartAty() {
        Intent intent=new Intent (getActivity (), LoginActivity.class);
        startActivity (intent);
    }
}
