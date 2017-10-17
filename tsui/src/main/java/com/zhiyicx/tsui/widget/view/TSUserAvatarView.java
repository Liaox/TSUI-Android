package com.zhiyicx.tsui.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.zhiyicx.tsui.R;
import com.zhiyicx.tsui.widget.imageview.TSFilterImageView;

/**
 * @Describe
 * @Author Jungle68
 * @Date 2017/3/10
 * @Contact master.jungle68@gmail.com
 */

public class TSUserAvatarView extends FrameLayout {
    private static final float DEFAULT_RATIO = 3.5f;

    private TSFilterImageView mIvAvatar;
    private ImageView mIvVerify;

    private int mAvatarSize;
    private int mVerifySize;
    private float mVerifyRatio = DEFAULT_RATIO;


    public TSUserAvatarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TSUserAvatarView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.view_user_avater, this);
        if (attrs != null) {
            TypedArray array = getContext().obtainStyledAttributes(attrs,
                    R.styleable.TSUserAvatarView);
            mAvatarSize = array.getDimensionPixelOffset(R.styleable.TSUserAvatarView_ts_avatare_size, getContext().getResources()
                    .getDimensionPixelOffset(R.dimen.head_pic_default));
            mVerifyRatio = array.getFloat(R.styleable.TSUserAvatarView_ts_ratio, DEFAULT_RATIO);
            array.recycle();
        } else {
            mAvatarSize = getContext().getResources().getDimensionPixelOffset(R.dimen.head_pic_default);
        }
        mVerifySize = (int) (mAvatarSize / mVerifyRatio);

        mIvAvatar = findViewById(R.id.iv_avatar);
        mIvVerify = findViewById(R.id.iv_verify);

        mIvAvatar.getLayoutParams().height = mAvatarSize;
        mIvAvatar.getLayoutParams().width = mAvatarSize;

        mIvVerify.getLayoutParams().height = mVerifySize;
        mIvVerify.getLayoutParams().width = mVerifySize;

    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        mIvAvatar.setOnClickListener(l);
    }

    public TSFilterImageView getIvAvatar() {
        return mIvAvatar;
    }

    public ImageView getIvVerify() {
        return mIvVerify;
    }
}
