package com.example.baopengjian.ray_seniorui.twenty_second;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Ray on 2019-12-4.
 */
public class FeedRootRecyclerView extends BetterRecyclerView {
    public FeedRootRecyclerView(Context context) {
        this(context,null);
    }

    public FeedRootRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeedRootRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //这个接口的作用是不允许父类打断这个onTouch 事件，
    //那么我设置一个空的函数，override 父类的方法，就可以达到相反的效果
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }
}
