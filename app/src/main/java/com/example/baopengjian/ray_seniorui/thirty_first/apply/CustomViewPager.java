package com.example.baopengjian.ray_seniorui.thirty_first.apply;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Ray on 2020-1-2.
 */
public class CustomViewPager extends ViewPager {

    private float mDownY;
    private float mDownX;

    public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean touch = super.onTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownY = ev.getY();
                mDownX = ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                //左右滑动
                if (Math.abs(ev.getY() - mDownY) - Math.abs(ev.getX() - mDownX) > 0) {
                    touch = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return touch;
    }
}
