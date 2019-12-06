package com.example.baopengjian.ray_seniorui.twenty_third;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.example.baopengjian.ray_seniorui.R;

import java.util.List;

/**
 * Created by Ray on 2019-12-6.
 */
public class ItemTouchHelperActivity extends AppCompatActivity  implements StartDragListener{

    private RecyclerView recyclerview;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_touch_helper_activity);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);

        List<QQMessage> list = DataUtils.init();


        MessageAdapter adapter = new MessageAdapter(list,this);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        recyclerview.setAdapter(adapter);

        Callback callback = new MessageItemTouchCallback(adapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerview);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }

}
