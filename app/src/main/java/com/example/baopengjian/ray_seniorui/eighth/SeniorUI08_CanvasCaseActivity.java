package com.example.baopengjian.ray_seniorui.eighth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2018/10/9.
 */
public class SeniorUI08_CanvasCaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seniorui08_canvas_case_activity);
    }

    public void board(View view){
        Intent intent = new Intent(this,DrawingBoardActivity.class);
        startActivity(intent);
    }

    public void reveal(View view){
        Intent intent = new Intent(this,RevealViewActivity.class);
        startActivity(intent);
    }

    public void search(View view){
        Intent intent = new Intent(this,SearchViewActivity.class);
        startActivity(intent);
    }
}
