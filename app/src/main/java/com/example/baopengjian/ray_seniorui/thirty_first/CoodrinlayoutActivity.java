package com.example.baopengjian.ray_seniorui.thirty_first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-23.
 */
public class CoodrinlayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coodrinlayout_acitivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("动脑学院");
        setSupportActionBar(toolbar);
    }
}
