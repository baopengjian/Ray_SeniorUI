package com.example.baopengjian.ray_seniorui.seventh;

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
 */
public class RegionView extends View {

    Paint paint;

    public RegionView(Context context) {
        this(context,null);
    }

    public RegionView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RegionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        //paint.setStyle(Paint.Style.FILL);
        paint.setStyle(Paint.Style.STROKE);

        paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        RectF r = new RectF(100, 100, 600, 800);
        Path path = new Path();
        path.addOval(r, Path.Direction.CCW);

        //创建一块矩形的区域
        Region region = new Region(100, 100, 600, 800);
       // Region region1 = new Region();
        //region1.setPath(path, region);//path的椭圆区域和矩形区域进行交集

        //结合区域迭代器使用（得到图形里面的所有的矩形区域）
        RegionIterator iterator = new RegionIterator(region);

        Rect rect = new Rect();
        while (iterator.next(rect)) {
            canvas.drawRect(rect, paint);
        }

    }
}
