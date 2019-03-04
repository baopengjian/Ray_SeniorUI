package com.example.baopengjian.ray_seniorui.tenth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SearchViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SearchView searchView = new SearchView(this);
        setContentView(searchView);
        searchView.setState(SearchView.SearchState.START);
    }
}
