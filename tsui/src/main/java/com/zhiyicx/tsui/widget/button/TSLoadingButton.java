package com.zhiyicx.tsui.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyicx.tsui.R;
import com.zhiyicx.tsui.utils.TSConvertUtils;


/**
 * @Describe 涵盖加载动画的 button
 * @Author Jungle68
 * @Date 2017/1/19
 * @Contact master.jungle68@gmail.com
 */

public class TSLoadingButton extends FrameLayout {

    protected TextView mTvText;
    protected ImageView mIvLoad;
    protected View mContainer;
    protected AnimationDrawable mAnimationDrawable;
    protected OnClickListener mOnClickListener;


    public TSLoadingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.ts_view_loading_button, this);
        mContainer = findViewById(R.id.rl_container);
        mTvText = findViewById(R.id.tv_text);
        mIvLoad = findViewById(R.id.iv_load);

        TypedArray array = context.obtainStyledAttributes(attrs,
                R.styleable.tsLoadButton);
        // 按钮文字
        String text = array.getString(R.styleable.tsLoadButton_tsText);
        // 按钮文字大小
        int textSize = array.getDimensionPixelSize(R.styleable.tsLoadButton_android_textSize, TSConvertUtils.dp2px(context, 5));
        // 按钮文字颜色
        int textColor = array.getColor(R.styleable.tsLoadButton_tsTextColor, 0x801B88EE);
        // 按钮加载动画
        Drawable animationRes = array.getDrawable(R.styleable.tsLoadButton_tsLoadingView);
        array.recycle();
        if (!TextUtils.isEmpty(text)) {
            mTvText.setText(text);
        }
//        mTvText.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        mTvText.setTextColor(textColor);
        if (animationRes != null){
            mIvLoad.setImageDrawable(animationRes);
        }
        mAnimationDrawable = (AnimationDrawable) mIvLoad.getDrawable();
        mContainer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickListener != null) {
                    mOnClickListener.onClick(v);
                }
            }
        });
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mContainer.setEnabled(enabled);
    }

    /**
     * 设置文字内容
     */
    public void setText(String text) {
        mTvText.setText(text);
    }

    /**
     * 设置响应监听
     */
    @Override
    public void setOnClickListener(OnClickListener l) {
        mOnClickListener = l;
    }

    /**
     * 设置背景
     */
    public void setBackground(int resid) {
        mContainer.setBackgroundResource(resid);
    }

    /**
     * 设置文字的大小
     *
     * @param dimenId 资源id
     */
    public void setTextSize(int dimenId) {
        mTvText.setTextSize(getResources().getDimension(dimenId));
    }

    /**
     * 设置文字的颜色
     *
     * @param color 颜色值
     */
    public void setTextColor(int color) {
        mTvText.setTextColor(color);
    }

    /**
     * 设置加载动画的资源
     *
     * @param resId 资源id
     */
    public void setAnimationRes(int resId) {
        mIvLoad.setImageResource(resId);
    }

    /**
     * 处理动画
     *
     * @param status true 开启动画，false 关闭动画
     */
    public void handleAnimation(boolean status) {
        if (mAnimationDrawable == null)
            throw new IllegalArgumentException("load animation not be null");
        if (status) {
            if (!mAnimationDrawable.isRunning()) {
                mIvLoad.setVisibility(VISIBLE);
                mAnimationDrawable.start();
            }
        } else {
            if (mAnimationDrawable.isRunning()) {
                mAnimationDrawable.stop();
                mIvLoad.setVisibility(INVISIBLE);
            }
        }
    }


}
