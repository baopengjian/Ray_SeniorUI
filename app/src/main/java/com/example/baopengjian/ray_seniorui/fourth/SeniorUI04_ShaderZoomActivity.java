package com.example.baopengjian.ray_seniorui.fourth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.baopengjian.ray_seniorui.R;


public class SeniorUI04_ShaderZoomActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ZoomImageView view = new ZoomImageView(this);
        setContentView(view);
    }


}
