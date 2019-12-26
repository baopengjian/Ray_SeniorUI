package com.example.baopengjian.ray_seniorui.thirtieth_third.widge;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Ray on 2019-12-26.
 */
public class ASpecImageView extends ImageView {

    public ASpecImageView(Context context) {
        super(context);
    }

    public ASpecImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ASpecImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredSizeWidth;
        float aspect;

        Drawable d = getDrawable();
        if (d == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        desiredSizeWidth = d.getIntrinsicWidth();
        aspect = (float) d.getIntrinsicWidth() / (float) d.getIntrinsicHeight();

        int widthsSize = View.resolveSize(desiredSizeWidth, widthMeasureSpec);

        int heightSize = (int) (widthsSize/ aspect);
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        if (specMode == MeasureSpec.AT_MOST || specMode == MeasureSpec.EXACTLY) {
            if (heightSize > specSize) {
                heightSize = specSize;
                widthsSize = (int) (heightSize * aspect);
            }
        }
        setMeasuredDimension(widthsSize, heightSize);
    }
}
