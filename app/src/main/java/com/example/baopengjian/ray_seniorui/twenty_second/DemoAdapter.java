package com.example.baopengjian.ray_seniorui.twenty_second;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baopengjian.ray_seniorui.R;

import java.util.Arrays;
import java.util.Random;

/**
 */

public class DemoAdapter extends RecyclerView.Adapter {

    String[] mTexts;
    DemoAdapter(){
        int count = new Random().nextInt(60);
        mTexts = new String[count];
        fillTexts(count);
    }

    private void fillTexts(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            char[] buf = new char[random.nextInt(10)];
            Arrays.fill(buf, (char) (random.nextInt(26) + 65));
            mTexts[i] = new String(buf);
        }
    }
    static final int TEXT = 0;
    static final int TITLE = 1;

    @Override
    public int getItemViewType(int position) {
        if (position % 10 == 0) return TITLE;
        return TEXT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        TextView view = new TextView(viewGroup.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        if (viewType == TITLE) {
            return new TitleTextViewHolder(view);
        } else {
            return new TextViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        TextView itemView = (TextView) viewHolder.itemView;
        if(viewHolder instanceof TitleTextViewHolder) {
            itemView.setText("~~~"+mTexts[position]+"~~~~");
        }else{
            itemView.setText(position+". "+mTexts[position]);
        }
    }

    @Override
    public int getItemCount() {
        return mTexts.length;
    }

    static class TextViewHolder extends RecyclerView.ViewHolder{

        public TextViewHolder(TextView itemView) {
            super(itemView);
            itemView.setTextAppearance(itemView.getContext(), R.style.TextAppearance_AppCompat_Medium);
        }
    }

    static class TitleTextViewHolder extends RecyclerView.ViewHolder{

        public TitleTextViewHolder(TextView itemView) {
            super(itemView);
            itemView.setTextAppearance(itemView.getContext(), R.style.TextAppearance_AppCompat_Headline);
            itemView.setGravity(Gravity.CENTER_HORIZONTAL);
        }
    }
}
