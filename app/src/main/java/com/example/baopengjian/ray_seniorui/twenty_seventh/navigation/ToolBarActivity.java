package com.example.baopengjian.ray_seniorui.twenty_seventh.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-12-17.
 */
public class ToolBarActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tool_bar_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back);
        //替换actionBar  注意
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(ToolBarActivity.this, "点击", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //弹出主题
//        toolbar.setPopupTheme();
        //
        toolbar.showOverflowMenu();
        //设置主标题字体样式
//        toolbar.setTitleTextAppearance();
        //设置副标题
//        toolbar.setSubtitleTextAppearance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.view_item,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        //v14    v14之后版本
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        SearchView searchView= (SearchView) menuItem.getActionView();
        //一进来就是 输入框     不隐藏
//        searchView.setIconified(false);


        ImageView imageView= (ImageView) searchView.findViewById(R.id.search_go_btn);
        imageView.setImageResource(R.drawable.abc_ic_voice_search_api_mtrl_alpha);
        imageView.setVisibility(View.VISIBLE);
        searchView.setSubmitButtonEnabled(true);


//        imageView.setImageResource(R.mipmap.ic_launcher);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            //文字输入完成   提交
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            //当文字发生改变
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//        //当用户点击   input
//        searchView.setOnSearchClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        return super.onCreateOptionsMenu(menu);
    }
}
