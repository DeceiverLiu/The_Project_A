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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.bean.HomePageGridBean;
import com.squareup.picasso.Picasso;


//一级界面 食物百科
//GridView kind值为restaurant的 适配器
public class HomePageGridRestaurantAdapter extends BaseAdapter{
    private HomePageGridBean bean;
    private Context context;

    public HomePageGridRestaurantAdapter (Context context) {
        this.context = context;
    }

    public void setBean (HomePageGridBean bean) {
        this.bean = bean;
        notifyDataSetChanged ();
    }

    @Override
    public int getCount () {
        return bean.getGroup ().get (2).getCategories ().size ();
    }

    @Override
    public Object getItem (int i) {
        return bean.getGroup ().get (2).getCategories ().get (i);
    }

    @Override
    public long getItemId (int i) {
        return i;
    }

    @Override
    public View getView (int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (view==null){
            view= LayoutInflater.from (context).inflate (R.layout.item_homepage_gv_restaurant,viewGroup,false);
            holder=new ViewHolder (view);
            view.setTag (holder);
        }else {
            holder= (ViewHolder) view.getTag ();
        }

            holder.home_restaurant_text.setText (bean.getGroup ().get (2).getCategories ().get (i).getName ());
            Picasso.with (context).load (bean.getGroup ().get (2).getCategories ().get (i).getImage_url ()).into (holder.home_restaurant_img);

            return view;

    }

    class ViewHolder{
        private TextView home_restaurant_text;
        private ImageView home_restaurant_img;
        public ViewHolder(View view){
            home_restaurant_img = (ImageView) view.findViewById (R.id.home_restaurant_img);
            home_restaurant_text = (TextView) view.findViewById (R.id.home_restaurant_text);
        }
    }
}
