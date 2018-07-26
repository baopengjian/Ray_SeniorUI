package com.example.baopengjian.ray_seniorui.seventh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by John on 2017/5/16.
 */

public class MyView extends View {


    private static final String TAG = "MyView";

    private Paint mPaint = null;
    private Bitmap mBitmap = null;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lsj);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        Log.d(TAG, "Current SaveCount = " + canvas.getSaveCount());

        canvas.translate(400, 400);
        RectF rectF = new RectF(0,0,600,600);

        //canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        canvas.drawBitmap(mBitmap, null, rectF, mPaint);

        canvas.save();
        Log.d(TAG, "Current SaveCount = " + canvas.getSaveCount());

        canvas.rotate(45);
        //canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        canvas.drawBitmap(mBitmap, null, rectF, mPaint);

        canvas.save();
        Log.d(TAG, "Current SaveCount = " + canvas.getSaveCount());

        canvas.rotate(45);
        //canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        canvas.drawBitmap(mBitmap, null, rectF, mPaint);

        canvas.save();
        Log.d(TAG, "Current SaveCount = " + canvas.getSaveCount());

        canvas.restoreToCount(1);
        Log.d(TAG, "Current SaveCount = " + canvas.getSaveCount());

        canvas.translate(0, 200);
        //canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        //rectF = new RectF(0,0,600,600);
        canvas.drawBitmap(mBitmap, null, rectF, mPaint);

        canvas.restoreToCount(3);
        Log.d(TAG, "Current SaveCount = " + canvas.getSaveCount());
        canvas.drawBitmap(mBitmap, null, rectF, mPaint);


    }
}
