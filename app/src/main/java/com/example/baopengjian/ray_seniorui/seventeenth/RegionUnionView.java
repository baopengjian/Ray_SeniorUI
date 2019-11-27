package com.example.baopengjian.ray_seniorui.seventeenth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

import com.example.baopengjian.ray_seniorui.utils.UtilsDensity;

/**
 * region.union
 */

public class RegionUnionView extends View {

    private Bitmap mBitmap = null;

    private static final boolean HIDE = false;//隐藏图片

    public RegionUnionView(Context context) {
        this(context, null);
    }

    public RegionUnionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RegionUnionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);

        Rect rect1 = new Rect(100,25,150,175);
        Rect rect2 = new Rect(25,75,200,125);
        canvas.drawRect(rect1,paint);
        canvas.drawRect(rect2,paint);

        canvas.translate(0,200);
        paint.setTextSize(UtilsDensity.dip2px(13));
        canvas.drawText("region.op(region1,region2, Region.Op.XOR)结果：",60,100,paint);
        canvas.translate(0,100);
        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        Region region = new Region();
        region.op(region1,region2, Region.Op.XOR);

        RegionIterator iterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (iterator.next(rect)){
            canvas.drawRect(rect,paint);
        }
    }
}
