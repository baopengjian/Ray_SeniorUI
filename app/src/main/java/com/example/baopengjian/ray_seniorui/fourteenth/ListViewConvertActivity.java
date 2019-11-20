package com.example.baopengjian.ray_seniorui.fourteenth;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2019-11-15.
 */
public class ListViewConvertActivity extends AppCompatActivity {

    private TableView table_view;
    int row = 10;
    int column = 10;
    Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_convert_activity);
        table_view = findViewById(R.id.table_view);
        table_view.setAdapter(new MyAdapter(this));

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                table_view.setAdapter(new MyAdapter(ListViewConvertActivity.this));
            }
        }, 1500);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                row = 10000;
                column = 1000;
                table_view.setAdapter(new MyAdapter(ListViewConvertActivity.this));
            }
        }, 8000);
    }

    class MyAdapter implements TableAdapter {

        private int width;
        private  int height;
        LayoutInflater inflater;
        public MyAdapter(Context context) {
            Resources resources = context.getResources();
            width = resources.getDimensionPixelSize(R.dimen.table_width);
            height = resources.getDimensionPixelSize(R.dimen.table_height);
            inflater=LayoutInflater.from(context);

        }


        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getRowCount() {
            return row;
        }

        @Override
        public int getColumnCount() {
            return column;
        }

        @Override
        public int getWidth(int column) {
            return width;
        }

        @Override
        public int getHeight(int row) {
            return height;
        }

        public View getView(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView= inflater.inflate(getLayout(row,column),parent,false);
            }
            TextView textView= (TextView) convertView.findViewById(R.id.text1);

            textView.setText(row+"行 "+"  列 "+column);
            return convertView;
        }

        @Override
        public int getItemViewType(int row, int column) {
            if (row < 0) {
                return 0;
            } else {
                return 1;
            }
        }
        @Override
        public int getViewTypeCount() {
            return 2 ;
        }
        private int getLayout(int row, int column) {
            final int layoutResource;
            switch (getItemViewType(row, column)) {
                case 0:
                    layoutResource = R.layout.item_table1_header;
                    break;
                case 1:
                    layoutResource = R.layout.item_table1;
                    break;
                default:
                    throw new RuntimeException("wtf?");
            }
            return layoutResource;
        }
    }
}
