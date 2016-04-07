package com.example.wangfei.mvpretrofitrxjava.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.example.wangfei.mvpretrofitrxjava.callback.IDelegate;
import com.example.wangfei.mvpretrofitrxjava.utils.ToastUtils;

import butterknife.ButterKnife;

/**
 * @author fei.wang
 * Describe：视图层代理的基类
 * 参考：http://www.kymjs.com/
 * Date：2016年4月6日
 */
public abstract class AppDelegate implements IDelegate{

    protected final SparseArray<View>  mViews = new SparseArray<>();  // SparseArray用法相当于Map,但更省内存。http://blog.csdn.net/xyz_fly/article/details/7931943

    protected View rootView;

    /**获取根布局的ID*/
    public abstract int getRootLayoutId();


    @Override
    public void onCreate(LayoutInflater inflater, ViewGroup group, Bundle saveInstanceBundle) {
        int rootLayoutId =  getRootLayoutId();
        rootView = inflater.inflate(rootLayoutId,group,false);
        ButterKnife.bind(this,rootView);  // 注解绑定
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void initWidget() {

    }

    @Override
    public int getOptionMenuId() {
        return 0;
    }

    @Override
    public Toolbar getToolbar() {
        return null;
    }



    public <T extends View> T bindView(int id) {
        T view = (T) mViews.get(id);
        if (view == null) {
            view = (T) rootView.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public <T extends View> T get(int id) {
        return (T) bindView(id);
    }

    /**遍历每一个View，使它满足点击事件*/
    public void setOnClickListener(View.OnClickListener listener, int... ids) {
        if (ids == null) {
            return;
        }
        for (int id : ids) {
            get(id).setOnClickListener(listener);
        }
    }

    public void showToast(String msg) {
        ToastUtils.showShort(msg);
    }
    public void showSnackbar(String msg) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_LONG).show();
    }

    public <T extends Activity> T getActivity() {
        return (T) rootView.getContext();
    }
}
