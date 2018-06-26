package com.example.baopengjian.ray_seniorui.fifth.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by John on 2017/5/12.
 */

public class HeartMapView extends View {

    private Paint mBitMapPaint;


    private Bitmap mBitMapSRC, mBitMapDST;

    private int dx;

    public HeartMapView(Context context) {
        super(context);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mBitMapPaint = new Paint();
        mBitMapPaint.setColor(Color.RED);

        mBitMapDST =BitmapFactory.decodeResource(getResources(), R.drawable.heartmap);
        mBitMapSRC = Bitmap.createBitmap(mBitMapDST.getWidth(),mBitMapDST.getHeight(), Bitmap.Config.ARGB_8888);

        startAnimation();

    }

    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, mBitMapDST.getWidth());
        animator.setDuration(6000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 清空src bitmap的内容，变成透明的
        Canvas c = new Canvas(mBitMapSRC);
        c.drawColor(Color.RED, PorterDuff.Mode.CLEAR);

        // 画不透明的矩形区域
        c.drawRect(mBitMapDST.getWidth() - dx, 0 , mBitMapDST.getWidth(),mBitMapDST.getHeight(),mBitMapPaint);

        // 画目标图片
        canvas.drawBitmap(mBitMapDST, 0 ,0 , mBitMapPaint);
        mBitMapPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(mBitMapSRC,0,0,mBitMapPaint);
        mBitMapPaint.setXfermode(null);
    }
}
