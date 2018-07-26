package com.example.baopengjian.ray_seniorui.seventh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by John on 2017/5/17.
 */

public class MyView3 extends View {

    public MyView3(Context context) {
        super(context);
    }

    public MyView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF = new RectF(0,0,400,500);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.GREEN);

        canvas.drawRect(rectF, paint);
        canvas.translate(50,50);

        canvas.saveLayer(0,0,canvas.getWidth(),canvas.getHeight(),null,Canvas.ALL_SAVE_FLAG);
        //canvas.save();
        canvas.drawColor(Color.BLUE);// 通过drawColor可以发现saveLayer是新建了一个图层，
                                    // 同时结合Lsn5的16种Xfermode叠加形式Demo可以验证是新建的透明图层
        paint.setColor(Color.YELLOW);
        canvas.drawRect(rectF,paint);
        //canvas.restore();
        canvas.restore();

        RectF rectF1 = new RectF(10,10,300,400);
        paint.setColor(Color.RED);
        canvas.drawRect(rectF1,paint);

    }
}
