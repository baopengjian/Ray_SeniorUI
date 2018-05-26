package com.example.baopengjian.ray_seniorui.third.circle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;
import com.example.baopengjian.ray_seniorui.third.circle.CircleProgressBar;

/**
 * Created by Ray on 2018/5、25 .
 *  圆形进度
 * RequireMent
 */

public class SeniorUI03_CircleProgressActivity extends AppCompatActivity{

    private CircleProgressBar mProgressbar;

    private int progress = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_progress_activity);

        mProgressbar = (CircleProgressBar) findViewById(R.id.progressbar);

        mProgressbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progress <= 100){
                            progress += 2;
                            mProgressbar.setProgress(progress);

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
    }


}
