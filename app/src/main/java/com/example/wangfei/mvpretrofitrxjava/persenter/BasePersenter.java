package com.example.wangfei.mvpretrofitrxjava.persenter;

import com.example.wangfei.mvpretrofitrxjava.callback.ActivityCallBack;
import com.example.wangfei.mvpretrofitrxjava.model.Data;

/**
 * Created by Administrator on 2016/4/5.
 */
public abstract class BasePersenter {

    protected ActivityCallBack callBack;

    /**动作唯一绑定标志*/
    public static final int ACTION_1 = 1;

    protected void sendMessage(Data data){

        if (callBack != null) {
            callBack.toUI(data.action,data.data);
        }
    }

    /**
     * 调用实例销毁时同步销毁Persenter实例,避免单例长期被持有,导致潜在的内存泄露
     */
    protected abstract void destoryInstence();
}
