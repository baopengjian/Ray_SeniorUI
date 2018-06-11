package com.example.baopengjian.ray_seniorui.fourth;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 环形渲染
 */

public class SweepGradientView extends View {
    private Paint mPaint;

    private int[] mColors = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};

    public SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        SweepGradient mSweepGradient = new SweepGradient(300, 300, mColors, null);
        mPaint.setShader(mSweepGradient);
        canvas.drawCircle(350, 350, 300, mPaint);

    }
}
