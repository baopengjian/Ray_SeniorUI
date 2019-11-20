package com.example.baopengjian.ray_seniorui.fourteenth;

import android.view.View;

import java.util.Stack;

/**
 * Created by Ray on 2019-11-15.
 */
public class Recycler {

    private Stack<View>[] mViews;

    public Recycler(int size) {
        mViews = new Stack[size];
        for (int i = 0; i < size; i++) {
            mViews[i] = new Stack<>();
        }
    }

    public void addRecycledView(View view, int type) {
        mViews[type].push(view);
    }

    public View getRecycledView(int type) {
        try {
            return mViews[type].pop();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
