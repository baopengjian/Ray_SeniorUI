package com.example.baopengjian.ray_seniorui.eighth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2018/10/9.
 */
public class SearchViewActivity extends AppCompatActivity {

    private SearchView mSearchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seniorui08_canvas_search_activity);

        mSearchView = (SearchView)findViewById(R.id.sv);
        mSearchView.setController(new Controller1());
    }

    public void start(View v){
        mSearchView.startAnimation();
    }
    public void reset(View v){
        mSearchView.resetAnimation();
    }
}
