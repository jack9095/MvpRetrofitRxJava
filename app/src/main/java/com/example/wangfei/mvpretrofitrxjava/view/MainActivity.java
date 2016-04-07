package com.example.wangfei.mvpretrofitrxjava.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.wangfei.mvpretrofitrxjava.R;
import com.example.wangfei.mvpretrofitrxjava.base.BasePresenter;
import com.example.wangfei.mvpretrofitrxjava.delegate.MainActivityDelegate;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

/**
 * @author fei.wang
 * Describe：演示ToolBar的使用
 * 参考：http://www.kymjs.com/
 * Date：2016年4月6日
 */
public class MainActivity extends BasePresenter<MainActivityDelegate> implements Toolbar.OnMenuItemClickListener {

    private String mPic = "";
    private String mTitle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();
        setSupportActionBar(viewDelegate.getToolbar());
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);   // 设置为true标题左上角会有箭头，false箭头隐藏
        getSupportActionBar().setDisplayShowTitleEnabled(false);  // false表示默认的标题（类名）不显示
        viewDelegate.getToolbar().setNavigationOnClickListener(new View.OnClickListener() {  // 设置标题左上角箭头的点击方法
            @Override
            public void onClick(View v) {
//                onBackPressed();  // 销毁本类（Activity）
            }
        });

        viewDelegate.getToolbar().setTitle("主标题");
        viewDelegate.getToolbar().setSubtitle("副标题");
        viewDelegate.getToolbar().setLogo(R.mipmap.ic_launcher);  // logo图标
        viewDelegate.getToolbar().setNavigationIcon(android.R.drawable.ic_input_delete);  // 导航按钮  也就是最左边的箭头按钮
        viewDelegate.getToolbar().setOnMenuItemClickListener(this);  // 菜单点击事件

        viewDelegate.setCollapsingToolbarLayoutTitle(mTitle);
        viewDelegate.setImageWithURL(mPic);
//        viewDelegate.loadNewsDetail(mUrl);
    }

    @Override
    protected void initData() {
        super.initData();
        mPic = R.mipmap.ic_error + "";
        mTitle = "大家好";
    }

    @Override
    protected Class<MainActivityDelegate> getDelegateClass() {
        return MainActivityDelegate.class;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "关于", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "分享按钮", Toast.LENGTH_SHORT).show();
                break;
        }

        return false;
    }
}
