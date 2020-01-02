package com.example.baopengjian.ray_seniorui.thirty_first.apply;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.example.baopengjian.ray_seniorui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 2020-1-2.
 */
public class ApplyActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private CustomViewPager viewPager;
    private List<MyFragment> bodyFragments;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        tabLayout = findViewById(R.id.community_container_tab_layout);
        viewPager = findViewById(R.id.viewPager);

        bodyFragments = new ArrayList<>();
        MyFragment myFragment1 = new MyFragment();
        myFragment1.setmTitle("ta回答的");
        MyFragment myFragment2 = new MyFragment();
        myFragment2.setmTitle("ta得到的");
        bodyFragments.add(myFragment1);
        bodyFragments.add(myFragment2);

        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return bodyFragments.get(position);
            }

            @Override
            public int getCount() {
                return bodyFragments.size();
            }

            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return bodyFragments.get(position).getmTitle();
            }
        };
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
    }



}
