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

Created by Android_刘德强 on 16/12/6.
*/


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.adapter.SearchAdapter.MyViewHolder;
import com.lanou3g.the_project_a.bean.SearchBean;

public class SearchAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private SearchBean bean;

    public SearchAdapter (Context context) {
        this.context = context;
    }

    public void setBean (SearchBean bean) {
        this.bean = bean;
        notifyDataSetChanged ();
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (context).inflate (R.layout.item_search,parent,false);
        MyViewHolder holder=new MyViewHolder (view);
        return holder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, int position) {
        holder.textView.setText (bean.getKeywords ().get (position));
    }

    @Override
    public int getItemCount () {
        return bean.getKeyword_count ();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public MyViewHolder (View itemView) {
            super (itemView);
            textView = (TextView) itemView.findViewById (R.id.search_text);
        }
    }
}
