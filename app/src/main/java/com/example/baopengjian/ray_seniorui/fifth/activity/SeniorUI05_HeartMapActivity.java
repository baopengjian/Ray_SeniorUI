package com.example.baopengjian.ray_seniorui.fifth.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.baopengjian.ray_seniorui.fifth.view.HeartMapView;

/**
 * Created by Ray on 2018/6/22.
 * 心电图
 */
public class SeniorUI05_HeartMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HeartMapView view = new HeartMapView(this);
        setContentView(view);
    }
}
