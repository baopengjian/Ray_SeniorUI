package com.example.baopengjian.ray_seniorui.tenth;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by John on 2017/5/24.
 */


public class MyView extends View {

    private static final String TAG = "MyView";
    private int mViewWidth;
    private int mViewHeight;
    private Paint mDeafultPaint;

    private Paint mPaint;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mDeafultPaint = new Paint();
        mDeafultPaint.setColor(Color.RED);
        mDeafultPaint.setStrokeWidth(5);
        mDeafultPaint.setStyle(Paint.Style.STROKE);

        mPaint = new Paint();
        mPaint.setColor(Color.DKGRAY);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 平移坐标系
        canvas.translate(mViewWidth / 2, mViewHeight / 2);
        // 画坐标线
        canvas.drawLine(-canvas.getWidth(), 0, canvas.getWidth(), 0, mPaint);
        canvas.drawLine(0, -canvas.getHeight(), 0, canvas.getHeight(), mPaint);

        //testForceClosed(canvas);

        // testGetSegment(canvas);

       // testGetSegmentMoveTo(canvas);

       testNextContour(canvas);
    }

    /** forceClosed 不同值时 getLength()获取长度*/
    private void testForceClosed(Canvas canvas) {
        Path path = new Path();

        path.lineTo(0, 200);
        path.lineTo(200, 200);
        path.lineTo(200, 0);

        PathMeasure measure1 = new PathMeasure(path, false);
        PathMeasure measure2 = new PathMeasure(path, true);

        Log.e(TAG, "forceClosed=false length = " + measure1.getLength());
        Log.e(TAG, "forceClosed=true length = " + measure2.getLength());
        canvas.drawPath(path, mDeafultPaint);
    }


    private void testGetSegment(Canvas canvas) {
        Path path = new Path();
        // 创建Path并添加了一个矩形
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);

        Path dst = new Path();
        // 将 Path 与 PathMeasure 关联
        PathMeasure measure = new PathMeasure(path, false);

        //截取200到600长度的片段以后，因为startWithMoveTo为false，Path的起点为原始起点，即片段的起点不是200处，改成原始起点
        measure.getSegment(200, 600, dst, false);

        canvas.drawPath(path,mPaint);
        // 绘制 dst
        canvas.drawPath(dst, mDeafultPaint);
    }

    private void testGetSegmentMoveTo(Canvas canvas) {
        Path path = new Path();
        // 创建Path并添加了一个矩形
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);

        Path dst = new Path();
        dst.lineTo(-300, -300);
        // 将 Path 与 PathMeasure 关联
        PathMeasure measure = new PathMeasure(path, false);

        // 截取一部分存入dst中，并使用 moveTo 保持截取得到的 Path 第一个点的位置不变
        //measure.getSegment(200, 600, dst, false);
        measure.getSegment(0, 600, dst, true);

        canvas.drawPath(path, mPaint);
        // 绘制 dst
        canvas.drawPath(dst, mDeafultPaint);
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void testNextContour(Canvas canvas) {
        Path path = new Path();
        Path path1 = new Path();
        Path path2 = new Path();
        // 添加小矩形
        path1.addRect(-100, -100, 100, 100, Path.Direction.CW);
        // 添加大矩形
        path2.addRect(-200, -200, 200, 200, Path.Direction.CW);
        path.op(path1,path2, Path.Op.XOR);
        canvas.drawPath(path,mDeafultPaint);

        PathMeasure measure = new PathMeasure(path, false);

        float len1 = measure.getLength();
        // 跳转到下一条路径
        measure.nextContour();

        float len2 = measure.getLength();
        Log.d(TAG,"len1 = "+len1);
        Log.d(TAG,"len2 = "+len2);
    }



}
