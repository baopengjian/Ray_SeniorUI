package com.example.baopengjian.ray_seniorui.eighth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Ray on 2018/10/9.
 */
public class DrawingBoardView extends View {

    float preX;
    float preY;
    private Paint paint;
    //定义一个内存中图片，将他作为缓冲区
    Bitmap cacheBitmap = null;
    //定义缓冲区Cache的Canvas对象
    Canvas cacheCanvas = null;
    private Path path;

    public DrawingBoardView(Context context) {
        this(context,null);
    }

    public DrawingBoardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawingBoardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //创建缓冲区Cache的Canvas对象
        cacheCanvas = new Canvas();
        path = new Path();

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setFlags(Paint.DITHER_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //创建一个与该VIew相同大小的缓冲区
        cacheBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        //设置cacheCanvas将会绘制到内存的bitmap上
        cacheCanvas.setBitmap(cacheBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        //将cacheBitmap绘制到该View
        canvas.drawBitmap(cacheBitmap,0,0,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //获取拖动时间的发生位置
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX,preY,x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_UP:
                //这是是调用了cacheBitmap的Canvas在绘制
                cacheCanvas.drawPath(path,paint);
                path.reset();
                invalidate();//在UI线程刷新VIew
                break;
        }
        return true;
    }
}
