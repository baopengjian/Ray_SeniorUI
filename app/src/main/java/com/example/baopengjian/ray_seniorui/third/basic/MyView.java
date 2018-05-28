package com.example.baopengjian.ray_seniorui.third.basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 */

public class MyView extends View {

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setEffect(int type) {
        mType = type;
        postInvalidate();
    }

    private int mType = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        switch (mType) {
            case 0:
                drawStrokeCap(canvas);
                break;
            case 1:
                drawStrokeJoin(canvas);
                break;
            case 2:
                drawCornerPathEffect(canvas);
                break;
            case 3:
                drawCornerPathEffectDemo(canvas);
                break;
            case 4:
                drawDashPathEffectDemo(canvas);
                break;
            case 5:
                drawDiscretePathEffectDemo(canvas);
                break;
            case 6:
                drawPathDashPathEffect(canvas);
                break;
            case 7:
                drawPathDashPathEffectDemo(canvas);
                break;
            case 8:
                drawComposePathEffectDemo(canvas);
                break;
            case 9:
                drawSubpixelText(canvas);
                break;
        }

    }

    //StrokeCap示例
    private void drawStrokeCap(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(80);
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        //paint.setStrokeMiter(); //画笔的倾斜度
        //paint.setDither();//设置图像是否使用抖动处理,会使得绘制出来的图片更加平滑和饱满，图像更加清晰

        paint.setStrokeCap(Paint.Cap.BUTT);// 无线帽
        canvas.drawLine(100, 200, 400, 200, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100, 400, 400, 400, paint);// 方形线帽

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100, 600, 400, 600, paint);// 圆形线帽

    }


    private void drawStrokeJoin(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(40);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(450, 100);
        path.lineTo(100, 300);
        paint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path, paint);

        path.moveTo(100, 400);
        path.lineTo(450, 400);
        path.lineTo(100, 600);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path, paint);

        path.moveTo(100, 700);
        path.lineTo(450, 700);
        path.lineTo(100, 900);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path, paint);
    }


    private Path getPath() {
        Path path = new Path();
        // 定义路径的起点
        path.moveTo(0, 0);

        // 定义路径的各个点
        for (int i = 0; i <= 40; i++) {
            path.lineTo(i * 35, (float) (Math.random() * 150));
        }
        return path;
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }


    /**
     * CornerPathEffect
     *
     * @param canvas
     */
    private void drawCornerPathEffectDemo(Canvas canvas) {
        Paint paint = getPaint();
        Path path = getPath();
        canvas.drawPath(path, paint);

        paint.setPathEffect(new CornerPathEffect(200));
        canvas.save();
        canvas.translate(0, 150);
        canvas.drawPath(path, paint);
    }


    private void drawCornerPathEffect(Canvas canvas) {
        Paint paint = getPaint();
        Path path = new Path();
        path.moveTo(100, 600);
        path.lineTo(400, 100);
        path.lineTo(700, 900);

        canvas.drawPath(path, paint);
        paint.setColor(Color.RED);
        paint.setPathEffect(new CornerPathEffect(100));
        canvas.drawPath(path, paint);

        paint.setPathEffect(new CornerPathEffect(200));
        paint.setColor(Color.YELLOW);
        canvas.drawPath(path, paint);
    }


    private void drawDashPathEffectDemo(Canvas canvas) {
        Paint paint = getPaint();
        Path path = getPath();

        canvas.translate(0, 100);
        paint.setPathEffect(new DashPathEffect(new float[]{15, 20, 15, 15}, 0));
        canvas.drawPath(path, paint);
    }


    private void drawDiscretePathEffectDemo(Canvas canvas) {
        Paint paint = getPaint();
        Path path = getPath();

        canvas.drawPath(path, paint);
        /**
         * 把原有的路线,在指定的间距处插入一个突刺
         * 第一个这些突出的“杂点”的间距,值越小间距越短,越密集
         * 第二个是突出距离
         */
        canvas.translate(0, 100);
        paint.setPathEffect(new DiscretePathEffect(2, 5));
        canvas.drawPath(path, paint);

        canvas.translate(0, 100);
        paint.setPathEffect(new DiscretePathEffect(6, 5));
        canvas.drawPath(path, paint);


        canvas.translate(0, 100);
        paint.setPathEffect(new DiscretePathEffect(6, 15));
        canvas.drawPath(path, paint);
    }

    private void drawPathDashPathEffect(Canvas canvas) {
        Paint paint = getPaint();

        Path path = new Path();
        path.moveTo(100, 300);
        path.lineTo(400, 20);
        path.lineTo(700, 300);
        canvas.drawPath(path, paint);


        canvas.translate(0, 50);

        /**
         * 利用以另一个路径为单位,延着路径盖章.相当于PS的印章工具
         */
        paint.setPathEffect(new PathDashPathEffect(getStampPath(), 35, 0, PathDashPathEffect.Style.MORPH));
        canvas.drawPath(path, paint);
    }


    private void drawPathDashPathEffectDemo(Canvas canvas) {
        Paint paint = getPaint();

        Path path = getPath();
        canvas.drawPath(path, paint);

        canvas.translate(0, 150);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(), 35, 0, PathDashPathEffect.Style.MORPH));
        canvas.drawPath(path, paint);

        canvas.translate(0, 150);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(), 35, 0, PathDashPathEffect.Style.ROTATE));
        canvas.drawPath(path, paint);

        canvas.translate(0, 150);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(), 35, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawPath(path, paint);
    }




    private Path getStampPath() {
        Path path = new Path();
        path.moveTo(0, 20);
        path.lineTo(10, 0);
        path.lineTo(20, 20);
        path.close();

        path.addCircle(0, 0, 3, Path.Direction.CCW);

        return path;
    }


    private void drawComposePathEffectDemo(Canvas canvas) {
        //画原始路径
        Paint paint = getPaint();
        Path path = getPath();
        canvas.drawPath(path, paint);

        //仅应用圆角特效的路径
        canvas.translate(0, 100);
        CornerPathEffect cornerPathEffect = new CornerPathEffect(100);
        paint.setPathEffect(cornerPathEffect);
        canvas.drawPath(path, paint);

        //仅应用虚线特效的路径
        canvas.translate(0, 100);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{2, 5, 10, 10}, 0);
        paint.setPathEffect(dashPathEffect);
        canvas.drawPath(path, paint);

        //利用ComposePathEffect先应用圆角特效,再应用虚线特效
        canvas.translate(0, 100);
        ComposePathEffect composePathEffect = new ComposePathEffect(dashPathEffect, cornerPathEffect);
        paint.setPathEffect(composePathEffect);
        canvas.drawPath(path, paint);

        //利用SumPathEffect,分别将圆角特效应用于原始路径,然后将生成的两条特效路径合并
        canvas.translate(0, 100);
        paint.setStyle(Paint.Style.STROKE);
        SumPathEffect sumPathEffect = new SumPathEffect(cornerPathEffect, dashPathEffect);
        paint.setPathEffect(sumPathEffect);
        canvas.drawPath(path, paint);

    }


    private void drawSubpixelText(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        String text = "动脑学院高级UI";
        paint.setTextSize(50);

        paint.setSubpixelText(false);
        canvas.drawText(text, 0, 100, paint);

        canvas.translate(0, 150);
        paint.setSubpixelText(true);
        canvas.drawText(text, 0, 100, paint);
    }
}
