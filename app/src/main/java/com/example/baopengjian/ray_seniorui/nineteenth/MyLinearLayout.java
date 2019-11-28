package com.example.baopengjian.ray_seniorui.nineteenth;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.baopengjian.ray_seniorui.R;

/**
 */

public class MyLinearLayout extends LinearLayout {
    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        //采花大盗---把我需要的自定义属性获取出来给自己用。
        return new MyLayoutParams(getContext(),attrs);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        MyLayoutParams p = (MyLayoutParams) params;
        if(!isDiscrollvable(p)){//判断是否有自定义属性，没有则不包裹一层容器
            super.addView(child,params);
        }else {
            //偷天换日
            MyFrameLayout mf = new MyFrameLayout(getContext());
            mf.addView(child);
            mf.setmDiscrollveAlpha(p.mDiscrollveAlpha);
            mf.setmDiscrollveFromBgColor(p.mDiscrollveFromBgColor);
            mf.setmDiscrollveToBgColor(p.mDiscrollveToBgColor);
            mf.setmDiscrollveScaleX(p.mDiscrollveScaleX);
            mf.setmDisCrollveTranslation(p.mDisCrollveTranslation);
            super.addView(mf, params);
        }
    }

    private boolean isDiscrollvable(MyLayoutParams p){
        return p.mDiscrollveAlpha||
                p.mDiscrollveScaleX||
                p.mDiscrollveScaleY||
                p.mDisCrollveTranslation!=-1||
                (p.mDiscrollveFromBgColor!=-1&&
                        p.mDiscrollveToBgColor!=-1);
    }

    public class MyLayoutParams extends LayoutParams{
        public int mDiscrollveFromBgColor;//背景颜色变化开始值
        public int mDiscrollveToBgColor;//背景颜色变化结束值
        public boolean mDiscrollveAlpha;//是否需要透明度动画
        public int mDisCrollveTranslation;//平移值
        public boolean mDiscrollveScaleX;//是否需要x轴方向缩放
        public boolean mDiscrollveScaleY;//是否需要y轴方向缩放

        public MyLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            //解析attrs得到自定义的属性，保存
            TypedArray a = getContext().obtainStyledAttributes(attrs,R.styleable.DiscrollView_LayoutParams);
            mDiscrollveAlpha = a.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_alpha, false);
            mDiscrollveScaleX = a.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_scaleX, false);
            mDiscrollveScaleY = a.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_scaleY, false);
            mDisCrollveTranslation = a.getInt(R.styleable.DiscrollView_LayoutParams_discrollve_translation, -1);
            mDiscrollveFromBgColor = a.getColor(R.styleable.DiscrollView_LayoutParams_discrollve_fromBgColor, -1);
            mDiscrollveToBgColor = a.getColor(R.styleable.DiscrollView_LayoutParams_discrollve_toBgColor, -1);
            a.recycle();
        }
    }

}


