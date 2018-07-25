package com.example.baopengjian.ray_seniorui.sixth.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2018/7/18.
 */
public class ColorMatrixColorFilterView extends View {

    Paint paint;
    Bitmap bitmap;

    public ColorMatrixColorFilterView(Context context) {
        this(context, null);
    }

    public ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        this.setWillNotDraw(false);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setTextSize(32);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xyjy2,options);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSrc(canvas);
        translate(canvas);
        opposition(canvas);
        scale(canvas);
        blackWhite(canvas);
        colour(canvas);
        vintage(canvas);
        filter(canvas);
    }


    //颜色通道过滤
    private void filter(Canvas canvas) {
        canvas.translate(bitmap.getWidth() + 250, 0);
        canvas.drawText("颜色通道过滤（只留红色）:", 30, 50, paint);
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 1, 0,
        });
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 20, 60, paint);
    }

    //复古效果
    private void vintage(Canvas canvas) {
        canvas.translate(-bitmap.getWidth() - 250, bitmap.getHeight() + 60);
        canvas.drawText("复古效果:", 30, 50, paint);
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1 / 2f, 1 / 2f, 1 / 2f, 0, 0,
                1 / 3f, 1 / 3f, 1 / 3f, 0, 0,
                1 / 4f, 1 / 4f, 1 / 4f, 0, 0,
                0, 0, 0, 1, 0,
        });
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 20, 60, paint);
    }

    //发色效果---（比如红色和绿色交换）
    private void colour(Canvas canvas) {
        canvas.translate(bitmap.getWidth() + 250, 0);
        canvas.drawText("发色效果（比如红色和绿色交换）:", 30, 50, paint);
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0, 1, 0, 0, 0,
                1, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 20, 60, paint);
    }

    // 黑白照片
    // 去色原理：只要把R G B 三通道的色彩信息设置成一样，那么图像就会变成灰色，
    // 同时为了保证图像亮度不变，同一个通道里的R+G+B =1
    private void blackWhite(Canvas canvas) {
        canvas.translate(-bitmap.getWidth() - 250, bitmap.getHeight() + 60);
        canvas.drawText("黑白照片:", 30, 50, paint);
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0.213f, 0.715f, 0.072f, 0, 0,
                0.213f, 0.715f, 0.072f, 0, 0,
                0.213f, 0.715f, 0.072f, 0, 0,
                0, 0, 0, 1, 0
        });
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 20, 60, paint);
    }

    //缩放运算---乘法 -- 颜色增强
    private void scale(Canvas canvas) {
        canvas.translate(bitmap.getWidth() + 250, 0);
        canvas.drawText("缩放运算---乘法 -- 颜色增强", 30, 50, paint);
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1.2f, 0, 0, 0, 0,
                0, 1.2f, 0, 0, 0,
                0, 0, 1.2f, 0, 0,
                0, 0, 0, 1, 0
        });
        //或者
        //  ColorMatrix colorMartrix = new ColorMatrix();
        // colorMartrix.setScale(1.2f,1.2f,1.2f,1);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 20, 60, paint);
    }

    // 反相效果 -- 底片效果
    private void opposition(Canvas canvas) {
        canvas.translate(-bitmap.getWidth() - 250, bitmap.getHeight() + 60);
        canvas.drawText("反相效果 -- 底片效果", 30, 50, paint);
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                -1, 0, 0, 0, 255,
                0, -1, 0, 0, 255,
                0, 0, -1, 0, 255,
                0, 0, 0, 1, 0
        });
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(bitmap, 20, 60, paint);
    }

    //平移运算：红色加100
    private void translate(Canvas canvas) {
        canvas.translate(bitmap.getWidth() + 250, 0);
        canvas.drawText("平移运算：红色加100", 20, 50, paint);
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1, 0, 0, 0, 0,
                0, 1, 0, 0, 100,
                0, 0, 1, 0, 0,
                0, 0, 0, 255, 0
        });
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 20, 60, paint);
    }

    private void drawSrc(Canvas canvas) {
        canvas.drawText("原图", 20, 50, paint);
        canvas.drawBitmap(bitmap, 20, 60, paint);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

}
