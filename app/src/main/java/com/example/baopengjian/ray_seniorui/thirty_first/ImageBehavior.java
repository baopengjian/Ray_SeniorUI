package com.example.baopengjian.ray_seniorui.thirty_first;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.baopengjian.ray_seniorui.thirty_first.design.Behavior;

/**
 * Created by Ray on 2019-12-23.
 */
public class ImageBehavior extends Behavior {

    private static final String TAG = "tuch";
    private int maxHeight =100;
    private int originHeight;

    public ImageBehavior(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override
    public void onLayoutFinish(View parent, View child) {
        super.onLayoutFinish(parent, child);
        if (originHeight == 0) {
            originHeight = child.getHeight();
        }
    }

    @Override
    public void onNestedScroll(View scrollView, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (scrollView.getScrollY() > 0) {
            ViewGroup.LayoutParams params = target.getLayoutParams();
            params.height = params.height - Math.abs(scrollView.getScrollY());
            if (params.height < maxHeight) {
                params.height = maxHeight;
            }
            target.setLayoutParams(params);
        } else if (scrollView.getScrollY() == 0) {
            ViewGroup.LayoutParams params = target.getLayoutParams();
            params.height = params.height+Math.abs(dyUnconsumed);
            if(params.height >= originHeight){
                params.height = originHeight;
            }

            target.setLayoutParams(params);
        }
    }
}
