package com.example.baopengjian.ray_seniorui.third.basic;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2018/5/26.
 * Paint画路径常见用法
 */

public class SeniorUI03_PaintBasicActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paint_basic_activity);

        lv = findViewById(R.id.lv);
        lv.setAdapter(new PointAdapter(this));
    }

    class PointAdapter extends BaseAdapter{

       private Context context;
        final String[] TITLES = {"StrokeCap示例:笔帽","stokeJoin示例：线段连接处样式","Path：CornerPathEffect示例圆形拐角","Path：CornerPathEffect原始path与圆角处理path",
        "Path：DashPathEffect虚线效果","path:DiscretePathEffect离散效果","PathDashPathEffect:延着路径盖章","DashPathEffectDemo:MORPH、ROTATE、TRANSLATE","原始、圆角、虚线、ComposePathEffect（圆角+虚线）、SumPathEffect（圆角+虚线）","drawSubpixelText:亚像素-"};


        PointAdapter(Context context){
            super();
            this.context = context;
        }


        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(context,R.layout.paint_basic_adapter,null);
            TextView tv_desc = (TextView) view.findViewById(R.id.tv_desc);
            tv_desc.setText(TITLES[position]);
            MyView mv = (MyView)view.findViewById(R.id.mv);
            mv.setEffect(position);
            return view;
        }
    }

}
