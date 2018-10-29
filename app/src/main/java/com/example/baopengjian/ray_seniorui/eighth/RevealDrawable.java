package com.example.baopengjian.ray_seniorui.eighth;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;

/**
 * Created by Ray on 2018/10/9.
 */
public class RevealDrawable extends Drawable {

    private Drawable mUnselectedDrawable;
    private Drawable mSelectedDrawable;
    private final Rect mTmpRect = new Rect();
    private int mOrientation;
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;

    public RevealDrawable(Drawable mUnselected, Drawable selected, int orientation) {
        mUnselectedDrawable = mUnselected;
        mSelectedDrawable = selected;
        mOrientation = orientation;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        //绘制
        int level = getLevel();//from 0 (minimun) to 10000
        //三个区间
        //右边区间和左边区间--设置成灰色
        if (level == 10000 || level == 0) {
            mUnselectedDrawable.draw(canvas);
        } else if (level == 5000) {
            //全部选中--设置成彩色
            mSelectedDrawable.draw(canvas);
        } else {
            //混合效果的Drawable
            //将画板分割成两块- 左和右
            final Rect r = mTmpRect;
            //得到当前自身Drawable的矩形局域
            Rect bounds = getBounds();
            //level 0~~5000~10000
            //比例
            float ratio = (level / 5000f) - 1f;
            {
                //1.先绘制灰色部分

                int w = bounds.width();
                if (mOrientation == HORIZONTAL) {
                    w = (int) (w * Math.abs(ratio));
                }
                int h = bounds.height();
                if (mOrientation == VERTICAL) {
                    h = (int) (h * Math.abs(ratio));
                }

                int gravity = ratio < 0 ? Gravity.LEFT : Gravity.RIGHT;
                //从已有的bounds矩形局域中抠出一个矩形r
                Gravity.apply(
                        gravity //从左边还是右边
                        , w //目标矩形的宽
                        , h //目标矩形的高
                        , bounds
                        , r);
                canvas.save();
                //切割、绘制、恢复画布
                canvas.clipRect(r);
                mUnselectedDrawable.draw(canvas);
                canvas.restore();
            }

            {
                //2.绘制彩色部分
                int w = bounds.width();
                if(mOrientation == HORIZONTAL){
                    w -= (int)(w*Math.abs(ratio));
                }
                int h = bounds.height();
                if(mOrientation == VERTICAL){
                    h -= (int)(h*Math.abs(ratio));
                }

                int gravity = ratio < 0 ? Gravity.RIGHT:Gravity.LEFT;
                Gravity.apply(
                        gravity,
                        w,
                        h,
                        bounds,
                        r
                );
                canvas.save();
                canvas.clipRect(r);
                mSelectedDrawable.draw(canvas);
            }
        }

    }

    @Override
    protected boolean onLevelChange(int level) {
        invalidateSelf();
        return true;
    }

    @Override
    public int getIntrinsicHeight() {
        return Math.max(mSelectedDrawable.getIntrinsicHeight(), mUnselectedDrawable.getIntrinsicHeight());
    }

    @Override
    public int getIntrinsicWidth() {
        return Math.max(mSelectedDrawable.getIntrinsicWidth(), mUnselectedDrawable.getIntrinsicWidth());
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        mUnselectedDrawable.setBounds(bounds);
        mSelectedDrawable.setBounds(bounds);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
