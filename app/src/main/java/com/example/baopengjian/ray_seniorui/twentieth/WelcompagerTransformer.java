package com.example.baopengjian.ray_seniorui.twentieth;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import android.view.ViewGroup;

import com.example.baopengjian.ray_seniorui.R;

public class WelcompagerTransformer implements PageTransformer {

    @Override
    public void transformPage(View view, float position) {
        if(position<1&&position>-1) {
            //找到里面的子控件
            ViewGroup v = (ViewGroup) view.findViewById(R.id.rl);
            int childCount = v.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childView = v.getChildAt(i);
                float factor = (float) Math.random() * 3;
                if (childView.getTag() == null) {
                    childView.setTag(factor);
                } else {
                    factor = (float) childView.getTag();
                }
                /**每一个子控件达到不同的视差效果，translationX是不一样的
                 * position : 0 ~ -1
                 * translationX: 0 ~ childView.getWidth();
                 */
                childView.setTranslationX(factor * childView.getWidth() * position);
            }
        }
//        view.setScaleX(1 - Math.abs(position));
//        view.setScaleY(1 - Math.abs(position));

        //效果2
//			view.setScaleX(Math.max(0.9f,1-Math.abs(position)));
//			view.setScaleY(Math.max(0.9f,1-Math.abs(position)));
        //效果3 3D翻转
//			view.setPivotX(position<0f?view.getWidth():0f);//左边页面：0~-1；右边的页面：1~0
//			view.setPivotY(view.getHeight()*0.5f);
//			view.setRotationY(position*45f);//0~90度
        //效果4 3D内翻转
//			view.setPivotX(position<0f?view.getWidth():0f);//左边页面：0~-1；右边的页面：1~0
//			view.setPivotY(view.getHeight()*0.5f);
//			view.setRotationY(-position*45f);//0~90度

//			view.setPivotX(view.getWidth()*0.5f);//左边页面：0~-1；右边的页面：1~0
//			view.setPivotY(view.getHeight()*0.5f);
//			view.setRotationY(-position*45f);//0~90度
    }

}
