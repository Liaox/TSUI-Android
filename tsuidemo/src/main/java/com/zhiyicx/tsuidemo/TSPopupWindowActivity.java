package com.zhiyicx.tsuidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

import com.zhiyicx.tsui.widget.popupwindow.TSCenterAlertPopWindow;
import com.zhiyicx.tsui.widget.popupwindow.TSCenterOnlyPopWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Catherine
 * @describe 弹框demo页面
 * @date 2017/10/13
 * @contact email:648129313@qq.com
 */

public class TSPopupWindowActivity extends AppCompatActivity {

    @BindView(R.id.btn_center_alert)
    AppCompatButton mBtnCenterAlert;
    @BindView(R.id.btn_alert_only)
    AppCompatButton mBtnAlertOnly;
    @BindView(R.id.btn_alert_only_with_button)
    AppCompatButton mBtnAlertOnlyWithButton;

    private TSCenterAlertPopWindow mCenterAlertPopWindow;
    private TSCenterOnlyPopWindow mCenterOnlyPopWindow;
    private TSCenterOnlyPopWindow mCenterOnlyWithButtonPopWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ts_popupwindow);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_center_alert, R.id.btn_alert_only, R.id.btn_alert_only_with_button})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_center_alert:
                if (mCenterAlertPopWindow == null){
                    mCenterAlertPopWindow = TSCenterAlertPopWindow.builder()
                            .with(this)
                            .titleContent("title")
                            .centerContent("content")
                            .titleTextStyle(R.color.colorPrimary, 0)
                            .rightTextStyle(R.color.colorAccent, 0)
                            .backgroundAlpha(0.8f)
                            .buildCenterPopWindowItem1ClickListener(new TSCenterAlertPopWindow.CenterPopWindowItemClickListener() {
                                @Override
                                public void onRightClicked() {
                                    // 点击右边按钮
                                    Toast.makeText(TSPopupWindowActivity.this, "点击右边按钮", Toast.LENGTH_SHORT).show();
                                    mCenterAlertPopWindow.dismiss();
                                }

                                @Override
                                public void onLeftClicked() {
                                    // 点击左边按钮
                                    Toast.makeText(TSPopupWindowActivity.this, "点击左边按钮", Toast.LENGTH_SHORT).show();
                                    mCenterAlertPopWindow.dismiss();
                                }
                            })
                            .build();
                }
               mCenterAlertPopWindow.show();
                break;
            case R.id.btn_alert_only:
                if (mCenterOnlyPopWindow == null){
                    mCenterOnlyPopWindow = TSCenterOnlyPopWindow.builder()
                            .with(this)
                            .backgroundAlpha(0.8f)
                            .titleContent("title")
                            .centerContent("content")
                            .isShowBottomButton(false)
                            .buildCenterPopWindowItem1ClickListener(new TSCenterOnlyPopWindow.CenterPopWindowItemClickListener() {
                                @Override
                                public void onButtonClick() {
                                    // 点击底部按钮
                                    Toast.makeText(TSPopupWindowActivity.this, "点击底部按钮", Toast.LENGTH_SHORT).show();
                                    mCenterOnlyPopWindow.dismiss();
                                }
                            })
                            .build();
                }
                mCenterOnlyPopWindow.show();
                break;
            case R.id.btn_alert_only_with_button:
                if (mCenterOnlyWithButtonPopWindow == null){
                    mCenterOnlyWithButtonPopWindow = TSCenterOnlyPopWindow.builder()
                            .with(this)
                            .backgroundAlpha(0.8f)
                            .titleContent("title")
                            .centerContent("content")
                            .isShowBottomButton(true)
                            .buildCenterPopWindowItem1ClickListener(new TSCenterOnlyPopWindow.CenterPopWindowItemClickListener() {
                                @Override
                                public void onButtonClick() {
                                    // 点击底部按钮
                                    Toast.makeText(TSPopupWindowActivity.this, "点击底部按钮", Toast.LENGTH_SHORT).show();
                                    mCenterOnlyWithButtonPopWindow.dismiss();
                                }
                            })
                            .build();
                }
                mCenterOnlyWithButtonPopWindow.show();
                break;
            default:
        }
    }

}
