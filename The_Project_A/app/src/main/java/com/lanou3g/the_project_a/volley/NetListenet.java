package com.lanou3g.the_project_a.volley;

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

Created by Android_刘德强 on 16/11/28.
*/


import com.android.volley.VolleyError;

public interface NetListenet {
    /**
     * 定义一个接口 两个方法 分别是成功时候的回调
     * 失败时候的回调
     */
    public interface NetListener<T> {
        //参数 就是解析后的数据
        void successListener (T response);

        //参数 对错误信息进行操作
        void errorListener (VolleyError error);
    }
}