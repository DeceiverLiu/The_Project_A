package com.lanou3g.the_project_a.third_party;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by dllo on 16/11/16.
 */
public abstract class EndLessOnScrollListener extends RecyclerView.OnScrollListener{

    private LinearLayoutManager m;
    //定义当前页初始为0
    private int currentPage = 0;

    //已经加载的Item数量
    private int totalCount;
    //主要用来存储上一个totalCount
    private int previousTotal = 0;
    //在屏幕上可见的item数量
    private int visibleCount;
    //在屏幕上可见的Item中的第一个
    private int firstVisible;
    //是否上拉数据
    private boolean loading = true;

    //构造方法(获取布局)
    public EndLessOnScrollListener (LinearLayoutManager m) {
        this.m = m;
    }



    //滑动监听事件
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        //显示的条目数
        visibleCount = recyclerView.getChildCount();
        //显示数据总数
        totalCount = m.getItemCount();
        firstVisible = m.findFirstVisibleItemPosition();
        //是否有数据
        if (loading) {
//            if (totalCount > previousTotal) {    !!!破玩意 不需要
                //说明加载结束
                loading = false;
                previousTotal = totalCount;
//            }
        }
        //状态是否是滑动停止状态，显示的最大条目是否大于整个数据
        if (!loading && totalCount - visibleCount <= firstVisible) {
            currentPage++;
            onLoadMore(currentPage);
            loading = true;
        }
    }

    //写抽象方法，在Activity中监听到这个EndLessOnScrollListener 并且实现这个方法
    protected abstract void onLoadMore(int currentPage);

}
