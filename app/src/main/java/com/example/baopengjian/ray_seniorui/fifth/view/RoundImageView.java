package com.example.baopengjian.ray_seniorui.fifth.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2018/6/21.
 */
public class RoundImageView extends View {

    private Paint mBitmapPaint;
    private Bitmap mBitmapSrc, mBitmapDst;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mBitmapPaint = new Paint();

        mBitmapSrc = BitmapFactory.decodeResource(getResources(),R.drawable.xyjy6);
        mBitmapDst =BitmapFactory.decodeResource(getResources(),R.drawable.shade);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(mBitmapDst,0,0,mBitmapPaint);
        mBitmapPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mBitmapSrc,0,0,mBitmapPaint);
        mBitmapPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
