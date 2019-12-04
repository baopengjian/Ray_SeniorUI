package com.example.baopengjian.ray_seniorui.twenty_second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-4.
 */
public class RecyclerCacheActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_cache_activity);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new PageAdapter(getSupportFragmentManager()));
    }
}
