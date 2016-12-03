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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.bean.GoeatKnowBean.FeedsBean;
import com.lanou3g.the_project_a.onclick.MyOnClick;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



public class GoearKnowledgeAdapter extends RecyclerView.Adapter {

    //数据源
    private List<FeedsBean> bean;
    //接口中不同行布局的ID
    private static final int SIMPLE = 1;
    private static final int COMPLEX = 2;
    //上下文
    private Context context;
    private MyOnClick myOnClick;


    //构造方法
    public GoearKnowledgeAdapter (Context context) {
        this.context = context;
        bean = new ArrayList<> ();
    }

    public void Clean(){
        bean.clear ();
    }


    public void setBean (List<FeedsBean> bean) {
        this.bean.addAll (bean);
        notifyDataSetChanged ();
    }

    public List<FeedsBean> getBean () {
        return bean;
    }

    public void setMyOnClick (MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }

    @Override
    public int getItemViewType (int position) {
        //获取ViewType
        return bean.get (position).getContent_type ();

    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
            switch (viewType) {
                case SIMPLE:
                    View views = LayoutInflater.from (context).inflate (R.layout.item_knowledge_easy, parent, false);
                    holder = new SIMPLEHolders (views);
                    break;
                case COMPLEX:
                    View viewc = LayoutInflater.from (context).inflate (R.layout.item_knowledge_difficult, parent, false);
                    holder = new COMPLEXHolders (viewc);
                    break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, final int position) {
        int Type = getItemViewType (position);
        FeedsBean feedsBean = bean.get (position);
        switch (Type) {
            case SIMPLE:
                SIMPLEHolders simpleHolders = (SIMPLEHolders) holder;
                simpleHolders.Konwledge_title.setText (feedsBean.getTitle ());
                simpleHolders.Konwledge_source.setText (feedsBean.getSource ());
                simpleHolders.Konwledge_tail.setText (feedsBean.getTail ());
                Picasso.with (context).load (feedsBean.getImages ().get (0)).into (simpleHolders.Konwledge_images);
                break;
            case COMPLEX:
                COMPLEXHolders complexHolders = (COMPLEXHolders) holder;
                complexHolders.eat_knowledge_tail.setText (feedsBean.getTail ());
                complexHolders.eat_knowledge_source.setText (feedsBean.getSource ());
                complexHolders.eat_knowledge_title.setText (feedsBean.getTitle ());
                Picasso.with (context).load (feedsBean.getImages ().get (0)).into (complexHolders.eat_knowledge_imgone);
                Picasso.with (context).load (feedsBean.getImages ().get (1)).into (complexHolders.eat_knowledge_imgtwo);
                Picasso.with (context).load (feedsBean.getImages ().get (2)).into (complexHolders.eat_knowledgethree);
                break;
        }
        holder.itemView.setOnClickListener (new OnClickListener () {
            @Override
            public void onClick (View v) {
                myOnClick.myListener (position,position);
            }
        });
    }

    @Override
    public int getItemCount () {
        return bean == null ? 0 : bean.size ();
    }

    class SIMPLEHolders extends RecyclerView.ViewHolder {
        private TextView Konwledge_title, Konwledge_source, Konwledge_tail;
        private ImageView Konwledge_images;

        public SIMPLEHolders (View itemView) {
            super (itemView);
            Konwledge_title = (TextView) itemView.findViewById (R.id.Konwledge_title);
            Konwledge_source = (TextView) itemView.findViewById (R.id.Konwledge_source);
            Konwledge_tail = (TextView) itemView.findViewById (R.id.Konwledge_tail);
            Konwledge_images = (ImageView) itemView.findViewById (R.id.Konwledge_images);
        }
    }

    class COMPLEXHolders extends RecyclerView.ViewHolder {
        private TextView eat_knowledge_title, eat_knowledge_source, eat_knowledge_tail;
        private ImageView eat_knowledge_imgone, eat_knowledge_imgtwo, eat_knowledgethree;

        public COMPLEXHolders (View itemView) {
            super (itemView);
            eat_knowledge_title = (TextView) itemView.findViewById (R.id.eat_knowledge_title);
            eat_knowledge_source = (TextView) itemView.findViewById (R.id.eat_knowledge_source);
            eat_knowledge_tail = (TextView) itemView.findViewById (R.id.eat_knowledge_tail);
            eat_knowledge_imgone = (ImageView) itemView.findViewById (R.id.eat_knowledge_imgone);
            eat_knowledge_imgtwo = (ImageView) itemView.findViewById (R.id.eat_knowledge_imgtwo);
            eat_knowledgethree = (ImageView) itemView.findViewById (R.id.eat_knowledgethree);
        }
    }
}
