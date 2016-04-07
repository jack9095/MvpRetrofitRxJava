package com.example.wangfei.mvpretrofitrxjava.callback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

/**
 * 参考：kymjs (http://www.kymjs.com/)
 * Describe：视图层代理的接口协议  （View delegate base class）
 * @author  fei.wang on 4/3/16.
 */
public interface IDelegate {

    /**创建布局*/
    void onCreate(LayoutInflater inflater, ViewGroup group, Bundle saveInstanceBundle);

    /**获取根V*/
    View getRootView();

    /**获取工具*/
    void initWidget();

    /**获取选项菜单ID*/
    int getOptionMenuId();

    /**获取标题栏*/
    Toolbar getToolbar();
}
