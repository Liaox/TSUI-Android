package com.zhiyicx.tsui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.zhiyicx.tsui.R;


/**
 * @Describe 可以设置 drawable 大小的 TextView
 * @Author Jungle68
 * @Date 2017/3/13
 * @Contact master.jungle68@gmail.com
 */

public class TSDrawableSizeTextView extends AppCompatTextView {

    private int mDrawableWidth;
    private int mDrawableHeight;

    public TSDrawableSizeTextView(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public TSDrawableSizeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public TSDrawableSizeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TSDrawableSizeTextView, defStyleAttr, defStyleRes);

        try {
            mDrawableWidth = array.getDimensionPixelSize(R.styleable.TSDrawableSizeTextView_tsCompoundDrawableWidth, -1);
            mDrawableHeight = array.getDimensionPixelSize(R.styleable.TSDrawableSizeTextView_tsCompoundDrawableHeight, -1);
        } finally {
            array.recycle();
        }

        if (mDrawableWidth > 0 || mDrawableHeight > 0) {
            initCompoundDrawableSize();
        }
    }

    private void initCompoundDrawableSize() {
        Drawable[] drawables = getCompoundDrawables();
        for (Drawable drawable : drawables) {
            if (drawable == null) {
                continue;
            }

            Rect realBounds = drawable.getBounds();
            float scaleFactor = realBounds.height() / (float) realBounds.width();

            float drawableWidth = realBounds.width();
            float drawableHeight = realBounds.height();

            if (mDrawableWidth > 0) {
                // save scale factor of image
                if (drawableWidth > mDrawableWidth) {
                    drawableWidth = mDrawableWidth;
                    drawableHeight = drawableWidth * scaleFactor;
                }
            }
            if (mDrawableHeight > 0) {
                // save scale factor of image

                if (drawableHeight > mDrawableHeight) {
                    drawableHeight = mDrawableHeight;
                    drawableWidth = drawableHeight / scaleFactor;
                }
            }

            realBounds.right = realBounds.left + Math.round(drawableWidth);
            realBounds.bottom = realBounds.top + Math.round(drawableHeight);

            drawable.setBounds(realBounds);
        }
        setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }
}
