package com.example.baopengjian.ray_seniorui.tenth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019/1/25.
 */
public class LoadingViewActivity extends AppCompatActivity {

    private float progress = 0f;
    private LoadingView mLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senior10_pathmeasure_loading_activity);
        mLoadingView = (LoadingView) findViewById(R.id.loadingview);
        mLoadingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progress <= 100) {
                            progress += 2;
                            mLoadingView.setProgress(progress / 100);

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();

            }
        });
        //setContentView(new LoadingView(this));
        //  setContentView(new LoadingView1(this));
    }
}
