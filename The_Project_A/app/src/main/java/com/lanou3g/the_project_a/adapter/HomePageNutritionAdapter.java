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

Created by Android_刘德强 on 16/11/26.
*/

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.adapter.HomePageNutritionAdapter.MyViewHolder;
import com.lanou3g.the_project_a.bean.WikipediaDetailsBean;
import com.lanou3g.the_project_a.bean.WikipediaDetailsBean.TypesBean;

import java.util.List;

//食物百科 - GridView 详情 - 营养素排序
public class HomePageNutritionAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private List<WikipediaDetailsBean.TypesBean> bean;
    private Context context;

    public HomePageNutritionAdapter (Context context) {
        this.context = context;
    }

    public void setBean (List<TypesBean> bean) {
        this.bean = bean;
        notifyDataSetChanged ();
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
       View view= LayoutInflater.from (context).inflate (R.layout.item_wikipedoapop,parent,false);
        MyViewHolder holder=new MyViewHolder (view);
        return holder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, int position) {
        holder.textView.setText (bean.get (position).getName ());
    }

    @Override
    public int getItemCount () {
        return bean.size ();
    }


    class MyViewHolder extends ViewHolder {
        private TextView textView;

        public MyViewHolder (View itemView) {
            super (itemView);
            textView = (TextView) itemView.findViewById (R.id.text_wikipedoapop);
        }
    }
}
