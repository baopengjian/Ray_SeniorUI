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
import com.example.baopengjian.ray_seniorui.second.FlowLayoutActivity;
import com.example.baopengjian.ray_seniorui.second.WaterFlowActivity;


public class MainActivity extends AppCompatActivity {

    static Class[] TARGETS = {SeniorUI01_DrawingProcessActivity.class, FlowLayoutActivity.class, WaterFlowActivity.class};
    static String[] TARGETS_DESC = {"01_UI绘制流程应用_底部弹出","02_UI绘制流程应用_flowLayout","02_UI绘制流程应用_WaterfallLayout"};

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
