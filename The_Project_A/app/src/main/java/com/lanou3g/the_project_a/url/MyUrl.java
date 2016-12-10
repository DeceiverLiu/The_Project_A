package com.lanou3g.the_project_a.url;

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


public class MyUrl {
    //食物百科- GridView
    public static final String WIKIPEDIA="http://food.boohee.com/fb/v1/categories/list";
    //逛吃- 首页网址
    public static final String EATHOMEBEFORE="http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    public static final String EATHOMEAFTER="http://&category=1&per=10";
    //逛吃- 知识
    public static final String EATKNOWLEDGEBEFORE="http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    public static final String EATKNOWLEDGEAFTER="&category=3&per=10";
    //逛吃- 美食
    public static final String EATGOODFOODBEFORE="http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    public static final String EATGOODFOODAFTER="&category=4&per=10";
    //逛吃- 测评
    public static final String AVI_ONE = "http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    public static final String AVI_TWO = "&category=2&per=10";
    //食物百科 - GridView - 营养素排序
    public static final String WILIPEDOAPOP= "http://food.boohee.com/fb/v1/foods/sort_types";
    //食物百科 - GridView 详情 - 食物分类
    public static final String ClassificationBefore ="http://food.boohee.com/fb/v1/foods?kind=";
    public static final String ClassificationMiddle ="&value=";
    public static final String ClassificationAfter ="&order_by=1&page=";
    public static final String ClassificationLast ="&order_asc=0&token=&user_key=&app_version=2.6&app_device=Android&os_version=5.1&phone_model=Google+Nexus+7+2013+-+5.1.0+-+API+22+-+1200x1920&channel=baidu";
    //搜索下方推荐
    public static final String SearchRecommended="http://food.boohee.com/fb/v1/keywords?token=&user_key=&app_version=2.6&app_device=Android&os_version=5.1&phone_model=Google+Nexus+7+2013+-+5.1.0+-+API+22+-+1200x1920&channel=baidu";
    //搜索网址拼接
    public static final String SearchField="http://food.boohee.com/fb/v1/search?page=1&order_asc=desc&q=";

}
