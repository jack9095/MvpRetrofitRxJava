package com.example.wangfei.mvpretrofitrxjava.base;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.wangfei.mvpretrofitrxjava.callback.IDelegate;
import com.example.wangfei.mvpretrofitrxjava.view.MySwipeBackActivity;
import com.rey.material.widget.SnackBar;

/**
 * @author fei.wang
 * Describe：Presenter层的实现基类
 * 参考：http://www.kymjs.com/
 * Date：2016年4月6日
 */
public abstract class BasePresenter<T extends IDelegate> extends AppCompatActivity {

    /**获取代理类的实例*/
    protected T viewDelegate;

    public BasePresenter() {
        try {
            viewDelegate = getDelegateClass().newInstance();  // 获取代理类的实例
        } catch (InstantiationException e) {
            throw new RuntimeException("create IDelegate error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create IDelegate error");
        }
    }

    /**获取代理类的实例*/
    protected abstract Class<T> getDelegateClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDelegate.onCreate(getLayoutInflater(), null, savedInstanceState);
        setContentView(viewDelegate.getRootView());
        initToolbar();
        viewDelegate.initWidget();
        bindEvenListener();
        initData();
        initView();
    }

    protected void initToolbar(){
        Toolbar toolbar = viewDelegate.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    /**初始化控件*/
    protected void initView() {

    }

    /**初始化数据*/
    protected void initData() {

    }

    /**绑定事件的监听*/
    protected void bindEvenListener() {

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (viewDelegate == null) {
            try {
                viewDelegate = getDelegateClass().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("create IDelegate error");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("create IDelegate error");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (viewDelegate.getOptionMenuId() != 0) {
            getMenuInflater().inflate(viewDelegate.getOptionMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewDelegate = null;
    }

    public void showSnackBar(String message){
        SnackBar.make(this).actionText(message).duration(Snackbar.LENGTH_SHORT).show();
    }

}
