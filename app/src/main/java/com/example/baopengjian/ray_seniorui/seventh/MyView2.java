package com.example.baopengjian.ray_seniorui.seventh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by John on 2017/5/16.
 */

public class MyView2 extends View{

    public MyView2(Context context) {
        super(context);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        canvas.drawColor(Color.RED);
        //保存的画布大小为全屏幕大小
        //canvas.save();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.saveLayer(0,0,canvas.getWidth(),canvas.getHeight(),null);
        }

        canvas.clipRect(new Rect(100, 100, 800, 800));
        canvas.drawColor(Color.GREEN);
        //保存画布大小为Rect(100, 100, 800, 800)
        //canvas.save();

        canvas.clipRect(new Rect(200, 200, 700, 700));
        canvas.drawColor(Color.BLUE);
        //保存画布大小为Rect(200, 200, 700, 700)
        //canvas.save();

        canvas.clipRect(new Rect(300, 300, 600, 600));
        canvas.drawColor(Color.BLACK);
        //保存画布大小为Rect(300, 300, 600, 600)
        //canvas.save();

        canvas.clipRect(new Rect(400, 400, 500, 500));
        canvas.drawColor(Color.WHITE);

        //连续出栈三次，将最后一次出栈的Canvas状态作为当前画布，并画成黄色背景
        //canvas.restoreToCount(2);
        //canvas.restore();
        //canvas.restore();
        canvas.drawColor(Color.YELLOW);




        //---------------初次演示Save和Restore的关系
        /*canvas.drawColor(Color.RED);

        //保存当前画布大小即整屏
        canvas.save();

        canvas.clipRect(new Rect(100, 100, 800, 800));
        canvas.drawColor(Color.GREEN);

        //恢复整屏画布
        canvas.restore();

        canvas.drawColor(Color.BLUE);*/




        //------------canvas画布裁剪
        /*canvas.drawColor(Color.RED);
        canvas.clipRect(new Rect(100, 100, 200, 200));
        canvas.drawColor(Color.GREEN);*/



        //--------------------skew 扭曲
        /*Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 5);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 5);

        Rect rect1 = new Rect(10,10,200,100);

        canvas.drawRect(rect1, paint_green);
        canvas.skew(1.732f,0);//X轴倾斜60度，Y轴不变
        canvas.drawRect(rect1, paint_red);*/

        //------------------------scale 缩放坐标系密度
        /*Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 5);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 5);
        Paint paint_gray   = generatePaint(Color.GRAY, Paint.Style.STROKE, 5);

        Rect rect1 = new Rect(10,10,200,100);
        canvas.drawRect(rect1, paint_green);

        canvas.scale(0.5f, 1);
        canvas.drawRect(rect1, paint_red);*/




        //----------------------Rotate Canvas正方向旋转30度
        /*Paint paint_green = generatePaint(Color.GREEN, Paint.Style.FILL, 5);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 5);

        Rect rect1 = new Rect(300,10,500,100);
        canvas.drawRect(rect1, paint_red); //画出原轮廓

        canvas.rotate(30);//顺时针旋转画布
        canvas.drawRect(rect1, paint_green);//画出旋转后的矩形*/



        //-----------屏幕显示与Canvas的关系
        //构造两个画笔，一个红色，一个绿色
        /*Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 5);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 5);

        //构造一个矩形
        Rect rect1 = new Rect(0,0,400,220);

        //在平移画布前用绿色画下边框
        canvas.drawRect(rect1, paint_green);

        //平移画布后,再用红色边框重新画下这个矩形
        canvas.translate(100, 100);
        canvas.drawRect(rect1, paint_red);*/




        //------------translate  平移,即改变坐标系原点位置
        /*Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        canvas.translate(100, 100);
        Rect rect1 = new Rect(0,0,400,220);
        canvas.drawRect(rect1, paint);*/

    }
    private Paint generatePaint(int color, Paint.Style style, int width)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }
}
