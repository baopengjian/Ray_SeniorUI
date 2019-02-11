package com.example.baopengjian.ray_seniorui.tenth;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by John on 2017/5/24.
 */

public class LoadingView extends View {
    /**
     * 左眼距离左边的距离（控件宽度＊EYE_PERCENT_W），
     * 右眼距离右边的距离（控件宽度＊EYE_PERCENT_W）
     */
    private static final float EYE_PERCENT_W = 0.35F;
    /**
     *眼睛距离top的距离（控件的高度＊EYE_PERCENT_H）
     */
    private static final float EYE_PERCENT_H = 0.38F;
    /**
     * 嘴巴左边跟右边距离top的距离（控件的高度＊MOUCH_PERCENT_H）
     */
    private static final float MOUCH_PERCENT_H = 0.55F;
    /**
     * 嘴巴中间距离top的距离（控件的高度＊MOUCH_PERCENT_H2）
     */
    private static final float MOUCH_PERCENT_H2 = 0.7F;
    /**
     * 嘴巴左边跟右边距离边缘的位置（控件宽度＊MOUCH_PERCENT_W）
     */
    private static final float MOUCH_PERCENT_W = 0.23F;
    /**
     * 眼睛跟嘴巴摆动的区间范围
     */
    private static final float DURATION_AREA = 0.15F;
    /**
     * 眼睛跟嘴巴摆动的动画
     */
    Animation mAmin =new Animation() {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            float offset=interpolatedTime*DURATION_AREA;
            mMouchH=MOUCH_PERCENT_H+offset;
            mMouchH2=MOUCH_PERCENT_H2+offset;
            mEyesH=EYE_PERCENT_H+offset;
            postInvalidate();
        }
    };
    private Paint reachedPaint;
    private Paint unreachedPaint;
    private Path reachedPath;
    private Path unreachedPath;
    private Path mouthPath=new Path();

    private float mProgress=0.1f;
    private float lineWidth=dp2px(2);

    private float mRadius;

    private float mMouchH=MOUCH_PERCENT_H;

    private float mMouchH2=MOUCH_PERCENT_H2;

    private float mEyesH=EYE_PERCENT_H;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void startAni() {
        mAmin.setDuration(500);
        mAmin.setRepeatCount(Animation.INFINITE);
        mAmin.setRepeatMode(Animation.REVERSE);
        startAnimation(mAmin);
    }

    private void initView() {
        reachedPaint=new Paint(Paint.ANTI_ALIAS_FLAG| Paint.DITHER_FLAG);
        reachedPaint.setStyle(Paint.Style.STROKE);
        reachedPaint.setStrokeWidth(lineWidth);
        reachedPaint.setColor(Color.WHITE);
        reachedPaint.setStrokeJoin(Paint.Join.ROUND);
        reachedPaint.setStrokeCap(Paint.Cap.ROUND);


        unreachedPaint=new Paint(reachedPaint);
        unreachedPaint.setColor(Color.GRAY);
    }
    private boolean isStart=true;
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(isStart){
            startAni();
            isStart=false;
        }
        mRadius=getWidth()/7F/2;
        if(unreachedPath==null){
            unreachedPath=new Path();
        }
        unreachedPath.addRoundRect(new RectF(lineWidth,lineWidth,w-lineWidth,h-lineWidth),w/6,w/6, Path.Direction.CCW);
        if(reachedPath==null){
            reachedPath=new Path();
        }
        reachedPath.addRoundRect(new RectF(lineWidth,lineWidth,w-lineWidth,h-lineWidth),w/6,w/6, Path.Direction.CW);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT);
        canvas.save();
        //draw face
        drawFace(canvas);
        //drawreached rect
        drawReachedRect(canvas);
        canvas.restore();
    }

    /**
     * draw face
     */
    private void drawFace(Canvas canvas) {
        unreachedPaint.setStyle(Paint.Style.FILL);
        //画左边的眼睛
        canvas.drawCircle(getWidth()*EYE_PERCENT_W,getHeight()*mEyesH-mRadius,mRadius,unreachedPaint);
        //画右边的眼睛
        canvas.drawCircle(getWidth()*(1-EYE_PERCENT_W),getHeight()*mEyesH-mRadius,mRadius,unreachedPaint);
        mouthPath.reset();
        //画嘴巴
        mouthPath.moveTo(getWidth()*MOUCH_PERCENT_W,getHeight()*mMouchH);
        mouthPath.quadTo(getWidth()/2,getHeight()*mMouchH2,getWidth()*(1-MOUCH_PERCENT_W),getHeight()*mMouchH);
        unreachedPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mouthPath,unreachedPaint);
    }

    private void drawReachedRect(Canvas canvas) {
        unreachedPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(unreachedPath,unreachedPaint);
        PathMeasure measure=new PathMeasure(reachedPath,false);
        float length = measure.getLength();
        //获取当前path长度
        float currLength=length*mProgress;
        Path path=new Path();
        /**
         * 因为uc的起始位置是在顶部的位置,而我们的path的起始位置是在左下的位置，
         * 所以我们需要加上一个length*1/3f偏移量
         */
        measure.getSegment(length*1/3f,currLength+length*1/3f,path,true);
        canvas.drawPath(path,reachedPaint);
        /**
         * 当mProgress>=2/3f的时候，也就是回到了起点的时候，我们得截取两段path了
         * 一段是1/3的位置到2/3
         * 一段是0到1/3的位置
         */
        if(mProgress>=2/3f){
            Path path2=new Path();
            measure.getSegment(0,length*(mProgress-2/3f),path2,true);
            canvas.drawPath(path2,reachedPaint);
        }

    }

    public float dp2px(float dpValue){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpValue,getResources().getDisplayMetrics());
    }
    public void setProgress(float progress){
        Log.d("TAG",""+progress);
        if(progress<mProgress){
            return;
        }
        this.mProgress=progress;

        postInvalidate();

    }

    public void loadComplete() {
        mAmin.cancel();
        clearAnimation();
        setVisibility(View.GONE);
    }
}
