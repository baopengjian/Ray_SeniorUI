package com.example.baopengjian.ray_seniorui.tenth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ray on 2019/1/25.
 */
public class WaveViewActivity extends AppCompatActivity {

    private WaveView mWaveView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWaveView = new WaveView(this);
        setContentView(mWaveView);
        mWaveView.startAnimation();
    }
}
