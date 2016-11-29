package com.lanou3g.the_project_a.adapter;

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


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.activity.onclick.MyOnClick;
import com.lanou3g.the_project_a.bean.GoeatHomeBean;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import it.sephiroth.android.library.picasso.Picasso;

//逛吃- 首页 RecyclerView适配器
public class GoeatHomeAdapter extends RecyclerView.Adapter {

    private List<GoeatHomeBean.FeedsBean> bean;
    private Context context;
    private static final int SIMPLE = 5;
    private static final int REC = 6;
    private MyOnClick myOnClick;

    public GoeatHomeAdapter (Context context) {
        this.context = context;
        bean = new ArrayList<> ();
    }

    public void setBean (List<GoeatHomeBean.FeedsBean> bean) {
        this.bean.addAll (bean);
        notifyDataSetChanged ();
    }

    public void setMyOnClick (MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
        notifyDataSetChanged ();
    }

    @Override
    public int getItemViewType (int position) {
        return bean.get (position).getContent_type ();
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case SIMPLE:
                View viewSend = LayoutInflater.from (context).inflate (R.layout.item_eat_home_difficult_, parent, false);
                holder = new SIMPLEHolder (viewSend);
                break;
            case REC:
                View viewRec = LayoutInflater.from (context).inflate (R.layout.item_eat_home_easy_, parent, false);
                holder = new COMPLEXHolder (viewRec);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, final int position) {
        int type = getItemViewType (position);
        switch (type) {
            case SIMPLE:
                SIMPLEHolder simpleHolder = (SIMPLEHolder) holder;
                simpleHolder.eat_home_title.setText (bean.get (position).getTitle ());
                simpleHolder.eat_home_publisher.setText (bean.get (position).getPublisher ());
                simpleHolder.eat_home_thumbUp.setText (bean.get (position).getLike_ct () + "");
                Picasso.with (context).load (bean.get (position).getCard_image ()).into (simpleHolder.eat_home_card);
                Picasso.with (context).load (bean.get (position).getPublisher_avatar ()).into (simpleHolder.eat_img_homeAvatar);
                break;
            case REC:
                COMPLEXHolder complexHolder = (COMPLEXHolder) holder;
                Picasso.with (context).load (bean.get (position).getCard_image ()).into (complexHolder.eat_img_homeEasy);
                break;
        }
        holder.itemView.setOnClickListener (new OnClickListener () {
            @Override
            public void onClick (View v) {
                myOnClick.myListener(position);
            }
        });
    }

    @Override
    public int getItemCount () {
        return bean.size ();
    }


    //内容较多的行布局内部类
    class SIMPLEHolder extends RecyclerView.ViewHolder {
        private ImageView eat_home_card;
        private TextView eat_home_title, eat_home_publisher, eat_home_thumbUp;
        private CircleImageView eat_img_homeAvatar;

        public SIMPLEHolder (View itemView) {
            super (itemView);
            eat_img_homeAvatar = (CircleImageView) itemView.findViewById (R.id.eat_home_homeAvatar);
            eat_home_card = (ImageView) itemView.findViewById (R.id.eat_img_card);
            eat_home_title = (TextView) itemView.findViewById (R.id.eat_home_title);
            eat_home_publisher = (TextView) itemView.findViewById (R.id.eat_home_publisher);
            eat_home_thumbUp = (TextView) itemView.findViewById (R.id.eat_home_thumbUp);
        }
    }

    //内容较少的行布局内部类
    class COMPLEXHolder extends RecyclerView.ViewHolder {
        private ImageView eat_img_homeEasy;

        public COMPLEXHolder (View itemView) {
            super (itemView);
            eat_img_homeEasy = (ImageView) itemView.findViewById (R.id.eat_img_homeEasy);
        }
    }
}
