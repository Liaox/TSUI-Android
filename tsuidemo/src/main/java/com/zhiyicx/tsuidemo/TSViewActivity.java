package com.zhiyicx.tsuidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhiyicx.tsui.widget.view.TSEmptyView;
import com.zhiyicx.tsui.widget.view.TSUserAvatarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Catherine
 * @describe
 * @date 2017/10/16
 * @contact email:648129313@qq.com
 */

public class TSViewActivity extends AppCompatActivity {

    @BindView(R.id.user_avatar1)
    TSUserAvatarView mUserAvatar1;
    @BindView(R.id.user_avatar2)
    TSUserAvatarView mUserAvatar2;
    @BindView(R.id.user_avatar3)
    TSUserAvatarView mUserAvatar3;
    @BindView(R.id.emptyView)
    TSEmptyView mEmptyView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ts_imageview);
        ButterKnife.bind(this);
        mUserAvatar1.getIvVerify().setImageResource(R.mipmap.ic_launcher_round);
        mUserAvatar2.getIvVerify().setImageResource(R.mipmap.ic_launcher_round);
        mUserAvatar3.getIvVerify().setImageResource(R.mipmap.ic_launcher_round);
    }

    @OnClick({R.id.btn_no_data, R.id.btn_no_net, R.id.btn_loading, R.id.btn_hide})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_no_data:
                mEmptyView.setNoDataTip(R.string.tsui_empty_view_default_no_data);
                mEmptyView.setErrorType(TSEmptyView.STATE_NODATA);
                break;
            case R.id.btn_no_net:
                mEmptyView.setNoNetTip(R.string.tsui_empty_view_default_no_net);
                mEmptyView.setErrorType(TSEmptyView.STATE_NETWORK_ERROR);
                break;
            case R.id.btn_loading:
                mEmptyView.setLoadingTip(R.string.tsui_empty_view_default_loading);
                mEmptyView.setErrorType(TSEmptyView.STATE_NETWORK_LOADING);
                break;
            case R.id.btn_hide:
                mEmptyView.setErrorType(TSEmptyView.STATE_HIDE_LAYOUT);
                break;
            default:
        }
    }

}
