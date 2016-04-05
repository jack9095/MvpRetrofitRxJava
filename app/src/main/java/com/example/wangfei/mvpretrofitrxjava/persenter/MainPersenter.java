package com.example.wangfei.mvpretrofitrxjava.persenter;

import android.view.View;

import com.example.wangfei.mvpretrofitrxjava.R;
import com.example.wangfei.mvpretrofitrxjava.callback.ActivityCallBack;
import com.example.wangfei.mvpretrofitrxjava.model.Data;
import com.example.wangfei.mvpretrofitrxjava.model.Model;

/**
 * Created by Administrator on 2016/4/5.
 */
public class MainPersenter extends BasePersenter {
    private static MainPersenter mainPersenter;

    public static MainPersenter getInstance(){
        if (mainPersenter == null) {
            mainPersenter = new MainPersenter();
        }
        return mainPersenter;
    }

    /**操作 在view中调用*/
    public void Operation(ActivityCallBack activityCallBack){
        callBack = activityCallBack;
        Model model = new Model();
        Data data = new Data();
        data.data = model.getString();
        data.action = ACTION_1;
        sendMessage(data);
    }

    @Override
    protected void destoryInstence() {
        if (mainPersenter != null) {
            mainPersenter = null;
        }
    }
}
