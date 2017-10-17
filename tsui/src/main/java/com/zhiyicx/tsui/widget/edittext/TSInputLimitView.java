package com.zhiyicx.tsui.widget.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zhiyicx.tsui.R;
import com.zhiyicx.tsui.utils.TSColorPhrase;

/**
 * @Describe 限制输入控件 view
 * @Author Jungle68
 * @Date 2017/1/12
 * @Contact master.jungle68@gmail.com
 */

public class TSInputLimitView extends FrameLayout {

    public final static int GRAVITY_RIGHT = 5;
    public final static int GRAVITY_LEFT = 3;

    protected TextView mTvLimitTip;
    protected TextView mBtSend;


    protected EditText mEtContent;
    protected EditText mEtEmpty;

    private int mLimitMaxSize;// 最大输入值
    private int mShowLimitSize;// 当输入值达到 mShowLimitSize 时，显示提示

    private String mLimitTipStr = "{}/";// 添加格式符号，用户ColorPhrase

    private int mGravity; // 内容的位置
    private int mShowLines; // 最多显示的行数
    private int mContentSize; // 输入的文字大小


    private OnSendClickListener mOnSendClickListener;

    public TSInputLimitView(Context context) {
        super(context);
        init(context, null);
    }

    public TSInputLimitView(Context context, int limitMaxSize, int showLimitSize) {
        super(context);
        mLimitMaxSize = limitMaxSize;
        mShowLimitSize = showLimitSize;
        init(context, null);
    }

    public TSInputLimitView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TSInputLimitView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_input_limit_viewgroup, this);
        mTvLimitTip = findViewById(R.id.tv_limit_tip);
        mBtSend = findViewById(R.id.bt_send);
        mEtContent = findViewById(R.id.et_content);
        mEtEmpty = findViewById(R.id.et_empty);
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs,
                    R.styleable.TSInputLimitView);
            mLimitMaxSize = array.getInteger(R.styleable.TSInputLimitView_tsLimitSize, getResources().getInteger(R.integer.comment_input_max_size));
            mShowLimitSize = array.getInteger(R.styleable.TSInputLimitView_tsShowLimitSize, getResources().getInteger(R.integer.show_comment_input_size));
            mGravity = array.getInteger(R.styleable.TSInputLimitView_tsContent_gravity, GRAVITY_LEFT);
            mShowLines = array.getInteger(R.styleable.TSInputLimitView_tsShowLines, 0);
            mContentSize = array.getDimensionPixelSize(R.styleable.TSInputLimitView_tsContent_size, 0);
            array.recycle();
        }
        if (mLimitMaxSize == 0) {
            mLimitMaxSize = context.getResources().getInteger(R.integer.comment_input_max_size);
        }
        if (mLimitMaxSize == 0) {
            context.getResources().getInteger(R.integer.show_comment_input_size);
        }
        // 设置输入内容的位置
        if (mGravity != 0) {
            if (mGravity == GRAVITY_LEFT) {
                mEtContent.setGravity(Gravity.START);
            } else if (mGravity == GRAVITY_RIGHT) {
                mEtContent.setGravity(Gravity.END);
            }
        }
        // 设置最大行数
        if (mShowLines != 0) {
            mEtContent.setMaxLines(mShowLines);
        }
        // 输入的文字大小
//        if (mContentSize != 0) {
//            mEtContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, mContentSize);
//        }
        mEtContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(mLimitMaxSize)});

        mEtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString().trim())) {
                    mBtSend.setEnabled(false);
                } else {
                    mBtSend.setEnabled(true);
                }
                if (s.length() >= mShowLimitSize) {
                    mLimitTipStr = "<" + s.length() + ">" + "/" + mLimitMaxSize;
                    CharSequence chars = TSColorPhrase.from(mLimitTipStr).withSeparator("<>")
                            .innerColor(ContextCompat.getColor(context, R.color.tsui_config_color_red))
                            .outerColor(ContextCompat.getColor(context, R.color.tsui_general_for_hint))
                            .format();
                    mTvLimitTip.setText(chars);
                    mTvLimitTip.setVisibility(VISIBLE);
                } else {
                    mTvLimitTip.setVisibility(GONE);
                }
            }
        });

        mBtSend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnSendClickListener != null) {
                    mOnSendClickListener.onSendClick(v, getInputContent());
                    mEtContent.setText("");
                }
            }
        });

    }

    public EditText getEtContent() {
        return mEtContent;
    }

    /**
     * 设置发送按钮点击监听
     */
    public void setOnSendClickListener(OnSendClickListener onSendClickListener) {
        mOnSendClickListener = onSendClickListener;
    }

    /**
     * 设置发送按钮是否显示
     *
     * @param isVisiable true 显示
     */
    public void setSendButtonVisiable(boolean isVisiable) {
        if (isVisiable) {
            mBtSend.setVisibility(VISIBLE);
        } else {
            mBtSend.setVisibility(GONE);
        }
    }

    /**
     * 设置 hint
     */
    public void setEtContentHint(String hintStr) {
        mEtContent.setHint(hintStr);
    }

    /**
     * 清除焦点
     */
    public void clearFocus() {
        mEtContent.clearFocus();
    }

    public void getFocus() {
        mEtEmpty.clearFocus();
        mEtContent.requestFocus();
    }

    /**
     * 设置输入提示
     */
    public void setTvLimitHint(@StringRes int hint) {
        mTvLimitTip.setHint(hint);
    }

    /**
     * 获取输入内容
     *
     * @return 当前输入内容，去掉前后空格
     */
    public String getInputContent() {
        return mEtContent.getText().toString().trim();
    }

    /**
     * 输入内容的位置
     *
     * @param gravity GRAVITY_RIGHT/GRAVITY_LEFT
     */
    public void setContentGravity(int gravity) {
        mEtContent.setGravity(gravity);
    }

    /**
     * 设置输入框最大行数
     *
     * @param showLines 行数
     */
    public void setShowLines(int showLines) {
        this.mShowLines = showLines;
        mEtContent.setMaxLines(showLines);
    }

    /**
     * 设置输入的文字大小
     *
     * @param size 文字大小
     */
    public void setContentSize(int size) {
        this.mContentSize = size;
        mEtContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public interface OnSendClickListener {
        void onSendClick(View v, String text);

    }
}
