package com.example.wangfei.mvpretrofitrxjava.app;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.example.wangfei.mvpretrofitrxjava.utils.CrashHandler;
import com.example.wangfei.mvpretrofitrxjava.utils.ToastUtils;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

/**
 * <Pre>
 *     MvpApplication  注意onCreate这里不能写太多东西，不然会造成启动延时或很慢的问题
 * </Pre>
 *
 * @author fei.wang
 * @version 1.0
 *          <p/>
 *          Create by 2016/3/21 11:49
 */
public class MvpApplication extends Application {

    private MvpApplication instance;
    public static String cacheDir = "";

    /**注意onCreate这里不能写太多东西，不然会造成启动延时或很慢的问题*/
    @Override
    public void onCreate() {
        super.onCreate();
        instance = (MvpApplication) getApplicationContext();

        Logger.init().logLevel(LogLevel.FULL); // 初始化日志，并设置日志的级别全部日志

        ToastUtils.register(this);  // 初始化Toast

        this.enabledStrictMode();  // 初始化检查程序中违例的工具，上线的时候不能用

        //LeakCanary检测OOM
        LeakCanary.install(this);

        //初始化日志输出工具
        CrashHandler.init(new CrashHandler(getApplicationContext()));

        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null && isExistSDCard()) {
            cacheDir = getApplicationContext().getExternalCacheDir().toString();
        }
        else {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }
    }

    /**对外提供全局上下文*/
    public Context getContext(){
        return instance;
    }

    /**判断SD卡是否存在*/
    private boolean isExistSDCard() {
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * StrictMode意思为严格模式，是用来检测程序中违例情况的开发者工具。最常用的场景就是检测主线程中本地磁盘和网络读写等耗时的操作
     * 严格模式需要在debug模式开启，不要在release（上线）版本中启用。
     * 使用严格模式，只需要过滤日志就能发现内存泄露
     */
    private void enabledStrictMode() {
        if (SDK_INT >= GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll()  //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
    }
}
