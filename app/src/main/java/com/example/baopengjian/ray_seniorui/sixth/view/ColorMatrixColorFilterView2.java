package com.example.baopengjian.ray_seniorui.sixth.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 */

public class ColorMatrixColorFilterView2 extends View {

    Paint paint;

    Bitmap bitmap;

    private int progress;

    public ColorMatrixColorFilterView2(Context context) {
        this(context, null);
    }

    public ColorMatrixColorFilterView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorMatrixColorFilterView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setTextSize(32);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xyjy2);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);


        RectF rectF = new RectF(50,10,bitmap.getWidth(),bitmap.getHeight());
        paint.reset();
        paint.setColor(Color.RED);

        canvas.drawBitmap(bitmap,null, rectF,paint);

        ColorMatrix colorMartrix = new ColorMatrix();
        //aixs-- 0 红色轴，1，绿色，2，蓝色
        // degrees -- 旋转的角度
        colorMartrix.setRotate(0,progress);

        paint.setColorFilter(new ColorMatrixColorFilter(colorMartrix));
        RectF rectF2 = new RectF(600,10,600 + bitmap.getWidth(),bitmap.getHeight());
        canvas.drawBitmap(bitmap,null, rectF2,paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                progress += 1f;
                progress += 20f;
                invalidate();
                break;
        }
        return true;

    }




}
