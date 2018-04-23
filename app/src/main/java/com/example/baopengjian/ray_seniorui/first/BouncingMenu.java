package com.example.baopengjian.ray_seniorui.first;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

import com.example.baopengjian.ray_seniorui.R;


public class BouncingMenu {
	private ViewGroup mParentVG;
	private View rootView;
	private BouncingView bouncingView;
	private RecyclerView recyclerView;

	public BouncingMenu(View view,int resId,final MyRecyclerAdapter adapter) {

		mParentVG = (ViewGroup) view;

		rootView = LayoutInflater.from(view.getContext()).inflate(resId, null, false);
		bouncingView = (BouncingView) rootView.findViewById(R.id.sv);
		recyclerView = (RecyclerView)rootView.findViewById(R.id.rv);
		recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
		bouncingView.setMyAnimationListener(new BouncingView.MyAnimationListener() {
			
			@Override
			public void showContent() {
				recyclerView.setVisibility(View.VISIBLE);
				recyclerView.setAdapter(adapter);
				recyclerView.scheduleLayoutAnimation();
			}
		});
	}
	

	public static BouncingMenu makeMenu(View view,int resId,MyRecyclerAdapter adapter){
		return new BouncingMenu(view, resId,adapter);
	}
	
	public BouncingMenu show(){
		if(rootView.getParent()!=null){
			mParentVG.removeView(rootView);
		}
		FrameLayout.LayoutParams lp =  new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		lp.bottomMargin = getNavigationHeight(mParentVG.getContext());
		mParentVG.addView(rootView,lp);
		bouncingView.show();
		return this;
	}
	
	public void dismiss(){
		mParentVG.removeView(rootView);
		rootView = null;
	}


	public static int getNavigationHeight(Context context) {
		int resourceId;
		int rid = context.getResources().getIdentifier("config_showNavigationBar", "bool", "android");
		if (rid!=0){
			resourceId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
			return context.getResources().getDimensionPixelSize(resourceId);
		}else
			return 0;
	}

}
