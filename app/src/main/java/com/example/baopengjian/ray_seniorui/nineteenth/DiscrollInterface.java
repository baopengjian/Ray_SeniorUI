package com.example.baopengjian.ray_seniorui.nineteenth;

/**
 * Created by ricky on 2017/6/16.
 */

public interface DiscrollInterface {
    /**
     * 当滑动的时候调用该方法，用来控制里面的控件执行相应的动画
     * @param ratio 动画执行的百分比（child view画出来的距离百分比）
     */
    public void onDiscroll(float ratio);

    /**
     * 重置动画--让view所有的属性都恢复到原来的样子
     */
    public void onResetDiscroll();
}
