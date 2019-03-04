package com.example.baopengjian.ray_seniorui.tenth;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.baopengjian.ray_seniorui.R;

/**
 */

public class WaveView extends View {

    private static final int INT_WAVE_LENGTH = 1000;
    private static final String TAG = "WaveView";

    private Path mPath;
    private Paint mPaint;

    private int mDeltaX;
    private Bitmap mBitMap;
    private PathMeasure mPathMeasure;
    private float[] pos;
    private float[] tan;
    private Matrix mMatrix;
    private float faction;

    public WaveView(Context context) {
        super(context);
        init();
        
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        mPath = new Path();
        pos = new float[2];
        tan = new float[2];
        mMatrix = new Matrix();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize =  2;
        mBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.timg,options);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        int orginY = 800;
        int halfWaveLength = INT_WAVE_LENGTH / 2;
        mPath.moveTo(-INT_WAVE_LENGTH + mDeltaX, orginY);
        for(int i = -INT_WAVE_LENGTH ; i < getWidth() + INT_WAVE_LENGTH;
            i += INT_WAVE_LENGTH){
            mPath.rQuadTo(halfWaveLength/2,60,halfWaveLength,0);
            mPath.rQuadTo(halfWaveLength/2,-60,halfWaveLength,0);
        }
        mPath.lineTo(getWidth(),getHeight());
        mPath.lineTo(0,getHeight());
        mPath.close();



        canvas.drawPath(mPath,mPaint);

        mPathMeasure = new PathMeasure(mPath,false);
        float length = mPathMeasure.getLength();
        mMatrix.reset();
        boolean posTan = mPathMeasure.getPosTan(length*faction,pos,tan);
        Log.d(TAG,"pos[0] = " + pos[0] + "pos[1] = " +pos[1]);
        Log.d(TAG,"tan[0] = " + tan[0] + "tan[1] = " +tan[1]);
        if(posTan){
            // 方案一 ：自己计算
            // 将tan值通过反正切函数得到对应的弧度，在转化成对应的角度度数
            /*float degrees = (float) (Math.atan2(tan[1],tan[0])*180f / Math.PI);
            mMatrix.postRotate(degrees, mBitMap.getWidth()/2, mBitMap.getHeight() / 2);
            mMatrix.postTranslate(pos[0]- mBitMap.getWidth() / 2,pos[1] - mBitMap.getHeight());
            canvas.drawBitmap(mBitMap,mMatrix,mPaint);*/

            // 方案一 ：直接使用API
            mPathMeasure.getMatrix(length*faction, mMatrix, PathMeasure.TANGENT_MATRIX_FLAG | PathMeasure.POSITION_MATRIX_FLAG);
            mMatrix.preTranslate(- mBitMap.getWidth() / 2, - mBitMap.getHeight());
            canvas.drawBitmap(mBitMap,mMatrix,mPaint);
        }

        //

    }

    public void startAnimation(){
        /*ValueAnimator animator = ValueAnimator.ofInt(0,INT_WAVE_LENGTH);
        animator.setDuration(1000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDeltaX = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();*/

        ValueAnimator animator = ValueAnimator.ofFloat(0,1);
        animator.setDuration(25000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                faction  = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

}
