package com.zhiyicx.tsui.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextPaint;
import android.util.AttributeSet;

import com.zhiyicx.tsui.R;


/**
 * @Describe show #mPressedColor color when pressed
 * @Author Jungle68
 * @Date 2017/2/29
 * @Contact master.jungle68@gmail.com
 */

public class TSFilterImageView extends AppCompatImageView {
    private static final int SHAPE_SQUARE = 0;
    private static final int SHAPE_CIRLCE = 1;
    private static final int DEFAULT_PRESSED_COLOR = 0x26000000; // cover：#000000 alpha 15%
    private int mPressedColor = DEFAULT_PRESSED_COLOR;// pressed color
    private int mShape = SHAPE_SQUARE;
    private Paint mPaint;
    private boolean isText;
    private Rect mRect;

    public TSFilterImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }


    public TSFilterImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    public TSFilterImageView(Context context) {
        super(context);
    }


    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TSFilterImageView);
        mPressedColor = array.getInteger(R.styleable.TSFilterImageView_tsPressColor, DEFAULT_PRESSED_COLOR);
        mShape = array.getInteger(R.styleable.TSFilterImageView_tsPressShape, SHAPE_SQUARE);
        array.recycle();
        mPaint = new TextPaint();
        mPaint.setColor(mPressedColor);
        mRect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            switch (mShape) {
                case SHAPE_SQUARE: // square
                    canvas.drawColor(mPressedColor);
                    break;
                case SHAPE_CIRLCE: // circle
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, mPaint);
                    break;
                default:

            }
        }
        if (isText) {
            mPaint.setColor(ContextCompat.getColor(getContext(), R.color.tsui_general_for_hint));
            canvas.drawCircle(getWidth() / 2, getHeight() / 2,getWidth() / 2, mPaint);
            mPaint.setTextSize(getWidth() / 2);
            mPaint.setColor(Color.WHITE);
            canvas.drawText("匿", getWidth() / 2 - mPaint.measureText("匿") / 2, getHeight() / 2 - (mPaint.descent() + mPaint.ascent()) / 2, mPaint);
        }
    }

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        super.dispatchSetPressed(pressed);
        invalidate();
    }

    public void setIsText(boolean isText) {
        this.isText = isText;
        postInvalidate();
    }
}
