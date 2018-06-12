package com.example.baopengjian.ray_seniorui.fourth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;
import com.example.baopengjian.ray_seniorui.fourth.view.RadarView;

/**
 * Created by Ray on 2018/6/12.
 * 雷达图
 */
public class SeniorUI04_RadarActivity extends AppCompatActivity {

    private RadarView mRadarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radar_activity);

        mRadarView = (RadarView) findViewById(R.id.radarview);
    }


    public void start(View view){
        mRadarView.startScan();
    }

    public void stop(View view){
        mRadarView.stopScan();
    }
}
