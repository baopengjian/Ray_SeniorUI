package com.example.baopengjian.ray_seniorui.twenty_ninth;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-19.
 */
public class StatusBarActivity extends BaseActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_bar_activity);

        String title = "标题：";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            title +="5.0以上";
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            title +="5.0以下，4.4以上";
        }else{
            title +="4.4以下";
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);

        View nav = findViewById(R.id.nav);
        setToolBarStyle(toolbar,nav, Color.GREEN);
    }
}
