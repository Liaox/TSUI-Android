package com.zhiyicx.tsui.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhiyicx.tsui.R;
import com.zhiyicx.tsui.utils.TSConvertUtils;


/**
 * @author LiuChao
 * @describe 个人中心的组合控件，图片-文字-图片
 * @date 2017/1/7
 * @contactemail:450127106@qq.com
 */
public class TSCombinationButton extends FrameLayout {
    ImageView mCombinedButtonImgLeft;
    ImageView mCombinedButtonImgRight;

    TextView mCombinedButtonLeftText;
    TextView mCombinedButtonRightText;
    View mVLine;

    public TSCombinationButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.ts_view_combination_button, this);
        mCombinedButtonImgLeft = findViewById(R.id.iv_left_img);
        mCombinedButtonImgRight = findViewById(R.id.iv_right_img);
        mCombinedButtonLeftText = findViewById(R.id.tv_left_text);
        mCombinedButtonRightText = findViewById(R.id.tv_right_text);
        mVLine = findViewById(R.id.v_line);
        TypedArray array = context.obtainStyledAttributes(attrs,
                R.styleable.tsCombinationBtn);
        Drawable leftImage = array.getDrawable(R.styleable.tsCombinationBtn_tsLeftImage);
        Drawable rightImage = array.getDrawable(R.styleable.tsCombinationBtn_tsRightImage);
        String leftText = array.getString(R.styleable.tsCombinationBtn_tsLeftText);
        String rightText = array.getString(R.styleable.tsCombinationBtn_tsRightText);
        int leftTextColor = array.getColor(R.styleable.tsCombinationBtn_tsLeftTextColor, -1);
        int rightTextColor = array.getColor(R.styleable.tsCombinationBtn_tsRightTextColor, -1);
        boolean showLine = array.getBoolean(R.styleable.tsCombinationBtn_tsShowLine, true);
        int dividerLeftMargin = array.getDimensionPixelSize(R.styleable.tsCombinationBtn_tsDividerLeftMargin, 0);
        int dividerRightMargin = array.getDimensionPixelSize(R.styleable.tsCombinationBtn_tsDividerRightMargin, 0);
        int leftTextLeftPadding = array.getDimensionPixelOffset(R.styleable.tsCombinationBtn_tsLeftTextLeftPadding, TSConvertUtils.dp2px(context, 10));
        array.recycle();
        if (!TextUtils.isEmpty(leftText)) {
            mCombinedButtonLeftText.setText(leftText);
        }
        if (leftTextColor != -1) {
            mCombinedButtonLeftText.setTextColor(leftTextColor);
        }
        if (rightTextColor != -1) {
            mCombinedButtonRightText.setTextColor(rightTextColor);
        }
        if (!TextUtils.isEmpty(rightText)) {
            mCombinedButtonRightText.setText(rightText);
        }
        mCombinedButtonLeftText.setPadding(leftTextLeftPadding, 0, 0, 0);
        if (leftImage == null) {
            mCombinedButtonImgLeft.setVisibility(GONE);
        } else {
            mCombinedButtonImgLeft.setVisibility(VISIBLE);
            mCombinedButtonImgLeft.setImageDrawable(leftImage);
        }
        mCombinedButtonImgRight.setImageDrawable(rightImage);
        if (showLine) {
            mVLine.setVisibility(VISIBLE);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mVLine.getLayoutParams();
            layoutParams.setMargins(dividerLeftMargin, 0, dividerRightMargin, 0);
        } else {
            mVLine.setVisibility(INVISIBLE);
        }
    }

    /**
     * 设置左边文字内容
     *
     * @param leftText content
     */
    public void setLeftText(String leftText) {
        mCombinedButtonLeftText.setText(leftText);
    }

    /**
     * 设置右边文字内容
     *
     * @param rightText content
     */
    public void setRightText(String rightText) {
        mCombinedButtonRightText.setText(rightText);
    }

    /**
     * 设置右边文字内容颜色
     *
     * @param color 颜色值
     */
    public void setRightTextColor(int color) {
        mCombinedButtonRightText.setTextColor(color);
    }

    /**
     * 获取右侧TextView
     *
     * @return TextView
     */
    public TextView getCombinedButtonRightTextView() {
        return mCombinedButtonRightText;
    }

    /**
     * 获取右侧TextView文字内容
     *
     * @return String
     */
    public String getRightText() {
        return mCombinedButtonRightText.getText().toString();
    }

    /**
     * 设置右边图片的点击事件
     *
     * @param listener OnClickListener
     */
    public void setRightImageClickListener(OnClickListener listener) {
        mCombinedButtonImgRight.setOnClickListener(listener);
    }

    /**
     * 获取右边图片控件
     *
     * @return ImageView
     */
    public ImageView getCombinedButtonImgRight() {
        return mCombinedButtonImgRight;
    }

    /**
     * 设置右边图片的资源
     *
     * @param res id
     */
    public void setRightImage(int res) {
        mCombinedButtonImgRight.setImageResource(res);
    }
}
