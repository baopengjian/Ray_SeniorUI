package com.example.baopengjian.ray_seniorui.tenth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019/1/25.
 */
public class SeniorUI10_PathMeasureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senior10_pathmeasure_activity);
    }

    public void basic(View v){
        startActivity(new Intent(SeniorUI10_PathMeasureActivity.this,PathMeasureBasicActivity.class));
    }

    public void loadingView(View v){

    }

    public void waveView(View v){

    }
}
