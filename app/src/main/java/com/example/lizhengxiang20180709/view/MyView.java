package com.example.lizhengxiang20180709.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.lizhengxiang20180709.R;

public class MyView extends View {
    private Paint paint;
    private Path mpath;
    private Bitmap obitmap;
    private Bitmap tbitmap;
    private Canvas canvas;//新建的画布
    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    private void init(){
        paint = new Paint();//设置透明的画笔
        paint.setAntiAlias(true);
        paint.setAlpha(0);//设置成透明
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(50);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        mpath = new Path();
        obitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image_12);
        tbitmap = Bitmap.createBitmap(tbitmap.getWidth(),tbitmap.getHeight(),Bitmap.Config.ARGB_8888);
        canvas = new Canvas(tbitmap);
        canvas.drawColor(Color.GRAY);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(obitmap, 0,0, null);
        canvas.drawBitmap(tbitmap, 0,0, null);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mpath.reset();
                mpath.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mpath.lineTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        canvas.drawPath(mpath,paint);
        invalidate();//执行重绘
        return true;
    }
}


