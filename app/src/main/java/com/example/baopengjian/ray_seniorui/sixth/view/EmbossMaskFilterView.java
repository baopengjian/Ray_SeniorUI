package com.example.baopengjian.ray_seniorui.sixth.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Ray on 2018/7/18.
 *   paint.setMaskFilter(new EmbossMaskFilter(direction,ambient,specular,blurRadius)
 *  direction  指定光源的位置，长度为xxx的数组标量[x,y,z]
 *  ambient    环境光的因子 （0~1），越接近0，环境光越暗
 *  specular   镜面反射系数 越接近0，镜面反射越强
 *  blurRadius 模糊半径 值越大，模糊效果越明显
 */
public class EmbossMaskFilterView extends View {

    public EmbossMaskFilterView(Context context) {
        this(context,null);
    }

    public EmbossMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public EmbossMaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }
}
