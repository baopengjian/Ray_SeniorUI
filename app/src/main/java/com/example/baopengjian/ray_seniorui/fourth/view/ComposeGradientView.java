package com.example.baopengjian.ray_seniorui.fourth.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * 环形渲染
 */

public class ComposeGradientView extends View {
    private Paint mPaint;
    private Bitmap mBitmap = null;

    private int mWidth;
    private int mHeight;
    private int[] mColors = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};

    public ComposeGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mBitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.xyjy2)).getBitmap();
        mPaint = new Paint();
        mWidth = mBitmap.getWidth();
        mHeight = mBitmap.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        /***************用ComposeShader即可实现心形图渐变效果*********************************/
        //创建BitmapShader，用以绘制心
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //创建LinearGradient，用以产生从左上角到右下角的颜色渐变效果
        LinearGradient linearGradient = new LinearGradient(0, 0, mWidth, mHeight, Color.GREEN, Color.BLUE, Shader.TileMode.CLAMP);
        //bitmapShader对应目标像素，linearGradient对应源像素，像素颜色混合采用MULTIPLY模式
        ComposeShader composeShader = new ComposeShader(bitmapShader, linearGradient, PorterDuff.Mode.MULTIPLY);
        //将组合的composeShader作为画笔paint绘图所使用的shader
        mPaint.setShader(composeShader);
        //用composeShader绘制矩形区域
        canvas.drawRect(50, 50, mWidth, mHeight, mPaint);
    }
}
