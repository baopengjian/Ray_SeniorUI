package com.example.baopengjian.ray_seniorui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.baopengjian.ray_seniorui.eighth.SeniorUI08_CanvasCaseActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.Senior05_LightBookActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.SeniorUI05_GuaGuaCardActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.SeniorUI05_HeartMapActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.SeniorUI05_InvertedImageActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.SeniorUI05_WaveViewActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.SeniorUi05_RoundImageActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.XfermodeActivity;
import com.example.baopengjian.ray_seniorui.first.SeniorUI01_DrawingProcessActivity;
import com.example.baopengjian.ray_seniorui.fourth.SeniorUI04_GradientActivity;
import com.example.baopengjian.ray_seniorui.fourth.SeniorUI04_LinearGradientActivity;
import com.example.baopengjian.ray_seniorui.fourth.SeniorUI04_RadarActivity;
import com.example.baopengjian.ray_seniorui.fourth.SeniorUI04_RippleActivity;
import com.example.baopengjian.ray_seniorui.fourth.SeniorUI04_ShaderZoomActivity;
import com.example.baopengjian.ray_seniorui.ninth.SeniorUI09_BezierActivity;
import com.example.baopengjian.ray_seniorui.second.SeniorUI02_FlowLayoutActivity;
import com.example.baopengjian.ray_seniorui.second.SeniorUI02_WaterFlowActivity;
import com.example.baopengjian.ray_seniorui.seventh.SeniorUI07_CanvasEmployActivity;
import com.example.baopengjian.ray_seniorui.sixth.activity.SeniorUI06_FilterActivity;
import com.example.baopengjian.ray_seniorui.third.basic.SeniorUI03_DashViewActivity;
import com.example.baopengjian.ray_seniorui.third.basic.SeniorUI03_PaintBasicActivity;
import com.example.baopengjian.ray_seniorui.third.circle.SeniorUI03_CircleProgressActivity;
import com.example.baopengjian.ray_seniorui.third.minion.SeniorUI03_MinionActivity;


public class MainActivity extends AppCompatActivity {

    static Class[] TARGETS = {SeniorUI01_DrawingProcessActivity.class,
            SeniorUI02_FlowLayoutActivity.class, SeniorUI02_WaterFlowActivity.class,
            SeniorUI03_PaintBasicActivity.class, SeniorUI03_CircleProgressActivity.class, SeniorUI03_DashViewActivity.class, SeniorUI03_MinionActivity.class,
            SeniorUI04_ShaderZoomActivity.class, SeniorUI04_LinearGradientActivity.class, SeniorUI04_GradientActivity.class, SeniorUI04_RadarActivity.class, SeniorUI04_RippleActivity.class, XfermodeActivity.class,
            SeniorUI05_InvertedImageActivity.class, SeniorUi05_RoundImageActivity.class, SeniorUI05_HeartMapActivity.class, SeniorUI05_GuaGuaCardActivity.class, SeniorUI05_WaveViewActivity.class,
            Senior05_LightBookActivity.class,
            SeniorUI06_FilterActivity.class,
            SeniorUI07_CanvasEmployActivity.class,
            SeniorUI08_CanvasCaseActivity.class,
            SeniorUI09_BezierActivity.class};
    static String[] TARGETS_DESC = {"01_UI绘制流程应用_底部弹出",
            "02_UI绘制流程应用_flowLayout", "02_UI绘制流程应用_WaterfallLayout",
            "03_Paint基本使用", "03_圆形进度_CircleProgressBar", "03_动态破折线", "03_小黄人",
            "04_BitmapShader:放大镜", "04_LinearGradient:霓虹灯文字", "04_环形渲染、梯度渲染、组合渲染", "04_雷达图", "04_水波纹效果",
            "05_Xfermode", "05_Xfermode倒影效果", "05_Xfermode圆角效果", "05_Xfermode心电图效果", "05_刮刮卡效果",
            "05_Xfermode波浪效果", "05_Xfermode书柜效果",
            "06_Filter滤镜效果",
            "07_canvas使用",
            "08_canvas实战",
            "09_贝塞尔曲线"};

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

    public void nonstop(View view) {
        startActivity(new Intent(MainActivity.this, TestActivity.class));
    }

}
