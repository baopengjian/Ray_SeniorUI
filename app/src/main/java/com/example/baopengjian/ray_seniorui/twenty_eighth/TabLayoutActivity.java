package com.example.baopengjian.ray_seniorui.twenty_eighth;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-18.
 */
public class TabLayoutActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    MyAdatper myAdatper;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    private final String[] titels = {"分类", "主页", "热门推荐", "热门收藏", "本月热榜", "今日热榜", "专栏", "随机"};
    private int[] drawbles = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout_activity);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        toolbar.setTitle("TabLayout等design包下View的综合使用");
        //顺序非常重要  设置 文字 样式调用setSupportActionBar  之前     设置监听在 setSupportActionBar之后
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);

        myAdatper = new MyAdatper(getSupportFragmentManager());
        viewPager.setAdapter(myAdatper);
        //设置联动
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                colorChage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        colorChage(0);
    }

    /**
     * 如果页面 发生切换     根据BItmap改变toolBar的颜色
     *
     * @param position
     */
    private void colorChage(int position) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawbles[position]);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                //拿到鲜艳的颜色
                Palette.Swatch vibreant = palette.getVibrantSwatch();
                if (vibreant == null) {
                    for (Palette.Swatch swatch : palette.getSwatches()) {
                        if (swatch != null) {
                            vibreant = swatch;
                            break;
                        }
                    }
                }

                viewPager.setBackgroundColor(vibreant.getRgb());
                tabLayout.setSelectedTabIndicatorColor(vibreant.getRgb());
                tabLayout.setBackgroundColor(vibreant.getRgb());
                toolbar.setBackgroundColor(vibreant.getRgb());
                if (Build.VERSION.SDK_INT > 21) {
                    Window window = getWindow();
                    //状态栏 颜色加深
                    window.setStatusBarColor(colorBurn(vibreant.getRgb()));
                    window.setNavigationBarColor(vibreant.getRgb());
                }
            }
        });
    }

    private int colorBurn(int rgb) {
        //加深颜色
        int red = rgb >> 16 & 0xFF;
        int green = rgb >> 8 & 0xFF;
        int blue = rgb&0xFF;

        red = (int) Math.floor(red * (1 - 0.2));
        green = (int) Math.floor(green * (1 - 0.2));
        blue = (int) Math.floor(blue * (1 - 0.2));
        return Color.rgb(red, green, blue);
    }


    class MyAdatper extends FragmentPagerAdapter {


        public MyAdatper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new ImageFrament();
            Bundle bundle = new Bundle();
            bundle.putInt("id", drawbles[position]);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return drawbles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titels[position];
        }
    }
}
