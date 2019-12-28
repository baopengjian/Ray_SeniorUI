package com.example.baopengjian.ray_seniorui.thirtieth_fourth;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-28.
 */
public class JboxActivity extends FragmentActivity implements SensorEventListener {


    private SensorManager sensorManager;
    private Sensor defaultSensor;
    private CollisionView collisionView;

    private int[] imgs = {
            R.drawable.share_fb,
            R.drawable.share_kongjian,
            R.drawable.share_pyq,
            R.drawable.share_qq,
            R.drawable.share_tw,
            R.drawable.share_wechat,
            R.drawable.share_weibo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jbox_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, defaultSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }


    @Override
    public void onContentChanged() {
        collisionView = (CollisionView) findViewById(R.id.jbox_view);
        initView();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        defaultSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    private void initView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        for (int i = 0; i < imgs.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imgs[i]);
            imageView.setTag(R.id.dn_view_circle_tag, true);
            collisionView.addView(imageView,layoutParams);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1] * 2.0f;
            collisionView.onSensorChanged(-x, y);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
