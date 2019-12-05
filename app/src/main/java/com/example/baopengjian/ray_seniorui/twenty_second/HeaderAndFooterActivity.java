package com.example.baopengjian.ray_seniorui.twenty_second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-5.
 */
public class HeaderAndFooterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header_activity);
        RecyclerView rv_normal = findViewById(R.id.rv_normal);
        rv_normal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecyclerView.Adapter adapter = new DemoAdapter();
        HeaderAndFooterWrapper wrapper = new HeaderAndFooterWrapper(adapter);

        TextView tv = new TextView(this);
        tv.setText("header");

        TextView footer = new TextView(this);
        footer.setText("footer");

        wrapper.addHeaderView(tv);
        wrapper.addFootView(footer);

        rv_normal.setAdapter(wrapper);


    }

}
