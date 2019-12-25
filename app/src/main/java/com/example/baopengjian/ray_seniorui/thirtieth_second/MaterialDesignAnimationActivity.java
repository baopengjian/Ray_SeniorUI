package com.example.baopengjian.ray_seniorui.thirtieth_second;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-25.
 */
public class MaterialDesignAnimationActivity extends AppCompatActivity {

    View imageView;
    View imageView2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.meterial_design_animation_activity);

        imageView = (ImageView) findViewById(R.id.img);
        imageView2 = (ImageView) findViewById(R.id.img2);

    }

    public void click(View view) {
        //  oneViewAnimation();
        multipleViewAnimation();
    }


    private void oneViewAnimation() {
        ActivityOptionsCompat comapt = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, getString(R.string.app_name));
        ActivityCompat.startActivity(this, new Intent(this, SecondActivity.class), comapt.toBundle());
    }

    private void multipleViewAnimation() {
        Pair<View, String> img1 = Pair.create(imageView, getString(R.string.app_name));
        Pair<View, String> img2 = Pair.create(imageView2, getString(R.string.app));
        ActivityOptionsCompat comapt = ActivityOptionsCompat.makeSceneTransitionAnimation(this, img1, img2);
        //跳转
        ActivityCompat.startActivity(this, new Intent(this, SecondActivity.class), comapt.toBundle());
    }


}
