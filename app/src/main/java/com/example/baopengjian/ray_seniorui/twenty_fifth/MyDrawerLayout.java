package com.example.baopengjian.ray_seniorui.twenty_fifth;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 */

public class MyDrawerLayout extends DrawerLayout  implements DrawerLayout.DrawerListener {
    //背景 自定义控件
    private MyDrawBgRealativeLayout myDrawBgRealativeLayout;

    //含有 布局内容的 Linealayout自定义控件
    private MyDrawSlideBar myDrawSlideBar;
    private  float y;

    private float slideOffset;
    //内容区域
    private  View contenView;
    public MyDrawerLayout(Context context) {
        super(context);
    }

    public MyDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initChild();

    }

    private void initChild() {
        for(int i=0;i<getChildCount();i++) {
            View view = getChildAt(i);
            if (view instanceof MyDrawSlideBar) {
                myDrawSlideBar= (MyDrawSlideBar) view;
                break;
            }else {
                contenView=view;
            }
        }
        //移除子控件   因为不符合我们的需求
        removeView(myDrawSlideBar);
        myDrawBgRealativeLayout = new MyDrawBgRealativeLayout(myDrawSlideBar);
        addView(myDrawBgRealativeLayout);
        addDrawerListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_UP) {
            closeDrawers();
            myDrawBgRealativeLayout.onMotionEventUp();
            return super.dispatchTouchEvent(ev);
        }
        y=ev.getY();

        if (slideOffset < 1) {
            super.dispatchTouchEvent(ev);
        }else if(ev.getAction() == MotionEvent.ACTION_MOVE) {
            //当大于1时   内容区域不做偏移  只是把背景贝塞尔曲线进行变化  拦截后  DrawerLayout.DrawerListener 不再起作用  因为内容不做偏移
            myDrawBgRealativeLayout.setTouch(y,slideOffset);
        }
        return true;
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        this.slideOffset = slideOffset;
        myDrawBgRealativeLayout.setTouch(y,slideOffset);
        float contentViewoffset=drawerView.getWidth()*slideOffset/2;
        contenView.setTranslationX(contentViewoffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

}
