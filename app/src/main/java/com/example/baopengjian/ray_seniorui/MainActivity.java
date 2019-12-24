package com.example.baopengjian.ray_seniorui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.baopengjian.ray_seniorui.eighteenth.AnimationSplashActivity;
import com.example.baopengjian.ray_seniorui.eighth.SeniorUI08_CanvasCaseActivity;
import com.example.baopengjian.ray_seniorui.fifteenth.AnimationActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.Senior05_LightBookActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.SeniorUI05_GuaGuaCardActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.SeniorUI05_HeartMapActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.SeniorUI05_InvertedImageActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.SeniorUI05_WaveViewActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.SeniorUi05_RoundImageActivity;
import com.example.baopengjian.ray_seniorui.fifth.activity.XfermodeActivity;
import com.example.baopengjian.ray_seniorui.first.SeniorUI01_DrawingProcessActivity;
import com.example.baopengjian.ray_seniorui.fourteenth.ListViewConvertActivity;
import com.example.baopengjian.ray_seniorui.fourth.SeniorUI04_GradientActivity;
import com.example.baopengjian.ray_seniorui.fourth.SeniorUI04_LinearGradientActivity;
import com.example.baopengjian.ray_seniorui.fourth.SeniorUI04_RadarActivity;
import com.example.baopengjian.ray_seniorui.fourth.SeniorUI04_RippleActivity;
import com.example.baopengjian.ray_seniorui.fourth.SeniorUI04_ShaderZoomActivity;
import com.example.baopengjian.ray_seniorui.nineteenth.AnimationFrameworkActivity;
import com.example.baopengjian.ray_seniorui.ninth.SeniorUI09_BezierActivity;
import com.example.baopengjian.ray_seniorui.second.SeniorUI02_FlowLayoutActivity;
import com.example.baopengjian.ray_seniorui.second.SeniorUI02_WaterFlowActivity;
import com.example.baopengjian.ray_seniorui.seventeenth.SeniorUI07_CanvasEmployActivity;
import com.example.baopengjian.ray_seniorui.sixth.activity.SeniorUI06_FilterActivity;
import com.example.baopengjian.ray_seniorui.tenth.SeniorUI10_PathMeasureActivity;
import com.example.baopengjian.ray_seniorui.third.basic.SeniorUI03_DashViewActivity;
import com.example.baopengjian.ray_seniorui.third.basic.SeniorUI03_PaintBasicActivity;
import com.example.baopengjian.ray_seniorui.third.circle.SeniorUI03_CircleProgressActivity;
import com.example.baopengjian.ray_seniorui.third.minion.SeniorUI03_MinionActivity;
import com.example.baopengjian.ray_seniorui.thirtieth.AppbarLayoutActivity;
import com.example.baopengjian.ray_seniorui.thirtieth.FloatingActionButtonActivity;
import com.example.baopengjian.ray_seniorui.thirty_first.CoordinatorLayoutActivity;
import com.example.baopengjian.ray_seniorui.twelfth.SeniorUI12SvgActivity;
import com.example.baopengjian.ray_seniorui.twentieth.ViewPagerTransformActivity;
import com.example.baopengjian.ray_seniorui.twenty_eighth.TabLayoutActivity;
import com.example.baopengjian.ray_seniorui.twenty_eighth.bank.BankCardActivity;
import com.example.baopengjian.ray_seniorui.twenty_fifth.DrawerLayoutActivity;
import com.example.baopengjian.ray_seniorui.twenty_fourth.RecyclerViewSwipeCardActivity;
import com.example.baopengjian.ray_seniorui.twenty_ninth.StatusBarActivity;
import com.example.baopengjian.ray_seniorui.twenty_second.RecyclerViewActivity;
import com.example.baopengjian.ray_seniorui.twenty_seventh.NavigationActivity;
import com.example.baopengjian.ray_seniorui.twenty_seventh.ToolBarActivity;
import com.example.baopengjian.ray_seniorui.twenty_sixth.SnackeBarActivity;
import com.example.baopengjian.ray_seniorui.twenty_third.ItemTouchHelperActivity;
import com.example.baopengjian.ray_seniorui.twenty_third.extension.ItemTouchExtensionActivity;


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
            SeniorUI09_BezierActivity.class,
            SeniorUI10_PathMeasureActivity.class,
            SeniorUI12SvgActivity.class,
            ListViewConvertActivity.class,
            AnimationActivity.class,
            AnimationSplashActivity.class,
            AnimationFrameworkActivity.class,
            ViewPagerTransformActivity.class,
            RecyclerViewActivity.class,
            ItemTouchHelperActivity.class,
            ItemTouchExtensionActivity.class,
            RecyclerViewSwipeCardActivity.class,
            DrawerLayoutActivity.class,
            SnackeBarActivity.class,
            NavigationActivity.class,
            ToolBarActivity.class,
            TabLayoutActivity.class,
            BankCardActivity.class,
            StatusBarActivity.class,
            FloatingActionButtonActivity.class,
            AppbarLayoutActivity.class,
            CoordinatorLayoutActivity.class};
    static String[] TARGETS_DESC = {"01_UI绘制流程应用_底部弹出",
            "02_UI绘制流程应用_flowLayout", "02_UI绘制流程应用_WaterfallLayout",
            "03_Paint基本使用", "03_圆形进度_CircleProgressBar", "03_动态破折线", "03_小黄人",
            "04_BitmapShader:放大镜", "04_LinearGradient:霓虹灯文字", "04_环形渲染、梯度渲染、组合渲染", "04_雷达图", "04_水波纹效果",
            "05_Xfermode", "05_Xfermode倒影效果", "05_Xfermode圆角效果", "05_Xfermode心电图效果", "05_刮刮卡效果",
            "05_Xfermode波浪效果", "05_Xfermode书柜效果",
            "06_Filter滤镜效果",
            "07_canvas使用",
            "08_canvas实战",
            "09_贝塞尔曲线",
            "10_PathMeasure",
            "12_可触碰式中国地图",
            "14_ListView复用思想",
            "15_属性动画",
            "18_加载动画：多圆旋转聚合逃逸效果",
            "19_自定义动画框架",
            "20_viewPager翻转效果",
            "22_RecyclerView常用封装、修复RecyclerView嵌套滚动问题及优化",
            "23_ItemTouchHelper",
            "23_ItemTouchHelper拓展item可定义移除背景",
            "24_RecyclerViewSwipeCard陌陌滑动移除效果",
            "SeniorUI25_自定义DrawerLayout设置背景和item动画效果",
            "SeniorUI26_Snackbar使用及其源码分析",
            "SeniorUI27_NavigationView",
            "SeniorUI27_ToolBar",
            "SeniorUI28_TabLayout",
            "SeniorUI28_Palatte应用",
            "SeniorUI29_沉浸式状态栏",
            "SeniorUI30_floatingbuttom",
            "SeniorUI30_AppbarLayout",
            "SeniorUI31_手写CoordinatorLayout和Behavior"};

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
        startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity.class));
    }

}
