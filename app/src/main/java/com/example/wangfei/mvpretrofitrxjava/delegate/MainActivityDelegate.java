package com.example.wangfei.mvpretrofitrxjava.delegate;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.wangfei.mvpretrofitrxjava.R;
import com.example.wangfei.mvpretrofitrxjava.base.AppDelegate;
import com.example.wangfei.mvpretrofitrxjava.utils.GlideUtil;
import com.rey.material.widget.ProgressView;

import butterknife.Bind;

/**
 * @author fei.wang
 *         Describe：主页面视图代理
 */
public class MainActivityDelegate extends AppDelegate {


    @Bind(R.id.iv_detail)
    ImageView mImageView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @Bind(R.id.progress)
    ProgressView progress;
    @Bind(R.id.textview1)
    TextView textview1;
    @Bind(R.id.button1)
    Button button1;
//    @Bind(R.id.title_text)
//    TextView title;

    /**获取页面的布局渲染*/
    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {
        super.initWidget();
    }

    @Override
    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setCollapsingToolbarLayoutTitle(String str) {
//        mCollapsingToolbarLayout.setCollapsedTitleGravity(TextView.TEXT_ALIGNMENT_GRAVITY); // 标题文字居中显示
//        mCollapsingToolbarLayout.setTitle(str); // 设置标题
//        title.setText(str);  // 自定义布局中的标题可以居中
    }

    public void setImageWithURL(String url) {
        GlideUtil.loadImage(getActivity(), url, mImageView);
    }
}