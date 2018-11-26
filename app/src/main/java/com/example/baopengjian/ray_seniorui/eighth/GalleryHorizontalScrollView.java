package com.example.baopengjian.ray_seniorui.eighth;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Ray on 2018/10/9.
 */
public class GalleryHorizontalScrollView extends HorizontalScrollView  {

    private LinearLayout container;
    private int centerX;
    private int icon_width;

    public GalleryHorizontalScrollView(Context context) {
        super(context);
        init();
    }

    public GalleryHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GalleryHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        container = new LinearLayout(getContext());
        container.setLayoutParams(params);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        View v = container.getChildAt(0);
        icon_width = v.getWidth();
        centerX = getWidth()/2;
        centerX = centerX - icon_width/2;
        container.setPadding(centerX,0,centerX,0);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        reveal();
    }

    private void reveal(){
        //渐变效果
        //得到滑动距离
        int scrollX = getScrollX();
        //找到两张渐变的图片的下标--左，右
        int index_left = scrollX/icon_width;
        int index_right = index_left + 1;
        //设置图片的level
        for(int i = 0 ; i < container.getChildCount();i++){
            if(i == index_left || i == index_right){
                //变化
                float ratio = 5000f/icon_width;
                ImageView iv_left = (ImageView) container.getChildAt(index_left);
                iv_left.setImageLevel((int) (5000-scrollX%icon_width*ratio));
                if(index_right <container.getChildCount()){
                    ImageView iv_right = (ImageView) container.getChildAt(index_right);
                    iv_right.setImageLevel((int) (10000 - scrollX%icon_width*ratio));
                }
            }else{
                ImageView iv = (ImageView) container.getChildAt(i);
                iv.setImageLevel(0);
            }
        }

    }

    //添加图片的方法
    public void addImageViews(Drawable[] revealDrawables){
        for (int i = 0; i < revealDrawables.length; i++) {
            ImageView img = new ImageView(getContext());
            img.setImageDrawable(revealDrawables[i]);
            container.addView(img);
            if(i==0){
                img.setImageLevel(5000);
            }
        }
        addView(container);
    }

    @Override
    public void fling(int velocity) {
        super.fling(velocity / 1000);
    }
}
