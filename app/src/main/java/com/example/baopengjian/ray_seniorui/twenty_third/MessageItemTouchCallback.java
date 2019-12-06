package com.example.baopengjian.ray_seniorui.twenty_third;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.Log;

public class MessageItemTouchCallback extends Callback {

	private static final String TAG = "ItemTouchCallback";
	private ItemTouchHelperAdapterCallback adapterCallback;

	public MessageItemTouchCallback(ItemTouchHelperAdapterCallback adapterCallback) {
		this.adapterCallback = adapterCallback;
	}

	@Override
	public int getMovementFlags(RecyclerView recyclerView, ViewHolder holder) {
		//callback回调监听哪些动作？---判断方向
		
		
		//makeMovementFlags(UP | DOWN, LEFT);
		int dragFlags = ItemTouchHelper.UP|ItemTouchHelper.DOWN;
		int swipeFlags = ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
		return makeMovementFlags(dragFlags, swipeFlags);
//		return 0;
	}

	@Override
	public boolean onMove(RecyclerView arg0, ViewHolder srcHolder, ViewHolder targetHolder) {
		// 监听滑动（水平方向、垂直方向）
		//让数据集合中的两个数据进行位置交换
		//同时还要刷新RecyclerView
		adapterCallback.onItemMove(srcHolder.getAdapterPosition(), targetHolder.getAdapterPosition());
		return true;
	}
	
	@Override
	public boolean isLongPressDragEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void onChildDraw(Canvas c, RecyclerView recyclerView,
			ViewHolder viewHolder, float dX, float dY, int actionState,
			boolean isCurrentlyActive) {
		Log.d(TAG, "onChildDraw");
		// 实现一些动画
		//条件：侧滑动作
//		if(actionState==ItemTouchHelper.ACTION_STATE_SWIPE){
//				//dX: 0~WIDTH
//				float alpha = 1-Math.abs(dX)/viewHolder.itemView.getWidth();
//				viewHolder.itemView.setAlpha(alpha);//1~0
//				viewHolder.itemView.setScaleX(Math.max(0.75f,alpha));
//				viewHolder.itemView.setScaleY(Math.max(0.75f,alpha));
//				if(alpha<=0){
//					viewHolder.itemView.setAlpha(1);//1~0
//					viewHolder.itemView.setScaleX(1);
//					viewHolder.itemView.setScaleY(1);
//				}
//		}
		
		super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState,
				isCurrentlyActive);
	}

	@Override
	public void onSwiped(ViewHolder holder, int arg1) {
		// 滑动删除的动作的时候回调
		//1.删除数据集合里面的position位置的数据
		//2.刷新adapter
		adapterCallback.onItemSwiped(holder.getAdapterPosition());
	}

	//滑动消失的距离，当滑动小于这个值的时候会删除这个item，否则不会视为删除
	@Override
	public float getSwipeThreshold(ViewHolder viewHolder) {
		return 0.1f;
	}

	@Override
	public float getSwipeEscapeVelocity(float defaultValue) {
		return 5f;
	}

	//设置手指离开后ViewHolder的动画时间
	@Override
	public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
		return 100;
	}

	//网格型RecyclerView
	@Override
	public float getMoveThreshold(ViewHolder viewHolder) {
		return 0.9f;
	}

    //返回值决定是否有滑动操作
	@Override
	public boolean isItemViewSwipeEnabled() {
		return true;
	}


}
