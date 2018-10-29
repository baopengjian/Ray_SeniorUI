package com.example.baopengjian.ray_seniorui.eighth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.baopengjian.ray_seniorui.R;

/**
 * Created by Ray on 2018/10/9.
 */
public class RevealViewActivity extends AppCompatActivity {
    private ImageView iv;
    private int[] mImgIds = new int[] { //7个
            R.drawable.avft,
            R.drawable.box_stack,
            R.drawable.bubble_frame,
            R.drawable.bubbles,
            R.drawable.bullseye,
            R.drawable.circle_filled,
            R.drawable.circle_outline,

            R.drawable.avft,
            R.drawable.box_stack,
            R.drawable.bubble_frame,
            R.drawable.bubbles,
            R.drawable.bullseye,
            R.drawable.circle_filled,
            R.drawable.circle_outline
    };
    private int[] mImgIds_active = new int[] {
            R.drawable.avft_active, R.drawable.box_stack_active, R.drawable.bubble_frame_active,
            R.drawable.bubbles_active, R.drawable.bullseye_active, R.drawable.circle_filled_active,
            R.drawable.circle_outline_active,
            R.drawable.avft_active, R.drawable.box_stack_active, R.drawable.bubble_frame_active,
            R.drawable.bubbles_active, R.drawable.bullseye_active, R.drawable.circle_filled_active,
            R.drawable.circle_outline_active
    };

    public Drawable[] revealDrawables;
    protected int level = 5000;
    private GalleryHorizontalScrollView hzv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seniorui08_reveal_view_activity);
        initData();
        initView();
    }

    private void initData(){
        revealDrawables = new Drawable[mImgIds.length];
    }

    private void initView()
    {
        for (int i = 0; i < mImgIds.length; i++)
        {
            RevealDrawable rd = new RevealDrawable(
                getResources().getDrawable(mImgIds[i]),
                getResources().getDrawable(mImgIds_active[i]),
                RevealDrawable.HORIZONTAL);
            revealDrawables[i] = rd;
        }
        hzv = (GalleryHorizontalScrollView)findViewById(R.id.gsv);
        hzv.addImageViews(revealDrawables);
    }


}
