package com.zhiyicx.tsuidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zhiyicx.tsui.utils.TSDeviceUtils;
import com.zhiyicx.tsui.utils.TSStatusBarUtils;
import com.zhiyicx.tsui.utils.TSTimeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Catherine
 * @describe 工具类相关页面
 * @date 2017/10/17
 * @contact email:648129313@qq.com
 */

public class TSUtilsActivity extends AppCompatActivity {

    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_device)
    TextView mTvDevice;
    @BindView(R.id.tv_convert)
    TextView mTvConvert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ts_utils);
        ButterKnife.bind(this);
        // 当前时间
        mTvTime.setText("当前时间：\n" + TSTimeUtils.getCurrentZeroTimeStr());
        // 设备信息
        mTvDevice.setText("当前设备：\n" + "当前设备是否存在SD卡：" + TSDeviceUtils.isExitsSdcard() + "\n状态栏高度：" + TSDeviceUtils.getStatuBarHeight(this)
                + "\n屏幕宽高：" + TSDeviceUtils.getScreenWidth(this) + "、" + TSDeviceUtils.getScreenHeight(this));

    }

    @OnClick({R.id.btn_status_black, R.id.btn_status_white, R.id.btn_share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_status_black:
                TSStatusBarUtils.statusBarLightMode(this);
                break;
            case R.id.btn_status_white:
                TSStatusBarUtils.statusBarDarkMode(this);
                break;
            case R.id.btn_share:
                TSDeviceUtils.showSystemShareOption(this, "share", "www.bilibili.com");
                break;
            default:
        }
    }

}
