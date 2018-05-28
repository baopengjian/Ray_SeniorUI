package com.example.baopengjian.ray_seniorui.third.basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 */

public class PathDashPathView extends View {

    public PathDashPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    int dx =0 ;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawPathDashPathEffect(canvas);
        dx++;
        invalidate();
    }

    private Paint getPaint(){
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    private void drawPathDashPathEffect(Canvas canvas){
        Paint paint = getPaint();

        Path path  = new Path();
        path.moveTo(100,600);
        path.lineTo(400,150);
        path.lineTo(700,900);
        canvas.drawPath(path,paint);
        canvas.drawPath(path,paint);

        canvas.translate(0,200);

        /**
         * 利用以另一个路径为单位,延着路径盖章.相当于PS的印章工具
         */
        paint.setPathEffect(new PathDashPathEffect(getStampPath(),35,dx, PathDashPathEffect.Style.MORPH));
        canvas.drawPath(path,paint);
    }


    private Path getStampPath(){
        Path path  = new Path();
        path.moveTo(0,20);
        path.lineTo(10,0);
        path.lineTo(20,20);
        path.close();

        path.addCircle(0,0,3, Path.Direction.CCW);

        return path;
    }
}
