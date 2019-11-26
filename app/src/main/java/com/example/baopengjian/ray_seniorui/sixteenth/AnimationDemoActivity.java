package com.example.baopengjian.ray_seniorui.sixteenth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;
import com.example.baopengjian.ray_seniorui.sixteenth.gift.GiftActivity;
import com.example.baopengjian.ray_seniorui.sixteenth.taobao.TaoBaoActivity;

/**
 * Created by Ray on 2019-11-26.
 */
public class AnimationDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity_demo);
    }

    public void gift(View v) {
        startActivity(new Intent(AnimationDemoActivity.this,GiftActivity.class));
    }

    public void taobo(View v) {
        startActivity(new Intent(AnimationDemoActivity.this,TaoBaoActivity.class));
    }
}
