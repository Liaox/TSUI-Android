package com.zhiyicx.tsui.widget.imageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Describe  正方形的 ImageView
 * @Author Jungle68
 * @Date 2017/2/21
 * @Contact master.jungle68@gmail.com
 */

public class TSSquareImageView extends TSFilterImageView {

    public TSSquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TSSquareImageView(Context context) {
        super(context);
    }

    public TSSquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
                getDefaultSize(0, heightMeasureSpec));
        // 高度和宽度一样
        heightMeasureSpec = widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(
                getMeasuredWidth(), View.MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
