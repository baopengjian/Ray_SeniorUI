package com.example.baopengjian.ray_seniorui.sixth.view;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by John on 2017/5/15.
 * BlurMaskFilter 模糊阴影
 */

public class BlurMaskFilterView extends View {

    private Paint paint;
    private RectF rectF;


    public BlurMaskFilterView(Context context) {
        this(context, null);
    }

    public BlurMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlurMaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setTextSize(32);
        rectF = new RectF(0, 100, 100, 200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSrc(canvas);
        drawBlurMaskFilterNormal(canvas);
        drawBlurMaskFilterSolid(canvas);
        drawBlurMaskFilterOuter(canvas);
        drawBlurMaskFilterInner(canvas);
    }

    private void drawSrc(Canvas canvas) {
        canvas.translate(50, 0);
        canvas.drawRect(rectF, paint);
        canvas.drawText("原图", 20, 250, paint);
    }

    /**
     * Create a blur maskfilter.绘制模糊阴影
     * BlurMaskFilter
     * radius 阴影的半径
     * style  NORMOL -- 整个图像都被模糊掉
     * SOLID -- 图像边界外产生一层与Paint颜色一致阴影效果，不影响图像的本身
     * OUTER -- 图像边界外产生一层阴影，并且将图像变成透明效果
     * INNER -- 在图像内部边沿产生模糊效果
     */
    private void drawBlurMaskFilterNormal(Canvas canvas) {
        canvas.translate(200, 0);
        paint.setMaskFilter(new BlurMaskFilter(20, BlurMaskFilter.Blur.NORMAL));
        canvas.drawRect(rectF, paint);
        canvas.drawText("NORMAL", 0, 250, paint);
    }

    private void drawBlurMaskFilterSolid(Canvas canvas) {
        canvas.translate(200, 0);
        paint.setMaskFilter(new BlurMaskFilter(30, BlurMaskFilter.Blur.SOLID));
        canvas.drawRect(rectF, paint);
        canvas.drawText("SOLID", 0, 250, paint);
    }


    private void drawBlurMaskFilterOuter(Canvas canvas) {
        canvas.translate(200, 0);
        paint.setMaskFilter(new BlurMaskFilter(30, BlurMaskFilter.Blur.OUTER));
        canvas.drawRect(rectF, paint);
        canvas.drawText("OUTER", 0, 250, paint);
    }

    private void drawBlurMaskFilterInner(Canvas canvas) {
        canvas.translate(200, 0);
        paint.setMaskFilter(new BlurMaskFilter(30, BlurMaskFilter.Blur.INNER));
        canvas.drawRect(rectF, paint);
        canvas.drawText("INNER", 0, 250, paint);
    }
}
