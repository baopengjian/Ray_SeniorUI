package com.example.baopengjian.ray_seniorui.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ray on 2018/4/20 .
 * RequireMent
 （1）底部弹出操作框
 （2）屏幕非操作框区域事件仍响应
 （3）显示动画：整体逐渐向上，顶部有曲线波动效果
 *
 *
 */

public class SeniorUI01_DrawingProcessActivity extends AppCompatActivity {

    private BouncingMenu bouncingMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawing_process_activity);
    }


    public void click(View v){

        if(bouncingMenu!=null){
            bouncingMenu.dismiss();
            bouncingMenu=null;
        }else{
            //弹出菜单
            //			Toast.makeText(this, "dddd", 1).show();
            List<String> list= new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                list.add("item:"+i);
            }
            MyRecyclerAdapter adapter = new MyRecyclerAdapter(list);
            //非倾入性代码封装！----低耦合动画框架
            bouncingMenu= BouncingMenu.makeMenu(getWindow().getDecorView(), R.layout.layout_rv_sweet,adapter).show();
        }
    }
}
