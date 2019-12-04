package com.example.baopengjian.ray_seniorui.twenty_second;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-4.
 * RecyclerView常用封装、修复RecyclerView嵌套滚动问题及优化
 */
public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);
    }

    public void issue(View v){
        startActivity(new Intent(RecyclerViewActivity.this,RecyclerIssueActivity.class));
    }

    public void cache(View v){
        startActivity(new Intent(RecyclerViewActivity.this,RecyclerCacheActivity.class));
    }
}
