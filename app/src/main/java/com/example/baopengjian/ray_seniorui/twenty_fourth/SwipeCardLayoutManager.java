package com.example.baopengjian.ray_seniorui.twenty_fourth;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ray on 2019-12-10.
 */
public class SwipeCardLayoutManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
//        super.onLayoutChildren(recycler, state);
        //h缓存的核心机制之一
        detachAndScrapAttachedViews(recycler);

        int itemCount = getItemCount();
        int initPosition;
        if (itemCount < CardConfig.MAX_SHOW_COUNT) {
            initPosition = 0;
        } else {
            initPosition = itemCount - CardConfig.MAX_SHOW_COUNT;
        }

        for (int position = initPosition; position < itemCount; position++) {
            //从缓存获取view
            View view = recycler.getViewForPosition(position);
            addView(view);
            measureChild(view, 0, 0);

            int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
            int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);

            layoutDecorated(view,
                    widthSpace/2,
                    heightSpace/2,
                    widthSpace/2 + getDecoratedMeasuredWidth(view),
                    heightSpace/2 + getDecoratedMeasuredHeight(view));
            // 均匀的缩放和位移
            int level = itemCount - position - 1;
            if (level > 0) {
                view.setScaleX(1 - CardConfig.SCALE_GAP * level);
                view.setScaleY(1- CardConfig.SCALE_GAP * level);
                if (level < CardConfig.MAX_SHOW_COUNT -1) {
                    view.setTranslationY(CardConfig.TRANS_Y_GAP* level);
                } else {
                    view.setTranslationY(CardConfig.TRANS_Y_GAP* (level - 1));
                }

            }
        }

    }
}
