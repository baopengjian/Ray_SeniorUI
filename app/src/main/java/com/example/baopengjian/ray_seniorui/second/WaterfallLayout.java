package com.example.baopengjian.ray_seniorui.second;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ray on 2018/5/3 .
 * （1）自定义控件继承ViewGroup
 *  (2) onMesure确定宽高，并记录每列高度
 * （3）定义一个Param，onMesure时记录每个child的位置
 * （4）onLayout中获取Param，设置每个child的位置
 */

public class WaterfallLayout extends ViewGroup {

    private int mColumns = 3;
    private int mTop[];
    private int mChildWidth = 0;
    private int mHorizontalSpace = 20;
    private int mVerticalSpace = 20;
    private int maxHeight;


    public WaterfallLayout(Context context) {
        this(context, null);
    }

    public WaterfallLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaterfallLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTop = new int[mColumns];
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //得到总宽度
        int measureWidth = 0;
        int measureHeight = 0;

        if (widthMode == MeasureSpec.EXACTLY) {
            measureWidth = widthSize;
            measureHeight = heightSize;
        } else {
            measureChildren(widthMeasureSpec, heightMeasureSpec);

            //得到单个Item的宽度
            mChildWidth = (widthSize - (mColumns - 1) * mHorizontalSpace) / mColumns;

            int childCount = getChildCount();
            if (childCount < mColumns) {
                measureWidth = childCount * mChildWidth + (childCount - 1) * mHorizontalSpace;
            } else {
                measureWidth = widthSize;
            }

            clearTop();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                int childHeight = child.getMeasuredHeight() * mChildWidth / child.getMeasuredWidth();
                int minColum = getMinHeightColum();

                WaterfallLayoutParams lParams = (WaterfallLayoutParams) child.getLayoutParams();
                lParams.left = minColum * (mChildWidth + mHorizontalSpace);
                lParams.top = mTop[minColum];
                lParams.right = lParams.left + mChildWidth;
                lParams.bottom = lParams.top + childHeight;
                mTop[minColum] += mVerticalSpace + childHeight;
            }
            measureHeight = getMaxHeight();
        }

        setMeasuredDimension(measureWidth, measureHeight);
    }

    private int getMinHeightColum() {
        int minColum = 0;
        for (int i = 0; i < mColumns; i++) {
            if (mTop[i] < mTop[minColum]) {
                minColum = i;
            }
        }
        return minColum;
    }

    private void clearTop() {
        for (int i = 0; i < mColumns; i++) {
            mTop[i] = 0;
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        clearTop();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            WaterfallLayoutParams params = (WaterfallLayoutParams) child.getLayoutParams();
            child.layout(params.left, params.top, params.right, params.bottom);
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new WaterfallLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new WaterfallLayoutParams(WaterfallLayoutParams.WRAP_CONTENT, WaterfallLayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new WaterfallLayoutParams(p);
    }

    public int getMaxHeight() {
        int maxHeight = 0;
        for (int i = 0; i < mColumns; i++) {
            if (mTop[i] > maxHeight) {
                maxHeight = mTop[i];
            }
        }

        return maxHeight;
    }

    public void setOnItemClickListener(final OnItemClickListener listener) {
        for (int i = 0; i < getChildCount(); i++) {
            final int index = i;
            View view = getChildAt(i);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v,index);
                }
            });
        }
    }

    @Override
    protected boolean checkLayoutParams(LayoutParams p) {
        return p instanceof WaterfallLayoutParams;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int index);
    }

    public static class WaterfallLayoutParams extends LayoutParams {

        public int left, top, right, bottom;

        public WaterfallLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public WaterfallLayoutParams(int width, int height) {
            super(width, height);
        }

        public WaterfallLayoutParams(LayoutParams source) {
            super(source);
        }
    }
}
