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
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.base.BaseActivity;

import de.hdodenhof.circleimageview.CircleImageView;
import it.sephiroth.android.library.picasso.Picasso;


//逛吃 首页 详情
//有详情 型
public class HomePageDetailsActivity  extends BaseActivity implements OnClickListener{
    private CircleImageView card_images; //作者头像
    private ImageView publisher_avatar_imgs; //详情图片
    private TextView publisher_details; //作者
    private TextView like_ct_details; //赞
    private ImageView img_xx; //返回按钮

    @Override
    public int getLayout () {
        return R.layout.activity_homepagedetails;
    }

    @Override
    public void initView () {
        card_images = (CircleImageView) findViewById (R.id.card_image);
        publisher_avatar_imgs = (ImageView) findViewById (R.id.publisher_avatar_img);
        publisher_details = (TextView) findViewById (R.id.publisher_details);
        like_ct_details = (TextView) findViewById (R.id.like_ct_details);
        img_xx = (ImageView) findViewById (R.id.img_xx);
        img_xx.setOnClickListener (this);

    }

    @Override
    public void initData () {
        //获取并添加数据
        GetData ();
    }

    private void GetData () {
        Intent intent=getIntent ();
        String  card_image= intent.getStringExtra ("card_image");
        String  publisher_avatar= intent.getStringExtra ("publisher_avatar");
        String  publisher= intent.getStringExtra ("publisher");
        String  like_ct= intent.getStringExtra ("like_ct");
        publisher_details.setText (publisher);
        like_ct_details.setText (like_ct);
        Picasso.with (this).load (card_image).into (publisher_avatar_imgs);
        Picasso.with (this).load (publisher_avatar).into (card_images);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId ()){
            case R.id.img_xx:
                finish ();
                break;
        }
    }
}
