package com.example.baopengjian.ray_seniorui.twenty_fifth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 */

public class MyDrawBgView extends View {

    private Paint paint;
    private Path path;
    private BitmapDrawable drawable;
    public MyDrawBgView(Context context) {
        this(context,null);
    }

    public MyDrawBgView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        path = new Path();
    }


    public void setTouchY(float y, float percent) {
        path.reset();
        float width=getWidth()*percent;
        float height=getHeight();
        float firstPointX=width/2;
        float offsetY=height/8;
        path.lineTo(firstPointX,-offsetY);
        path.quadTo(width * 3 / 2, y, firstPointX, height + offsetY);
        path.lineTo(0, height);
        path.close();
        path.offset(getWidth() - width, 0);
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
         //完成图片的绘制
        if (drawable != null) {
            Bitmap bitmap=drawable.getBitmap();
            Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            paint.setShader(shader);
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path,paint);
    }

    public void setColor(Drawable color) {
        if (color instanceof ColorDrawable) {
            ColorDrawable colorDrawable= (ColorDrawable) color;
            paint.setColor(colorDrawable.getColor());
        } else if (color instanceof BitmapDrawable) {
            this.drawable= (BitmapDrawable) color;
        }
    }

}
