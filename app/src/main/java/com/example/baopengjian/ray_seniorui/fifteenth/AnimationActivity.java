package com.example.baopengjian.ray_seniorui.fifteenth;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-11-24.
 * 动画基础
 */
public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int[] IDS = {R.id.iv_1, R.id.iv_2, R.id.iv_3, R.id.iv_4, R.id.iv_5, R.id.iv_6,R.id.iv_7,R.id.iv_8};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_acitivity);

        for (int i = 0; i < IDS.length; i++) {
            findViewById(IDS[i]).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_1:
                animationUitls(v);
                break;
            case R.id.iv_2:
                setTranslationX(v);
                break;
            case R.id.iv_3:
                objectAnimator(v);
                break;
            case R.id.iv_4:
                animatorUpdateListener(v);
                break;
            case R.id.iv_5:
                propertyValuesHolder(v);
                break;
            case R.id.iv_6:
                animationSet(v);
                break;
            case R.id.iv_7:
                drop(v);
                break;
            case R.id.iv_8:
                interpolater(v);
                break;
        }
    }

    private void interpolater(View v) {
        ObjectAnimator oa = ObjectAnimator.ofFloat(v, "translationY", 0f,1000f);
        oa.setDuration(3000);

//		TimeInterpolator
//		oa.setInterpolator(new AccelerateInterpolator(1));
//		oa.setInterpolator(new AccelerateDecelerateInterpolator());
//		oa.setInterpolator(new BounceInterpolator());
//		oa.setInterpolator(new AnticipateInterpolator());
        oa.setInterpolator(new CycleInterpolator(5));
        oa.start();
    }

    private void drop(final View v) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(2000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        final PointF pointF = new PointF();

        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {

            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue) {
                // 估值计算方法---可以在执行的过程当中干预改变属性的值---做效果：用自己的算法来控制
                //不断地去计算修改坐标
                //x匀速运动 x=v*t 为了看起来效果好我让t变成fraction*5
                pointF.x = 100f*(fraction*5);
                //加速度 y=vt=1/2*g*t*t
//				pointF.y = 0.5f*9.8f*(fraction*5)*(fraction*5);
                pointF.y = 6f*0.5f*9.8f*(fraction*5)*(fraction*5);
                return pointF;
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF f = (PointF) animation.getAnimatedValue();
                v.setX(f.x);
                v.setY(f.y);
            }

        });
        valueAnimator.start();

    }

    private void animationSet(View iv) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv, "translationX", 0f, 100f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(iv, "alpha", 0.1f, 1f);
//		animator2.setStartDelay(startDelay)//设置延迟执行
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(iv, "scaleX", 0.5f, 2f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        //animator1在后面
        animatorSet.play(animator3).with(animator2).before(animator1);
//animatorSet.playTogether(animator1,animator2,animator3);
//animatorSet.playSequentially(animator1,animator2,animator3);
        animatorSet.start();
    }

    private void propertyValuesHolder(View iv) {
        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("alpha", 1f, 0.5f);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.5f);
        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.5f);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv, holder1, holder2, holder3);
        animator.setDuration(200);
        animator.start();
    }

    private void animatorUpdateListener(final View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(v, "hehe", 0f, 100f);
        animator.setDuration(300);
        // 监听动画回调
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //执行动画的百分比：0-1，API 12+
                //animation.getAnimatedFraction();
                float value = (float) animation.getAnimatedValue();
                //得到0f~100f当中的这个时间点对应的值
                v.setScaleX(0.5f + value / 200);
                v.setScaleY(0.5f + value / 200);
                v.setTranslationX(value);
            }
        });
        animator.setRepeatCount(ValueAnimator.REVERSE);
        animator.start();
//		animator.setRepeatCount(2);
//		animator.setRepeatMode(ValueAnimator.RESTART);
//		animator.setRepeatMode(ValueAnimator.INFINITE.)
    }

    private void objectAnimator(View v) {
        ObjectAnimator oa = ObjectAnimator.ofInt(v, "backgroundColor", Color.RED, Color.BLUE);
        oa.setDuration(500);
        oa.start();
    }


    private void animationUitls(View v) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.left_in);
        v.startAnimation(animation);
    }

    int i = 0;

    public void setTranslationX(View view) {
        view.setTranslationX(50 + i * 50);
        i++;
    }
}
