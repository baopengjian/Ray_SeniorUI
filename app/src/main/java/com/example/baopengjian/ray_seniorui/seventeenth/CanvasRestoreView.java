package com.example.baopengjian.ray_seniorui.seventeenth;

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
 * canvas.save();和 canvas.restore()/ canvas.restoreToCount(int saveCount)
 * save将状态保留到一个栈中restore和restoreToCount则是将状态恢复到相应的栈
 *
 */

public class CanvasRestoreView extends View {


    private static final String TAG = "MyView";

    private Paint mPaint = null;
    private Bitmap mBitmap = null;

    public CanvasRestoreView(Context context) {
        this(context, null);
    }

    public CanvasRestoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lsj);
        init();
    }

    public CanvasRestoreView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        Log.i(TAG, "Current SaveCount = " + canvas.getSaveCount());
        //打印结果：Current SaveCount = 2

        canvas.translate(200, 200);
        RectF rectF = new RectF(0,0,300,300);
        canvas.drawBitmap(mBitmap, null, rectF, mPaint);

        canvas.save();
        Log.i(TAG, "Current SaveCount = " + canvas.getSaveCount());
        //打印结果：Current SaveCount = 3
        canvas.rotate(45);
        canvas.drawBitmap(mBitmap, null, rectF, mPaint);

        canvas.save();
        Log.i(TAG, "Current SaveCount = " + canvas.getSaveCount());
        //打印结果：Current SaveCount = 4
        canvas.rotate(45);
        canvas.drawBitmap(mBitmap, null, rectF, mPaint);

        canvas.restoreToCount(1);
        Log.i(TAG, "Current SaveCount = " + canvas.getSaveCount());
        //打印结果：Current SaveCount =1
        canvas.translate(0, 100);
        canvas.drawBitmap(mBitmap, null, rectF, mPaint);

       canvas.restoreToCount(3);
        Log.i(TAG, "Current SaveCount = " + canvas.getSaveCount());
        //打印结果：Current SaveCount =1
        canvas.drawBitmap(mBitmap, null, rectF, mPaint);
    }
}
