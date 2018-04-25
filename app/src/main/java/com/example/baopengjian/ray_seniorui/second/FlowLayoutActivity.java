package com.example.baopengjian.ray_seniorui.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2018/4/25 .
 * * RequireMent
    （1）创建一个标签容器（高度wrapcontent，宽度matchParent）
    （2）标签：能够显示标签文本，宽度大小不定，高度大小不定，每行顶部对齐，每列左对齐，可点击
 */

public class FlowLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_flowlayout_acitivity);
    }
}
