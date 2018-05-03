package com.example.baopengjian.ray_seniorui.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.baopengjian.ray_seniorui.R;

import java.util.Random;

/**
 * Created by Ray on 2018/5/3 .
 * 瀑布流
 * RequireMent
 （1）瀑布流添加标签，图片或其他View均可；
 （2）宽度相等，高度不定；
 （3）每次添加元素加到最低高度的列上；
 */

public class WaterFlowActivity extends AppCompatActivity{

    private static int IMG_COUNT = 5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_flow);

        final WaterfallLayout waterfallLayout = ((WaterfallLayout)findViewById(R.id.waterfallLayout));
        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addView(waterfallLayout);
            }
        });
    }

    public void addView(WaterfallLayout waterfallLayout) {


        Random random = new Random();
        Integer num = Math.abs(random.nextInt());
        WaterfallLayout.LayoutParams layoutParams = new WaterfallLayout.LayoutParams(
                WaterfallLayout.LayoutParams.MATCH_PARENT,
                WaterfallLayout.LayoutParams.MATCH_PARENT);

        ImageView imageView = new ImageView(this);
        if (num % IMG_COUNT == 0) {
            imageView.setImageResource(R.drawable.second_pic_1);
        } else if (num % IMG_COUNT == 1) {
            imageView.setImageResource(R.drawable.second_pic_2);
        } else if (num % IMG_COUNT == 2) {
            imageView.setImageResource(R.drawable.second_pic_3);
        } else if (num % IMG_COUNT == 3) {
            imageView.setImageResource(R.drawable.second_pic_4);
        } else if (num % IMG_COUNT == 4) {
            imageView.setImageResource(R.drawable.second_pic_5);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        waterfallLayout.addView(imageView, layoutParams);

        waterfallLayout.setOnItemClickListener(
                new WaterfallLayout.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int index) {
                        Toast.makeText(WaterFlowActivity.this, "item=" + index, Toast.LENGTH_SHORT).show();
                    }
        });
    }
}
