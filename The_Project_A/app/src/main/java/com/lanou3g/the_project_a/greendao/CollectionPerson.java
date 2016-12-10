package com.lanou3g.the_project_a.greendao;

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

Created by Android_刘德强 on 16/12/10.
*/


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class CollectionPerson {

    @Id
    private Long id;
    private String title, source, tail,background,image;

    @Transient
    private String say;

@Generated(hash = 1936425332)
public CollectionPerson(Long id, String title, String source, String tail,
        String background, String image) {
    this.id = id;
    this.title = title;
    this.source = source;
    this.tail = tail;
    this.background = background;
    this.image = image;
}

@Generated(hash = 1923236581)
public CollectionPerson() {
}

public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

public String getTitle() {
    return this.title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getSource() {
    return this.source;
}

public void setSource(String source) {
    this.source = source;
}

public String getTail() {
    return this.tail;
}

public void setTail(String tail) {
    this.tail = tail;
}

public String getBackground() {
    return this.background;
}

public void setBackground(String background) {
    this.background = background;
}

public String getImage() {
    return this.image;
}

public void setImage(String image) {
    this.image = image;
}

}