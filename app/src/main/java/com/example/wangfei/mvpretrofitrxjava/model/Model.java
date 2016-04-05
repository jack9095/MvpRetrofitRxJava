package com.example.wangfei.mvpretrofitrxjava.model;

/**
 * Created by fei.wang on 2016/4/5.
 */
public class Model {

    public Model() {
    }

    public String getString(){
        StringBuffer  buffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            buffer.append(i + "");
        }
        return buffer.toString();
    }
}
