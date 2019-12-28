
package com.example.baopengjian.ray_seniorui.thirtieth_fourth;


import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class CollisionView extends FrameLayout{
    private JboxImpl jboxImpl;
    public CollisionView(@NonNull Context context) {
        this(context,null);
    }

    public CollisionView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CollisionView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        initView();
    }

    private void initView() {
        jboxImpl = new JboxImpl(getResources().getDisplayMetrics().density);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        jboxImpl.setWorlSize(w,h);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        jboxImpl.createWorld();
        //子viwe创建tag 设置body
        int childCount = getChildCount();
        for (int i =0; i< childCount; i++) {
            View view = getChildAt(i);
            if (!jboxImpl.isBodyView(view) || changed) {
                jboxImpl.creatBody(view);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        jboxImpl.startWorld();
        int childCount = getChildCount();
        for (int i =0; i< childCount; i++) {
            View view = getChildAt(i);
            if (jboxImpl.isBodyView(view)) {
               view.setX(jboxImpl.getViewX(view));
                view.setY(jboxImpl.getViewY(view));
                view.setRotation(jboxImpl.getViewRotaion(view));
            }
        }
        invalidate();
    }

    public void onSensorChanged(float x, float y) {
        int childCount = getChildCount();
        for (int i =0; i< childCount; i++) {
            View view = getChildAt(i);
            if (jboxImpl.isBodyView(view)) {
                jboxImpl.applyLinearImpulse(x,y,view);
            }
        }
    }
}
