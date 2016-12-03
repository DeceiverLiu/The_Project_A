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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.bean.GoeatReviewBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class GoeatReviewAdapter extends BaseAdapter {
    private List<GoeatReviewBean.FeedsBean> bean;
    private Context context;


    public GoeatReviewAdapter (Context context) {
        this.context = context;
        bean=new ArrayList<> ();
    }




    public void setBean (List<GoeatReviewBean.FeedsBean> bean) {
        this.bean = bean;
        notifyDataSetChanged ();
    }

    public void Clean(){
        bean.clear ();
    }

    @Override
    public int getCount () {
        return bean.size ()!=0? bean.size ():0 ;
    }

    @Override
    public Object getItem (int i) {
        return bean.get (i);
    }

    @Override
    public long getItemId (int i) {
        return i;
    }

    @Override
    public View getView (int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (view==null){
            view= LayoutInflater.from (context).inflate (R.layout.item_eat_review,viewGroup,false);
            holder=new ViewHolder (view);
            view.setTag (holder);
        }else {
            holder= (ViewHolder) view.getTag ();
        }
        holder.reciew_text_source.setText (bean.get (i).getSource ());
        holder.reciew_text_title.setText (bean.get (i).getTitle ());
        holder.reciew_text_tail.setText (bean.get (i).getTail ());
        Picasso.with (context).load (bean.get (i).getBackground ()).into (holder.relative_img);
        return view;
    }

    class  ViewHolder{
        private ImageView relative_img;
        private TextView reciew_text_source,reciew_text_title,reciew_text_tail;
        public ViewHolder(View view){
            relative_img = (ImageView) view.findViewById (R.id.relative_img);
            reciew_text_tail = (TextView) view.findViewById (R.id.reciew_text_tail);
            reciew_text_source = (TextView) view.findViewById (R.id.reciew_text_source);
            reciew_text_title = (TextView) view.findViewById (R.id.reciew_text_title);

        }
    }
}
