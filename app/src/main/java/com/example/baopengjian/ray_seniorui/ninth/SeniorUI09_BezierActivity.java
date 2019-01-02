package com.example.baopengjian.ray_seniorui.ninth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019/1/2.
 * 贝塞尔曲线
 */
public class SeniorUI09_BezierActivity extends AppCompatActivity {

    private DragBubbleView mDragBubbleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seniorui09_bezier_activity);

        mDragBubbleView = (DragBubbleView) findViewById(R.id.drag_buddle_view);
        findViewById(R.id.reset_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDragBubbleView.reset();
            }
        });
    }


}
