package com.example.baopengjian.ray_seniorui.twenty_third;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baopengjian.ray_seniorui.R;

import java.util.Collections;
import java.util.List;

public class MessageAdapter extends Adapter<MessageAdapter.MyHolder> implements ItemTouchHelperAdapterCallback{
	private List<QQMessage> list;
	private StartDragListener dragListener;

	public MessageAdapter(List<QQMessage> list,StartDragListener dragListener) {
		this.list = list;
		this.dragListener = dragListener;
	}
	
	class MyHolder extends ViewHolder{
		public TextView tv_name;
		public View iv_logo;
		

		public MyHolder(View itemView) {
			super(itemView);
			tv_name = (TextView)itemView.findViewById(R.id.tv_name);
			iv_logo = itemView.findViewById(R.id.iv_logo);
		}
		
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void onBindViewHolder(final MyHolder holder, int position) {
		QQMessage qqMessage = list.get(position);
		holder.tv_name.setText(qqMessage.getName());
		holder.iv_logo.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// 传递事件
				if(event.getAction()==MotionEvent.ACTION_DOWN){
//					ItemTouchHelper.startDrag();
					dragListener.onStartDrag(holder);
				}
				return false;
			}
		});
		
	}

	@Override
	public MyHolder onCreateViewHolder(ViewGroup parent, int arg1) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
		return new MyHolder(view);
	}

	@Override
	public boolean onItemMove(int fromPosition, int toPosition) {

		//让数据集合中的两个数据进行位置交换
		Collections.swap(list, fromPosition, toPosition);
		//同时还要刷新RecyclerView
//		notifyDataSetChanged();
		notifyItemMoved(fromPosition, toPosition);
		
		return false;
	}

	@Override
	public void onItemSwiped(int adapterPosition) {
		//1.删除数据集合里面的position位置的数据
		list.remove(adapterPosition);
		//2.刷新adapter
		notifyItemRemoved(adapterPosition);
	}

}
