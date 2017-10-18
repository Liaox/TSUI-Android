package com.zhiyicx.tsui.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.zhiyicx.tsui.R;


/**
 * @Describe 空置页面或错误提示
 * @Author Jungle68
 * @Date 2017/2/7
 * @Contact master.jungle68@gmail.com
 */
public class TSEmptyView extends LinearLayout {

    // view 当前状态
    /**
     * default
     */
    public static final int STATE_DEFAULT = 0;
    /**
     * net error
     */
    public static final int STATE_NETWORK_ERROR = 1;
    /**
     * loading
     */
    public static final int STATE_NETWORK_LOADING = 2;
    /**
     * no data and clickable is false
     */
    public static final int STATE_NODATA = 3;
    /**
     * no data and clickable is true
     */
    public static final int STATE_NODATA_ENABLE_CLICK = 4;
    /**
     * hide this view
     */
    public static final int STATE_HIDE_LAYOUT = 5;

    /**
     * default tip when there is no data
     */
    public static final int DEFAULT_NO_DATA_TIP = R.string.tsui_empty_view_default_no_data;

    /**
     * default tip when connect failed
     */
    public static final int DEFAULT_NO_NET_TIP = R.string.tsui_empty_view_default_no_net;

    /**
     * default tip when loading
     */
    public static final int DEFAULT_LOADING_TIP = R.string.tsui_empty_view_default_loading;


    private ProgressBar mAnimProgress;
    public ImageView mIvError;
    private TextView mTvError;
    private View mLlContent;

    private OnClickListener mOnClickListener;
    private int mErrorState;
    private boolean mClickEnable = true;

    private boolean mIsNeedClickLoadState = true;// 是否需要点击响应时自动 load 状态


    private boolean mIsNeedTextTip = true;// 是否需要文字提示

    private String mNoDataTip; // 没有数据提示语内容
    private String mNoNetTip; // 没有网络提示语内容
    private String mLoadingTip; // 加载中提示语内容

    private int mNoDataTipImageId; // 没有数据中间提示的图片
    private int mNoNetTipImageId; // 没有网络中间提示的图片
//    private int mLoadingTipImageId; // 没有数据中间提示的图片

    private Context mContext;

    public TSEmptyView(Context context) {
        super(context);
        init(context, null);
    }

    public TSEmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TSEmptyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.mContext = context;
        View view = View.inflate(mContext, R.layout.view_empty, this);
        mLlContent = view.findViewById(R.id.ll_content);
        mIvError = view.findViewById(R.id.iv_error_layout);
        mTvError = view.findViewById(R.id.tv_error_layout);
        // 设置默认的提示文字
        setNoNetTip(DEFAULT_NO_NET_TIP);
        setNoNetTip(DEFAULT_NO_DATA_TIP);
        mAnimProgress = view.findViewById(R.id.pb_animation_bar);
        mLlContent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mClickEnable) {
                    if (mIsNeedClickLoadState) {
                        setErrorType(STATE_NETWORK_LOADING);
                    }
                    if (mOnClickListener != null)
                        mOnClickListener.onClick(mLlContent);
                }
            }
        });
    }

    @Override
    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    @Override
    public void setVisibility(int visibility) {
        if (visibility == View.GONE) {
            mErrorState = STATE_HIDE_LAYOUT;
        }
        super.setVisibility(visibility);
    }

    /**
     * 隐藏当前 view
     */
    public void dismiss() {
        mErrorState = STATE_HIDE_LAYOUT;
        setVisibility(View.GONE);
    }


    public int getErrorState() {
        return mErrorState;
    }

    /**
     * 设置错误提示信息内容
     *
     * @param msg 信息内容，not null
     */
    public void setErrorMessage(String msg) {
        if (mIsNeedTextTip) {
            mTvError.setVisibility(VISIBLE);
            mTvError.setText(msg);
        }
    }

    /**
     * 当前是否在加载状态
     *
     * @return true, 当前处于加载状态
     */
    public boolean isLoading() {
        return mErrorState == STATE_NETWORK_LOADING;
    }

    /**
     * @return
     */
    public boolean isNeedClickLoadState() {
        return mIsNeedClickLoadState;
    }

    /**
     * 是否自动添加加载状态
     */
    public void setNeedClickLoadState(boolean needClickLoadState) {
        mIsNeedClickLoadState = needClickLoadState;
    }

    public boolean isNeedTextTip() {
        return mIsNeedTextTip;
    }

    /**
     * 设置文字提示
     */
    public void setNeedTextTip(boolean needTextTip) {
        mIsNeedTextTip = needTextTip;
    }

    /**
     * 设置没有网络提示语
     *
     * @param resId 提示语内容 资源id
     */
    public void setNoNetTip(int resId) {
        this.mNoNetTip = getContext().getString(resId);
    }

    public void setNoNetTip(String tip) {
        this.mNoNetTip = tip;
    }

    /**
     * 设置没有网络的图片
     *
     * @param resId 资源id
     */
    public void setNoNetTipImageId(int resId) {
        this.mNoDataTipImageId = resId;
    }

    /**
     * 设置没有数据提示语
     *
     * @param resId 提示语内容 资源id
     */
    public void setNoDataTip(int resId) {
        this.mNoDataTip = getContext().getString(resId);
    }

    public void setNoDataTip(String tip) {
        this.mNoDataTip = tip;
    }

    /**
     * 设置没有数据的图片
     *
     * @param resId 资源id
     */
    public void setNoDataTipImageId(int resId) {
        this.mNoDataTipImageId = resId;
    }

    /**
     * 设置加载中的文字提示，没有的时候传0
     *
     * @param resId 资源id
     */
    public void setLoadingTip(int resId) {
        this.mLoadingTip =getContext().getString(resId);
    }

    public void setLoadingTip(String tip) {
        this.mLoadingTip = tip;
    }

    /**
     * 设置提示图片
     *
     * @param resId 资源引用 id
     * @return true, 加载中
     */
    public void setErrorImage(@DrawableRes int resId) {
        mIvError.setVisibility(View.VISIBLE);
        mIvError.setImageResource(resId);
    }

    /**
     * 设置当前状态
     *
     * @param type 当前状态类型
     */
    public void setErrorType(int type) {
        setVisibility(View.VISIBLE);
        switch (type) {
            case STATE_NETWORK_ERROR:
                mErrorState = STATE_NETWORK_ERROR;
                mAnimProgress.setVisibility(View.GONE);
                setErrorImage(mNoNetTipImageId);
                setErrorMessage(mNoNetTip);
                mClickEnable = true;
                break;
            case STATE_NETWORK_LOADING:
                mErrorState = STATE_NETWORK_LOADING;
                mAnimProgress.setVisibility(View.VISIBLE);
                mIvError.setVisibility(View.GONE);
                setErrorMessage(mLoadingTip);
                mClickEnable = false;
                break;
            case STATE_NODATA:
                mErrorState = STATE_NODATA;
                mAnimProgress.setVisibility(View.GONE);
                setErrorImage(mNoDataTipImageId);
                setErrorMessage(mNoDataTip);
                mClickEnable = false;
                break;
            case STATE_HIDE_LAYOUT:
                setVisibility(View.GONE);
                mIvError.setVisibility(View.GONE);
                mAnimProgress.setVisibility(View.GONE);
                break;
            case STATE_NODATA_ENABLE_CLICK:
                mErrorState = STATE_NODATA_ENABLE_CLICK;
                mAnimProgress.setVisibility(View.GONE);
                setErrorImage(mNoDataTipImageId);
                setErrorMessage(mNoDataTip);
                mClickEnable = true;
                break;
            default:
        }
    }


}

