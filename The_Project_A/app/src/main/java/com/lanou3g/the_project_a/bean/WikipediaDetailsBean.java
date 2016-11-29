package com.lanou3g.the_project_a.bean;

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

import java.util.List;

//食物百科 GridView详情 营养素排序Bean
public class WikipediaDetailsBean {


    private List<TypesBean> types;

    public List<TypesBean> getTypes () {
        return types;
    }

    public void setTypes (List<TypesBean> types) {
        this.types = types;
    }

    public static class TypesBean {
        /**
         * code : calory
         * name : 热量
         * index : 2
         */

        private String code;
        private String name;
        private String index;

        public String getCode () {
            return code;
        }

        public void setCode (String code) {
            this.code = code;
        }

        public String getName () {
            return name;
        }

        public void setName (String name) {
            this.name = name;
        }

        public String getIndex () {
            return index;
        }

        public void setIndex (String index) {
            this.index = index;
        }
    }
}
