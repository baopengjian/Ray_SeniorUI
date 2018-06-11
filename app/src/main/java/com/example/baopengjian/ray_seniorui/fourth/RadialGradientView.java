package com.example.baopengjian.ray_seniorui.fourth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * 环形渲染
 */

public class RadialGradientView extends View {
    private Paint mPaint;
    private int[] mColors = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};

    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        RadialGradient mRadialGradient = new RadialGradient(350, 350, 100, mColors, null, Shader.TileMode.CLAMP);
        mPaint.setShader(mRadialGradient);
        canvas.drawCircle(350, 350, 300, mPaint);
    }
}
