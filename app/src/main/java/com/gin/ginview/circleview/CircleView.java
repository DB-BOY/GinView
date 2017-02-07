package com.gin.ginview.circleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.gin.ginview.R;


/**
 * Created by wang.lichen on 16/11/11.
 */

public class CircleView extends View {
    float radius;
    float smallLength;
    float largeLength;
    private float mBorderWidth;
    private int mBorderColor;
    private Paint mPaint;
    private RectF mBounds;
    private float width;
    private float height;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleView, defStyleAttr, 0);

        try {
            mBorderColor = typedArray.getColor(R.styleable.CircleView_border_color, 0xff000000);
            mBorderWidth = typedArray.getDimension(R.styleable.CircleView_border_width, 2);
        } finally {
            typedArray.recycle();
        }
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mBorderWidth);
        mPaint.setColor(mBorderColor);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        
        mBounds = new RectF(getLeft(), getTop(), getRight(), getBottom());

        width = mBounds.right - mBounds.left;
        height = mBounds.bottom - mBounds.top;

        if (width < height) {
            radius = width / 4;
        } else {
            radius = height / 4;
        }

        smallLength = 10;
        largeLength = 20;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i("------wang.lichen--","onMeasure");
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("------wang.lichen--","onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.i("------wang.lichen--","onDraw");
        canvas.drawColor(0xff000000);
        mPaint.setColor(0x66555555);

        float left,top,right,bottom;
        left = mBounds.centerX() - (float) 0.9 * width / 2;
        top = mBounds.centerY() - (float) 0.9 * width / 2;
        right = mBounds.centerX() + (float) 0.9 * width / 2;
        bottom = mBounds.centerY() + (float) 0.9 * width / 2;
        
        RectF rectF = new RectF(left, top,right,bottom);
        
        canvas.drawRoundRect(rectF, 30, 30, mPaint);
        mPaint.setColor(mBorderColor);
        canvas.drawCircle(mBounds.centerX(), mBounds.centerY(), radius, mPaint);
        float start_x, start_y;
        float end_x, end_y;
        for (int i = 0; i < 60; ++i) {
            start_x = radius * (float) Math.cos(Math.PI / 180 * i * 6);
            start_y = radius * (float) Math.sin(Math.PI / 180 * i * 6);
            if (i % 5 == 0) {
                end_x = start_x + largeLength * (float) Math.cos(Math.PI / 180 * i * 6);
                end_y = start_y + largeLength * (float) Math.sin(Math.PI / 180 * i * 6);
            } else {
                end_x = start_x + smallLength * (float) Math.cos(Math.PI / 180 * i * 6);
                end_y = start_y + smallLength * (float) Math.sin(Math.PI / 180 * i * 6);
            }
            start_x += mBounds.centerX();
            end_x += mBounds.centerX();
            start_y += mBounds.centerY();
            end_y += mBounds.centerY();
            canvas.drawLine(start_x, start_y, end_x, end_y, mPaint);
        }
        canvas.drawCircle(mBounds.centerX(), mBounds.centerY(), 20, mPaint);
        canvas.rotate(60, mBounds.centerX(), mBounds.centerY());
        canvas.drawLine(mBounds.centerX(), mBounds.centerY(), mBounds.centerX(), mBounds.centerY() - radius, mPaint);
    }
}
