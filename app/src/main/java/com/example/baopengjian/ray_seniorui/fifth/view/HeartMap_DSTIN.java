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
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by John on 2017/5/10.
 */
public class HeartMap_DSTIN extends View {

    private Paint mPaint;
    private int mItemWaveLength = 0;
    private int dx=0;

    private Bitmap BmpSRC,BmpDST;
    public HeartMap_DSTIN(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setColor(Color.RED);

        BmpDST = BitmapFactory.decodeResource(getResources(), R.drawable.heartmap,null);
        BmpSRC = Bitmap.createBitmap(BmpDST.getWidth(), BmpDST.getHeight(), Bitmap.Config.ARGB_8888);

        mItemWaveLength = BmpDST.getWidth();
        startAnim();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Canvas c = new Canvas(BmpSRC);
        //清空bitmap
        c.drawColor(Color.RED, PorterDuff.Mode.CLEAR);
        //画上矩形
        c.drawRect(BmpDST.getWidth() - dx,0,BmpDST.getWidth(),BmpDST.getHeight(),mPaint);

        //模式合成
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(BmpDST,0,0,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(BmpSRC,0,0,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }


    public void startAnim(){
        ValueAnimator animator = ValueAnimator.ofInt(0,mItemWaveLength);
        animator.setDuration(6000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int)animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}
