package com.example.baopengjian.ray_seniorui.fifth.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by john on 2017/5/9.
 */
public class InvertedImageView_SRCATOP extends View {
    private Paint mBitPaint;
    private Bitmap BmpDST,BmpSRC,BmpRevert;
    public InvertedImageView_SRCATOP(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mBitPaint = new Paint();
        BmpDST = BitmapFactory.decodeResource(getResources(), R.drawable.invert_shade,null);
        BmpSRC = BitmapFactory.decodeResource(getResources(),R.drawable.xyjy6,null);

        Matrix matrix = new Matrix();
        matrix.setScale(1F, -1F);
        // 生成倒影图
        BmpRevert = Bitmap.createBitmap(BmpSRC, 0, 0, BmpSRC.getWidth(), BmpSRC.getHeight(), matrix, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //先画出小狗图片
        canvas.drawBitmap(BmpSRC,0,0,mBitPaint);

        //再画出倒影
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.translate(0,BmpSRC.getHeight());

        canvas.drawBitmap(BmpDST,0,0,mBitPaint);
        mBitPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(BmpRevert,0,0,mBitPaint);

        mBitPaint.setXfermode(null);

        canvas.restoreToCount(layerId);
    }
}
