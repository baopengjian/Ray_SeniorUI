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
 * Created by John on 2017/5/10.
 */

public class MyGradientView extends View {
    private Paint mPaint;

    private int[] mColors = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};

    public MyGradientView(Context context, @Nullable AttributeSet attrs) {
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

        /*SweepGradient mSweepGradient = new SweepGradient(300, 300, mColors, null);
		mPaint.setShader(mSweepGradient);
		canvas.drawCircle(300, 300, 300, mPaint);*/

        /*ComposeShader mComposeShader = new ComposeShader(linearGradient, mBitmapShader, PorterDuff.Mode.SRC_OVER);
        mPaint.setShader(mComposeShader);
        canvas.drawRect(0, 0, 800, 1000, mPaint);*/

        /***************用ComposeShader即可实现心形图渐变效果*********************************/
        /*//创建BitmapShader，用以绘制心
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //创建LinearGradient，用以产生从左上角到右下角的颜色渐变效果
        LinearGradient linearGradient = new LinearGradient(0, 0, mWidth, mHeight, Color.GREEN, Color.BLUE, Shader.TileMode.CLAMP);
        //bitmapShader对应目标像素，linearGradient对应源像素，像素颜色混合采用MULTIPLY模式
        ComposeShader composeShader = new ComposeShader(bitmapShader, linearGradient, PorterDuff.Mode.MULTIPLY);
        //将组合的composeShader作为画笔paint绘图所使用的shader
        mPaint.setShader(composeShader);
        //用composeShader绘制矩形区域
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);*/
    }
}
