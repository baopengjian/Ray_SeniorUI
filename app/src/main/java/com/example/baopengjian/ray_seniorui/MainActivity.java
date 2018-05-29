package com.example.baopengjian.ray_seniorui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.baopengjian.ray_seniorui.first.SeniorUI01_DrawingProcessActivity;
import com.example.baopengjian.ray_seniorui.second.SeniorUI02_FlowLayoutActivity;
import com.example.baopengjian.ray_seniorui.second.SeniorUI02_WaterFlowActivity;
import com.example.baopengjian.ray_seniorui.third.basic.SeniorUI03_DashViewActivity;
import com.example.baopengjian.ray_seniorui.third.basic.SeniorUI03_PaintBasicActivity;
import com.example.baopengjian.ray_seniorui.third.circle.SeniorUI03_CircleProgressActivity;
import com.example.baopengjian.ray_seniorui.third.minion.SeniorUI03_MinionActivity;


public class MainActivity extends AppCompatActivity {

    static Class[] TARGETS = {SeniorUI01_DrawingProcessActivity.class,
            SeniorUI02_FlowLayoutActivity.class, SeniorUI02_WaterFlowActivity.class,
            SeniorUI03_PaintBasicActivity.class,SeniorUI03_CircleProgressActivity.class, SeniorUI03_DashViewActivity.class, SeniorUI03_MinionActivity.class};
    static String[] TARGETS_DESC = {"01_UI绘制流程应用_底部弹出",
            "02_UI绘制流程应用_flowLayout", "02_UI绘制流程应用_WaterfallLayout",
            "03_Paint基本使用","03_圆形进度_CircleProgressBar","03_动态破折线","03_小黄人"};

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, TARGETS_DESC));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(context, TARGETS[position]));
            }
        });
    }


}
