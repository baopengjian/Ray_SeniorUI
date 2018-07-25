package com.example.baopengjian.ray_seniorui.sixth.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2018/7/18.
 */
public class PorterDuffColorFilterView extends View {


    Paint paint;

    Bitmap bitmap;

    private int progress;

    public PorterDuffColorFilterView(Context context) {
        super(context);
        init();
    }

    public PorterDuffColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PorterDuffColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xyjy2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        paint.reset();
        paint.setColor(Color.RED);

        RectF rectF = new RectF(50, 50, bitmap.getWidth(), bitmap.getHeight());
        paint.setColorFilter(new PorterDuffColorFilter(Color.argb(255,140,90,200), PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(bitmap, null, rectF, paint);
    }
}
