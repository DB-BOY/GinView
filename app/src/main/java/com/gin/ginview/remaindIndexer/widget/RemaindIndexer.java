package com.gin.ginview.remaindIndexer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.gin.ginview.R;

/**
 * Created by wang.lichen on 2016/11/17.
 */

public class RemaindIndexer extends View {
    private final String[] IndexChar = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private int mHeight;

    ////-----------------------------Properties
    // 向右偏移多少画字符， default 30
    private float mWidthOffset = 30.0f;

    // 最小字体大小
    private int mMinFontSize = 24;

    // 最大字体大小
    private int mMaxFontSize = 48;

    // 提示字体大小
    private int mTipFontSize = 52;

    // 提示字符的额外偏移
    private float mAdditionalTipOffset = 20.0f;

    // 贝塞尔曲线控制的高度
    private float mMaxBezierHeight = 150.0f;

    // 贝塞尔曲线单侧宽度
    private float mMaxBezierWidth = 240.0f;

    // 贝塞尔曲线单侧模拟线量
    private int mMaxBezierLines = 32;

    // 列表字符颜色
    private int mFontColor = 0xffffffff;

    // 提示字符颜色
    private int mTipFontColor = 0xffd33e48;

    ////-----------------------------
    private int mChooseIndex = -1;
    private Paint mPaint;


    public RemaindIndexer(Context context) {
        this(context, null);
    }

    public RemaindIndexer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RemaindIndexer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (context != null && attrs != null) {
            TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RemaindIndexer, defStyleAttr, 0);
            try {
                mWidthOffset = array.getDimension(R.styleable.RemaindIndexer_widthOffset, mWidthOffset);
                mMaxBezierHeight = array.getDimension(R.styleable.RemaindIndexer_maxBezierHeight, mMaxBezierHeight);
                mMaxBezierWidth = array.getDimension(R.styleable.RemaindIndexer_maxBezierWidth, mMaxBezierWidth);
                mAdditionalTipOffset = array.getDimension(R.styleable.RemaindIndexer_additionalTipOffset, mAdditionalTipOffset);

                mFontColor = array.getColor(R.styleable.RemaindIndexer_fontColor, mFontColor);
                mTipFontColor = array.getColor(R.styleable.RemaindIndexer_tipFontColor, mTipFontColor);


                mMaxBezierLines = array.getInteger(R.styleable.RemaindIndexer_maxBezierLines, mMaxBezierLines);
                mMinFontSize = array.getInteger(R.styleable.RemaindIndexer_minFontSize, mMinFontSize);
                mMaxFontSize = array.getInteger(R.styleable.RemaindIndexer_maxFontSize, mMaxFontSize);
                mTipFontSize = array.getInteger(R.styleable.RemaindIndexer_tipFontSize, mTipFontSize);


            } finally {
                array.recycle();
            }
        }

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mHeight = getHeight();//索引列表的高度
        int width = getWidth();

        float charHeight = mHeight / IndexChar.length;
        int workHeight = 0;// 绘制文字区域的高度
        mPaint.reset();
        
        float xCenter = width - mWidthOffset;
        
        for (int i = 0; i < IndexChar.length; i++) {
            mPaint.setColor(mFontColor);
            float yCenter = workHeight + charHeight / 2;
            
            int fontSize = adjustFontSize(i, yCenter);

            mPaint.setTextSize(fontSize);

            //添加一个字符的高度
            workHeight += charHeight;
            
            drawTextInCenter(canvas, IndexChar[i], xCenter, yCenter);
        }
        mPaint.reset();
        
    }

    /**
     * @param canvas
     *         画板
     * @param string
     *         被绘制的字母
     * @param xCenter
     *         字母的中心x方向位置
     * @param yCenter
     *         字母的中心y方向位置
     */
    private void drawTextInCenter(Canvas canvas, String string, float xCenter, float yCenter) {
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        float fontHeight = mPaint.getFontSpacing();
        float drawY = yCenter + fontHeight / 2 - fm.ascent;
        
        if(drawY<-fm.ascent-fm.descent){
            drawY = -fm.ascent-fm.descent;
        }
        if(drawY> mHeight){
            drawY = mHeight;
        }
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(string,xCenter,drawY,mPaint);
    }

    private int adjustFontSize(int i, float yPos) {
        return mMinFontSize;
    }


}
