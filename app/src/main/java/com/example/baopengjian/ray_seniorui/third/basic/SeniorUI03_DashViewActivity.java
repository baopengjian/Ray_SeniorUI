package com.example.baopengjian.ray_seniorui.third.basic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2018/5/28.
 */

public class SeniorUI03_DashViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senior03_dash_view);


        MyDashView mv = findViewById(R.id.mv);
        mv.startAnim();
    }
}
