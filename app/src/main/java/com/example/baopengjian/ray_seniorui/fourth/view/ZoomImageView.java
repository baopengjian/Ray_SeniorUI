package com.example.baopengjian.ray_seniorui.fourth.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Require：放大镜效果
 *      1、一张背景图片，触摸背景图片，会显示触摸区域会显示一个圆形放大
 *     2、 手指滑动，触摸区域会随着移动
 *
 * Theory：
 *    1）利用Paint的Shader实现
 *    2） 将图片放大，创建一个ShapeDrawable，设置它的区域
 *    3） 监听onTouchEvent，利用Matrix移动，设置到ShapeDrawable中
 *
 */

public class ZoomImageView extends View {

    //放大倍数
    private static final int FACTOR = 2;
    //放大镜的半径
    private static final int RADIUS  = 100;
    // 原图
    private Bitmap mBitmap;
    // 放大后的图
    private Bitmap mBitmapScale;
    // 制作的圆形的图片（放大的局部），盖在Canvas上面
    private ShapeDrawable mShapeDrawable;

    private Matrix mMatrix;

    public ZoomImageView(Context context) {
        this(context,null);
    }

    public ZoomImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ZoomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xyjy3);
        mBitmapScale = mBitmap;
        //放大后的整个图片
        mBitmapScale = Bitmap.createScaledBitmap(mBitmapScale,mBitmapScale.getWidth() * FACTOR,
                mBitmapScale.getHeight() * FACTOR,true);
            BitmapShader bitmapShader = new BitmapShader(mBitmapScale, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);

        mShapeDrawable = new ShapeDrawable(new OvalShape());
        mShapeDrawable.getPaint().setShader(bitmapShader);
        // 切出矩形区域，用来画圆（内切圆）
        mShapeDrawable.setBounds(0,0,RADIUS * 2,RADIUS * 2);

        mMatrix = new Matrix();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 1、画原图
        canvas.drawBitmap(mBitmap, 0 , 0 , null);

        // 2、画放大镜的图
        mShapeDrawable.draw(canvas);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        // 将放大的图片往相反的方向挪动
        mMatrix.setTranslate(RADIUS - x * FACTOR, RADIUS - y *FACTOR);
        mShapeDrawable.getPaint().getShader().setLocalMatrix(mMatrix);
        // 切出手势区域点位置的圆
        mShapeDrawable.setBounds(x-RADIUS,y - RADIUS, x + RADIUS, y + RADIUS);
        invalidate();
        return true;
    }
}
