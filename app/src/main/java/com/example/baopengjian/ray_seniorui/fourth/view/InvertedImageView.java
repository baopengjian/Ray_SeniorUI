package com.example.baopengjian.ray_seniorui.fourth.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2018/6/11.
 * 倒影效果
 */
public class InvertedImageView extends View {

    private Bitmap mBitmap;
    private Paint mPaint;

    private int mHeight, mWidth;

    public InvertedImageView(Context context) {
        this(context, null);
    }

    public InvertedImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InvertedImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xyjy2);
        mHeight = mBitmap.getHeight();
        mWidth = mBitmap.getWidth();

        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        if(MeasureSpec.EXACTLY == widthMode){
            width = measureWidth;
        }else{
            width = mWidth;
        }

        int height;
        if(MeasureSpec.EXACTLY == heightMode){
            height = measureHeight;
        }else{
            height = mHeight*2;
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);


        Matrix matrix = new Matrix();
        matrix.setScale(1,-1);
        Bitmap alterBitmap = Bitmap.createBitmap(mBitmap,0,0,mWidth,mHeight);
        matrix.postTranslate(0,2*mHeight);
        canvas.drawBitmap(alterBitmap,matrix,mPaint);
    }
}
