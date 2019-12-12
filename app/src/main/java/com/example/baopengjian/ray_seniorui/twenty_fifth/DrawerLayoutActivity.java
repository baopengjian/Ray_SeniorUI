package com.example.baopengjian.ray_seniorui.twenty_fifth;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

import java.lang.reflect.Field;

/**
 * Created by Ray on 2019-12-12.
 */
public class DrawerLayoutActivity extends AppCompatActivity  implements DrawerLayout.DrawerListener{


    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout_activity);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        setDrawerLeftEdgeSize(this,drawerLayout , 0.3f);
        drawerLayout.addDrawerListener(this);
    }

    public void onClick(View view) {
        drawerLayout.openDrawer(Gravity.START);

      //  drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN, GravityCompat.END);
    }


    public static void setDrawerLeftEdgeSize(Activity activity, DrawerLayout drawerLayout, float displayWidthPercentage) {
        if (activity == null || drawerLayout == null) return;
        try {
            Field leftDraggerField = drawerLayout.getClass().getDeclaredField("mLeftDragger");
            leftDraggerField.setAccessible(true);
            ViewDragHelper leftDragger = (ViewDragHelper) leftDraggerField.get(drawerLayout);
            Field edgeSizeField = leftDragger.getClass().getDeclaredField("mEdgeSize");
            edgeSizeField.setAccessible(true);
            int edgeSize = edgeSizeField.getInt(leftDragger);
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            edgeSizeField.setInt(leftDragger, Math.max(edgeSize, (int) (dm.widthPixels * displayWidthPercentage)));
        } catch (Exception e) {
        }
    }

    /**
     * drawerView   左菜单
     *  slideOffset    滑动百分比
     *  打开菜单
     * @param drawerView
     * @param slideOffset
     */
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        Log.i("tuch", "  drawerView  " + drawerView + " slideOffset " + slideOffset);
    }

    /**
     *
     * @param drawerView
     */
    @Override
    public void onDrawerOpened(View drawerView) {
        //打开的状态
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        //关闭 的状态
    }

    @Override
    public void onDrawerStateChanged(int newState) {
    }
}
