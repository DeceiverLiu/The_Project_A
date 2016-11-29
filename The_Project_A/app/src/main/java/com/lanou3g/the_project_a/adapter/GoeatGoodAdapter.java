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

Created by Android_刘德强 on 16/11/24.
*/

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.bean.GoeatGoodBean.FeedsBean;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

//逛吃- 美食
public class GoeatGoodAdapter extends RecyclerView.Adapter {

    private static final int SIMPLE = 1;
    private static final int COMPLEX = 2;
    private List<FeedsBean> bean;
    private Context context;


    public GoeatGoodAdapter (Context context) {
        this.context = context;
        bean=new ArrayList<> ();
}

    public void Clean(){
        bean.clear ();
    }
    public void setBean (List<FeedsBean> bean) {
        this.bean .addAll (bean);
        notifyDataSetChanged ();
    }

    @Override
    public int getItemViewType (int position) {
        return bean.get (position).getContent_type ();
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        switch (viewType){
            case SIMPLE:
                View view_one= LayoutInflater.from (context).inflate (R.layout.item_eat_goodfood_easy,parent,false);
                holder=new SIMPLEHolder (view_one);
                break;
            case COMPLEX:
                View view_two=LayoutInflater.from (context).inflate (R.layout.item_goodfood_difficult,parent,false);
                holder=new COMPLEXHolder (view_two);
                break;
        }
        return holder;
    }


    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {
        int Type=getItemViewType (position);
        switch (Type){
            case SIMPLE:
                SIMPLEHolder simpleHolder= (SIMPLEHolder) holder;
                simpleHolder.Good_source.setText (bean.get (position).getSource ());
                simpleHolder.Good_tail.setText (bean.get (position).getTail ());
                simpleHolder.Good_title.setText (bean.get (position).getTitle ());
                Picasso.with (context).load (bean.get (position).getImages ().get (0)).into (simpleHolder.Goodfood_images);
                break;
            case COMPLEX:
                COMPLEXHolder complexHolder= (COMPLEXHolder) holder;
                complexHolder.eat_goodfood_title.setText (bean.get (position).getTitle ());
                complexHolder.eat_goodfood_source.setText (bean.get (position).getSource ());
                complexHolder.eat_goodfood_tail.setText (bean.get (position).getTail ());
                Picasso.with (context).load (bean.get (position).getImages ().get (0)).into (complexHolder.eat_goodfood_imgone);
                Picasso.with (context).load (bean.get (position).getImages ().get (1)).into (complexHolder.eat_goodfood_imgtwo);
                Picasso.with (context).load (bean.get (position).getImages ().get (2)).into (complexHolder.eat_goodfood_three);
                break;
            default:

                break;
        }
    }

    @Override
    public int getItemCount () {
        return bean==null?0:bean.size ();
    }

    class SIMPLEHolder extends RecyclerView.ViewHolder {
        private TextView Good_title,Good_source,Good_tail;
        private ImageView Goodfood_images;
        public SIMPLEHolder (View itemView) {
            super (itemView);
            Good_title = (TextView) itemView.findViewById (R.id.Good_title);
            Good_source = (TextView) itemView.findViewById (R.id.Good_source);
            Good_tail = (TextView) itemView.findViewById (R.id.Good_tail);
            Goodfood_images = (ImageView) itemView.findViewById (R.id.Goodfood_images);
        }
    }

    class COMPLEXHolder extends RecyclerView.ViewHolder {
        private TextView eat_goodfood_title, eat_goodfood_source, eat_goodfood_tail;
        private ImageView eat_goodfood_imgone, eat_goodfood_imgtwo, eat_goodfood_three;

        public COMPLEXHolder (View itemView) {
            super (itemView);
            eat_goodfood_title = (TextView) itemView.findViewById (R.id.eat_goodfood_title);
            eat_goodfood_source = (TextView) itemView.findViewById (R.id.eat_goodfood_source);
            eat_goodfood_tail = (TextView) itemView.findViewById (R.id.eat_goodfood_tail);
            eat_goodfood_imgone = (ImageView) itemView.findViewById (R.id.eat_goodfood_imgone);
            eat_goodfood_imgtwo = (ImageView) itemView.findViewById (R.id.eat_goodfood_imgtwo);
            eat_goodfood_three = (ImageView) itemView.findViewById (R.id.eat_goodfoodthree);
        }
    }
}
