package com.example.baopengjian.ray_seniorui.thirtieth;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.baopengjian.ray_seniorui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 2019-12-20.
 */
public class FloatingActionButtonActivity extends AppCompatActivity {


    Toolbar mToolbar;

   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floating_action_button_activity);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclverView);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setTitle("网易新闻");
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("item"+i);
        }

       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setAdapter(new MyRecyclerAdapter(list));
    }


}
