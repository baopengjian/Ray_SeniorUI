package com.example.baopengjian.ray_seniorui.eighth;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;

/**
 * Created by Ray on 2018/10/29.
 */
public abstract class BaseController {

    public static final int STATE_ANIM_NONE = 0;
    public static final int STATE_ANIM_START = 1;
    public static final int STATE_ANIM_STOP = 2;
    public static final int DEFAULT_ANIM_TIME = 1000;

    public SearchView searchView;
    public int mState = STATE_ANIM_NONE;
    public float mpro = -1;

    public void setSearchView(SearchView searchView) {
        this.searchView = searchView;
    }

    public abstract void draw(Canvas canvas, Paint mPaint);

    public void startAnim() {

    }

    public void resetAnim() {

    }

    public int getWidth() {
        return searchView.getWidth();
    }

    public int getHeight() {
        return searchView.getHeight();
    }

    public ValueAnimator startViewAnimation() {

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(DEFAULT_ANIM_TIME);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mpro = (float) animation.getAnimatedValue();
                searchView.invalidate();
            }
        });

        valueAnimator.start();
        mpro = 0;
        return valueAnimator;

    }
}
