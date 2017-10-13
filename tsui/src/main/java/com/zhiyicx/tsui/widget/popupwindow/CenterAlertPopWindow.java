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
 * @describe 中间的提示框 按钮默认确认和取消
 * @date 2017/8/21
 * @contact email:648129313@qq.com
 */

public class CenterAlertPopWindow extends CustomPopupWindow {

    private CenterPopWindowItemClickListener mCenterPopWindowItemClickListener;

    private String titleStr;
    private String centerContent;
    private String itemRight;
    private String itemLeft;

    private int titleTextSize;
    private int titleTextColor;

    private int contentTextSize;
    private int contentTextColor;

    private int leftTextSize;
    private int leftTextColor;

    private int rightTextSize;
    private int rightTextColor;

    public static CBuilder builder() {
        return new CBuilder();
    }

    protected CenterAlertPopWindow(CBuilder builder) {
        super(builder);
        // 标题
        this.titleStr = builder.titleStr;
        this.titleTextColor = builder.titleTextColor;
        this.titleTextSize = builder.titleTextSize;
        // 正文
        this.centerContent = builder.centerContent;
        this.contentTextSize = builder.contentTextSize;
        this.contentTextColor = builder.contentTextColor;
        // 右边
        this.itemRight = builder.itemRight;
        this.rightTextColor = builder.rightTextColor;
        this.rightTextSize = builder.rightTextSize;
        // 左边
        this.itemLeft = builder.itemLeft;
        this.leftTextColor = builder.leftTextColor;
        this.leftTextSize = builder.leftTextSize;
        this.mCenterPopWindowItemClickListener = builder.mCenterPopWindowItemClickListener;

        initView();
    }

    private void initView() {
        initTextView(titleStr, titleTextColor, R.id.ppw_center_title, titleTextSize);
        initTextView(centerContent, contentTextColor, R.id.ppw_center_description, contentTextSize);
        initBottomLeftView(itemLeft, leftTextColor, R.id.ppw_center_item_left, leftTextSize, mCenterPopWindowItemClickListener);
        initBottomRightView(itemRight, rightTextColor, R.id.ppw_center_item, rightTextSize, mCenterPopWindowItemClickListener);
    }

    private void initBottomRightView(String text, int colorId, int resId, int size, final CenterPopWindowItemClickListener listener) {
        TextView textView = mContentView.findViewById(resId);
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
                    listener.onRightClicked();
                }
            }
        });
    }

    private void initBottomLeftView(String text, int colorId, int resId, int size, final CenterPopWindowItemClickListener listener) {
        TextView textView = mContentView.findViewById(resId);
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
                    listener.onLeftClicked();
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
        private String itemRight;
        private String itemLeft;

        // 样式相关 emm 感觉不常用啊
        private int titleTextSize;
        private int titleTextColor;

        private int contentTextSize;
        private int contentTextColor;

        private int leftTextSize;
        private int leftTextColor;

        private int rightTextSize;
        private int rightTextColor;

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

        public CBuilder titleContent(String content) {
            this.titleStr = content;
            return this;
        }

        public CBuilder titleTextStyle(int titleTextColor, int titleTextSize) {
            this.titleTextColor = titleTextColor;
            this.titleTextSize = titleTextSize;
            return this;
        }

        public CBuilder desStr(String desStr) {
            this.centerContent = desStr;
            return this;
        }

        // 右边文字的内容以及样式，不传或者传空为默认的
        public CBuilder rightContent(String itemRightStr) {
            this.itemRight = itemRightStr;
            return this;
        }

        public CBuilder rightTextStyle(int rightTextColor, int rightTextSize) {
            this.rightTextColor = rightTextColor;
            this.rightTextSize = rightTextSize;
            return this;
        }

        // 左边文字的内容以及样式，不传或者传空为默认的
        public CBuilder leftContent(String itemLeft){
            this.itemLeft = itemLeft;
            return this;
        }

        public CBuilder leftTextStyle(int leftTextColor, int leftTextSize){
            this.leftTextColor = leftTextColor;
            this.leftTextSize = leftTextSize;
            return this;
        }

        // 中间提示文字的内容以及样式，不传或者传空为默认的
        public CBuilder centerContent(String itemLeft){
            this.itemLeft = itemLeft;
            return this;
        }

        public CBuilder centerTextStyle(int contentTextColor, int contentTextSize){
            this.contentTextColor = contentTextColor;
            this.contentTextSize = contentTextSize;
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
        public CenterAlertPopWindow build() {
            contentViewId = R.layout.ppw_for_center_alert;
            isWrap = true;
            return new CenterAlertPopWindow(this);
        }
    }

    public interface CenterPopWindowItemClickListener {
        void onRightClicked();
        void onLeftClicked();
    }

}
