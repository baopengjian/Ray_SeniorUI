package com.example.baopengjian.ray_seniorui.twenty_fifth;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/6/29.
 */

public class MyDrawBgRealativeLayout extends RelativeLayout {

    private MyDrawSlideBar myDrawSlideBar;
    private MyDrawBgView myDrawBgView;


    public MyDrawBgRealativeLayout(MyDrawSlideBar myDrawSlideBar) {
        super(myDrawSlideBar.getContext() );
        init(myDrawSlideBar);
    }

    private void init(MyDrawSlideBar myDrawSlideBar) {
        //转移宽高属性
        setLayoutParams(myDrawSlideBar.getLayoutParams());
        int parentLayoutGravity = ((DrawerLayout.LayoutParams) getLayoutParams()).gravity;

        this.myDrawSlideBar=myDrawSlideBar;

        //子控件 是否居中
        myDrawBgView = new MyDrawBgView(getContext());
        addView( myDrawBgView, 0, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        //添加滑动内容区域
        myDrawBgView.setColor(myDrawSlideBar.getBackground());
        myDrawSlideBar.setBackgroundColor(Color.TRANSPARENT);
        addView(myDrawSlideBar, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }


    public void setTouch(float y, float offset) {
        //背景做贝塞尔曲线
        myDrawBgView.setTouchY(y,offset);
        myDrawSlideBar.setTouchY(y,offset);
    }

    public void onMotionEventUp() {
        myDrawSlideBar.onMotionEventUp();
    }
}
