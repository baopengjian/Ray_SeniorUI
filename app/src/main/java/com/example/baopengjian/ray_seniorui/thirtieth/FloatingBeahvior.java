package com.example.baopengjian.ray_seniorui.thirtieth;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Ray on 2019-12-20.
 */
public class FloatingBeahvior extends FloatingActionButton.Behavior {

    private boolean isAnimate = false;
    //加速器
    private static final FastOutSlowInInterpolator FASTOUTSLOWININTERPOLATOR = new FastOutSlowInInterpolator();

    /**
     * 写构造方法   不写奔溃
     */
    public FloatingBeahvior(Context context, AttributeSet set) {
        super();
    }


    /**
     * 关心  滑动横轴
     *
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        // 当观察的view(RecyclerView)发生滑动开始的时候回调
        //nestedScrollAxes:滑动关联轴---我们这里只关心垂直滑动
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (dyConsumed > 0) {
            animationOut(child);
        } else {
            animationIn(child);
        }
    }

    private void animationIn(FloatingActionButton child) {
        ViewCompat.animate(child)
                .scaleX(1.0f)
                .scaleY(1.0f)
                .alpha(1.0f)
                .setListener(null)
                .setInterpolator(FASTOUTSLOWININTERPOLATOR)
                .start();
    }


    private void animationOut(FloatingActionButton child) {
        ViewCompat.animate(child)
                .scaleX(0.0f)
                .scaleY(0.0f)
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {
                        isAnimate = true;
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        isAnimate = false;
                    }

                    @Override
                    public void onAnimationCancel(View view) {
                        isAnimate = false;
                    }
                }).start();
    }


}
