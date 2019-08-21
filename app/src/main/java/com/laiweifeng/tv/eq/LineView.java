package com.laiweifeng.tv.eq;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineView extends View {

    private Paint paint;
    private int size=0;
    private Path path;
    private List<Float> lineList;

    private Map<Integer, Float> lineMap=new HashMap<>();

    public LineView(Context context) {
        this(context,null);
    }

    public LineView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setStrokeWidth(20);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);
        path.reset();
        path.moveTo(0 , getHeight()/2);
        int size=lineMap.size();
        for (int i = 1; i <= lineMap.size(); i++) {
            float positionX=(getWidth()/size*i)-(getWidth()/size/2);
            float value = lineMap.get(i);
            float positionY= getHeight()-(float) ((getHeight()/100.0)*value);
            path.lineTo(positionX,positionY);
        }
        path.lineTo(getWidth() , getHeight()/2);
        canvas.drawPath(path,paint);


    }


    public void setData(Map<Integer, Float> lineMap) {
        this.lineMap=lineMap;
        invalidate();
    }
}
