package com.example.baopengjian.ray_seniorui.seventeenth;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Ray on 2018/7/26.
 * Region：通过RegionIterator绘制
 * 将区域分割成一个个的矩形，然后去画图
 */
public class RegionView extends View {

    Paint paint;

    public RegionView(Context context) {
        this(context, null);
    }

    public RegionView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RegionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        RectF r = new RectF(100, 100, 400, 500);
        Path path = new Path();
        float radii[] = {10, 10, 10, 10, 10, 10, 50, 60};
        path.addRoundRect(r, radii, Path.Direction.CCW);

        Region region = new Region(100, 100, 400, 500);
        Region region1 = new Region();
        region1.setPath(path, region);

        //结合区域迭代器使用（得到图形里面的所有的矩形区域）
        RegionIterator iterator = new RegionIterator(region1);
        Rect rect = new Rect();
        while (iterator.next(rect)) {
            canvas.drawRect(rect, paint);
        }

    }
}
