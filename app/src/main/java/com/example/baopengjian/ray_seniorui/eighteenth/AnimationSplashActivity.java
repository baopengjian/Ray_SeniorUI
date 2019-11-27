package com.example.baopengjian.ray_seniorui.eighteenth;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

/**
 * Created by Ray on 2019-11-27.
 */
public class AnimationSplashActivity extends AppCompatActivity {

    private FrameLayout mMainView;
    private SplashView splashView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainView = new FrameLayout(this);
        ContentView contentView = new ContentView(this);
        mMainView.addView(contentView);
        splashView = new SplashView(this);
        mMainView.addView(splashView);

        setContentView(mMainView);

        startLoadData();
    }

    Handler handler = new Handler();

    private void startLoadData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //数据加载完毕，进入主界面--->开启后面的两个动画
                splashView.splashDisappear();
            }
        }, 3000);//延迟时间
    }

}
