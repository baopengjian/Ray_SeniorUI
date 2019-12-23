package com.example.baopengjian.ray_seniorui.thirty_first;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.example.baopengjian.ray_seniorui.thirty_first.design.Behavior;

/**
 * Created by Ray on 2019-12-23.
 */
public class ToolBarBehavior extends Behavior {

    private int maxHeight = 400;

    public ToolBarBehavior(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override
    public void onNestedScroll(View scrollView, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(scrollView, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if(scrollView.getScaleY() <= maxHeight){
            ViewCompat.setAlpha(target,scrollView.getScrollY()*1.0f/maxHeight);
        }else if (scrollView.getScrollY() == 0) {
            ViewCompat.setAlpha(target,0);
        }
    }
}
