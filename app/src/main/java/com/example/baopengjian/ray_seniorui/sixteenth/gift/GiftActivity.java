package com.example.baopengjian.ray_seniorui.sixteenth.gift;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-11-26.
 * 视屏直播送礼物爱心效果
 */
public class GiftActivity extends AppCompatActivity {

    private LoveLayout loveLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gift_activity);

        loveLayout = (LoveLayout)findViewById(R.id.loveLayout);
    }

    public void start(View v){
        loveLayout.addLoveIcon();
    }
}
