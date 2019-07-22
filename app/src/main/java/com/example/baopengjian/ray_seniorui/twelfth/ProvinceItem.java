package com.example.baopengjian.ray_seniorui.twelfth;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.Log;

/**
 * Created by Ray on 2019-7-22.
 */
public class ProvinceItem {

    private Path path;

    private int drawColor;

    public ProvinceItem(Path path) {
        this.path = path;
    }

    public void draw(Canvas canvas, Paint paint, boolean isSelect) {
        if (isSelect) {
            paint.setStrokeWidth(2);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.FILL);
            paint.setShadowLayer(8, 0, 0,0xFFFFFFFF);
            canvas.drawPath(path, paint);

           paint.clearShadowLayer();
            paint.setColor(drawColor);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(2);
            canvas.drawPath(path, paint);
        } else {
            paint.clearShadowLayer();
            paint.setStrokeWidth(1);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(drawColor);
            canvas.drawPath(path, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(0xffD0E8F4);
            canvas.drawPath(path, paint);
        }
    }

    public boolean isTouch(int x, int y) {
        RectF rect = new RectF();
        path.computeBounds(rect, true);
        Region region = new Region();
        region.setPath(path, new Region((int) rect.left, (int) rect.top, (int) rect.right, (int) rect.bottom));
        boolean result = region.contains(x, y);

        Log.i("ProvinceItem", "isTouch x="+ result );
        return result;
    }

    public int getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(int drawColor) {
        this.drawColor = drawColor;
    }
}
