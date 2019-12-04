package com.example.baopengjian.ray_seniorui.twenty_second;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baopengjian.ray_seniorui.R;

/**
 */

public class FakeAdapter extends RecyclerView.Adapter<FakeAdapter.ViewHolder> {

    int DEFAULT_COUNT = 20;
    int count = DEFAULT_COUNT;

    int mLayoutRes;
    public FakeAdapter(int layoutRes){
        mLayoutRes = layoutRes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(mLayoutRes, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.view.setText("Text :" + position);
    }

    public void set(int value) {
        count = value;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return count;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView view;
        public ViewHolder(View itemView) {
            super(itemView);
            view = (TextView)itemView.findViewById(R.id.item_view_holder_text);
        }
    }
}
