package com.example.baopengjian.ray_seniorui.twelfth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.graphics.PathParser;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.baopengjian.ray_seniorui.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Ray on 2019-7-22.
 */
public class SvgChinaView extends View {

    private Context context;
    private List<ProvinceItem> list = new ArrayList<>();
    private static int[] colorArray = new int[]{0xFF239BD7, 0xFF30A9E5, 0xFF80CBF1, Color.RED};
    private ProvinceItem selectItem;
    private float scale = 1.3f;
    private Paint paint;
    private GestureDetectorCompat gestureDetectorCompat;

    public SvgChinaView(Context context) {
        this(context, null);
    }

    public SvgChinaView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SvgChinaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.paint = new Paint();
        paint.setAntiAlias(true);
        loadThread.start();
        gestureDetectorCompat = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDown(MotionEvent e) {
                handlerTouch(e.getX(),e.getY());
                return true;
            }
        });
    }

    private void handlerTouch(float x, float y) {
        if(list != null){
            ProvinceItem temp = null;
            for(ProvinceItem item:list){
                if(item.isTouch((int)(x/scale), (int)(y/scale))){
                    temp = item;
                    break;
                }
            }
            if(temp != null){
                selectItem = temp;
                postInvalidate();
            }
        }
    }

    Thread loadThread = new Thread() {

        @Override
        public void run() {
            InputStream inputStream = context.getResources().openRawResource(R.raw.china);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            try {
                builder = factory.newDocumentBuilder();
                Document document = builder.parse(inputStream);
                Element element = document.getDocumentElement();
                NodeList items = element.getElementsByTagName("path");
                for (int i = 0; i < items.getLength(); i++) {
                    Element element1 = (Element) items.item(i);
                    String pathData = element1.getAttribute("android:pathData");
                    @SuppressLint("RestrictedApi") Path path = PathParser.createPathFromPathData(pathData);
                    ProvinceItem item = new ProvinceItem(path);
                    list.add(item);
                    handler.sendEmptyMessage(1);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (list != null) {
                int totalNumber = list.size();
                for (int i = 0; i < totalNumber; i++) {
                    int color = Color.WHITE;
                    int flag = i % 4;
                    switch (flag) {
                        case 1:
                            color = colorArray[0];
                            break;
                        case 2:
                            color = colorArray[1];
                            break;
                        case 3:
                            color = colorArray[2];
                            break;
                        default:
                            color = 0x00FFF0EF;
                            break;
                    }
                    list.get(i).setDrawColor(color);
                }
                postInvalidate();
            }
        }
    };


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetectorCompat.onTouchEvent(event);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(list != null){
            canvas.save();
            canvas.scale(scale, scale);
            for(ProvinceItem item:list){
              if(item != selectItem){
                  item.draw(canvas,paint , false);
              }
            }

            if(selectItem != null){
                selectItem.draw(canvas,paint ,true );
            }
        }

    }
}
