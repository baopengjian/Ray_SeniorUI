package com.example.baopengjian.ray_seniorui.third.circle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 */

public class CircleProgressBar extends View{
    private int max;
    private int roundColor;
    private int roundProgressColor;
    private int textColor;
    private float textSize;
    private float roundWidth;
    private boolean textShow;
    private int progress;
    private Paint paint;
    public static final int STROKE = 0;
    public static final int FILL = 1;

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar);
        max = typedArray.getInteger(R.styleable.CustomProgressBar_max, 100);
        roundColor = typedArray.getColor(R.styleable.CustomProgressBar_roundColor, Color.RED);
        roundProgressColor = typedArray.getColor(R.styleable.CustomProgressBar_roundProgressColor, Color.BLUE);
        textColor = typedArray.getColor(R.styleable.CustomProgressBar_textColor, Color.GREEN);
        textSize = typedArray.getDimension(R.styleable.CustomProgressBar_textSize, 55);
        roundWidth = typedArray.getDimension(R.styleable.CustomProgressBar_roundWidth, 10);
        textShow = typedArray.getBoolean(R.styleable.CustomProgressBar_textShow, true);


        typedArray.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画背景圆环
        int center = getWidth() / 2;

        float radius = center - roundWidth / 2;
        paint.setColor(roundColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(roundWidth); // 圆环的宽度
        paint.setAntiAlias(true);
        canvas.drawCircle(center,center,radius,paint);

        // 画进度百分比
        paint.setColor(textColor);
        paint.setStrokeWidth(0);
        paint.setTextSize(textSize);
        paint.setTypeface(Typeface.DEFAULT_BOLD);

        int percent = (int)(progress / (float)max * 100);
        String strPercent = percent + "%";
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        if(percent != 0){
            canvas.drawText(strPercent, getWidth() / 2 - paint.measureText(strPercent) / 2 ,
                    getWidth() / 2  +(fm.bottom - fm.top)/2 - fm.bottom, paint);
        }


        // 画圆弧
        RectF oval = new RectF(center - radius, center - radius,
                center + radius, center + radius);
        paint.setColor(roundProgressColor);
        paint.setStrokeWidth(roundWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(oval, 0 , 360 * progress / max, false, paint);

    }

    public void setProgress(int progress){
        if(progress < 0 ){
            throw new IllegalArgumentException("进度Progress不能小于0");
        }
        if(progress > max){
            progress = max;
        }
        if(progress <= max){
            this.progress = progress;
            postInvalidate();
        }
    }
}
