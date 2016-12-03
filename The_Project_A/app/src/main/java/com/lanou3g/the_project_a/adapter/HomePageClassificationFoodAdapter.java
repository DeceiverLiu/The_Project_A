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

Created by Android_刘德强 on 16/12/1.
*/


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.bean.ClassificationOfFoodBean;
import com.lanou3g.the_project_a.bean.ClassificationOfFoodBean.FoodsBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomePageClassificationFoodAdapter extends BaseAdapter {

    private List<ClassificationOfFoodBean.FoodsBean> bean;
    private Context context;

    public HomePageClassificationFoodAdapter (Context context) {
        this.context = context;
        bean=new ArrayList<> ();
    }

    public List<FoodsBean> getBean () {
        return bean;
    }

    public void setBean (List<FoodsBean> bean) {
        this.bean = bean;
        notifyDataSetChanged ();
    }


    @Override
    public int getCount () {
        return bean.size ();
    }

    @Override
    public Object getItem (int position) {
        return bean.get (position);
    }

    @Override
    public long getItemId (int position) {
        return position;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            convertView= LayoutInflater.from (context).inflate (R.layout.item_classification_of_food,parent,false);
            holder=new ViewHolder (convertView);
            convertView.setTag (holder);
        }else {
            holder= (ViewHolder) convertView.getTag ();
        }
        Picasso.with (context).load (bean.get (position).getThumb_image_url ()).into (holder.thumb_image_url);
        holder.thumb_name.setText (bean.get (position).getName ());
        holder.calory.setText (bean.get (position).getCalory ());
        holder.weight.setText (bean.get (position).getWeight ());
        return convertView;
    }

    class ViewHolder{
        private CircleImageView thumb_image_url;
        private TextView thumb_name,calory,weight;
        public ViewHolder(View view){
            thumb_image_url = (CircleImageView) view.findViewById (R.id.thumb_image_url);
            thumb_name = (TextView) view.findViewById (R.id.thumb_name);
            calory = (TextView) view.findViewById (R.id.calory);
            weight = (TextView) view.findViewById (R.id.weight);
        }
    }

}
