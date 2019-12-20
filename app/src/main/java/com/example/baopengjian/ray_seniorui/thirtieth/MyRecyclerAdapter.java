package com.example.baopengjian.ray_seniorui.thirtieth;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baopengjian.ray_seniorui.R;

import java.util.List;

public class MyRecyclerAdapter extends Adapter<ViewHolder> {
	private List<String> list;

	public MyRecyclerAdapter(List<String> list) {
		this.list = list;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		String string = list.get(position);
		MyViewHolder holder = (MyViewHolder)viewHolder;
		holder.tv.setText(string);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate( R.layout.item, parent, false);
		return new MyViewHolder(view);
	}

	class MyViewHolder extends ViewHolder {
		TextView tv;

		public MyViewHolder(View itemView) {
			super(itemView);
			tv = (TextView) itemView.findViewById(R.id.textView1);
		}
		
	}
	
}
