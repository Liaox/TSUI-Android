package com.zhiyicx.tsui.widget.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zhiyicx.tsui.R;
import com.zhiyicx.tsui.utils.TSColorPhrase;
import com.zhiyicx.tsui.utils.TSConvertUtils;

import static android.support.annotation.Dimension.SP;

/**
 * @author LiuChao
 * @describe 用户个人资料，简介编辑框
 * @date 2017/1/17
 * @contact email:450127106@qq.com
 */

public class TSUserIntroduceInputView extends FrameLayout {
    /**
     * 提示 格式xx/xx
     */
    protected TextView mTvLimitTip;
    /**
     * 输入EditText
     */
    protected EditText mEtContent;
    /**
     * 最大输入值
     */
    private int mLimitMaxSize;
    /**
     * 当输入值达到 mShowLimitSize 时，显示提示
     */
    private int mShowLimitSize;
    /**
     * 编辑框的hint提示文字
     */
    private String mHintContent;
    /**
     * 编辑框显示最大行数，超过改行数就滚动
     */
    private int mShowLines;
    /**
     * 输入文字的内容
     */
    private int mContentGravity;
    /**
     * 监听输入框输入内容变化
     */
    private ContentChangedListener mContentChangedListener;

    /**
     * 添加格式符号，用户TSColorPhrase
     */
    private String mLimitTipStr = "{}/";

    /**
     * 对外提供 获取输入EditText
     *
     * @return EditText
     */
    public EditText getEtContent() {
        return mEtContent;
    }

    public TSUserIntroduceInputView(Context context) {
        super(context);
        init(context, null);
    }

    public TSUserIntroduceInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TSUserIntroduceInputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.ts_view_userinfo_introduce_inputview, this);
        mTvLimitTip = findViewById(R.id.tv_limit_tip);
        mEtContent = findViewById(R.id.et_content);
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TSInputLimitView);
            mLimitMaxSize = array.getInteger(R.styleable.TSInputLimitView_tsLimitSize, context.getResources().getInteger(R.integer.comment_input_max_size));
            mShowLimitSize = array.getInteger(R.styleable.TSInputLimitView_tsShowLimitSize, context.getResources().getInteger
                    (R.integer.show_comment_input_size));
            mHintContent = array.getString(R.styleable.TSInputLimitView_tsHintContent);
            // 如果为0就不要设置maxLine了
            mShowLines = array.getInteger(R.styleable.TSInputLimitView_tsShowLines, 0);
            // 如果为0就不要设置maxLine了
            mContentGravity = array.getInteger(R.styleable.TSInputLimitView_tsContent_gravity, Gravity.START);
            mEtContent.setGravity(mContentGravity);
            if (array.getDimensionPixelSize(R.styleable.TSInputLimitView_tsContent_size, 0) != 0) {
                mEtContent.setTextSize(SP, TSConvertUtils.px2dp(getContext(), array.getDimension(R.styleable.TSInputLimitView_tsContent_size, 0)));
            }
            array.recycle();
        } else {
            mLimitMaxSize = context.getResources().getInteger(R.integer.comment_input_max_size);
            mShowLimitSize = context.getResources().getInteger(R.integer.show_comment_input_size);
            mHintContent = context.getResources().getString(R.string.tsui_edit_introduce);
            mShowLines = 0;
        }

        // 初始化控件属性  2*mLimitMaxSize 用于兼容 emoji
        mEtContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2 * mLimitMaxSize)});
        mEtContent.setHint(mHintContent);
        if (mShowLines > 0) {
            mEtContent.setLines(mShowLines);
        }
        mTvLimitTip.setVisibility(GONE);
        mEtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mContentChangedListener != null) {
                    mContentChangedListener.contentChanged(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 一下是处理适配 emoji, 让emoji 算成一个长度
                int parseContentLength = TSConvertUtils.stringLengthDealForEmoji(s);
                mLimitTipStr = "<" + parseContentLength + ">" + "/" + mLimitMaxSize;
                int emojiNum = TSConvertUtils.stringEmojiCount(s);
                mEtContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(mLimitMaxSize + emojiNum + 1)});
                if (parseContentLength > mLimitMaxSize) {
                    String shouldShowContent = s.toString().substring(0, s.toString().length() - (parseContentLength - mLimitMaxSize));
                    int shouldShowEmojiNum = TSConvertUtils.stringEmojiCount(shouldShowContent);
                    int offset = emojiNum - shouldShowEmojiNum;
                    if (offset > 0) {
                        TSConvertUtils.emojiStrLength(offset);
                        shouldShowContent = shouldShowContent.substring(0, shouldShowContent.length() - offset);
                    }
                    mEtContent.setText(shouldShowContent);
                    mEtContent.setSelection(shouldShowContent.length());
                }
                if (parseContentLength >= mShowLimitSize) {
                    CharSequence chars = TSColorPhrase.from(mLimitTipStr).withSeparator("<>")
                            .innerColor(ContextCompat.getColor(context, R.color.tsui_config_color_red_note))
                            .outerColor(ContextCompat.getColor(context, R.color.tsui_general_for_hint))
                            .format();
                    mTvLimitTip.setText(chars);
                    mTvLimitTip.setVisibility(VISIBLE);
                    mEtContent.setPadding(0, 0, 0, context.getResources().getDimensionPixelSize(R.dimen.tsui_default_30));
                } else {
                    mTvLimitTip.setVisibility(GONE);
                    mEtContent.setPadding(0, 0, 0, 0);
                }
            }
        });
    }

    /**
     * 获取输入内容
     *
     * @return 当前输入内容，去掉前后空格
     */
    public String getInputContent() {
        return mEtContent.getText().toString().trim();
    }

    public void setText(String content) {
        mEtContent.setText(content);
    }

    /**
     * 因为控件使用了TextChangedListener，无法在外面再次创建一个监听
     * 获取控件，在某些时候需要用到
     */
    public void setContentChangedListener(ContentChangedListener contentChangedListener) {
        mContentChangedListener = contentChangedListener;
    }

    public interface ContentChangedListener {
        /**
         * 内容改变
         *
         * @param  s 内容
         */
        void contentChanged(CharSequence s);
    }
}
