package com.zhiyicx.tsui.widget.popupwindow;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.zhiyicx.tsui.R;


/**
 * @author Catherine
 * @describe 仅有中间提示语和一个确认按钮的提示框, 可以隐藏掉确认按钮
 * @date 2017/10/16
 * @contact email:648129313@qq.com
 */

public class TSCenterOnlyPopWindow extends TSBasePopupWindow {

    private CenterPopWindowItemClickListener mCenterPopWindowItemClickListener;

    private String titleStr;
    private String centerContent;
    private String buttonContent;

    private int titleTextSize;
    private int titleTextColor;

    private int contentTextSize;
    private int contentTextColor;

    private int buttonTextColor;
    private int buttonTextSize;
    private boolean isShowButton; // 是否显示底部的按钮，默认是显示的

    public static CBuilder builder() {
        return new CBuilder();
    }

    protected TSCenterOnlyPopWindow(CBuilder builder) {
        super(builder);
        // 标题
        this.titleStr = builder.titleStr;
        this.titleTextColor = builder.titleTextColor;
        this.titleTextSize = builder.titleTextSize;
        // 正文
        this.centerContent = builder.centerContent;
        this.contentTextSize = builder.contentTextSize;
        this.contentTextColor = builder.contentTextColor;
        // 底部按钮
        this.buttonContent = builder.buttonContent;
        this.buttonTextColor = builder.buttonTextColor;
        this.buttonTextSize = builder.buttonTextSize;
        this.isShowButton = builder.isShowButton;

        this.mCenterPopWindowItemClickListener = builder.mCenterPopWindowItemClickListener;
        initView();
    }

    private void initView() {
        initTextView(titleStr, titleTextColor, R.id.ppw_center_title, titleTextSize);
        initTextView(centerContent, contentTextColor, R.id.ppw_center_description, contentTextSize);
        initBottomView(isShowButton, buttonContent, buttonTextColor, R.id.ppw_center_bottom, buttonTextSize, mCenterPopWindowItemClickListener);
    }

    private void initBottomView(boolean isShowButton, String text, int colorId, int resId, int size, final CenterPopWindowItemClickListener listener) {
        TextView textView = mContentView.findViewById(resId);
        if (!isShowButton){
            textView.setVisibility(View.GONE);
            mContentView.findViewById(R.id.view_diver).setVisibility(View.GONE);
            return;
        }
        if (!TextUtils.isEmpty(text)) {
            textView.setText(text);
        }
        if (colorId != 0) {
            textView.setTextColor(ContextCompat.getColor(mActivity, colorId));
        }
        if (size != 0){
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onButtonClick();
                }
            }
        });
    }

    private void initTextView(String text, int colorId, int resId, int size) {
        TextView textView = mContentView.findViewById(resId);
        if (!TextUtils.isEmpty(text)) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(text);
        }
        if (colorId != 0) {
            textView.setTextColor(ContextCompat.getColor(mActivity, colorId));
        }
        if (size != 0){
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }

    public static final class CBuilder extends Builder {

        private CenterPopWindowItemClickListener mCenterPopWindowItemClickListener;
        private String titleStr;
        private String centerContent;

        // 样式相关 emm 感觉不常用啊
        private int titleTextSize;
        private int titleTextColor;

        private int contentTextSize;
        private int contentTextColor;

        private String buttonContent;
        private int buttonTextSize;
        private int buttonTextColor;
        private boolean isShowButton = true;

        public CBuilder buildCenterPopWindowItem1ClickListener(CenterPopWindowItemClickListener mCenterPopWindowItem1ClickListener) {
            this.mCenterPopWindowItemClickListener = mCenterPopWindowItem1ClickListener;
            return this;
        }

        @Override
        public CBuilder backgroundAlpha(float alpha) {
            super.backgroundAlpha(alpha);
            return this;
        }

        @Override
        public CBuilder width(int width) {
            super.width(width);
            return this;
        }

        @Override
        public CBuilder height(int height) {
            super.height(height);
            return this;
        }

        // 标题提示文字的内容以及样式，不传或者传空为默认的
        public CBuilder titleContent(String content) {
            this.titleStr = content;
            return this;
        }

        public CBuilder titleTextStyle(int titleTextColor, int titleTextSize) {
            this.titleTextColor = titleTextColor;
            this.titleTextSize = titleTextSize;
            return this;
        }

        // 中间提示文字的内容以及样式，不传或者传空为默认的
        public CBuilder centerContent(String centerContent){
            this.centerContent = centerContent;
            return this;
        }

        public CBuilder centerTextStyle(int contentTextColor, int contentTextSize){
            this.contentTextColor = contentTextColor;
            this.contentTextSize = contentTextSize;
            return this;
        }

        // 底部按钮提示文字的内容以及样式，不传或者传空为默认的
        public CBuilder buttonContent(String buttonContent){
            this.buttonContent = buttonContent;
            return this;
        }

        public CBuilder buttonTextStyle(int buttonTextColor, int buttonTextSize){
            this.buttonTextColor = buttonTextColor;
            this.buttonTextSize = buttonTextSize;
            return this;
        }

        public CBuilder isShowBottomButton(boolean isShowButton){
            this.isShowButton = isShowButton;
            return this;
        }

        @Override
        public CBuilder with(Activity activity) {
            super.with(activity);
            return this;
        }

        @Override
        public CBuilder isOutsideTouch(boolean isOutsideTouch) {
            super.isOutsideTouch(isOutsideTouch);
            return this;
        }

        @Override
        public CBuilder isFocus(boolean isFocus) {
            super.isFocus(isFocus);
            return this;
        }

        @Override
        public CBuilder backgroundDrawable(Drawable backgroundDrawable) {
            super.backgroundDrawable(backgroundDrawable);
            return this;
        }

        @Override
        public CBuilder animationStyle(int animationStyle) {
            super.animationStyle(animationStyle);
            return this;
        }

        public CBuilder parentView(View parentView) {
            super.parentView(parentView);
            return this;
        }

        @Override
        public TSCenterOnlyPopWindow build() {
            contentViewId = R.layout.ts_ppw_for_center_only;
            isWrap = true;
            return new TSCenterOnlyPopWindow(this);
        }
    }

    public interface CenterPopWindowItemClickListener {
        void onButtonClick();
    }

}
