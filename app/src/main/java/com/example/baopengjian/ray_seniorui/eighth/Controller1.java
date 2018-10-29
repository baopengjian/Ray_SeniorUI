package com.example.baopengjian.ray_seniorui.eighth;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

/**
 * Created by Ray on 2018/10/29.
 */
public class Controller1 extends BaseController {

    private static final String TAG = "Controller1";

    private String mColor = "#4CAF50";

    private int mCircleX;

    private int mCircleY;

    private int mRadius;

    private RectF mRectF;

    private int mDeltaD = 15;

    public Controller1() {
        mRectF = new RectF();
    }

    @Override
    public void draw(Canvas canvas, Paint mPaint) {
        canvas.drawColor(Color.parseColor(mColor));
        switch (mState) {
            case STATE_ANIM_NONE:
                drawNormalView(mPaint, canvas);
                break;
            case STATE_ANIM_START:
                drawStartAnimView(mPaint, canvas);
                break;
            case STATE_ANIM_STOP:
                drawNormalView(mPaint, canvas);
                break;
        }
    }

    //			canvas.drawArc(
    //			r,
    //			startAngle, //起始角度，相对X轴正方向
    //			sweepAngle, //画多少角度的弧度
    //			useCenter, //boolean, false：只有一个纯弧线；true：闭合的边
    //			paint)；
    private void drawStartAnimView(Paint mPaint, Canvas canvas) {
        canvas.save();
        //0~1
        if (mpro < 0.5f) {
            /**
             * -360 ~ 0 需要变换的范围
             * 	 0  ~ 0.5 mpro实际的变化范围
             * 转换公式：360*(mpro*2-1),
             */
            //绘制圆和把手
            float sweepAngle = 360 * (mpro * 2 - 1);
            canvas.drawArc(
                    mRectF,
                    45,
                    sweepAngle,
                    false,
                    mPaint
            );

            canvas.save();
            float circleX = mRectF.left + mRadius;
            float circleY = mRectF.top + mRadius;
            canvas.rotate(45, circleX, circleY);
            canvas.drawLine(circleX + mRadius - mPaint.getStrokeWidth() / 2, circleY, circleX + mRadius * 2, circleY, mPaint);
        } else {
            /**
             *   0    ~ 1 需要变换的范围
             * 	 0.5  ~ 1 mpro实际的变化范围
             * 转换公式：(mpro*2-1),
             */
            canvas.save();
            float circleX = mRectF.left + mRadius;
            float circleY = mRectF.top + mRadius;
            canvas.rotate(45, circleX, circleY);
            canvas.drawLine(circleX + mRadius - mPaint.getStrokeWidth() / 2 + mRadius * (mpro * 2 - 1), circleY, circleX + mRadius * 2, circleY, mPaint);
        }

        canvas.rotate(-45, mRectF.left + 3 * mRadius, mRectF.top + mRadius);
        //绘制下面的横线
        canvas.drawLine(
                mRectF.left + 3 * mRadius,
                mRectF.top + mRadius,
                mRectF.left + 3 * mRadius - mpro * 250,
                mRectF.top + mRadius,
                mPaint
        );
        canvas.restore();

        mRectF.left = mCircleX - mRadius + mpro * 250;
        mRectF.right = mCircleX + mRadius + mpro * 250;

    }

    /**
     * 画只有搜索标识的情况
     *
     * @param mPaint
     * @param canvas
     */
    private void drawNormalView(Paint mPaint, Canvas canvas) {
        mRadius = getWidth() / 20;
        Log.d(TAG, "mRadius = " + mRadius);
        mCircleX = getWidth() / 2;
        mCircleY = getHeight() / 2;

        mRectF.left = mCircleX - mRadius;
        mRectF.right = mCircleX + mRadius;
        mRectF.top = mCircleY - mRadius;
        mRectF.bottom = mCircleY + mRadius;


        canvas.save();
        mPaint.reset();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);

        canvas.rotate(45, mCircleX, mCircleY);
        canvas.drawLine(mCircleX + mRadius
                , mCircleY
                , mCircleX + mRadius * 2
                , mCircleY
                , mPaint);
        canvas.drawArc(
                mRectF,
                0,
                360,
                false,
                mPaint
        );
        canvas.restore();
    }

    @Override
    public void startAnim() {
        super.startAnim();
        mState = STATE_ANIM_START;
        startViewAnimation();
    }

    @Override
    public void resetAnim() {
        super.resetAnim();
        mState = STATE_ANIM_STOP;
        mpro = 0;
        searchView.invalidate();
    }
}
