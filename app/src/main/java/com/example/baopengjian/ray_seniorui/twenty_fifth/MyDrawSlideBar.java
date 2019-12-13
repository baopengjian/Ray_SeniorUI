package com.example.baopengjian.ray_seniorui.twenty_fifth;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.baopengjian.ray_seniorui.R;

/**
 */

public class MyDrawSlideBar  extends LinearLayout {
    private boolean opened;
    float maxTranslationX;
    public MyDrawSlideBar(Context context) {
        super(context);
    }

    public MyDrawSlideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }
    private void init(AttributeSet attrs) {
        setOrientation(VERTICAL);
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SideBar);
            maxTranslationX = a.getDimension(R.styleable.SideBar_maxTranslationX, 0);
            a.recycle();
        }
    }
    void setTouchY(float y, float percent) {
        //opened  判定   执行百分比 等于 1   时  为完全打开
        opened = percent == 1;
        Log.i("tuch", "-------------------------------------");
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            child.setPressed(false);
            boolean inHover = opened && child.getTop() < y && child.getBottom() > y;
            if (inHover) {
                child.setPressed(true);
            }
            apply((ViewGroup) getParent(), child, y, percent);
        }

    }

    void onMotionEventUp() {
        for (int i = 0; opened && i < getChildCount(); i++) {

            View child = getChildAt(i);
            if (child.isPressed()) {
                child.performClick();
                return;
            }
        }
    }


    public void apply(ViewGroup MyDrawSlideBar, View itemView, float touchY, float slideOffset) {
        float translationX=0;
        int centerY = itemView.getTop() + itemView.getHeight() / 2;
        float distance = Math.abs(touchY - centerY);
        float scale = distance / MyDrawSlideBar.getHeight()*3 ; // 距离中心点距离与 MyDrawSlideBar 的 1/3 对比
        translationX =   maxTranslationX - scale * maxTranslationX ;
        Log.i("tuch","maxTranslationX  "+maxTranslationX+"   touchY  "+ touchY+"   slideOffset  "+ slideOffset + "   偏移量  " + translationX * slideOffset);
        itemView.setTranslationX(translationX * slideOffset);
    }
}