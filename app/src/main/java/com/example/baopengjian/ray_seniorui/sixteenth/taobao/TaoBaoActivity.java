package com.example.baopengjian.ray_seniorui.sixteenth.taobao;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-11-26.
 */
public class TaoBaoActivity extends AppCompatActivity {


    private View first_view;
    private View second_view;
    private Button bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tao_bao_activity);

        first_view = findViewById(R.id.first);
        second_view = findViewById(R.id.second);

        bt = (Button) findViewById(R.id.bt);
    }

    public void startFirstAnim(View v){
        //显示first_view：1.透明度动画；2.缩放动画；3.翻转动画
        //透明度动画
        ObjectAnimator firstAlphaAnim = ObjectAnimator.ofFloat(first_view, "alpha", 1.0f, 0.7f);
        firstAlphaAnim.setDuration(300);
        //旋转动画1
        ObjectAnimator firstRotationXanim = ObjectAnimator.ofFloat(first_view, "rotationX", 0f,20f);
        firstRotationXanim.setDuration(300);
        //再旋转回来
        ObjectAnimator firstResumeRotationXanim = ObjectAnimator.ofFloat(first_view, "rotationX", 20f, 0f);
        firstResumeRotationXanim.setDuration(300);
        firstResumeRotationXanim.setStartDelay(300);//延迟第一次旋转动画的时间，在这之后再执行

        //缩放动画
        ObjectAnimator firstScaleXAnim = ObjectAnimator.ofFloat(first_view, "ScaleX", 1.0f, 0.8f);
        firstScaleXAnim.setDuration(300);
        ObjectAnimator firstScaleYAnim = ObjectAnimator.ofFloat(first_view, "ScaleY", 1.0f, 0.8f);
        firstScaleYAnim.setDuration(300);

        //由于缩放造成离顶部有一个距离，需要平移
        ObjectAnimator firstTranslationYAnim = ObjectAnimator.ofFloat(first_view, "translationY", 0f, -0.1f*first_view.getHeight());
        firstTranslationYAnim.setDuration(300);

        //第二个view和第一个view动画同时开始执行
        ObjectAnimator secondTranslationYAnim = ObjectAnimator.ofFloat(second_view, "translationY", second_view.getHeight(), 0f);
        secondTranslationYAnim.setDuration(300);
//		secondTranslationYAnim.setStartDelay(200);
        secondTranslationYAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                second_view.setVisibility(View.VISIBLE);
                bt.setClickable(false);
            }
        });


        AnimatorSet set = new AnimatorSet();
        set.playTogether(firstScaleXAnim,firstScaleYAnim,firstAlphaAnim,firstRotationXanim,firstResumeRotationXanim,firstTranslationYAnim,secondTranslationYAnim);
        set.start();

    }
}
